package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSTekoaly extends Pelaaja {

    private static final Scanner scanner = new Scanner(System.in);
    Tekoaly tekoaly;
    
    public KPSTekoaly(Tuomari tuomari, Tekoaly tekoaly) {
        super(tuomari);
        this.tekoaly = tekoaly;
    }

    @Override
    public void pelaa() {
        System.out.print("Ensimmäisen pelaajan siirto: ");
        String ekanSiirto = scanner.nextLine();
        
        String tokanSiirto = tekoaly.annaSiirto();
        System.out.println("Tietokone valitsi: " + tokanSiirto);

        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();

            System.out.print("Ensimmäisen pelaajan siirto: ");
            ekanSiirto = scanner.nextLine();

            tokanSiirto = tekoaly.annaSiirto();
            System.out.println("Tietokone valitsi: " + tokanSiirto);

        }
        peliOhi();
    }
}