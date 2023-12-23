package day13_writeExcel_Screenshot;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {

    @Test
    public void test01() throws IOException {

        // excel dosyaları bilgisayarımızda olduğu için
        // Java'dan FileInputStream class'i yardımıyla ulaşacağız

        String dosyaYolu = "src/test/java/day12_webtables_excel/ulkeler.xlsx";

        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fileInputStream);

        System.out.println(workbook.getSheet("Sayfa1").getRow(3).getCell(1));

        // satır ve sutun bilgisini parametre olarak alıp
        // o hücredeki bilgiyi yazdıran method oluşturalım

        dataYazdir(23,2); // Batı Shra
        dataYazdir(14,3); // Tiran

    }

    private void dataYazdir(int satir, int sutun) throws IOException {

        String dosyaYolu = "src/test/java/day12_webtables_excel/ulkeler.xlsx";

        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fileInputStream);

        System.out.println(workbook.getSheet("Sayfa1").getRow(satir).getCell(sutun));

    }


}


