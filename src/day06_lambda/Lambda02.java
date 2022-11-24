package day06_lambda;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Lambda02 {
    public static void main(String[] args) throws IOException {
        //TASK 01 -->nisa.txt dosyasını okuyunuz.(Console'a yazdırınız)
        System.out.println("\n*** nisa.txt dosyasını okuyunuz --> ");

        Path nisa= Path.of("src/day06_lambda/nisa.txt"); //path nisa obj atandı
        Stream<String> akıs= Files.lines(nisa); //nisa.txt dataları akış straem'e atandı

        //1. yol...
        Files.lines(nisa).
       // Files.lines(Paths.get("src/day06_lambda/nisa.txt")).//Files class'dan lines() method call edilerek data çekilecek dosya yolu(path)
                                                                // parametre girilerek path'deki dosyanın  dataları akışa alındı
                forEach(System.out::println); //akışdaki datalar(her satırdaki string) yazıldı

        //2. yol...
        akıs.forEach(System.out::println);


        //TASK 02 -->nisa.txt büyük harflerle okuyunuz.(Console'a büyük harflerle yazdırınız)
        System.out.println("\n*** nisa.txt büyük harflerle okuyunuz --> ");
        Files.lines(Paths.get("src/day06_lambda/nisa.txt")).
                map(String::toUpperCase). //akışdaki datalar büyük harfe update edildi
                // çekilecek dosya yolu(path)
                // parametre girilerek path'deki dosyanın  dataları akışa alındı
                        forEach(System.out::println); //akışdaki datalar(her satırdaki string) yazıldı



    }
}
