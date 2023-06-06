package org.lessons.java.shop;

//IMPORT
import java.math.BigDecimal;

//Smartphone estende Prodotto
public class Smartphone extends Prodotto {

    //ATTRIBUTI
    private String imei;
    private int memoria;

    //COSTRUTTORE
    //con dati singoli
    public Smartphone(String nome, String descrizione, BigDecimal prezzo, BigDecimal iva, String imei, int memoria) {
        super(nome, descrizione, prezzo, iva);
        this.imei = imei;
        this.memoria = memoria;
        if(memoria < 32) {
            super.setSconto(5);
        }
    }
    //con oggetto esistente
    public Smartphone(Prodotto prodotto, String imei, int memoria) {
        super(prodotto);
        this.imei = imei;
        setMemoria(memoria);
    }

    //GETTERS
    public String getImei() {
        return imei;
    }
    public int getMemoria() {
        return memoria;
    }

    //SETTERS
    public void setImei(String imei) {
        this.imei = imei;
    }
    public void setMemoria(int memoria) {
        this.memoria = memoria;
        if(memoria < 32) {
            super.setSconto(5);
        }
    }

    //METODI
    @Override
    public String toString() {
        return super.toString() + ", imei= " + imei + ", memoria= " + memoria;
    }
}
