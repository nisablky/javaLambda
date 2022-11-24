package day04_lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda02 {
    /*
    Task :
    fields--> Universite(String)
              bolum(String)
              ogrcSayisi(int)
              notOrt(int)
              olan POJO class create edip main method içinde 5 farklı obj'den List creat ediniz.
     */
    public static void main(String[] args) {
        Universite bogaziçi = new Universite("bogaziçi", "matematik", 571, 93);
        Universite itu = new Universite("istanbul teknik", "matematik", 622, 81);
        Universite istanbul = new Universite("istanbul", "hukuk", 1453, 71);
        Universite marmara = new Universite("marmara", "bilgisayar muh", 1071, 77);
        Universite ytu = new Universite("yıldız teknik", "gemi", 333, 74);

        List<Universite> unv = new ArrayList<>(Arrays.asList(bogaziçi, itu, istanbul, marmara, ytu));

        System.out.println(notOrt74BykUnv(unv)); //false
        System.out.println("\n  ***  ");

    }


    //task 01--> notOrt'larının 74'den büyük olduğunu kontrol eden pr create ediniz
    public static boolean notOrt74BykUnv(List<Universite> unv) {

        return unv.
                stream().
                allMatch(t -> t.getNotOrt() > 74);
    }

}
