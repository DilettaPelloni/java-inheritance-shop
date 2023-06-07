package org.lessons.java.shop;

//IMPORT
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Random;

public class Prodotto {

    //ATTRIBUTI
    private int codice;
    private String nome;
    private String descrizione;
    private BigDecimal prezzo;
    private BigDecimal iva;

    //COSTRUTTORE
    //da dati singoli
    public Prodotto(String nome, String descrizione, BigDecimal prezzo, BigDecimal iva) {
        this.codice = generateCode();
        this.nome = nome;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.iva = iva;
    }
    //da prodotto esistente
    public Prodotto(Prodotto prodotto) {
        this.codice = generateCode();
        this.nome = prodotto.nome;
        this.descrizione = prodotto.descrizione;
        this.prezzo = prodotto.prezzo;
        this.iva = prodotto.iva;
    }

    //GETTERS
    public int getCodice() {
        return codice;
    }
    public String getNome() {
        return nome;
    }
    public String getDescrizione() {
        return descrizione;
    }
    public BigDecimal getPrezzo() {
        return prezzo;
    }
    public BigDecimal getIva() {return iva;}

    //SETTERS
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }
    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }

    //METODI
    public BigDecimal getPrezzoIvato() {
        return prezzo.add(prezzo.multiply(iva.divide(new BigDecimal(100))));
    }

    protected int getSconto() {
        return 2;
    }

    public BigDecimal getPrezzoScontato() {
        //applico lo sconto sull'imponibile
        BigDecimal prezzoScontato = prezzo.subtract(prezzo.multiply(new BigDecimal((double)getSconto() / 100)));
        //restituisco il prezzo scontato con l'iva
        return prezzoScontato.add(prezzoScontato.multiply(iva.divide(new BigDecimal(100))));
    }

    public String getPrezzoFormattato() {
        return new DecimalFormat("###,###.00€").format(prezzo);
    }

    public String getNomeCompleto() {
        return codice + "-" + nome;
    }

    @Override
    public String toString() {
        return "codice= " + codice +
                ", nome= " + nome +
                ", descrizione= " + descrizione +
                ", prezzo= " + getPrezzoFormattato() +
                ", iva= " + iva +  "%";
    }

    private int generateCode(){
        return new Random().nextInt(0, 1000);
    }

}
