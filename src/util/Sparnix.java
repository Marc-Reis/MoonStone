package util;

/**
 * Created by reisma on 16.06.15.
 */
public class Sparnix {


    public static void main(String[] args) {
        int z = 7;
        Konto schmitts = new Konto();
        Konto theis = new Konto();

        schmitts.bez = "RObins Konto";
        schmitts.kontostand = 1000000;
        schmitts.knr = "DE4711666666";

        theis.bez = "Carstens Konto";
        theis.kontostand = 1000001.99;
        theis.knr = "DE500030001";

        System.out.println(schmitts.bez + " "
                + schmitts.kontostand + " "
                + schmitts.knr);
    }
}
