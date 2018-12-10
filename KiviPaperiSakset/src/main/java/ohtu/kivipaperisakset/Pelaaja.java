/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

/**
 *
 * @author janne
 */
public abstract class Pelaaja {
    protected static Tuomari tuomari;
    
    protected Pelaaja(Tuomari tuomari) {
        this.tuomari = tuomari;
    }
    
    public static Pelaaja pelaajaVSPelaaja(Tuomari tuomari) {
        return new KPSPelaajaVsPelaaja(tuomari);
    }
    
    public static Pelaaja pelaajaVSHuonoTekoaly(Tuomari tuomari, Tekoaly tekoaly) {
        return new KPSTekoaly(tuomari, tekoaly);
    }
    
    public static Pelaaja pelaajaVSHyvaTekoaly(Tuomari tuomari, Tekoaly tekoaly) {
        return new KPSTekoaly(tuomari, tekoaly);
    }    
    
    protected abstract void pelaa();
    
    public static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
    
    public static void peliOhi() {
        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }    
}
