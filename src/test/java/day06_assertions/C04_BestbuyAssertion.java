package day06_assertions;

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

public class C04_BestbuyAssertion {

    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com");
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    public void urlTest(){
    // Sayfa url'nin https://www.bestbuy.com/ ' a eşit olduğunu test edin

        String expectedURL = "https://www.bestbuy.com/";
        String actualURL = driver.getCurrentUrl();
        System.out.println(actualURL);
        Assert.assertTrue(actualURL.equals(expectedURL));

    }

    @Test
    public void titleTest(){
        // titleTest => Sayfa baslığının "Rest" içermediğini(contains) test edin

        String expectedIcermeyenKelime = "Rest";
        String actualTitle = driver.getTitle();

        Assert.assertFalse(actualTitle.contains(expectedIcermeyenKelime));
    }

    @Test
    public void logoTest(){
        // logoTest => BestBuy logosunun görüntülendiğinin testini yapın.

        WebElement logoElementi = driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(logoElementi.isDisplayed());
    }

    @Test
    public void unitedStateLinkTest(){
        // unitedStateisLinkTest => UnitedStates linkinin görüntülendiği testi

        WebElement unitedStatesLink = driver.findElement(By.xpath("(//img[@alt='United States'])[1]"));

        Assert.assertTrue(unitedStatesLink.isDisplayed());

    }



}
