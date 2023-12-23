package day06_assertions;

import org.junit.Assert;
import org.junit.Test;

public class C02_Assertion {

    /*
    * jUnit frameworku çalıştırılan testlerin passed veya failed olmasinin raporlar
    * Ancak raporlamanın doğru sonuç vermesi için
    * Testlerin Assert class'ındaki methodlarla ypilmasi gerekir
    *
    * Eğer Assert class'i kulanmazsa
    * Junir kodlari sorunsuz olarak çalıştığını raporlar
    * C01'de testler if-else ile yaptığımız için
    * Testler failed olsa da kodlar sorunsuz çalıştığı için
    * testler yeşil tik olarak işaretlendi
    * */

    int P1yas = 60;
    int P2yas = 66;
    int P3yas = 70;

    @Test
    public void test01(){
        // emekli yasi 65 olduguna gore
        // P2'nin emekli olabileceğini test edin

        Assert.assertTrue(P2yas>65);
    }

    @Test
    public void test02(){
        // emekli yasi 65 olduguna gore
        // P1'in emekli olamayacagını test edin

        Assert.assertFalse(P1yas>65);
    }

    @Test
    public void test03(){
        // emekli yasi 65 olduguna gore
        // P3'in emekli olamayacagını test edin

        Assert.assertFalse("Girilen yas 65'den kucuk olmadigindan emekli olabilir.",P3yas>65);
    }



}
