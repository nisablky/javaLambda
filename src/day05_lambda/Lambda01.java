package day05_lambda;

import day04_lambda.Universite;

import java.util.*;
import java.util.stream.Collectors;

public class Lambda01 {
    public static void main(String[] args) {

        Universite bogaziçi = new Universite("bogaziçi", "matematik", 571, 93);
        Universite itu = new Universite("istanbul teknik", "matematik", 622, 81);
        Universite istanbul = new Universite("istanbul", "hukuk", 1453, 71);
        Universite marmara = new Universite("marmara", "bilgisayar muh", 1071, 77);
        Universite ytu = new Universite("yıldız teknik", "gemi", 333, 74);

        List<Universite> unv = new ArrayList<>(Arrays.asList(bogaziçi, itu, istanbul, marmara, ytu));

        System.out.println(ogrcSayisi110AzMi(unv)); //true
        System.out.println("\n  ***  ");

        System.out.println(matBolumVarMı(unv)); //true
        System.out.println("\n  ***  ");

        System.out.println(ogrSayiBkSirala(unv)); //[Universite{universite='istanbul', bolum='hukuk', ogrcSayisi=1453, notOrt=71
                                                 // , Universite{universite='marmara', bolum='bilgisayar muh', ogrcSayisi=1071, notOrt=77
                                                 // , Universite{universite='istanbul teknik', bolum='matematik', ogrcSayisi=622, notOrt=81
                                                 // , Universite{universite='bogaziçi', bolum='matematik', ogrcSayisi=571, notOrt=93
                                                 // , Universite{universite='yıldız teknik', bolum='gemi', ogrcSayisi=333, notOrt=74
                                                  // ]
        System.out.println("\n  ***  ");

        ogrSayiBkSiralaVoid(unv); //[Universite{universite='istanbul', bolum='hukuk', ogrcSayisi=1453, notOrt=71
                                 // , Universite{universite='marmara', bolum='bilgisayar muh', ogrcSayisi=1071, notOrt=77
                                 // , Universite{universite='istanbul teknik', bolum='matematik', ogrcSayisi=622, notOrt=81
                                 // , Universite{universite='bogaziçi', bolum='matematik', ogrcSayisi=571, notOrt=93
                                 // , Universite{universite='yıldız teknik', bolum='gemi', ogrcSayisi=333, notOrt=74
                                  // ]
        System.out.println("\n  ***  ");

        System.out.println(notOrtBkSiraliIlkUc(unv)); //[Universite{universite='bogaziçi', bolum='matematik', ogrcSayisi=571, notOrt=93
                                                     // , Universite{universite='istanbul teknik', bolum='matematik', ogrcSayisi=622, notOrt=81
                                                     // , Universite{universite='marmara', bolum='bilgisayar muh', ogrcSayisi=1071, notOrt=77
                                                      // ]
        System.out.println("\n  ***  ");

        System.out.println(enAzOgrcSayisi2Unv(unv)); //[Universite{universite='bogaziçi', bolum='matematik', ogrcSayisi=571, notOrt=93
                                                    // ]
        System.out.println("\n  ***  ");

        System.out.println("task7: "+ notOrt63BykUnvOgrcSayisiTopla( unv)); //task7: 4050
        System.out.println("\n  ***  ");

        System.out.println("mapToInt ile: "+ notOrt63BykUnvOgrcSayisiToplaToInt(unv)); //mapToInt ile: 4050
        System.out.println("\n  ***  ");

        System.out.println(ogrcSayisi333BykNotOrtOrtalamaAl(unv)); //OptionalDouble[80.5]
        System.out.println("\n  ***  ");

        System.out.println(mathBolmSayisi(unv)); //2
        System.out.println("\n  ***  ");

        System.out.println(ogrcSayisi571BykMaxNotOrt(unv)); //OptionalInt[81]
        System.out.println("\n  ***  ");

        System.out.println(ogrcSayisi1071AzMinNotOrt(unv)); //OptionalInt[74]
        System.out.println("\n  ***  ");

    }


    //task 02--> ogrc sayilarinin 110 den az olmadığını kontrol eden pr create ediniz.
    public static boolean ogrcSayisi110AzMi(List<Universite> unv){
       return  unv.stream().allMatch(t->t.getOgrcSayisi()>110);

    }


