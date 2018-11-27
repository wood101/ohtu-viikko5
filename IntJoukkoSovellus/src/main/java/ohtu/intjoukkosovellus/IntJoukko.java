
package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
                            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] jononLuvut;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        joukonAlustus(KAPASITEETTI, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti) {
        joukonAlustus(kapasiteetti, OLETUSKASVATUS);
    }
    
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        joukonAlustus(kapasiteetti, kasvatuskoko);
    }
    
    private void joukonAlustus(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti väärin");
        }
        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("Kasvatuskoon pitää olla positiivinen");
        }
        jononLuvut = new int[kapasiteetti];
        for (int i = 0; i < jononLuvut.length; i++) {
            jononLuvut[i] = 0;
        }
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;        
    }

    public boolean lisaa(int luku) {
        if (alkioidenLkm == 0) {
            jononLuvut[0] = luku;
            alkioidenLkm++;
            return true;
        } else if (!kuuluuJoukkoon(luku)) {
            return lisaaUusiLuku(luku);
        }
        return false;
    }

    private boolean lisaaUusiLuku(int luku) {
        jononLuvut[alkioidenLkm] = luku;
        alkioidenLkm++;
        if (alkioidenLkm % jononLuvut.length == 0) {
            int[] taulukkoOld = jononLuvut;
            kopioiTaulukko(jononLuvut, taulukkoOld);
            jononLuvut = new int[alkioidenLkm + kasvatuskoko];
            kopioiTaulukko(taulukkoOld, jononLuvut);
        }
        return true;
    }
    
    public boolean kuuluuJoukkoon(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == jononLuvut[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean poista(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == jononLuvut[i]) {
                jononLuvut[i] = 0;
                for (int j = i; j < alkioidenLkm - 1; j++) {
                    int apu = jononLuvut[j];
                    jononLuvut[j] = jononLuvut[j + 1];
                    jononLuvut[j + 1] = apu;
                }
                alkioidenLkm--;
                return true;
            }
        }
        return false;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        System.arraycopy(vanha, 0, uusi, 0, vanha.length);

    }

    public int mahtavuus() {
        return alkioidenLkm;
    }


    @Override
    public String toString() {
        switch (alkioidenLkm) {
            case 0:
                return "{}";
            case 1:
                return "{" + jononLuvut[0] + "}";
            default:
                String tuotos = "{";
                for (int i = 0; i < alkioidenLkm - 1; i++) {
                    tuotos += jononLuvut[i] + ", ";
                }
                tuotos += jononLuvut[alkioidenLkm - 1] + "}";
                return tuotos;
        }
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        System.arraycopy(jononLuvut, 0, taulu, 0, taulu.length);
        return taulu;
    }
   

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko joukko = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            joukko.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            joukko.lisaa(bTaulu[i]);
        }
        return joukko;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko joukko = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    joukko.lisaa(bTaulu[j]);
                }
            }
        }
        return joukko;

    }
    
    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        IntJoukko joukko = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            joukko.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            joukko.poista(i);
        }
        return joukko;
    }
        
}