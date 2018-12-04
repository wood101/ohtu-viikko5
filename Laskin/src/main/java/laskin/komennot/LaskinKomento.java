/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskin.komennot;

import java.util.Map;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import laskin.Komento;
import laskin.Sovelluslogiikka;

/**
 *
 * @author janne
 */
public abstract class LaskinKomento implements Komento {
    protected TextField tuloskentta;
    protected TextField syotekentta;
    protected Button nollaa;
    protected Button undo;
    protected Sovelluslogiikka sovellus;
    protected int vanhaTulos;
    protected int vanhaSyote;

    public LaskinKomento(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
        this.sovellus = sovellus;
        this.vanhaTulos = 0;
        this.vanhaSyote = 0;
    }
    
    protected int haeSyote(String syote) {
        int arvo = 0;
        try {
            arvo = Integer.parseInt(syote);
        } catch (Exception e) {
        }
        return arvo;
    }

    protected void annaTulos(int tulos) {
        syotekentta.setText("");
        tuloskentta.setText("" + tulos);

        if ( tulos == 0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
        undo.disableProperty().set(false);
    }
    
    protected void annaEdellinenTulos(int tulos) {
        syotekentta.setText("");
        tuloskentta.setText("" + tulos);
        if ( tulos == 0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
        undo.disableProperty().set(true);
    }
}

