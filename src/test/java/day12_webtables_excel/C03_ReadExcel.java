package day12_webtables_excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class C03_ReadExcel {

    @Test
    public void test01() throws IOException {

        // ulkeler excelinde Sayfa1'e gidecek şekilde ayarlar yapalım
        String dosyaYolu = "src/test/java/day12_webtables_excel/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        // 1.satırdaki 2. hücreye gidelim ve yazıralım
        System.out.println(workbook.getSheet("Sayfa1").getRow(0).getCell(1));

        // 1. satırdaki 2. hücreyi bir string değişkenine atayalım ve yazdıralım
        String istenenHucredekiStr = workbook.getSheet("Sayfa1").getRow(0).getCell(1).toString();
        System.out.println(istenenHucredekiStr);

        // 5. satır, 4. cell'in afganistan'ın başkenti olduğunu test edelim
        String actualBaskent = workbook.getSheet("Sayfa1").getRow(4).getCell(3).toString();
        String expectedBaskent = "Kâbil";
        Assert.assertEquals(expectedBaskent,actualBaskent);

        // Satır sayısını bulalım.
        System.out.println("Satır sayısı " + (workbook.getSheet("Sayfa1").getLastRowNum()+1));

        // Fiziki olarak kullanılan satır sayısını bulun
        // Bunu için Sayfa2'deki son satır index'ini ve fiziki kullanılan satır sayısını yazdıralım

        System.out.println("2. Sayfa son satır index'i: " + workbook.getSheet("Sayfa2").getLastRowNum());
        System.out.println("2. Sayfa fiziki kullanılan satır sayısı: " + workbook.getSheet("Sayfa2").getPhysicalNumberOfRows());

        // ingilizce ülke isimleri ve başkentleri bir map olarak kaydedelim.
        // ülke ismi ingilizce --> key, geriye kalan 3 bilgi birleştirilerek value olsun

        Map<String,String> ulkelerMap = new TreeMap<>();

        int sonSatirIndexi = workbook.getSheet("Sayfa1").getLastRowNum();
        String key="";
        String value="";

        for (int i = 0; i <= sonSatirIndexi ; i++) {

            key = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            value= workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString() + ", " +
                    workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString() + ", " +
                    workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();

            ulkelerMap.put(key,value);
        }

        System.out.println(ulkelerMap);
    }
}
