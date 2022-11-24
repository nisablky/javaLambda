package day04_lambda;

public class Universite {
    /*
    Task :
    fields--> Universite(String)
              bolum(String)
              ogrcSayisi(int)
              notOrt(int)
              olan POJO class create edip main method içinde 5 farklı obj'den List creat ediniz.
              pojo class : plan old java object --> model classı

              private variable
              constructor
              getter setter
              toString

     */

   private String universite;
   private String bolum;
   private int ogrcSayisi;
   private int notOrt;


    public Universite(){
    }

    public Universite(String universite, String bolum, int ogrcSayisi, int notOrt) {
        this.universite = universite;
        this.bolum = bolum;
        this.ogrcSayisi = ogrcSayisi;
        this.notOrt = notOrt;
    }


    public String getUniversite() {
        return universite;
    }

    public void setUniversite(String universite) {
        this.universite = universite;
    }

    public String getBolum() {
        return bolum;
    }

    public void setBolum(String bolum) {
        this.bolum = bolum;
    }

    public int getOgrcSayisi() {
        return ogrcSayisi;
    }

    public void setOgrcSayisi(int ogrcSayisi) {
        this.ogrcSayisi = ogrcSayisi;
    }

    public int getNotOrt() {
        return notOrt;
    }

    public void setNotOrt(int notOrt) {
        this.notOrt = notOrt;
    }

    @Override
    public String toString() {
        return "Universite{" +
                "universite='" + universite + '\'' +
                ", bolum='" + bolum + '\'' +
                ", ogrcSayisi=" + ogrcSayisi +
                ", notOrt=" + notOrt +
                '\n';
    }
}
