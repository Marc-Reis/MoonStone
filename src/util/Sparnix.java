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

        schmitts.bez = "Robins Konto";
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
            Konto x = findeKonto(alleKonten, eingabe("Bitte Kontonummer angeben!") );
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
     * @param message  String der die Anzuzeigende Nachricht beinhaltet wie "Bitte Kontonummer eingeben"
     * @return String der Kontonummer
     *
     */
    public static String eingabe(String message){
        Scanner myScanner = new Scanner(System.in);
        System.out.println(message);

        return  myScanner.next();
    }

    /**
     * Ausgabe der Daten eines Kontos
     * @param dasKonto Konto dessen Daten ausgegeben werden sollen
     */
    public static void ausgabe( Konto dasKonto){
        if( dasKonto != null ) {
            // Ausgabe
            System.out.println(dasKonto.bez + " "
                    + dasKonto.kontostand + " "
                    + dasKonto.knr);
            // Eine Einzahlung/Auszahlung tätigen?
            String ein =  eingabe("Ein/Aus Zahlen ? E/A/N: ");
            // Unterscheiden was der Benutzer will - nur E und A, alles andere führt zu keiner bearbeitung
            switch (ein) {
                case "E":
                    kontostandAendern(dasKonto,  true);
                    break;
                case "A":
                    kontostandAendern(dasKonto, false);
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * Aendert den Kontostand ab auf dem als Parameter uebergebenem Konto.
     * Einzahlen wird genutzt um zu unterscheiden ob positiv oder negativ auf dem Kontostand gerechnet wird
     * @param dasKonto das Konto auf dem gearbeitet wird
     * @param einzahlen true, wenn es eine Einzahlung ist, false wenn es eine Auszahlung ist
     */
    public static void kontostandAendern(Konto dasKonto, boolean einzahlen){
        double x = Double.parseDouble(      // Wert den die Methode einfabe liefert als Double parsen und speichern
                eingabe("Betrag zur " +
                        (einzahlen ? "Einzahlung":"Auszahlung") // wie ein if, wenn einzahlen true dann "einzahlung" sonst "auszahlung"
                        + " bitte positiv angeben: " ) );
        if( einzahlen)
            dasKonto.kontostand =  dasKonto.kontostand + x;
        else
            dasKonto.kontostand =  dasKonto.kontostand - x;

        System.out.println("Wir Danken! Aktueller Kontostand nun: "+dasKonto.kontostand);
    }




}
