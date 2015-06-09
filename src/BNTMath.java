/**
 * Created by reisma on 09.06.15.
 */
public class BNTMath {

    // Speichert sich die letzte operation die auf dem Objekt ausgeführt wurde
    private String lastOperation = "";

    /**
     * Addiert zwei zahlen a und b
     * @param a double erste Zahl
     * @param b double zweite Zahl
     * @return double ergebniss der Addition
     */
    public double add( double a, double b){
        double c = a+b;
        lastOperation = a+" + "+b;
        return c;
    }

    /**
     * Berechnet den Potentierung
     * @param a Basis
     * @param b Exponent
     * @return Ergebnis von a^b
     */
    public double pow( double a, double b){
        lastOperation = a+" ^ "+b;
        return Math.pow(a,b);
    }

    /**
     * Private Methode für interne Zwecke
     * @param a basis
     * @return immer a hoch zwei
     */
    private double powsqr(double a){
        return Math.pow(a,2);
    }

    /**
     * Zweite Exponential Methode -> Potetiert alles bis auf b=2 direkt b=2 ist ausgelagert
     * @param a double Wert der Basis
     * @param b double Wert des Exponenten
     * @return direktes Berechnung von a^b, bei b= 2 über hilfsmethode
     */
    public double pow2(double a, double b){
        double res;

        if( b!= 2){
            res = Math.pow(a, b);
            lastOperation = a+" ^ "+b;
        }
        else {
            res = powsqr(a);
            lastOperation = a+" ^ zwo";
        }
        return res;

    }

}
