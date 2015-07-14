package util.basics;

import java.awt.*;

/**
 * Created by reisma on 14.07.15.
 */
public class Auto {
    // Definition der Eigenschaften die wir im Programm abbilden möchten
    int ps;
    Color farbe;
    double kmStand;

    /**
     * Konstruktor - initalisiert das neue Objekt der Klasse mit den
     * von uns angegebenen Werten (Parameter des Aufrufs)
     * @param ps
     * @param farbe
     * @param kmStand
     */
    public Auto(int ps, Color farbe, double kmStand){
        // setzen dieser werte (des Objekts) mit denen als Parameter angegebenen
        this.ps = ps;
        this.farbe = farbe;
        this.kmStand = kmStand;

    }
    /**
     * Zweiter Konstruktor - andere Signatur Auto(int, String ,double) statt
     * Auto(int, Color, double)
     * @param ps2
     * @param farbe2
     * @param kmStand2
     */
    public Auto(int ps2, String farbe2, double kmStand2){
        this(ps2, Color.getColor(farbe2),kmStand2);

    }
    /**
     * Überschreiben des Standardkonstruktors (jede Klasse hat einen,
     * aber dort passiert ohne unsere Angaben nichts)
     */
    public Auto(){
        // Aufrufen des "ersten" Konstruktors - good practice
       this(60, Color.GREEN, 20.0);
    }

    /**
     * Instanzmethode die das Auto eine strecke als int angegeben
     * fahren lässt
     * @param strecke
     */
    public void fahre(int strecke){
        // Parameter Strecke auf die Feldvariable des Objekts addieren
        kmStand+= strecke;
    }

    /**
     * Wir Überschreiben to methode toString, welche alle Objects in Java
     * haben. Wir geben nun eine Zeichenkette zurück, welche für uns
     * sinvoll ist
     * @return
     */
    @Override
    public String toString(){
        return "PS: "+ps+", Farbe "+farbe+", Kilometerstand "+kmStand;
    }

    /**
     * Main methode zum testen der Klasse
     * @param args
     */
    public static void main(String[] args) {
        // Wir erzeugen drei Objekte der Klasse Auto
        Auto erstes     = new Auto();
        // und lassen sie ein paar Kilometer fahren
        erstes.fahre(10);
        Auto zweites    = new Auto(100, Color.BLACK, 10.0);
        zweites.fahre(20);
        Auto drittes    = new Auto(100, "Black", 10.0);
        drittes.fahre(30);
        // Wir nutzen die Überschriebene Methode toString() impliziet,
        // da jedes Objekt so direkt ausgegeben werden kann.
        System.out.println(erstes); // erstes.toString();
        System.out.println(zweites);
        System.out.println(drittes);
    }
}
