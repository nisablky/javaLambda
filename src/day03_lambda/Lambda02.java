package day03_lambda;

import day01_lambda.Lambda01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class Lambda02 {
    public static void main(String[] args) {

        List<String> menü = new ArrayList<>(Arrays.asList("kişleme", "adana", "triliçe", "havuçDilim", "buryan",
                "yağlama", "kokoreç", "arabAşı", "güveç"));

        alfBykTekrarsız(menü); //ADANA ARABAŞI BURYAN GÜVEÇ HAVUÇDİLİM KOKOREÇ KİŞLEME TRİLİÇE YAĞLAMA
        System.out.println("\n  ***  ");

        chrSayisiTersSirali(menü); //10 7 6 5
        System.out.println("\n  ***  ");

        chrSayisiBkSirala(menü); //adana güveç buryan kişleme triliçe yağlama kokoreç arabAşı havuçDilim
        System.out.println("\n  ***  ");

        sonHarfBkSirala(menü); //arabAşı kokoreç güveç buryan havuçDilim kişleme triliçe adana yağlama
        System.out.println("\n  ***  ");



    }

    // Task : List elemanlarını alfabetik büyük harf ve tekrarsız print ediniz.
    public static void alfBykTekrarsız(List<String> yemek) {
        yemek. //akış kaynağı
                stream().//akışa girdi
                // map(t->t.toUpperCase()). //Jamb.Ex elemanlar büyük harf update edildi
                        map(String::toUpperCase). //Method ref. elemanlar büyük harf update edildi
                sorted(). //alfabetik(naturel doğal) sıra yapıldı
                distinct(). //benzersiz : tekrarsız hale getirildi
                forEach(t -> System.out.print(t + " ")); //print edildi

        /*
         distinct() => Bu method tekrarlı elemanları sadece bir kere akışa sokar.
                       Bu akışın farklı elemanlarından (Object.equals(Object)'e göre) oluşan bir akış döndürür
                       Sıralı akışlar için, farklı elemanın seçimi sabittir
                       (yinelenen öğeler için, karşılaşma sırasında ilk görünen öğe korunur.)
                       Sırasız akışlar için, herhangi bir kararlılık garantisi verilmez.Sream return eder.

         */

    }

    // Task : List elemanlarının character sayisini ters sıralı olarak tekrarsız print ediniz
    public static void chrSayisiTersSirali(List<String> menü) {
        menü.
                stream(). // akışa alındı
                // map(t-> t.length()).
                        map(String::length). //elemanlar karakter sayısına update edildi
                sorted(Comparator.reverseOrder()). // tek sıra yapıldı
                distinct(). // benzersiz yapıldı
                // forEach(t-> System.out.print(t+" "));
                        forEach(Lambda01::yazdir); //print edildi
    }

    // Task : List elemanlarının character sayisina göre küçükten büyüğe göre print ediniz
    public static void chrSayisiBkSirala(List<String> menü) {
        menü.
                stream().
                sorted(Comparator.
                        comparing(String::length)).
                forEach(t -> System.out.print(t + " "));

    }

    // Task : List elemanlarının son harfine göre ters sıralı print ediniz
    public static void sonHarfBkSirala(List<String> menü) {
        menü.
                stream().
                sorted(Comparator.
                        comparing(t -> t.toString().
                                charAt(t.toString().length() - 1)). //elemanın length()-1) --> son index'inin karakterini alır
                                reversed()). //elemanın length()-1) --> son index'inin karakterini ters sıralar z->a
                forEach(t -> System.out.print(t + " "));

    }
}

