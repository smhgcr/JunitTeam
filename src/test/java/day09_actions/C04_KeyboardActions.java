package day09_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C04_KeyboardActions extends TestBase {

    @Test
    public void test01(){
        //1- "https://www.amazon.com/" sayfasına gidin
        driver.get("https://www.amazon.com/");

        //2- Arama kutusuna actions method'ları kullanarak
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));

        Actions actions = new Actions(driver);
        actions
                .click(aramaKutusu)
                .keyDown(Keys.SHIFT)
                .sendKeys("s")
                .keyUp(Keys.SHIFT)
                .sendKeys("amsung ")
                .keyDown(Keys.SHIFT)
                .sendKeys("a")
                .keyUp(Keys.SHIFT)
                .sendKeys("71")
                .sendKeys(Keys.ENTER)
                .perform();

        ReusableMethods.bekle(3);

        //  "Samsung A71" yazdırın ve Enter'a basarak arama yaptırın
        WebElement sonucYazisiELementi = driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));

        String expectedKelime = "Samsung A71";
        String actualSonucYazisi = sonucYazisiELementi.getText();

        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));
    }
}
