package day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_AssertionMethodlari {

    static WebDriver driver;
    @BeforeClass
    // @BeforeClass ve @AfterClass notasyonu kullanan methodlar
    // static olmak zorundadır
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        System.out.println("setUp method calisti");
    }

    @AfterClass
    public static void tearDown(){
        System.out.println("tearDown methodu calisti");
        driver.close();
    }

    @Test
    public void test01(){
        // 1.method amazona gidip, amazona gidildigini test et
        driver.get("https://www.amazon.com");

        String expectedKelime = "Amazon";
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedKelime));
    }

    @Test
    public void test02(){
        // 2. method amazonda nutella aratip sonuclari nutella icerdigini test edin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        String expectedKelime = "Nutella";
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        String sonucYazisiStr = sonucYaziElementi.getText();

        Assert.assertTrue(sonucYazisiStr.contains(expectedKelime));
    }

    @Test
    public void test03(){
        // 3.method'da nutella arama sonuc sayisinin 50'den fazla oldugunu test edin
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        String sonucYazisiStr = sonucYaziElementi.getText();
        //System.out.println(sonucYazisiStr);

        String[] sonucYazisiArr = sonucYazisiStr.split(" ");
        String sonucAdediStr = sonucYazisiArr[2];
        int actualSonucAdediInt = Integer.parseInt(sonucAdediStr);
        System.out.println(actualSonucAdediInt);

        int expectedAramaSonucSayisi = 50;

        Assert.assertTrue(actualSonucAdediInt>expectedAramaSonucSayisi);

    }
}
