package day09_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C03_MoveToElement extends TestBase {

    @Test
    public void test01(){
        //1- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

        //2- Sag ust bolumde bulunan "Account & Lists" menüsünün açılması için mouse'u bu menünü üstüne getirin
        WebElement beklenecekElement = driver.findElement(By.id("nav-link-accountList"));
        Actions actions = new Actions(driver);
        actions.moveToElement(beklenecekElement).perform();
        ReusableMethods.bekle(3);

        //3- "Create a list" butonuna basın
        driver.findElement(By.xpath("//span[text()='Create a List']")).click();
        ReusableMethods.bekle(3);

        //4- Açılan sayfada "Your Lists" yazısı olduğunu test edin
        WebElement yourListElementi = driver.findElement(By.id("my-lists-tab"));

        Assert.assertTrue(yourListElementi.isDisplayed());
    }
}
