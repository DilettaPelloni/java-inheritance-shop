package org.lessons.java.shop;

//IMPORT
import java.math.BigDecimal;

//Televisore estende Prodotto
public class Televisore extends Prodotto{

    //ATTRIBUTI
    private int dimensioni;
    private boolean smart;

    //COSTRUTTORE
    //con dati singoli
    public Televisore(String nome, String descrizione, BigDecimal prezzo, BigDecimal iva, int dimensioni, boolean smart) {
        super(nome, descrizione, prezzo, iva);
        this.dimensioni = dimensioni;
        this.smart = smart;
        if(!smart) {
            super.setSconto(10);
        }
    }
    //con oggetto esistente
    public Televisore(Prodotto prodotto, int dimensioni, boolean smart) {
        super(prodotto);
        this.dimensioni = dimensioni;
        setSmart(smart);
    }

    //GETTERS
    public int getDimensioni() {
        return dimensioni;
    }
    public boolean isSmart() {
        return smart;
    }

    //SETTERS
    public void setDimensioni(int dimensioni) {
        this.dimensioni = dimensioni;
    }
    public void setSmart(boolean smart) {
        this.smart = smart;
        if(!smart) {
            super.setSconto(10);
        }
    }

    //METODI
    @Override
    public String toString() {
        return super.toString() + ", dimensioni= " + dimensioni + ", smart= " + (smart ? "si" : "no");
    }
}
