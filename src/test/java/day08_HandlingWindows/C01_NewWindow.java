package day08_HandlingWindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_NewWindow {

    /*
    * Selenium 4 ile windows konusunda yeni bir özellik geldi.
    *
    * İstersek kontrollü olarak driver için yeni bir window veya tab oluşturabiliriz.
    * Bu durumda driver'imiz da otomatik olarak yeni sayfaya geçmiş olur.
    *
    *
    * Testin ilerleyen aşamalarında yeniden eski sayfalara dönüş görevi varsa
    * o sayfada iken o sayfanin window Handle değeri alınıp, kaydedilir
    * ve o sayfaya geçmek istendiğinde
    * driver.switchTo().window(istenenSayfaninWindowHandleDegeri)
    * kodu ile o sayfaya geçiş yapılır.
    * */


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
        driver.quit();
    }


    @Test
    public void test01() throws InterruptedException {

        driver.get("https://www.amazon.com");
        Thread.sleep(3000);

        // Testin ilerleyen aşamalarında yeniden amazın sayfasına dönmek gerekiyorsa
        // amazon sayfasındayken bu window'un window Handle değerini alıp kaydetmeliyiz.

        String ilkSayfaHandleDegeri = driver.getWindowHandle();


        // yeni bir tab'da wisequarter.com'a gidin ve gittiğinizi test edin

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.wisequarter.com");


        String actualUrl = driver.getCurrentUrl();
        String expectedString = "wisequarter";
        Assert.assertTrue(actualUrl.contains(expectedString));
        Thread.sleep(3000);

        // wisequarter testini yaptıktan sonra
        // yeniden amazonun açık olduğu taba geçin
        // ve amazon anasayfanın açık olduğunu test edin

        driver.switchTo().window(ilkSayfaHandleDegeri);
        actualUrl = driver.getCurrentUrl();
        expectedString = "amazon";
        Assert.assertTrue(actualUrl.contains(expectedString));
        Thread.sleep(3000);


    }

}
