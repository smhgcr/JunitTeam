package day08_HandlingWindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class C02_WindowHandles {


    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test01() throws InterruptedException {
        // https://the-internet.herokuapp.com/windows adresine git
        driver.get("https://the-internet.herokuapp.com/windows");

        // Sayfadaki textin "Opening a new window" olduğunu doğrulayın
        String expectedSayfaYazisi = "Opening a new window";
        String actualSayfaYazisi = driver.findElement(By.tagName("h3")).getText();

        Assert.assertEquals(expectedSayfaYazisi,actualSayfaYazisi);

        // Sayfa başlığının(title) "The Internet" olduğunu doğrulayın
        String expectedSayfaTitle = "The Internet";
        String actualSayfaTitle = driver.getTitle();
        String ilkSayfaHandleDegeri = driver.getWindowHandle();

        Assert.assertEquals(expectedSayfaTitle,actualSayfaTitle);

        // Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();
        Thread.sleep(3000);

        /*
        * Kontrolsüz açılan tab'a geçiş yapmak için
        * 1- ilk sayfada iken o sayfanın WindowHandle degerini alıp kaydedin
        * 2- 2.sayfa açıldıktan sonra getWindowHandles() kullanarak
        *      açık olan tüm sayfaların WH değerlerini bir Set olarak kaydedin
        * 3- Şu anda elimizde 2 elementli bri Set var,
        *    elementlerden bir tanesi 1.sayfanın WHD
        *    1. sayfanın WHD'ine eşit olmayan ise 2.sayfanın WHD olur.
        * 4- bu şekilde 2.sayfanın WHD elde edildikten sonra
        *    WHD'leri kullanılarak sayfalar arasında geçiş yapılabilir.
        * */


        Set<String> tumWHDegerlerSeti = driver.getWindowHandles();
        String ikinciSayfaWHD="";
        for (String eachWhd : tumWHDegerlerSeti){
            if(!eachWhd.equals(ilkSayfaHandleDegeri)){
                ikinciSayfaWHD = eachWhd;
            }
        }


        // Açılan yeni pencerenin sayfa başlığının (title) "New Window" olduğunu doğrulayın
        driver.switchTo().window(ikinciSayfaWHD);
        String expectedNewSayfaTitle = "New Window";
        String actualNewSayfaTitle = driver.getTitle();

        Assert.assertEquals(expectedNewSayfaTitle,actualNewSayfaTitle);

        // Sayfadaki textin "New Window" olduğunu doğrulayın.
        String expectedYeniSayfaYazi="New Window";
        String actualYeniSayfaYazi = driver.findElement(By.tagName("h3")).getText();

        Assert.assertEquals(expectedNewSayfaTitle,actualYeniSayfaYazi);

        // Bir önceki pencereye geri döndükten sonra sayfa başlığının "The Internet" olduğunu doğrulayın
        driver.switchTo().window(ilkSayfaHandleDegeri);
        expectedSayfaTitle = "The Internet";
        actualSayfaTitle = driver.getTitle();

        Assert.assertEquals(expectedSayfaTitle,actualSayfaTitle);

        Thread.sleep(3000);

    }


}
