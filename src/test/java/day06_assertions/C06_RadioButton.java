package day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_RadioButton {

    // Gerekli yapiyi oluşturun ve aşağıdaki görevi tamamlayın

    // 1. Verilen web sayfasına gidin
    // https://www.facebook.com
    // 2. Cookies'i kabul edin
    // 3. Create an account butona basın.
    // 4. Radio buton elementlerini locate edin ve size uygun olanı seçin

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
       driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.facebook.com");

        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        WebElement maleRadioButtonLocator = driver.findElement(By.xpath("(//input[@type='radio'])[2]"));

        if(!maleRadioButtonLocator.isSelected()){
            maleRadioButtonLocator.click();
        }
        Thread.sleep(1000);
        Assert.assertTrue(maleRadioButtonLocator.isSelected());

    }





}
