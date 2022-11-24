package day06_lambda;

import java.util.stream.IntStream;

public class Lambda01 {
    public static void main(String[] args) {
        System.out.println("Task 01 amele topla -->"+toplaAmele(10)); //Task 01 amele topla -->55
        System.out.println("Task 01 cincix topla -->"+toplaCincix(10)); // Task 01 cincix topla -->55
        System.out.println("\n  ***  ");

        System.out.println("Task 02 -->"+toplaCift(10)); //2+4+6+8+10 = 30
        System.out.println("\n  ***  ");

        System.out.println("Task 03 -->"+toplaIlkXCift(10)); //2+4+6+...+18+20 = 110
        System.out.println("\n  ***  ");

        System.out.println("Task 04 -->"+toplaIlkXTek(10)); //1+3+5...+19 = 100
        System.out.println("\n  ***  ");

        System.out.println("Task 05 -->");
        ikininIlkXKuvvetPrint(7); //2 4 8 16 32 64 128
        System.out.println("\n  ***  ");

        System.out.println("Task 06 -->");
        istenenSayiIlkXKuvvetPrint(4,3); //4 16 64
        System.out.println("\n  ***  ");
        istenenSayiIlkXKuvvetPrint(3,4); //3 9 27 81
        System.out.println("\n  ***  ");

        System.out.println("Task 07 -->"+istenenSayiFactorial(5)); //1*2*3*...*5 = 120
        System.out.println("\n  ***  ");

        System.out.println("Task 08 -->"+xKuvveti(4,3)); //64
        System.out.println("Task 08 -->"+xKuvveti(3,4)); //81
        System.out.println("\n  ***  ");
    }
    //Task 01 --> Structured Progtamming ve Functional Programming ile 1'den x'e kadar tam sayıları toplayan bir program crate ediniz
    //Structured(AMELE) Programming
    public static int toplaAmele(int x){
        int toplam=0;
        for (int i = 1; i <=x ; i++) {
            toplam+=i;

        }
        return toplam;
    }
    
    //Functional(CİNCİX) Programming
    public static int toplaCincix(int x){
      return  IntStream.
              range(1,x+1). //1'den x'e kadar(x dahil x+1 hariç) int değerler akışa alındı
              sum(); //akışdaki int değerler toplandı

    }

    //Task 02 --> 1'den x'e kadar çift tamsayıları toplayan bir program create ediniz
    public static int toplaCift(int x){
        return  IntStream.
                rangeClosed(1,x).//1'den x'e kadar(x dahil) int değerler akışa alındı
                filter(day01_lambda.Lambda01::ciftBul). //akışdaki çift int değerler filtrelendi
                sum(); //akışdaki int değerler toplandı

    }

    //Task 03 --> Ilk x pozitif çift sayıyı toplayan program create ediniz
    public static int toplaIlkXCift(int x){
        return IntStream.
                iterate(2, t -> t + 2).//2'den sonsuza kadar elemanları 2 arttırarak akışa alır
                limit(x).//akışdaki ilk x int değeri akışa alır
                sum();//akışdaki int değerler toplandı
        //iterate(seed,repeat action) -->seed'den başlayarak repeat action'a sonsuza kadar elemanları akışa koyar

    }

    //Task 04 --> Ilk x pozitif tek tamsayıyı toplayan programı create ediniz
    public static int toplaIlkXTek(int x){
        return IntStream.
                iterate(1, t -> t + 2).//1'den sonsuza kadar elemanları 1 arttırarak akışa alır
                        limit(x).//akışdaki ilk x int değeri akışa alır
                        sum();//akışdaki int değerler toplandı
        //iterate(seed,repeat action) -->seed'den başlayarak repeat action'a sonsuza kadar elemanları akışa koyar

    }

    //Task 05 --> 2'nin ilk x kuvvetini ekrana yazdıran programı create ediniz
    public static void ikininIlkXKuvvetPrint(int x){
         IntStream.
                iterate(2,t -> t * 2).//2'den sonsuza kadar elemanları 2 ile çarparak akışa alır
                        limit(x).//akışdaki ilk x int değeri akışa alır
                        forEach(day01_lambda.Lambda01::yazdir);//akışdaki int değerler toplandı
        //iterate(seed,repeat action) -->seed'den başlayarak repeat action'a sonsuza kadar elemanları akışa koyar

    }

    //Task 06 --> Istenilen bir sayının ilk x kuvvetini ekrana yazdıran programı create ediniz
    public static void istenenSayiIlkXKuvvetPrint(int istenenSayi, int x){
        IntStream.
                iterate(istenenSayi,t -> t * istenenSayi).//2'den sonsuza kadar elemanları 2 ile çarparak akışa alır
                limit(x).//akışdaki ilk x int değeri akışa alır
                forEach(day01_lambda.Lambda01::yazdir);//akışdaki int değerler toplandı
        //iterate(seed,repeat action) -->seed'den başlayarak repeat action'a sonsuza kadar elemanları akışa koyar

    }

    //Task 07 --> Istenilen bir sayının faktoriyelini hesaplayan programı create ediniz
    public static int istenenSayiFactorial(int x){
       return IntStream.
                rangeClosed(1,x).
                //reduce(Math::multiplyExact).
                reduce(1,(t,u)->t*u);

    }

    //Task 08 --> Istenilen bir sayının x.kuvvetini ekrana yazdıran programı create ediniz
    public static int xKuvveti(int istenenSayi, int x){
        return IntStream.
                iterate(istenenSayi,t->t*istenenSayi).
                limit(x).
                reduce(0,(t,u)-> u);
              // return Math.pow(istenenSyi,x);
    }

}
