package day12_webtables_excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel {

    @Test
    public void test01() throws IOException {

        // dosya yolu oluşturulur
        String dosyaYolu = "src/test/java/day12_webtables_excel/ulkeler.xlsx";

        // FileInputStream objesi oluşturup, parametre olarak dosya yolunu yazalım
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);

        // kod alanımızda excelin bir kopyasını oluşturup
        // tüm bilgileri ona kopyalayacağız

        Workbook workbook = WorkbookFactory.create(fileInputStream);

        // workbook içerisinde birden fazla sayfa olabilir
        // istediğimiz sayfaya gidelim

        Sheet sheet = workbook.getSheet("Sayfa1");

        // Andola yazdırmak istediğimiz için 10. satıra gidelim

        Row row = sheet.getRow(10);

        // 10. satırdaki 2. indexi alalım

        Cell cell = row.getCell(2);

        System.out.println(cell);


    }

}
