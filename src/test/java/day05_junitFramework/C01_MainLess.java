package day05_junitFramework;

import org.junit.Ignore;
import org.junit.Test;

public class C01_MainLess {

    @Test
    public void test01(){
        System.out.println("test01 calisti");
        // @Test notasyonu sayesinde herbir test methodu bağızsız olarak çalışabilir.
        // Eğer testin içerisinde bir assertion yoksa
        // kod problem yaşanmadan çalişip bittiğinde
        // JUnit test passed olarak raporlar
    }

    @Test @Ignore
    public void test02(){
        System.out.println("test02 calisti");
        // @Ignore notasyonu yazildiği test methodunun çalıştırılmamasını sağlar
    }

    @Test
    public void test03(){
        System.out.println("test03 calisti");
    }


}
