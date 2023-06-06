package org.lessons.java.shop;

import java.math.BigDecimal;

//Cuffie estende Prodotto
public class Cuffie extends Prodotto{

    //ATTRIBUTI
    private String colore;
    private boolean wireless;

    //COSTRUTTORE
    //con dati singoli
    public Cuffie(String nome, String descrizione, BigDecimal prezzo, BigDecimal iva, String colore, boolean wireless) {
        super(nome, descrizione, prezzo, iva);
        this.colore = colore;
        this.wireless = wireless;
        if(!wireless) {
            super.setSconto(7);
        }
    }
    //con oggetto esistente
    public Cuffie(Prodotto prodotto, String colore, boolean wireless) {
        super(prodotto);
        this.colore = colore;
        setWireless(wireless);
    }

    //GETTERS
    public String getColore() {
        return colore;
    }
    public boolean isWireless() {
        return wireless;
    }

    //SETTERS
    public void setColore(String colore) {
        this.colore = colore;
    }
    public void setWireless(boolean wireless) {
        this.wireless = wireless;
        if(!wireless) {
            super.setSconto(7);
        }
    }

    //METODI
    @Override
    public String toString() {
        return super.toString() + ", colore= " + colore + ", wireless= " + (wireless ? "si" : "no");
    }
}
