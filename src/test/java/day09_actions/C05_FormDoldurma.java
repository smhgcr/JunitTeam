package day09_actions;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.security.Key;

public class C05_FormDoldurma extends TestBase {

    @Test
    public void test01(){

        // facebook.com sayfasına gidin
        driver.get("https://www.facebook.com");

        // yeni hesap oluştur butonuna basın
        driver.findElement(By.linkText("Yeni hesap oluştur")).click();

        // ilgili alanları faker kütüphanesinden değerlerle doldurup
        // kaydol butonuna basın
        WebElement firstNameKutusu = driver.findElement(By.name("firstname"));

        Actions actions = new Actions(driver);
        Faker faker = new Faker();
        String mailAdresi = faker.internet().emailAddress();

        actions.click(firstNameKutusu)
                         .sendKeys(faker.name().firstName()).sendKeys(Keys.TAB)
                        .sendKeys(faker.name().lastName()).sendKeys(Keys.TAB)
                        .sendKeys(mailAdresi).sendKeys(Keys.TAB)
                        .sendKeys(mailAdresi).sendKeys(Keys.TAB)
                        .sendKeys(faker.internet().password()).sendKeys(Keys.TAB)
                        .sendKeys("11").sendKeys(Keys.TAB)
                        .sendKeys("Kas").sendKeys(Keys.TAB)
                        .sendKeys("1993").sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                        .sendKeys(Keys.ARROW_RIGHT).perform();

        ReusableMethods.bekle(3);
        WebElement signUpButonu = driver.findElement(By.name("websubmit"));
        signUpButonu.click();

        ReusableMethods.bekle(3);
        // kayıt olamadığınızı test edin.
        WebElement hataMesajElementi = driver.findElement(By.id("reg_error_inner"));

        Assert.assertTrue(hataMesajElementi.isDisplayed());

        ReusableMethods.bekle(15);

    }
}
