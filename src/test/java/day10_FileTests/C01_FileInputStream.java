package day10_FileTests;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class C01_FileInputStream {

    @Test
    public void test01() throws FileNotFoundException {


        String dosyaYolu="/Users/semih/Desktop/MerhabaJava.docx";
        FileInputStream fis = new FileInputStream(dosyaYolu);

        /*
        * Dosya File testlerinde genellikle downloads'a indirilecek dosyanın
        * indirildiğini test etmek veya masaüstündeki bir dosyanın
        * web'e upload edildiğini test etmek isteriz
        *
        * Ancak herkesin bilgisayarının ismi kullanıcı isimleri gibi
        * farklılıklar olacağından testler tek bir bilgisayarda çalışacak gibi
        * yazılmak zorunda kalınır.
        *
        * Bu karışıklılığın önüne geçebilmek için java iki kod blogu sunmuş
        *
        * */

        System.out.println(System.getProperty("user.dir"));
        // o anda çalışan dosyanın (C01_FileInputStream) yolunu verir.
        // /Users/semih/IdeaProjects/com.wiseJUnit

        System.out.println(System.getProperty("user.home"));
        // kullanıcının temel path'inin verir
        // /Users/semih

        // Masaüstüne gitmek istersek
        // /Users/semih + /Desktop eklemeliyiz

        // Downloads'a gitmek istersek
        // /Users/semih + /Downloads eklememiz yeterlidir.

        // Kodlarımızın dinamik olması yani kişinin bilgisayarındaki
        // kullanıcı adı gibi detaylara takılmaması için
        // File testlerinde kullanılacak dosya yolunu
        // user.home ... temel path'ini çalıştığı bilgisayardan alacak şekilde
        // olutururuz

        String dinamikDosyaYolu = System.getProperty("user.home") + "/Desktop/MerhabaJava.docx";




    }

}
