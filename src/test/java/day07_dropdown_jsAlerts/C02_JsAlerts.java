package day07_dropdown_jsAlerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_JsAlerts {

    // gerekli ayarlamaları yapıp
    // https://the-internet.herokuapp.com/javascript_alerts  adresine gidin
    // 3 test methodu oluşturup, her method'da bir JsAlert'e basn
    // İlgili methodlari kullanın

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
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // 1. alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();

        // Alert'deki yazinin "I am a JS Alert" olduğunu test edelim
        String actualAlertText = driver.switchTo().alert().getText();
        String expectedAlertText = "I am a JS Alert";

        Assert.assertEquals(expectedAlertText,actualAlertText);

        // Ok tuşuna basip alert'i kapatalim
        driver.switchTo().alert().accept();

        Thread.sleep(3000);
    }

    @Test
    public void test02() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // 2. alert'e tıklayalım
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();

        // cancel'e basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
        Thread.sleep(3000);
        driver.switchTo().alert().dismiss();

        String actualResultText = driver.findElement(By.xpath("//*[text()='You clicked: Cancel']")).getText();

        String expectedResultText = "You clicked: Cancel";

        Assert.assertEquals(expectedResultText,actualResultText);
    }

    @Test
    public void test03() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // 3. alert'e tıklayalım
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();

        // Çıkan prompt ekranına "Semih" yazdıralım ve OK tusuna basarak alert'i kapatalım
        driver.switchTo().alert().sendKeys("Semih");
        Thread.sleep(3000);
        driver.switchTo().alert().accept();

        // Çıkan sonuc yazisinin Semih içerdiğini test edelim

        String actualResultText = driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedText = "Semih";

        Assert.assertTrue(actualResultText.contains(expectedText));
    }

}
