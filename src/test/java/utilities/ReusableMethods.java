package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReusableMethods {

    public static void bekle(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {

        }
    }

    public static void tumSayfaScreenshotCek(WebDriver driver) {

        // 1- TakeScreenShot objesi oluştur
        TakesScreenshot tss = (TakesScreenshot) driver;

        // 2- resmi son olarak kaydedeceğimiz dosyayı oluştur.
        // Her resim çektiğinde üst üstte kaydetmemesi için resim dosya yoluna
        // tarih ve saat içeren ek yapalım

        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String tarih = ldt.format(dtf);
        String dosyaYolu = "target/ekranResimleri/tumEkranSS" + tarih + ".jpeg";
        File tumSayfaScreenshot = new File(dosyaYolu);

        // 3- tss objesi kullanarak ekran görüntüsü alıp geçici dosyaya kaydet
        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);
        // 4- Geçici dosyayı ana dosyaya kopyala
        try {
            FileUtils.copyFile(geciciDosya, tumSayfaScreenshot);

        } catch (IOException e) {

        }

    }

    public static void elementSSCek(WebElement element) {

        // 1- screenshot alacağımız elementi locate et
        // 2- Kaydedeceğimiz dosyayı oluştur
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String tarih = ldt.format(dtf);
        String dosyaYolu = "target/ekranResimleri/istenenElementSS" + tarih + ".jpeg";

        File elementSS = new File(dosyaYolu);
        // 3- Geçiçi dosyayı oluşturup, element üzerinden screenshot yapalım

        File gecici = element.getScreenshotAs(OutputType.FILE);

        // 4- Geçici dosyayı, hedef dosyaya kopyala

        try {
            FileUtils.copyFile(gecici, elementSS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
