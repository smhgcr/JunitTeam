package day11_seleniumwaits_cookies;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C02_ExplicitlyWait {

    protected WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void implicitWaitTest(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // 1- https://the-internet.herokuapp.com/dynamic_controls adresine gidin
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // 2- Remove butonuna basın
        driver.findElement(By.xpath("//button[text()='Remove']")).click();

        // 3- "It's gone!" mesanının görüntülendiğini doğrulayın
        WebElement itsGoneElementi = driver.findElement(By.xpath("//p[@id='message']"));

        Assert.assertTrue(itsGoneElementi.isDisplayed());

        // 4- Add butonuna basın
        driver.findElement(By.xpath("//button[text()='Add']")).click();

        // 5- "It's back!" yazısının göründüğünü test edin
        WebElement itsBackElementi = driver.findElement(By.xpath("//p[@id='message']"));

        Assert.assertTrue(itsBackElementi.isDisplayed());


    }

    @Test
    public void explicitWaitTest(){

        // 1- https://the-internet.herokuapp.com/dynamic_controls adresine gidin
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // 2- Remove butonuna basın
        driver.findElement(By.xpath("//button[text()='Remove']")).click();


        // 3- "It's gone!" mesanının görüntülendiğini doğrulayın
        // Explicitly wait için önce wait objesi oluşturalım
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // bundan sonraki adımı belirlerken
        // işlem yapmak istediğimiz elementin locate edilebilir
        // olup olmadığı önemlidir.
        // Eğer locate edilebilirse, önce locate edip, sonra wait objesi ile o web element bekletilebilir.
        // locate edilemiyorsa wait objesine bekleme emri locater olarak verilebilir.

        WebElement itsGoneElementi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertTrue(itsGoneElementi.isDisplayed());


        // 4- Add butonuna basın
        driver.findElement(By.xpath("//button[text()='Add']")).click();

        // 5- "It's back!" yazısının göründüğünü test edin

        WebElement itsBackElementi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));

        Assert.assertTrue(itsBackElementi.isDisplayed());

    }


}

