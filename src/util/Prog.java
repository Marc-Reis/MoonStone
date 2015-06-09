package util;

import util.BNTMath;

/**
 * Created by reisma on 09.06.15.
 */
public class Prog {

    public static void main(String[] args) {

        // Deklaration einer Variable vom Typ util.BNTMath
        BNTMath meinBib;
        // Zuweisung eines neuen Objektes erstellt von der Klasse util.BNTMath
        // meinBib = Objekt der Klasse util.BNTMath
        meinBib = new BNTMath();

        // Simulierte Eingabe (einfach festgelegt) für a und b (ohne operator)
        double a = 5;
        double b = 7;

        // Berechnung und Ausgabe
        System.out.println(meinBib.add(a,b) );
        System.out.println(meinBib.pow(a, b));

        // meinBib.powsqr kann nur benutzt werden wenn diese nicht Private ist!

        /* System.out.println(meinBib.powsqr(a) ); */
    }
}
