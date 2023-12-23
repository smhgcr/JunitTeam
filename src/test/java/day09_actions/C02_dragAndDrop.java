package day09_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class C02_dragAndDrop extends TestBase {

    @Test
    public void test01(){

        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable" +
                "");
        //2- "Drag me" butonunu tutup "Drop here" kutusunun üstüne bırakalım
        WebElement dragMeElementi = driver.findElement(By.xpath("//div[@id='draggable']"));

        WebElement birakilacakAlanElementi  = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragMeElementi,birakilacakAlanElementi).perform();


        //3- "Drop here" yazısı yerine "Dropped!" olduğunu test edelim

        WebElement droppedYaziElementi = driver.findElement(By.xpath("//*[text()='Dropped!']"));
        Assert.assertTrue(droppedYaziElementi.isDisplayed());
    }
}
