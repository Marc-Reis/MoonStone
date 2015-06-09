package util;

import java.util.Scanner;

/**
 * Created by reisma on 09.06.15.
 */
public class Eingabe {

    public String operator = null;
    public double a = 0.0;
    public double b = 0.0;

    public void getUserInput(Scanner scanner){

        //********************************************************************
        // Eingabe des Operators und der Zahlen
        System.out.println("Gib Zahl 1  ein");
        a = scanner.nextDouble();

        System.out.println("Gib den Operator ein");
        operator = scanner.next();

        System.out.println("Gib Zahl 2  ein");
        b = scanner.nextDouble();

    }

}
