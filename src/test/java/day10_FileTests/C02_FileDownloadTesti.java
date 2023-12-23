package day10_FileTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C02_FileDownloadTesti extends TestBase {

    @Test
    public void test01(){

        // 1. https://https://the-internet.herokuapp.com/download adresine gidelim
        driver.get("https://the-internet.herokuapp.com/download");

        ReusableMethods.bekle(3);
        // 2. logo.pgn dosyasını indirelim
        driver.findElement(By.xpath("//a[text()='logo.png']")).click();
        ReusableMethods.bekle(3);

        // 3. Dosyanın başarılı bir şekilde indirilip, indirilmediğini test edelim


        // Test için öncelikle dosyanın indirildiğinde dosyaYolu ne olacak bunu oluşturulmalıyız

        String dosyaYolu = System.getProperty("user.home") + "/Downloads/logo.png";

        // Bir dosyanın bilgisayarımızda var olduğunu (exist) test etmek için
        // Javadaki Files class'ından yardım alacağız
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }

    @Test
    public void test02(){
        // Masaüstünde MerhabaJava.docx dosyası olduğunu test edin.

        // dinamik dosya yolunu oluştur.
        String dosyaYolu = System.getProperty("user.home") + "/Desktop/MerhabaJava.docx";

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
}
