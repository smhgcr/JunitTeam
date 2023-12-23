package day07_dropdown_jsAlerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_handleDropdownMenu {

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

        // ilgili ayarları yapıp
        // amazon anasayfaya gidin
        // arama kutusundaki dropdown menuden book secin
        // arama kutusuna java yazdirip aramayı yapın
        // title, Java içerdiğini test edin

        driver.get("https://www.amazon.com");

        // DropdownMenuden istediğimiz optionu seçebilmek için
        // öncelikle Select class'indan bir obje oluşturmalıyız.
        // ancak select objesi oluştrumak için Select class'inin constructor'i
        // handle edeceğimiz webelement'i istedğinden
        // 1- Select objesi oluşturmadan once dropdown webelementi locate etmeliyiz

        WebElement dropDownWebElement = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        // 2- Select class'indan obje oluşturmak
        Select select = new Select(dropDownWebElement);

        // 3- select objesini kullanarak istedğimiz method/method'lari calistirin

        //select.selectByValue("search-alias=stripbooks-intl-ship");
        //select.selectByIndex(5);
        select.selectByVisibleText("Books");

        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java"+ Keys.ENTER);

        String expectedKelime = "Java";
        String actualTitle = driver.getTitle();
        //System.out.println(actualTitle);
        Thread.sleep(1000);
        Assert.assertTrue(actualTitle.contains(expectedKelime));


        // dropdown menuden book seceneğinin seçildiğini test edin.
        /*
        * Locate ettiğimiz elementi bulamazsa -> NoSuchElementException
        * Sayfa yenilendiği için var olan elementi bulamazsa -> StaleElementException hatası verir
        * bu durumda locate ve secme işlemini yeniden yaparsak kodumuz çalışır.
        * */
        dropDownWebElement = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        select = new Select(dropDownWebElement);
        select.selectByVisibleText("Books");

        String actualSecilenOption = select.getFirstSelectedOption().getText();
        String expectedSecilecekOption = "Books";

        Assert.assertEquals(expectedSecilecekOption,actualSecilenOption);

        // Dropdown menudeki seçenek sayisinin 24 olduğunu test edin

        List<WebElement> optionsWebElementListesi = select.getOptions();

        int actualOptionSayisi = optionsWebElementListesi.size();
        int expectedOptionSayisi = 28;

        Assert.assertEquals(expectedOptionSayisi,actualOptionSayisi);


        Thread.sleep(3000);

    }
}
