package util;

/**
 * Created by reisma on 09.06.15.
 */
import java.util.Scanner;

// Rechner nunr als Objekt ausgelegt, nicht als reine procedurale "Main-Methode"
public class Rechner {

    // Variablen deklaration
    boolean keepRunning = true;                     // Variable für den Schleifendurchlauf / Prüfung
    int zaehler = 0;                                // Scleifenzähler für das Array (0,1,2 0,1,2 usw.)
    Scanner scanner;
    BNTMath myMath;
    Eingabe myEingabe;
    String [] arrayofstring;

    /**
     *
     * @param args
     */
    public static void main(String args[]) {

        Rechner myRechner  = new Rechner();
        myRechner.rechne();

    }

    private void init(){
        System.out.println("Hallo zum Rechner v1.0");

        // Variablen initialisierung
        scanner         = new Scanner(System.in);
        arrayofstring   = new String [3];      // Array zum Speichern von zwischenwerten
        myMath          = new BNTMath();                 // Berechnungen nun ausgelagert
        myEingabe       = new Eingabe();              // Eingabe und Daten ausgelagert

    }

    private void rechne(){

        init();

        // Hauptschleife
        while (keepRunning) {
            // Zähler für das zwischenspechern prüfen, da nur 3 gespeichert werden sollen
            if(zaehler >= 3) {zaehler = 0;}

            // Benutzt ein Objekt der Klasse Einfabe um diese zu lesen und Speichern/Abfragen
            myEingabe.getUserInput(scanner);

            // Berechnung in einem Objekt der Klasse BNTMath, nutzt das Objekt der Eingabe um Werte zu erhalten
             myMath.berechnung(myEingabe.operator, myEingabe.a, myEingabe.b);

            ergebnisausgabe(myMath.getLastOperation(), scanner);

            ergebnisspeichern( arrayofstring, myMath.getLastOperation() );

        }

        System.out.println("Good Bye!");
    }



    /**
     *
     * @param operation
     * @param scanner
     */
    private void ergebnisausgabe(String operation, Scanner scanner){
        //********************************************************************
        // Ergebnis ausgabe vorbereiten und ausgeben

        System.out.println(operation);

        //********************************************************************
        // Abfragen ob noch eine Berechnung gewünscht ist und prüfen
        System.out.println("Noch eine Berechnung? (J/N)");

        if (scanner.next().equals("N") ){
            keepRunning = false;
        }
    }

    /**
     *
     * @param arrayofString
     * @param operation
     */
    private void ergebnisspeichern(String arrayofString[], String operation){
        //********************************************************************
        //Speichern
        arrayofString[zaehler] = operation;
        zaehler++;

        //Ausgabe mit "for each" schleife
        for(String txt : arrayofString){
            System.out.println(txt);
        }
    }
}
