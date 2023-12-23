package day08_HandlingWindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class C03_WindowHandle {


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
        // https://the-internet.herokuapp.com/iframe adresine git
        driver.get("https://the-internet.herokuapp.com/iframe");

        // elemental selenium linkine tıklayın
        // Linke tıkladığımızda yeni sayfa açıldığından
        // click yapmadan önce ilk sayfanın WHD'ini alıp kaydedelim
        String ilkSayfaWHD = driver.getWindowHandle();
        driver.findElement(By.linkText("Elemental Selenium")).click();

        // click yapınca yeni tab açılır ancak driver eski tab'da kalır
        // yeni tab'a driver'ı geçirmek için yeni tab'ın WHD ihtiyacımız var

        Set<String> ikiSayfaninWHDegerleriSeti = driver.getWindowHandles();
        String ikinciSayfaWHD="";

        for (String eachWHD: ikiSayfaninWHDegerleriSeti){
            if(!eachWHD.equals(ilkSayfaWHD)){
                ikinciSayfaWHD = eachWHD;
            }
        }

        // foreach loop bittiğinde ikinci sayfanın WHD elde etmiş olacağız
        // bu değeri kullanarak, driver'i ikinci sayfaya geçirebiliriz.
        driver.switchTo().window(ikinciSayfaWHD);

        // yeni tab'a geçip, sayfadaki en büyük yazının "Make sure your code lands" olduğunu test edin
        String expectedIkinciSayfaYazi = "Make sure your code lands";
        String actualIkinciSayfaYazi = driver.findElement(By.tagName("h1")).getText();
        Thread.sleep(3000);

        Assert.assertEquals(expectedIkinciSayfaYazi,actualIkinciSayfaYazi);


        // ilk sayfaya geri dönüp, sayfadaki yazının
        driver.switchTo().window(ilkSayfaWHD);
        // "An iFrame containing the TinyMCE WYSIWYG Editor" olduğunu test edin.
        String expectedIlkSayfaYazi="An iFrame containing the TinyMCE WYSIWYG Editor";
        String actualIlkSayfaYazi= driver.findElement(By.tagName("h3")).getText();

        Assert.assertEquals(expectedIlkSayfaYazi,actualIlkSayfaYazi);

        Thread.sleep(3000);
    }

}
