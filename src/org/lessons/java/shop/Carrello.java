package org.lessons.java.shop;

//IMPORT
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Carrello {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Benvenuto nel carrello");
        System.out.print("Quanti prodotti vuoi inserire?");
        int numProdotti = Integer.parseInt(scan.nextLine());

        //creo il carrello
        Prodotto[] carrello = new Prodotto[numProdotti];

        //entro nel loop di richiesta d'inserimento nel carrello.
        for (int i = 0; i < numProdotti; i++) {
            System.out.println("------------ " + (i+1) + "° PRODOTTO ------------");
            //raccolgo l'input dall'utente e lo verifico
            int inputUtente;
            do {
                System.out.println("Che tipo di prodotto vuoi inserire?");
                System.out.println("1 - Smartphone");
                System.out.println("2 - Televisore");
                System.out.println("3 - Cuffie");
                inputUtente = Integer.parseInt(scan.nextLine());
                if(inputUtente < 1 || inputUtente > 3) {
                    System.out.println("L'input inserito non è valido.\n");
                }
            } while (inputUtente < 1 || inputUtente > 3);

            //raccolgo dall'utente le informazioni per creare il prodotto
            //parto da quelle comuni a tutte le tipologie di prodotto
            System.out.print("Inserisci il nome del prodotto: ");
            String nome = scan.nextLine();
            System.out.print("Inserisci la descrizione del prodotto: ");
            String descrizione = scan.nextLine();
            System.out.print("Inserisci il prezzo del prodotto: ");
            BigDecimal prezzo = new BigDecimal(scan.nextLine());
            System.out.print("Inserisci l'aliquota IVA del prodotto: ");
            BigDecimal iva = new BigDecimal(scan.nextLine());

            Prodotto nuovoProdotto = new Prodotto(nome, descrizione, prezzo, iva);

            //poi chiedo quelle specifiche in base al suo input e creo l'oggetto specifico
            switch(inputUtente) {
                case 1:
                    System.out.print("Inserisci il codice IMEI dello Smartphone: ");
                    String imei = scan.nextLine();
                    System.out.print("Inserisci la quantità di memoria dello Smartphone: ");
                    int memoria = Integer.parseInt(scan.nextLine());
                    nuovoProdotto = new Smartphone(nuovoProdotto, imei, memoria);
                    break;
                case 2:
                    System.out.print("Inserisci la dimensione in pollici del televisore: ");
                    int dimensione = Integer.parseInt(scan.nextLine());
                    System.out.print("Il televisore è smart? s/n ");
                    boolean smart = scan.nextLine().toLowerCase().equals("s");
                    nuovoProdotto = new Televisore(nuovoProdotto, dimensione, smart);
                    break;
                case 3:
                    System.out.print("Inserisci il colore delle cuffie: ");
                    String colore = scan.nextLine();
                    System.out.print("Le cuffie sono wireless? s/n ");
                    boolean wireless = scan.nextLine().toLowerCase().equals("s");
                    nuovoProdotto = new Cuffie(nuovoProdotto, colore, wireless);
                    break;
            }//chiusura switch

            //metto il nuovo prodotto nel carrello
            carrello[i] = nuovoProdotto;

        }//chiusura ciclo for

        //chiedo all'utente se ha la tessera fedeltà
        System.out.println("Hai la tessera fedeltà? s/n");
        boolean fedele = scan.nextLine().toLowerCase().equals("s");

        //stampo il carrello e il suo totale
        BigDecimal prezzoTotale = new BigDecimal(0);
        System.out.println("Ecco il tuo carrello:");

        for (int i = 0; i < carrello.length ; i++) {
            System.out.println((i+1) + "° prodotto:");
            System.out.println(carrello[i].toString());
            if(fedele) {
                prezzoTotale = prezzoTotale.add(carrello[i].getPrezzoScontato());
            } else {
                prezzoTotale = prezzoTotale.add(carrello[i].getPrezzoIvato());
            }
        }

        System.out.println("Totale carrello: " + new DecimalFormat("###,###.00€").format(prezzoTotale));

        scan.close();
    }
}
