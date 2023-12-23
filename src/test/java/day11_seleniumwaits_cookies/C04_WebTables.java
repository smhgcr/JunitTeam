package day11_seleniumwaits_cookies;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

import javax.swing.*;
import java.util.List;

public class C04_WebTables extends TestBase {

    @Test
    public void test01(){

        // 1- "https://www.amazon.com" adresine gidin
        driver.get("https://www.amazon.com");
        ReusableMethods.bekle(3);
        // 2- sayfanın en altına inin
        Actions action = new Actions(driver);
        action.sendKeys(Keys.END).perform();


        // 3- Web table tüm body'sini yazdırın
        WebElement tumBody = driver.findElement(By.xpath("//tbody"));
        System.out.println(tumBody.getText());

        // 4- Web table'daki satır sayısının 9 olduğunu test edin
        List<WebElement> satirlarListesi = driver.findElements(By.xpath("//tbody/tr"));
        Assert.assertEquals(8,satirlarListesi.size());

        // 5- Tüm satırları yazdırın
        for (WebElement eachRow: satirlarListesi
             ) {
            System.out.println(eachRow.getText());
        }

        // 6- Web table'daki sutun sayısının 13 olduğunu test edin
        List<WebElement> ucuncuSatirSutunSayisi = driver.findElements(By.xpath("//tbody/tr[3]/td"));
        Assert.assertEquals(13,ucuncuSatirSutunSayisi.size());

        // 7- 5. sutunu yazdırın
        List<WebElement> besinciSutunElementleri = driver.findElements(By.xpath("//tbody/tr/td[5]"));

        System.out.println("=============");
        for (WebElement eachElement: besinciSutunElementleri
             ) {
            System.out.println(eachElement.getText());
        }
        // 8- Satır ve sutun sayısını parametre olarak alıp, hücredeki bilgiyi döndüren bir method oluşturun

        System.out.println("----****----*****---****");
        WebElement istenenDataElementi = getElement(3,5);
        System.out.println(istenenDataElementi.getText());


        ReusableMethods.bekle(3);

    }

    private WebElement getElement(int satir, int sutun) {

        String dinamikXpath= "//tbody/tr["+satir+"]/td["+sutun+"]";
        WebElement istenenElement = driver.findElement(By.xpath(dinamikXpath));

        return istenenElement;
    }
}
