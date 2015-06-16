package util;

import java.util.Scanner;

/**
 * Created by reisma on 16.06.15.
 */
public class Sparnix {


    public static void main(String[] args) {

        Konto [] alleKonten;
        alleKonten = beispieleAnlegen();
        kontoInfo(alleKonten);

    }

    /**
     * Legt die zwei Beispielkonten an
     * @return Konto [] Array mit den Beispielkonten
     */
    public static Konto [] beispieleAnlegen(){
        Konto [] alleKonten = new Konto[3];
        Konto schmitts = new Konto();
        Konto theis = new Konto();

        schmitts.bez = "RObins Konto";
        schmitts.kontostand = 1000000;
        schmitts.knr = "DE4711";

        theis.bez = "Carstens Konto";
        theis.kontostand = 1000001.99;
        theis.knr = "DE5000";

        alleKonten[0] = schmitts;
        alleKonten[1] = theis;

        return alleKonten;
    }

    /**
     * Läuft in einer Schleife und Fragt nach einer Kontonummer
     * durch aufruf der methode eingabe, und sucht diese in den konten
     * durch aufruf der methode findeKonto.
     * Erzeugt durch aufruf von ausgabe eine Ausgabe
     * @param alleKonten
     */
    public static void kontoInfo(Konto [] alleKonten){

        while(true) {
            Konto x = findeKonto(alleKonten, eingabe() );
            ausgabe(x);
        }

    }

    /**
     * Sucht nach der Kontonummer (String x) in einem
     * Array von Konten in eine
     * @param alle Konto [] Array mit allen Konten die durchsucht werden
     * @param kontonr String der mit Konto.knr verglichen wird
     * @return Konto Objekt zur Kontonummer oder null
     */
    public static Konto findeKonto(Konto [] alle, String kontonr){
         for(Konto k: alle ){
             if (k != null && k.knr.equals(kontonr) ) {
                 return k;
             }
         }
        // nix gefunden... dann null
        return null;
    }

    /**
     * Erstellt einen Scanner, fragt nach der Kontonummer
     * und gibt diese als String zurück
     * @return String der Kontonummer
     */
    public static String eingabe(){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Bitte Kontonummer angeben!");

        return  myScanner.next();
    }

    /**
     * Ausgabe der Daten eines Kontos
     * @param dasKonto Konto dessen Daten ausgegeben werden sollen
     */
    public static void ausgabe( Konto dasKonto){
        if( dasKonto != null ) {
            System.out.println(dasKonto.bez + " "
                    + dasKonto.kontostand + " "
                    + dasKonto.knr);
        }
    }




}
