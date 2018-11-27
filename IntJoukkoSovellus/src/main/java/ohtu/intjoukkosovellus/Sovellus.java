package ohtu.intjoukkosovellus;

import java.util.Scanner;

public class Sovellus {

    private static IntJoukko A, B, C;

    private static String lueSyote() {
        Scanner lukija = new Scanner(System.in);
        String luettu = lukija.nextLine();
        return luettu;
    }

    private static IntJoukko pyydaMuokattavaJoukko() {
        String luettu = lueSyote();
        while (true) {
            if (luettu.toLowerCase().equals("a")) {
                return A;
            } else if (luettu.toLowerCase().equals("b")) {
                return B;
            } else if (luettu.toCharArray().equals("c")) {
                return C;
            } else {
                System.out.println("Virheellinen joukko! " + luettu);
                System.out.println("Yritä uudelleen!");
                luettu = lueSyote();
            }
        }
    }

    private static void joukkoonLisays() {
        Scanner lukija = new Scanner(System.in);
        System.out.println("Mihin joukkoon? ");
        IntJoukko joukko = pyydaMuokattavaJoukko();
        System.out.println("Mikä luku lisätään? ");
        joukko.lisaa(lukija.nextInt());
    }

    private static void joukkojenYhdiste() {
        IntJoukko aJoukko = null, bJoukko = null, c;
        kysyJoukot(aJoukko, bJoukko);
        c = IntJoukko.yhdiste(aJoukko, bJoukko);
        System.out.println("A yhdiste B = " + c.toString());
    }

    private static void joukkojenLeikkaus() {
        IntJoukko aJoukko = null, bJoukko = null, c;
        kysyJoukot(aJoukko, bJoukko);
        c = IntJoukko.leikkaus(aJoukko, bJoukko);
        System.out.println("A leikkaus B = " + c.toString());
    }

    private static void joukkojenErotus() {
        IntJoukko aJoukko = null, bJoukko = null, c;
        kysyJoukot(aJoukko, bJoukko);
        c = IntJoukko.erotus(aJoukko, bJoukko);
        System.out.println("A erotus B = " + c.toString());
    }
    
    private static void kysyJoukot(IntJoukko aJoukko, IntJoukko bJoukko) {
        System.out.println("1. joukko? ");
        aJoukko = pyydaMuokattavaJoukko();
        System.out.println("2. joukko? ");
        bJoukko = pyydaMuokattavaJoukko();
    }
    
    private static void joukostaPoisto() {
        Scanner lukija = new Scanner(System.in);
        System.out.print("Mistä joukosta? ");
        IntJoukko joukko = pyydaMuokattavaJoukko();
        System.out.print("Mikä luku poistetaan? ");
        joukko.poista(lukija.nextInt());
    }

    private static void kuuluukoJoukkoon() {
        Scanner lukija = new Scanner(System.in);
        System.out.print("Mihin joukkoon? ");
        IntJoukko joukko = pyydaMuokattavaJoukko();
        System.out.print("Mikä luku? ");
        int kysLuku = lukija.nextInt();
        if(joukko.kuuluuJoukkoon(kysLuku)) {
            System.out.println(kysLuku + " kuuluu joukkoon ");
        } else {
            System.out.println(kysLuku + " ei kuulu joukkoon ");
        }
    }

    public static void main(String[] args) {
        A = new IntJoukko();
        B = new IntJoukko();
        C = new IntJoukko();
        String luettu;

        System.out.println("Tervetuloa joukkolaboratorioon!");
        System.out.println("Käytössäsi ovat joukot A, B ja C.");
        System.out.println("Komennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e), leikkaus(le) ja lopetus(quit)(q).");
        System.out.println("Joukon nimi komentona tarkoittaa pyyntöä tulostaa joukko.");

        Scanner lukija = new Scanner(System.in);
        while (true) {
            luettu = lukija.nextLine();
            if (luettu.equals("lisää") || luettu.equals("li")) {
                joukkoonLisays();
            } else if (luettu.equalsIgnoreCase("poista") || luettu.equalsIgnoreCase("p")) {
                joukostaPoisto();
            } else if (luettu.equalsIgnoreCase("kuuluu") || luettu.equalsIgnoreCase("k")) {
                kuuluukoJoukkoon();
            } else if (luettu.equalsIgnoreCase("yhdiste") || luettu.equalsIgnoreCase("y")) {
                joukkojenYhdiste();
            } else if (luettu.equalsIgnoreCase("leikkaus") || luettu.equalsIgnoreCase("le")) {
                joukkojenLeikkaus();
            } else if (luettu.equalsIgnoreCase("erotus") || luettu.equalsIgnoreCase("e")) {
                joukkojenErotus();
            } else if (luettu.equalsIgnoreCase("A")) {
                System.out.println(A);
            } else if (luettu.equalsIgnoreCase("B")) {
                System.out.println(B);
            } else if (luettu.equalsIgnoreCase("C")) {
                System.out.println(C);
            } else if (luettu.equalsIgnoreCase("lopeta") || luettu.equalsIgnoreCase("quit") || luettu.equalsIgnoreCase("q")) {
                System.out.println("Lopetetaan, moikka!");
                break;
            } else {
                System.out.println("Virheellinen komento! " + luettu);
                System.out.println("Komennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e) ja leikkaus(le).");
            }
            System.out.println("Komennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e) ja leikkaus(le).");
        }
    }
}
