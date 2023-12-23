package day12_webtables_excel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C01_WebTables extends TestBase {

    @Test
    public void test01(){

        // 1. "https://demoqa.com/webtables" sayfasına gidin
        driver.get("https://demoqa.com/webtables");

        // 2. Headers da bulunan başlıkları yazdırın
        WebElement headerElementi = driver.findElement(By.xpath("//div[@class='rt-thead -header']"));
        System.out.println("başlıktaki bilgiler " +"\n"+ headerElementi.getText());

        // 3. 3. sutun başlığını yazdırın
        List<WebElement> basliklarListesi = driver.findElements(By.xpath("//div[@class='rt-th rt-resizable-header -cursor-pointer']"));
        System.out.println("****** " + "\n" + basliklarListesi.get(2).getText());

        // 4. Tablodaki tüm dataları yazdırın
        WebElement bodyElementi = driver.findElement(By.xpath("//div[@class='rt-tbody']"));
        System.out.println("body " + "\n"+ bodyElementi.getText());

        // 5. Tabloda kaç tane boş olmayan cell (data) olduğunu yazdırın
        List<WebElement> datalarListesi = driver.findElements(By.xpath("//div[@class='rt-td']"));

        int siraNo = 1;
        for ( WebElement eachElement: datalarListesi
             ) {
            if(!(eachElement.getText().equals("") || eachElement.getText().equals(" "))) {
                System.out.println(siraNo + ".- " + eachElement.getText());
                siraNo++;
            }
        }

        // 6. Tablodaki satır sayısını yazdırın
        List<WebElement> satirElementleriListesi = driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
        System.out.println("Tablodaki satır sayısı: " + satirElementleriListesi.size());


        // 7. Tablodaki sutun sayısını yazdırın
        // (başta başlıklar listesi oluşturmuştuk onun size'ını alalım
        System.out.println("Tablodaki sutun sayısı: " + basliklarListesi.size());

        // 8. Tablodaki 3. kolonu yazdırın
        List<WebElement> ucuncuSutunDatalarListesi = driver.findElements(By.xpath("//div[@class='rt-tr-group']//div[1]/div[3]"));
        System.out.println("Tablodaki 3. kolondaki datalar");
        siraNo=1;
        for ( WebElement eachElement: ucuncuSutunDatalarListesi
        ) {
            if(!(eachElement.getText().equals("") || eachElement.getText().equals(" "))) {
                System.out.println(siraNo + ".- " + eachElement.getText());
                siraNo++;
            }
        }

        // 9. Tabloda "First Name" i Kierra olan kişinin Salary'sini yazdırın
        // index'i saydıralım Kierra'yı bulunca, index'in 4 fazlasını yazdıralım

        for(int i=0; i<datalarListesi.size(); i++){

            if(datalarListesi.get(i).getText().equals("Kierra")){
                System.out.println("İstenen kişinin maaşı= " + datalarListesi.get(i+4).getText());
            }
        }

        // 10. Page sayfasına bir method oluşturun
        // Test sayfasından satır ve sutun sayısını girdiğimizda datayı yazdırsın
    }
}
