package util.basics;

import javax.swing.*;
import java.util.Scanner;

/**
 * Created by reisma on 23.06.15.
 */
public class Checkliste {

    public static void main (String [] args){
        Checkliste ckl =  new Checkliste();
        long startTime  = System.currentTimeMillis();
        ckl.countDown(100000);
        long stopTime = System.currentTimeMillis();

        ckl.countDownSlow(100000);
        Scanner s = new Scanner(System.in);
        long stopTime2 = System.currentTimeMillis();

        System.out.println("Time: " + (startTime - stopTime));
        System.out.println("Time: "+ (startTime-stopTime2));

        char c = s.next().charAt(0);

    }

    public void countDown(int number){

        StringBuffer buffer = new StringBuffer(100000);

        while( number > 0){
            buffer.append("\n"+number);
            number--;
        }
        System.out.println(buffer);

    }
    public void countDownSlow(int number){
        long startTime  = System.currentTimeMillis();

        while( number > 0){
            System.out.println(number);
            number--;
        }

    }
}
