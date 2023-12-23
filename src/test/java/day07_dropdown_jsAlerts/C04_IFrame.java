package day07_dropdown_jsAlerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_IFrame {

    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {

        // 1- https://the-internet.herokuapp.com/iframe  adresine gidin
        driver.get("https://the-internet.herokuapp.com/iframe");
        // 2- Bir method olusturun: iframeTest
        // - "An IFrame containing.." textinin erişilebilir olduğunu test edin
        // ve konsolda yazdirin
        WebElement actualSayfaYazisiElementi = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(actualSayfaYazisiElementi.isEnabled());
        Thread.sleep(3000);


        // - TextBox'a "Merhaba Dunya!" yazin.

        // normal locate yapip yazdirmayi denediğimizde NoSuchElementException verdi
        // yani elementi bulamadı
        // kontrol ederken istediğimiz webelement'in bir iframe icinde oldugunu gordul
        // Bu durumda once o iframe'e switchTo() yapmaliyiz.

        WebElement iframeWebElementi = driver.findElement(By.xpath("//*[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframeWebElementi);
        WebElement yaziKutuElementi = driver.findElement(By.xpath("//body[@id='tinymce']"));
        yaziKutuElementi.clear();
        yaziKutuElementi.sendKeys("Merhaba Dunya!");
        Thread.sleep(3000);

        // - TextBox'in altinda bulunan "Elemental Selenium" linkini textinin gorunur oldugunu dogrulayin
        // ve konsolda yazdirin

        // Iframe içine girdikten sonra oradan çık denilinceye kadar driver iframe içinde kalır
        // Eğer dışına çıkmak isterseniz

        driver.switchTo().parentFrame();  // bulundugu iframe'den bir üst html sayfasına geçer
        // bu daha cok ic ice iframe'ler oldugunda tercih edilir.


        driver.switchTo().defaultContent(); // anasayfaya geçiş yapar.

        WebElement elementalSeleniumLinkElementi = driver.findElement(By.xpath("//div[text()='Powered by ']"));
        Assert.assertTrue(elementalSeleniumLinkElementi.isDisplayed());

        System.out.println(elementalSeleniumLinkElementi.getText());





    }
}
