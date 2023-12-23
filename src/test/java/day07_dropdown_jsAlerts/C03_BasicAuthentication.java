package day07_dropdown_jsAlerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BasicAuthentication {

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
        // 2- https://the-internet.herokuapp.com/basic_auth  adresine gidin
        driver.get("https://the-internet.herokuapp.com/basic_auth");
        Thread.sleep(3000);
        // aşağıdaki yöntem ve test datalari kullanarak authentication'i yapin
        //
        //Html komutu: htps://username:password@URL
        // Username : admin
        // password : admin
        //
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        // 4- Başarılı şekilde sayfaya girildiğini doğrulayin

        String actualSonucYazisi = driver.findElement(By.tagName("p")).getText();
        String expectedKelime = "Congratulations";

        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));


    }
}
