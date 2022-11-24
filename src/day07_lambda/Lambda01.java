package day07_lambda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lambda01 {
    public static void main(String[] args) throws IOException {
        //TASK 03 -->nisa.txt dosyasındaki ilk satırı küçük harflerle yazdırınız
        System.out.println("\n*** nisa.txt dosyasındaki ilk satırı küçük harflerle okuyunuz --> ");

        Path nisa= Path.of("src/day06_lambda/nisa.txt"); //path nisa obj atandı
        Stream<String> akıs= Files.lines(nisa); //nisa.txt dataları akış straem'e atandı

        //1.  yol limit();
        Files.
                lines(nisa).
                map(String::toLowerCase).
                limit(1).
                forEach(System.out::println);

        //2. yol findFirst();
        System.out.println(Files.
                lines(nisa).
                map(String::toLowerCase).
                findFirst());

        //TASK 04 -->nisa.txt dosyasında başarı kelimesinin kaç satırda geçtiğini print ediniz
        System.out.println("\n*** nisa.txt dosyasında başarı kelimesinin kaç satırda geçtiğini yazdırınız --> ");
        System.out.println(Files.
                lines(nisa).
                map(String::toLowerCase).
                filter(t -> t.contains("basari")).
                count());


        //TASK 05 -->nisa.txt dosyasındaki farklı kelimeleri yazdırınız
        System.out.println("\n*** nisa.txt dosyasındaki farklı kelimeleri yazdırınız -->");
        //1. yol.. distinct()
        System.out.println(Files.
                lines(nisa).
                map(t -> t.split(" ")). //satırlardaki kelimeler array'e atandı
                flatMap(Arrays::stream). //2D arraydeki elemanlar tek eleman olarak akışa alındı
                distinct(). //akışdaki elemanlar tekrarsız yapıldı
                collect(Collectors.toList())); //akışdaki tekrarsız elemanlar list'e atandı

        //2. yol.. toset()
        System.out.println(Files.
                lines(nisa).
                map(t -> t.split(" ")). //satırlardaki kelimeler array'e atandı
                        flatMap(Arrays::stream).
                collect(Collectors.toSet()));

        /*
        Stream.flatMap, adıyla tahmin edilebileceği gibi, bir map ve flat işleminin birleşimidir. Bu ilk önce elemanlarınıza bir
        fonksiyon uyguladığınız ve daha sonra düzleştirdiğiniz anlamına gelir.
        Stream.map yalnızca akışı düzleştirmeden bir işlevi uygular

        Bir akışın düzleştirmenin neyi içerdiğini anlamak için, "iki seviye" olan [ [1,2,3] [4,5,6] [7,8,9] ] gibi bir yapı düşünün.
        Buun düzleştirilmesi, "bir seviye" yapısında dönüştürülmesi anlamına gelir: [ 1,2,3,4,5,6,7,8,9 ].
        flatMap yöntemi, bir akışın her bir değerini başka bir aakışla değiştirmenizi sağlar
        ve ardından oluşturulan tüm akışları tek bir akışa birleştirir.
         */


        //TASK 06 -->nisa.txt dosyasındaki tüm kelimeleri natural order yazdırınız
        System.out.println("\n*** nisa.txt dosyasını okuyunuz");
        Files.
                lines(nisa).
                map(t -> t.split(" ")). //satırlardaki kelimeler array'e atandı
                flatMap(Arrays::stream).//2D arraydeki elemanlar tek eleman olarak akışa alındı
                sorted(). //harf sırası yapıldı
                forEach(System.out::println); //print edildi


        //TASK 07 -->nisa.txt dosyasında başarı kelimesinin kaç kere geçtiğini büyük harf küçük harf bagımsız print ediniz
        System.out.println("\n*** nisa.txt dosyasında başarı kelimesinin kaç kere geçtiğini yazdırınız");
        System.out.println(Files.
                lines(nisa).
                map(t -> t.toLowerCase().split(" ")).
                flatMap(Arrays::stream).
                filter(t -> t.equals("basari")).
                count());


        //TASK 08 -->nisa.txt dosyasında a harfi geçen kelimelerin sayısını print eden programı create ediniz
        System.out.println("\n*** nisa.txt dosyasında a harfi geçen kelimelerin sayısını ekrana yazdıran programı yazdırınız");
        System.out.println(Files.
                lines(nisa). //txt dosyasına erişildi
                map(t -> t.split(" ")). // satırlar akışa alındı
                flatMap(Arrays::stream). //her satırdaki her kelime akışa alındı
                filter(t -> t.contains("a")). //a bulunduran kelimeler filtrelendi
                count()); // a bulunduran kelimeler sayıldı


        //TASK 09 -->nisa.txt dosyasında a harfi geçen kelimeleri print ediniz
        System.out.println("\n*** nisa.txt dosyasında a harfi geçen kelimeler yazdırınız");
        System.out.println(Files.
                lines(nisa).
                map(t -> t.split(" ")).
                flatMap(Arrays::stream).
                filter(t -> t.contains("a")).
                collect(Collectors.toSet()));


        //TASK 10 -->nisa.txt dosyasında kaç farklı harf kullanıldığını print ediniz
        System.out.println("\n*** nisa.txt dosyasında kaç farklı harf kullanıldığını yazdırınız");
        System.out.println(Files.
                lines(nisa).
                map(t -> t.replaceAll("\\W", "").//satırlar \\W ifadesi a-z A-Z 0-9 _dışındakileri kapsar
                        replaceAll("\\d", "").
                        split("")). //harf akışı sağlanır
                flatMap(Arrays::stream).
                distinct().
                count());


        //TASK 11 -->nisa.txt dosyasında kaç farklı kelime kullanıldığını print ediniz
        System.out.println("\n*** nisa.txt dosyasında kaç farklı kelime kullanıldığını yazdırınız");
        System.out.println(Files.
                lines(nisa).
                map(t -> t.replaceAll("[.!,:)\\-]", "").//satırlar \\W ifadesi a-z A-Z 0-9 _dışındakileri kapsar

                        split( " ")). //kelime akışı sağlanır
                flatMap(Arrays::stream).
                distinct().
                count());


        //TASK 12 -->nisa.txt dosyasında farklı kelimelerini print ediniz
        System.out.println("\n*** nisa.txt dosyasında kaç farklı kelime kullanıldığını yazdırınız");
        Files.
                lines(nisa).
                map(t -> t.replaceAll("[.!,:)\\-]", "").//satırlar \\W ifadesi a-z A-Z 0-9 _dışındakileri kapsar

                        split( " ")). //kelime akışı sağlanır
                        flatMap(Arrays::stream).
                distinct().forEach(System.out::println);

    }
}
