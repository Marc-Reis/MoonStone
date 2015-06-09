package util;

/**
 * Created by reisma on 09.06.15.
 */
public class BNTMath {

    // Speichert sich die letzte operation die auf dem Objekt ausgeführt wurde
    private String lastOperation = null;

    /**
     * Addiert zwei zahlen a und b
     * @param a double erste Zahl
     * @param b double zweite Zahl
     * @return double ergebniss der Addition
     */
    public double add( double a, double b){
        double c = a+b;
        lastOperation = a+" + "+b+" = "+c;
        return c;
    }

    /**
     * Berechnet den Potentierung
     * @param a Basis
     * @param b Exponent
     * @return Ergebnis von a^b
     */
    public double pow( double a, double b){
        double c = Math.pow(a,b);
        lastOperation = a+" ^ "+b+" = "+c;
        return c;
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
            lastOperation = a+" ^ "+b+" = "+res;
        }
        else {
            res = powsqr(a);
            lastOperation = a+" ^ zwo"+" = "+res;
        }
        return res;

    }

    /**
     *
     * @param a
     * @param b
     * @return
     */
    public double div( double a, double b){
        double c = a/b;
        lastOperation = a+" / "+b+" = "+c;
        return c;
    }

    /**
     *
     * @param a
     * @param b
     * @return
     */
    public double sub( double a, double b){
        double c = a-b;
        lastOperation = a+" - "+b+" = "+c;
        return c;
    }

    /**
     *
     * @param a
     * @param b
     * @return
     */
    public double mul( double a, double b){
        double c = a*b;
        lastOperation = a+" * "+b+" = "+c;
        return c;
    }

    /**
     * Gibt die letze Operation des Objektes zürück, null wenn noch nichts berechnett
     * @return
     */
    public  String getLastOperation(){
        return lastOperation;
    }

    /**
     *
     * @param operator
     * @param vara
     * @param varb
     * @return
     */
    public double berechnung(String operator, double vara, double varb ){
        //********************************************************************
        // Unterscheidung der Operatoren und Berechnung

        // Variable für das Ergebnis
        double result;

        switch (operator) {

            case "/":
                result = div(vara, varb);
                break;

            case "*":
                result = mul(vara, varb);
                break;

            case "+":
                result = add(vara,varb);
                break;

            case "-":
                result = sub(vara,varb);
                break;

            case "^":
                result = pow(vara, varb);
                break;

            default:
                System.out.println("Ich kenne " + operator + " nicht!");
                result = 0;

        }

        return result;
    }

}
