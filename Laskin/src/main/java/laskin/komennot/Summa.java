/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskin.komennot;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import laskin.Sovelluslogiikka;

/**
 *
 * @author janne
 */
public class Summa extends LaskinKomento {

    public Summa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    public void suorita() {
        vanhaTulos = haeSyote(tuloskentta.getText());
        vanhaSyote = haeSyote(syotekentta.getText());
        sovellus.plus(vanhaSyote);
        annaTulos(sovellus.tulos());
    }
    
    @Override
    public void peru() {
        sovellus.miinus(vanhaSyote);
        annaEdellinenTulos(vanhaTulos);
    }
}
