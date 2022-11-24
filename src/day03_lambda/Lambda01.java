package day03_lambda;

import java.util.*;

public class Lambda01 {
    public static void main(String[] args) {

        List<Integer> sayi = new ArrayList<>(Arrays.asList(4, 2, 6, 11, -5, 7, 3, 15));

        minBul(sayi); //Optional[-5]
        // Optional[-5]
        // -5
        // Optional[-5]

        System.out.println("\n  ***  ");

        bestenBykEnKck(sayi); //Optional[7]
        System.out.println("\n  ***  ");

        ciftKareKbPrint(sayi); //4 16 36
        System.out.println("\n  ***  ");

        tekKareBkPrint(sayi); //225 121 49 9
        System.out.println("\n  ***  ");

    }

    // Task : List'teki elemanlardan en küçüğünü 4 farklı yöntem ile print ediniz.

    public static void minBul(List<Integer> sayi){
        //1.yöntem Method Reference --> Integer class
        Optional<Integer> minSayiInteger= sayi.stream().reduce(Integer::min);
        System.out.println(minSayiInteger);

        //2.yöntem Method Reference --> Math class
        Optional<Integer> minSayiMath= sayi.stream().reduce(Math::min);
        System.out.println(minSayiMath);

        //3.yöntem Lambda Expressions
        int minSayiLJambda= (sayi.stream().reduce(Integer.MAX_VALUE, (x, y) -> x < y ? x : y));
        System.out.println(minSayiLJambda);

        //4.yöntem Method Reference --> nisa class
        Optional<Integer> minSayiNisa= sayi.stream().reduce(day03_lambda.Lambda01::bynNisaMin);
        System.out.println(minSayiNisa);

    }

    public static int bynNisaMin(int a, int b){ // bu method kendisine verilen iki int değerin en küçüğünü return eder

        return a<b?a:b;
    }

    // Task : List'teki 5'ten büyük en küçük tek sayıyı print ediniz.
    public static void bestenBykEnKck(List<Integer> sayi){
        System.out.println(sayi.stream().filter(t -> t > 5 && t % 2 == 1).reduce(day03_lambda.Lambda01::bynNisaMin));

    }

    // Task : List'in çift elemanlarının karelerini küçükten büyüğe print ediniz.
     public static void  ciftKareKbPrint(List<Integer> sayi){
        sayi.
                stream(). // akışa alındı
                filter(day01_lambda.Lambda01::ciftBul). //çift elemanlar filtrlendi
                map(t -> t*t). //filtrelenen çift sayı karesi alındı
                sorted(). //karesi alınan elemanlar doğal(k>b) sıralandı
                forEach(day01_lambda.Lambda01::yazdir); // print edildi


         /*
         sorted() => Doğal düzene göre sıralanmış, bu akışın elemanlarında oluşan bir akış döndürür.
         sorted() => methodu tekraarlı kullanılırsa en son kullanılan aktif olur
          */
     }

    // Task : List'in tek elemanlarının karelerini büyükten küçüğe print ediniz.
    public static void  tekKareBkPrint(List<Integer> sayi){
        sayi.// akış kaynağı
                stream(). // akışa alındı
                filter(t-> t%2!=0). //tek elemanlar filtrlendi
                map(t -> t*t). //filtrelenen çift sayı karesi alındı
                sorted(Comparator.reverseOrder()). //karesi alınan elemanlar ters(b>k) sıralandı
                forEach(day01_lambda.Lambda01::yazdir); // print edildi


    }


}