    //task 03--> universite'lerde herhangi birinde "matematik" olup olmadığını kontrol eden pr create ediniz.
    public static boolean matBolumVarMı(List<Universite> unv){
       return unv.stream().anyMatch(t->t.getBolum().toLowerCase().contains("mat"));
    }


    //task 04--> universite'leri ogr sayilarına göre b->k sıralayınız.
    public static List<Universite> ogrSayiBkSirala(List<Universite> unv){
       return  unv.
                stream().
                sorted(Comparator.comparing(Universite::getOgrcSayisi).reversed()).
                collect(Collectors.toList());
    }
    public static void ogrSayiBkSiralaVoid(List<Universite> unv){
        System.out.println(unv.
                stream().
                sorted(Comparator.comparing(Universite::getOgrcSayisi).reversed()).
                collect(Collectors.toList()));
        // collect()-> akışdaki elemanları istenen şarta göre toplar
        // Collector.toList()-> collect'e toplanan elemanlari list'e çevirir

    }


    //task 05--> universite'leri notOrt göre b->k siralayıp ilk 3'unu print ediniz.
    public static List<Universite> notOrtBkSiraliIlkUc(List<Universite> unv){
        return unv.
                stream(). //akışa alındı
                sorted(Comparator.comparing(Universite::getNotOrt).reversed()). //notOrt a göre b->k sıralandı
                limit(3). //akışın ilk 3 elemanı alındı
                collect(Collectors.toList()); //akışın ilk 3 elemanı list'e assign edildi
             // toList()); //akışın ilk 3 elemanı list'e assign edildi

    }


    //task 06--> ogr sayısı en az olan 2. universite'yi print ediniz.
    public static List<Universite> enAzOgrcSayisi2Unv(List<Universite> unv){
       return unv.
               stream().
               sorted(Comparator.comparing(Universite::getOgrcSayisi)).
               limit(2).
               skip(1).
               collect(Collectors.toList());
    }


    //task 07--> notOrt 63'den büyük olan universite'lerin notOrt'larının ortalamasını bulunu.
    public static int notOrt63BykUnvOgrcSayisiTopla(List<Universite> unv){
       return unv.
                stream().
                filter(t->t.getNotOrt()>63).
                map(t->t.getOgrcSayisi()).
              // reduce(Integer::sum);
              // reduce(Math::addExact);
               reduce(0,(t,u)->t+u);
    }
    public static int notOrt63BykUnvOgrcSayisiToplaToInt(List<Universite> unv){
        return unv.
                stream().
                filter(t->t.getNotOrt()>63).
                mapToInt(t->t.getOgrcSayisi()).
                sum();

        //mapToInt() --> bu method akıştaki elemanların data type'ını
        // parametresindeki değere göre Int data type update eder

    }



    //task 08--> ogrenci sayısı 333'dan büyük olan universite'lerin notOrt'larının ortalamasını bulunuz.
    public static OptionalDouble ogrcSayisi333BykNotOrtOrtalamaAl(List<Universite> unv){
      return unv.
              stream().
              filter(t->t.getOgrcSayisi()>333).
              mapToDouble(t->t.getNotOrt()).
              average(); //akışdaki elemanların ortalaması alındı

        //mapToDouble() --> bu method akıştaki elemanların data type'ını
        // parametresindeki değere göre double data type update eder
    }


    //task 09--> "matematik" bölümlerinin sayısını print ediniz.
    public static int mathBolmSayisi(List<Universite> unv){
      return (int) unv.
                stream().
                filter(t->t.getBolum().contains("mat")).
                count(); // akışdaki eleman sayısını return eder
    }


    //task 10--> öğrenci sayıları 571'dan fazla olan universite'lerin en büyük notOrt'unu bulunuz.
    public static OptionalInt ogrcSayisi571BykMaxNotOrt(List<Universite> unv){
       return unv.
                stream(). //akış
                filter(t->t.getOgrcSayisi()>571). //unv obj akışı filtrelendi
                mapToInt(t->t.getNotOrt()). // akışdaki ubv obj notOrt akışı olarak update edildi
                max(); //akışın en byk değerini return eder

    }


    //task 11--> öğrenci sayıları 1071'den az olan üniversite'lerin en küçük notOrt'unu bulunuz.
    public static OptionalInt ogrcSayisi1071AzMinNotOrt(List<Universite> unv){
      return   unv.
              stream().
              filter(t->t.getOgrcSayisi()<1071).
              mapToInt(t->t.getNotOrt()).
              min();

    }

}
