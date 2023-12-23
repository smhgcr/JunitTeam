package day13_writeExcel_Screenshot;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_WriteExcel {

    @Test
    public void test01() throws IOException {

        // Excel dosyasından kopyaladığımız workbook objesi üzerinde değişiklik yapabiliriz
        // Bunun için öncelikle excel'in kopyası olan workbook'u oluşturalım

        String dosyaYolu = "src/test/java/day12_webtables_excel/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        // 5. sutun olarak Nufus başlığı ile bir sutun oluşturalım
        workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("Nufus");

        // 3. satırdaki nufus bilgisini 1500000 yapalım
        workbook.getSheet("Sayfa1").getRow(2).createCell(4).setCellValue(1500000);

        // 7. satırdaki nufus bilgisini 3000000 yapalım
        workbook.getSheet("Sayfa1").getRow(6).createCell(4).setCellValue(3000000);

        // Yaptığımız değişiklikler kopya workbook üzerinde
        // bu değişiklikleri excel dosyasına kaydetmek için
        // bunun için FileOutpuStream class'ini kullanmalıyız

        FileOutputStream fos = new FileOutputStream(dosyaYolu);
        workbook.write(fos);

        workbook.close();
        fis.close();
        fos.close();

    }
}
