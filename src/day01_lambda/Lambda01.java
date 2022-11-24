package day01_lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda01 {
    public static void main(String[] args) {

        /*
        1) Lambda "Functional Programming" --> method(action) kullanma pr dili.
           Lambda --> method create etme değil mevcut method'ları(library) seçip kullanmaktır...
           Lambda kendi başına tanımlanabilen parametre alıp gönderebilen fonksiyonlardır.
           Lambda'lar sayesinde daha az kod ve hızlı geliştirme sağlanabilmektir.
           Java 8 ile gelen bu özellik, Java 8'in önemli özelliğidir.

           "Functional Programming" de "Nasıl yaparım?" değil "Ne yaparım?" düşünülür.
        2) "Structured Programming" de "Ne yaparım? dan çok "Nasıl yaparım?" düşünülür
        3) "Functional Programming" hız, code kısalığı, code okunabilirliği
            ve hatasız code yazma acılarından çok faydalıdır.
        4) Lambda sadece collections'larda(List, Queue, Set) ve Array'lerde kullanılabilir ancak map'lerde kullanılamaz.
           Lambda kullanmak hatasız code kullanmaktır.


           Collections Nedir?
           Çoğu yazılım tek tek öğeler yerine öğelerden oluşan toplulukları depolar ve onlar üzerinden işlem
           yapar. Array'ler onlardan birisidir. Java Collections Framework, arraylerle yapılan işleri daha kolay
           yaptığı gibi, daha fazlasını da yapar.
           Java'da bir koleksiyon(collection - bazen container, ambar diye adlandırılır) nesnelerden oluşan bir
           topluluğu bir arada tutan bir yapıdır. "Collections Framework" ise arayüzler ve onların kurgularından
           (implementations) oluşur.
         */

        List<Integer> sayi = new ArrayList<>(Arrays.asList(34,22,16,11,35,20,63,21,65,44,66,64,81,38,15));

        printElStructured(sayi); //34 22 16 11 35 20 63 21 65 44 66 64 81 38 15
        System.out.println("\n  ***   ");

        printElFunctional(sayi); //34 22 16 11 35 20 63 21 65 44 66 64 81 38 15
        System.out.println("\n  ***   ");

        printElFunctional1(sayi); //342216113520632165446664813815
        System.out.println("\n  ***   ");

        printElFunctional2(sayi); //34 22 16 11 35 20 63 21 65 44 66 64 81 38 15
        System.out.println("\n  ***   ");

        printCiftElStructred(sayi); //34 22 16 20 44 66 64 38
        System.out.println("\n  ***   ");

        printCiftElFunctional(sayi); //34 22 16 20 44 66 64 38
        System.out.println("\n  ***   ");

        printCiftElFunctional1(sayi); //34 22 16 20 44 66 64 38
        System.out.println("\n  ***   ");

        printCiftOtzKckFunctional(sayi); //22 16 20
        System.out.println("\n  ***   ");

        printCiftOtzBykFunctional(sayi); //34 22 16 35 20 63 65 44 66 64 81 38
        System.out.println("\n  ***   ");
        //yeni satır
        //

    }
    // Task : "Structured Programming" kullanarak list elemanlarını aynı satırda aralarında boşluk olacak şekilde print ediniz.
    public static void printElStructured(List<Integer> sayi){
        for (Integer w :sayi) {
            System.out.print(w+" ");
        }
    }

    //Task : "Functional Programming" kullanarak list elemanlarını aynı satırda aralarında boşluk olacak şekilde print ediniz.
    public static void printElFunctional(List<Integer> sayi){

        sayi.stream().forEach((t)-> System.out.print(t+" "));
    }

    /*
      stream() : dataları yukarıdan aşağıya akış şekline getirir. Stream bir interface olduğundan dolayı doğrudan nesne olmaz.
      forEach() : datanın parametresine göre her bir elemanı işler
      t-> : Lambda operatörü
        Lambda Expression--> (parameter list) -> {action body}
        Parameter list: Fonksiyonun parametreleri tanımlanır. Hiç parametre geçirmeden başta olabilir.
        -> Arrow-token: Argüman listesi ile expression gövdesini birbirine bağlamak için kullanılır.
        Body: Expressionları ve statementları içerir.

        Bir kod bloğundan oluşan body...
        Bu tip lambda body, block body olarak bilinir. Block gövdesi,lambda gövdesinin birden çok ifade içermesine izin verir.
        Bu ifadeler parantez içine alınır ve parantezlerden sonra noktalı virgül eklemeniz gerekir.


           () -> {
             double pi = 3.1415;
                return pi;
              };

          Lambda Expression yapısı çok tavsiye edilmez daha çok METHOD REFERENCE kullanılır.


     */


    public static void printElFunctional1(List<Integer> sayi){
        sayi.stream().forEach(System.out::print); // method reference--> System.out yapısında print methodu refere et
                                                 // bu action task'deki aynı satıra ve boşluk ile yazmayı karşılamaz bunun için
                                                // seed(tohum) method create edilip refere edilmeli
    }

    public static void yazdir(int a){ // verilen int değeri aynı satırda boşluk bırakarak yazdırma action yapan seed(tohum) method creat edildi
        System.out.print(a+" ");
    }

    public static void printElFunctional2(List<Integer> sayi){
        sayi.stream().forEach(Lambda01::yazdir); // method reference--> System.out yapısında print methodu refere et
    }

   // Task : structured Programming ile list elemanlarının çift olanlarını ayni satırda aralarına boşluk bırakarak print ediniz.

    public static void printCiftElStructred(List<Integer> sayi){
        for (Integer w : sayi) {
            if (w%2==0){
                System.out.print(w+" ");
            }
        }
    }

    // Task : functional Programming ile list elemanlarının çift olanlarını ayni satırda aralarına boşluk bırakarak print ediniz.

    public static void printCiftElFunctional(List<Integer> sayi){
        sayi.
                stream().
                filter(t->t%2==0).
                forEach(Lambda01::yazdir);
    }
    public static boolean ciftBul(int a){ //seed(tohum) method kendisine verilen int değerin çift olmasını kontrol eder

        return a%2==0;
    }

    public static void printCiftElFunctional1(List<Integer> sayi){
        sayi.
                stream().//list akışa alındı
                filter(Lambda01::ciftBul). // çift bul method refere edilerek akışdaki elemanlar filtrelendi(çift sayı)
                forEach(Lambda01::yazdir); //filtre den gelen elemanlar yazdır() method refere edilerek print edildi
    }


    // Task : functional Programming ile list elemanlarının 34 den küçük çift olanlarını ayni satırda aralarına boşluk bırakarak print ediniz.

    public static void printCiftOtzKckFunctional(List<Integer> sayi){
        sayi.
                stream().
                //filter(t->t%2==0  &&  t<34).
                filter(Lambda01::ciftBul). // method ref.
                filter(t-> t<34). //lambda exp.
                forEach(Lambda01::yazdir);
    }

    // Task : functional Programming ile list elemanlarının 34 den büyük veya çift olanlarını ayni satırda aralarına boşluk bırakarak print ediniz.

    public static void printCiftOtzBykFunctional(List<Integer> sayi){
        sayi.
                stream().
                filter(t->t%2==0  ||  t>34).  //çift veya 34'den büyük elemanları filtreler 44 63 65 38
                //filter(Lambda01::ciftBul).  method ref.
                //filter(t-> t>34).  lambda exp.
                forEach(Lambda01::yazdir);
    }
}
