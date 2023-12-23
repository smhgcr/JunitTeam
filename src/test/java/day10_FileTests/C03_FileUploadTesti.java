package day10_FileTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C03_FileUploadTesti extends TestBase {

    @Test
    public void test01(){

        // https://https://the-internet.herokuapp.com/upload adresine git
        driver.get("https://the-internet.herokuapp.com/upload");

        // chooseFile butonuna bas
        // Yuklemek istediğimiz dosyayı seç


        /*
        * Bu görevi yapabilmek için chooseFile butonuna basıldığında
        * açılan bilgisayarımızdaki file dosyalarını click yapabilmemiz gerekir
        * ancak selenium bilgisayarımızdaki dosyaları click yapamaz
        *
        * Bunu yerine şöyle bir çözüm üretilmiştir.
        *
        * 1- chooseFile botununu locate edelim
        * 2- upload edilecek dosyanın dosya yolunu oluşturalım
        * 3- chooseFile butonuna sendKeys ile dosya yolunu gönderin
        * */
        WebElement choseFileButonu = driver.findElement(By.xpath("//*[@id='file-upload']"));

        String dosyaYolu = System.getProperty("user.home")+"/Desktop/MerhabaJava.docx";

        choseFileButonu.sendKeys(dosyaYolu);


        // Upload butonuna bas
        driver.findElement(By.xpath("//*[@id='file-submit']")).click();

        // "File Uploaded!" text'inin görüntülendiğini test edelim.
        WebElement fileUploadElementi = driver.findElement(By.tagName("h3"));

        Assert.assertTrue(fileUploadElementi.isDisplayed());

        ReusableMethods.bekle(5);


    }
}
