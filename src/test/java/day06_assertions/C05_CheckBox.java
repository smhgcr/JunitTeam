package day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_CheckBox {

    // Gerekli yapiyi olusturun ve asagidaki gorevi tamamlayın
    // 1. Verilen web sayfasına gidin. -> https://the-internet.herokuapp.com/checkboxes
    // 2. Checkbox1 ve checkbox2 elementlerini locate edin
    // 3. Checkbox1 seçili değilse onay kutusunu tıklanyın ve seçili olduğunu test edin.
    // 4. Checkbox2 seçili değilse onay kutusunu tıklayın ve seçili olduğunu test edin.

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }
    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {

        WebElement cb1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement cb2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));

        Thread.sleep(3000);
        // 3. Checkbox1 seçili değilse onay kutusunu tıklayın ve seçili olduğunu test edin.
        if(!cb1.isSelected()){
            cb1.click();
        }
        Assert.assertTrue(cb1.isSelected());

        Thread.sleep(3000);
        // 4. Checkbox2 seçili değilse onay kutusunu tıklayın ve seçili olduğunu test edin.
        if(!cb2.isSelected()){
            cb2.click();
        }
        Assert.assertTrue(cb2.isSelected());
        Thread.sleep(3000);
    }


}
