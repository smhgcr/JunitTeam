package day13_writeExcel_Screenshot;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C03_TakeScreenshotTumSayfa extends TestBase {

    @Test
    public void test01() {

        // amazon'a gidip
        driver.get("https://www.amazon.com");
        // Nutella arat
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        // arama sonuçlarının Nutella içerdiğini test edin

        WebElement aramaSonucElementi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String expectedKelime = "Nutella";
        String actualAramaSunucu = aramaSonucElementi.getText();

        Assert.assertTrue(actualAramaSunucu.contains(expectedKelime));


        // Tüm sayfanın screenshot'ını alın

       ReusableMethods.tumSayfaScreenshotCek(driver);


        ReusableMethods.bekle(3);


    }
}
