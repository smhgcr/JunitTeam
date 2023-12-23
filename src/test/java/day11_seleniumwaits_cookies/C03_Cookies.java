package day11_seleniumwaits_cookies;

import org.checkerframework.checker.units.qual.C;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.Set;

public class C03_Cookies extends TestBase {

    @Test
    public void test01(){

        // 1- Amazon anasayfaya gidin
        driver.get("https://wwww.amazon.com");
        ReusableMethods.bekle(7);
        // 2- tüm cookie'leri listeleyin
        Set<Cookie> cookiesSeti = driver.manage().getCookies();
        int siraNo=1;

        for (Cookie eachCookie : cookiesSeti
             ) {
            System.out.println(siraNo + "- " + eachCookie);
            siraNo++;
        }

        // 3- sayfadaki cookies sayısının 5'den büyük olduğunu test edin
        Assert.assertTrue(cookiesSeti.size()>5);

        // 4- ismi i18n-prefs olan cookie değeiernin USD olduğunu test edin
        String expectedCookieDegeri = "USD";
        String actualCookieDegeri ="";
        for (Cookie eachCookie : cookiesSeti
        ) {
            if(eachCookie.getName().equals("i18n-prefs")){
                actualCookieDegeri = eachCookie.getValue();
            }
        }

        Assert.assertEquals(expectedCookieDegeri,actualCookieDegeri);

        // 5- ismi "en sevdiğim cookie' ve degeri "cikolatali" olan bir cookie oluşturun
        // ve sayfaya eklendiğini test edin
        Cookie benimCookie = new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(benimCookie);

        cookiesSeti = driver.manage().getCookies();
        siraNo=1;

        for (Cookie eachCookie : cookiesSeti
        ) {
            System.out.println(siraNo + "- " + eachCookie);
            siraNo++;
        }

        // 6- eklediğiniz cookie'nin sayaya eklendiğini test edin
        expectedCookieDegeri = "cikolatali";
        int cikolataliCookieSayisi = 0;

        for (Cookie eachCookie : cookiesSeti
        ) {
            if(eachCookie.getName().equals("en sevdigim cookie")){
                cikolataliCookieSayisi++;
            }
        }
        Assert.assertTrue(cikolataliCookieSayisi>0);

        // 7- ismi skin olan cookie'yi silin ve silindiğini test edin

        driver.manage().deleteCookieNamed("skin");
        cookiesSeti = driver.manage().getCookies();

        int skinCookieSayisi = 0;
        for (Cookie eachCookie : cookiesSeti
        ) {
            if(eachCookie.getName().equals("skin")){
                skinCookieSayisi++;
            }
        }

        Assert.assertEquals(0,skinCookieSayisi);

        // 8- tüm cookie'leri silin ve silindiğini test edin
        driver.manage().deleteAllCookies();
        cookiesSeti = driver.manage().getCookies();
        Assert.assertEquals(0,cookiesSeti.size());
    }
}
