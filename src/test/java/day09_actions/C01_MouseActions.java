package day09_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.Set;

public class C01_MouseActions extends TestBase {


    @Test
    public void test01(){
        // 1- Yeni bir class olusturalım MouseActions1
        // 2- "https://the-internet.herokuapp.com/context_menu" sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

        // 3- Çizili olan üzerinde sağ click yapın
        Actions actions = new Actions(driver);
        WebElement ciziliAlanElementi = driver.findElement(By.xpath("//*[@id='hot-spot']"));
        actions.contextClick(ciziliAlanElementi).perform();

        ReusableMethods.bekle(2);

        // 4- Alert'te çıkan yazının "You selected a context menu" olduğunu test edin
        String expectedAlertYazisi = "You selected a context menu";
        String actualAlertYazisi = driver.switchTo().alert().getText();

        Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);

        // 5- Tamam diyerek alert'i kapatalım
        driver.switchTo().alert().accept();

        // 6- Elemental Selenium linkine tıklayalım
        String ilkSayfaWHD = driver.getWindowHandle();
        System.out.println(ilkSayfaWHD);
        driver.findElement(By.linkText("Elemental Selenium")).click();

        // 7- Açılan sayfada h1 tagında "Make sure your code lands" yazdığını test edelim

        Set<String> ikiSayfaninWHDSeti = driver.getWindowHandles();

        String ikinciSayfaWHD = "";
        for (String eachWHD : ikiSayfaninWHDSeti) {

            if(!eachWHD.equals(ilkSayfaWHD)){
                ikinciSayfaWHD = eachWHD;
            }
        }

        driver.switchTo().window(ikinciSayfaWHD);

        String expectedYeniSayfaYazi = "Make sure your code lands";
        String actualYeniSayfaYazi = driver.findElement(By.tagName("h1")).getText();

        Assert.assertEquals(expectedYeniSayfaYazi,actualYeniSayfaYazi);


        ReusableMethods.bekle(3);

    }
}
