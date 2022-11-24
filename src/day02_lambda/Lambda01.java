package day02_lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda01 {
    public static void main(String[] args) {

        List<Integer> sayi = new ArrayList<>(Arrays.asList(4,2,6,11,-5,7,3,15));

        ciftKarePrint(sayi); //16 4 36
        System.out.println("\n  ***  ");

        tekKupBirFazlaPrint(sayi); //1332 -124 344 28 3376
        System.out.println("\n  ***  ");

        ciftKareKokPrint(sayi); //2.0 1.4142135623730951 2.449489742783178
        System.out.println("\n  ***  ");

        maxEl( sayi ); //Optional[15]   halukça : Optional[15]
        System.out.println("\n  ***  ");

        ciftKareMaxBul(sayi); //Optional[36]
        System.out.println("\n  ***  ");

        elTopla(sayi); //43
        System.out.println("\n  ***  ");

        ciftCarp(sayi); //48
    }
    // Task : Functional programming ile listin elemanlarının karelerini ayni satırda aralarına boşluk bırakarak print yazdırınız

    public static void ciftKarePrint(List<Integer> sayi ){
        sayi.
                stream().
                filter(day01_lambda.Lambda01::ciftBul).
                map(t-> t*t). // map()--> Stream içerisindeki elemanları başka tiplere dönüştürmek veya
                // üzerlerinde işlem yapmak (update) için Map kullanılmaktadır.
                        forEach(day01_lambda.Lambda01::yazdir);

    }
    // Task : Functional Programming ile listin tek elemanlarının küplerinin bir fazlasını aynı satırda aralarına boşluk bırakarak print ediniz


    public static void tekKupBirFazlaPrint(List<Integer> sayi ){
        sayi.
                stream(). //sayılar akışa alındı
                filter(t->t%2!=0). //tek elemanlar filtrelendi
                map(t->(t*t*t)+1). //tek elemanları küplerinin 1 fazlasına update edildi
                forEach(day01_lambda.Lambda01::yazdir); //print edildi

    }

    // Task : Functional Programming ile listin çift elemanlarının karaköklerini aynı satırda aralarında boşluk bırakarak yazdırınız

    public static void ciftKareKokPrint(List<Integer> sayi ){
        sayi.
                stream().
                filter(day01_lambda.Lambda01::ciftBul).
                map(Math::sqrt). // meth ref --> double değer return eder
                //forEach(Lambda01::yazdir); --> yazdır() method int. çalıştığı için map den çıkan dataları çalıştırmaz
                        forEach(t-> System.out.print(t+" "));

    }

    // Task :list'in en büyük elemanını yazdırınız

    public static void maxEl(List<Integer> sayi ){
        Optional<Integer> maxSayi = sayi.
                stream().
                reduce(Math::max); // akışa giren elemanların action sonrası tek eleman haline getirir

        System.out.println(maxSayi);
        System.out.println("halukça : " + sayi.stream().reduce(Math::max));

        /*
        reduce() --> azaltmak ... bir çok datayı bir dataya(max min carp top. vs işlemlerde) çevirmek için kullanılır.
        kullanımı yaygındır pratiktir.
        Bir Stream içerisindeki verilen teker teker işlenmesidir. Teker teker işleme sürecinde, bir önceki admda elde dilen sonuç
        bir sonraki adıma girdi olarak sunulmaktadır. Bu sayede yığılımlı bir hesaplama süreci elde edilimiş olmaktır.
        reduce methodu ilk parametrede identity değeri, ikinci parametrede ise BinaryOperatör türünden bir obj kullanılır.
        reduce işleminde bir önceki hesaplanmış değer ile sıradaki değer bir işleme tabi tutulmaktadır.
        İşleme başlarken bir önceki değer olmadığı için bu değer identity parametresinde tanımlanmaktadır.

         */
    }

    // Task : List'in cift elemanların karelerinin en büyüğünü print ediniz

    public static void ciftKareMaxBul(List<Integer> sayi){

        System.out.println(sayi.
                stream().
                filter(day01_lambda.Lambda01::ciftBul).
                map(t -> t * t).
                reduce(Math::max));


        System.out.println("daha hızlı specific ınteger class :" + sayi.
                stream().
                filter(day01_lambda.Lambda01::ciftBul).
                map(t->t*t).
                reduce(Integer::max)); // specific class daha hızlı run olur
    }

    // Task : List'teki tüm elemanların toplamını yazdırınız.
    // Lambda Expression...

    public static void elTopla(List<Integer> sayi){

        int toplam = sayi.stream().reduce(0,(a,b)->a+b);  // Lambda Expression...


        /*
          a ilk değerini her zaman değerden (identity) alır
          b değerini her zaman stream()' den akıştan alır
          a ilk değerinden sonraki her değeri action(işlem)'dan alır
         */

        System.out.println("Lamda exp. : "+toplam);// Lambda Expression...

        Optional<Integer> topla = sayi.stream().reduce(Integer::sum);
        System.out.println("method ref : " +sayi.stream().reduce(Integer::sum)); // method ref

    }

    //Task :List'teki çift elemanların çarpımını yazdırınız

    public static void ciftCarp(List<Integer> sayi){

        System.out.println("method ref : "+sayi.
                stream().
                filter(day01_lambda.Lambda01::ciftBul).
                reduce(Math::multiplyExact)); // method ref



        System.out.println("Lamda exp. : " +sayi.
                stream().
                filter(day01_lambda.Lambda01::ciftBul).
                reduce(1, (a, b) -> (a * b)));// Lambda Expression...


    }
}
