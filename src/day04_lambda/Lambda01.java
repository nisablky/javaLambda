package day04_lambda;

import java.util.*;
import java.util.stream.Stream;

public class Lambda01 {
    public static void main(String[] args) {

        List<String> menü = new ArrayList<>(Arrays.asList("kişleme", "adana", "triliçe", "havuçDilim", "buryan",
                "yağlama", "kokoreç", "arabAşı", "güveç", "waffle", "wenemen", "cacix"));


        charKaresiCiftElSirala(menü); //100 36
        System.out.println("\n  ***  ");

        harfSayisi7denAzKontrol(menü); //amale code
        // list elemanları 7 harften büyük
        // cincix code
        // list elemanları 7 harften büyük

        System.out.println("\n  ***  ");

        wIleBaslayanElKontrol(menü); //agam wenemen ne menen bir şey ?
        System.out.println("\n  ***  ");

        xIleBitenElKontrol(menü); //agam senden bir cacix olmaz ?
        System.out.println("\n  ***  ");

        charSayisiBykElPrint(menü); //Optional[havuçDilim]
        System.out.println("\n  ***  ");

        ilkElHaricSonHrfSiraliPrint(menü); //
        System.out.println("\n  ***  ");

    }
    // Task : List elemanlarının karakterlerinin çift sayılı karelerini hesaplayan,ve karelerini tekrarsız büyükten küçüğe sıralı print ediniz
    public static void charKaresiCiftElSirala(List<String> menü){
        menü.
                stream(). //akışa alındı
                map(t->t.length()*t.length()). //akışdaki string elemanları boyutlarının karesine update edildi
                filter(day01_lambda.Lambda01::ciftBul). //çift elemanlar filtrelendi
                distinct(). //tekrarsız yapıldı
                sorted(Comparator.reverseOrder()). //ter b->k sıra yapıldı
                forEach(day01_lambda.Lambda01::yazdir); //print edildi
    }

    // Task : List elemanlarının karakter sayısını 7 ve 7'den az olma durumunu kontrol ediniz
    public static void harfSayisi7denAzKontrol(List<String> menü){
        //amale code
        System.out.println("amale code");
        boolean kontrol =menü.stream().allMatch(t->t.length()<=7);
        if (kontrol){
            System.out.println("list elemanları 7 ve daha az harften olşuyor");
        }else{
            System.out.println("list elemanları 7 harften büyük ");
        }
        //cincix code
        System.out.println("cincix code");
        System.out.println(menü.
                stream().
                allMatch(t -> t.length() <= 7) ? "list elemanları 7 ve daha az harften olşuyor" : "list elemanları 7 harften büyük ");


           /*
           anyMatch()-->en az bir eleman şartı sağlarsa true aksi durumda false return eder
           allMatch()-->tüm elemanlar şartı sağlarsa true en az bir eleman şartı sağlamazsa false return eder
           noneMatch()-->hiç bir şartı SAĞLAMAZSA true en az bi releman şartı SAĞLARSA false return eder
           */

    }

    // Task : List elemanlarının "W" ile başlamasını kontrol ediniz
    public static void wIleBaslayanElKontrol(List<String> menü){
        System.out.println(menü.
                stream().
                noneMatch(t -> t.startsWith("w")) ? "agam w ile başlayan yemahh olu mu ?" : "agam wenemen ne menen bir şey ?");

    }

    // Task : List elemanlarının "x" ile biten en az bir elemanı kontrol ediniz
    public static void xIleBitenElKontrol(List<String> menü){
        System.out.println(menü.
                stream().
                anyMatch(t -> t.endsWith("x")) ? "agam senden bir cacix olmaz ?" : "agam senin aradığın yemek bu topraklarda yooogggg");
    }

    // Task : Karakter sayısını en büyük elemanı yazdırınız
    public static void charSayisiBykElPrint(List<String> menü){
        Stream<String> sonIsim= (menü.
                stream().
                sorted(Comparator.comparing(t -> t.toString().length()).
                        reversed()).
              //  findFirst()); //ilk eleman alındı
                limit(1));
        /*
           sonIsim.toArray() --> limit() method return dan dolayı stream type olan sonIsim toArray() method ile array type convert edildi
         */
        System.out.println(Arrays.toString(sonIsim.toArray())); //arraya çevrilen sonIsim stream print edildi

        /*
        Limit(a) akışından çıkan elemanları a parametresine göre ilk a elemanı alır
        limit(1) => Sınırlandırma demek.Bu akışın elemanlarından oluşan,uzunluğu maxSize'dan uzun olmayacak
        şekilde kesilmiş bir akış return eder.Stream return eder.
         */


        /*
         TRİCK : Stream'ler ekrana direk yazdırılamaz.Stream'i toArray() ile Array'e çeviririz.Array'i de Arrays.toString()'in içine alır
         ÖRN: System.out.println(Arrays.toString(stream.toArray())); veya System.out.println(Arrays.asList(***.toArray())); kullanılabilir
         */




        //akış çıktısı bir variable assaign edilebilir
        Optional<String> enBykKrEl =(menü.
                stream().
                sorted(Comparator.comparing(t -> t.toString().length()).
                        reversed()).
                findFirst()); //ilk eleman alındı

    }

    // Task : List elemanlarını son harfine göre sıralayıp ilk eleman hariç kalan elemanları print ediniz
    public static void ilkElHaricSonHrfSiraliPrint(List<String> menü){
        menü.
                stream(). //akışa alındı
                sorted(Comparator.comparing(t->t.charAt(t.length()-1))). //son harfe göre sıralandı
                skip(1). //ilk eleman atlandı -->adana
                forEach(t-> System.out.print(t+" ")); //peint edildi

        /*
        skip(1) => atlama demek.Akışın ilk n elemanını attııktan sonra bu akışın kalan elemanlarından oluşan bir akış return eder.
        Bu akış n'den daha az öğe içeriyorsa, boş bir akış döndürülür.Bu, durum bilgisi olan bir ara işlemdir.
        skip(list.size()-1) => List'in uzunluğunun 1 eksiğini yazarsak son elemanı yazdırırız.

         */
    }
}


