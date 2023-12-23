package day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_BeforeClassAfterClass {

    // 3 ayri test methodu olustur
    // 1. methodda amazona gidip, amazona gittiginizi test edin
    // 2. methodda amazona nutella aratip sonuclari nutella icerdigini test edin
    // 3. methodda mutella arama sonuc sayisinin 50den fazla oldugunu test edin
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

        if(actualTitle.contains(expectedKelime)){
            System.out.println("Amazon gidis test PASSED");
        }else{
            System.out.println("Amazon gidis test FAILED");
        }

    }

    @Test
    public void test02(){
        // 2. method amazonda nutella aratip sonuclari nutella icerdigini test edin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        String expectedKelime = "Nutella";
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        String sonucYazisiStr = sonucYaziElementi.getText();

        if(sonucYazisiStr.contains(expectedKelime)){
            System.out.println("Nutella arama testi PASSED");
        }else{
            System.out.println("Nutella arama testi FAILED");
        }
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

        if(actualSonucAdediInt>expectedAramaSonucSayisi){
            System.out.println("Nutella arama sonuc sayisi testi PASSED");
        }else {
            System.out.println("Nutella arama sonuc sayisi testi FAILED");
        }

    }



}
