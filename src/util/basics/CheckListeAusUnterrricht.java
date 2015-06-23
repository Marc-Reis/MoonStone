package util.basics;

/**
 * Created by reisma on 23.06.15.
 */
public class CheckListeAusUnterrricht {

    // Eine Variable f¸r die Klasse deklarieren (nicht nur in einem Methodenblock)
    double pi = Math.PI;

    // eine Methode in der Klasse deklarieren; Mit Parameter "radius" und rücckgabewert
    public double kreisflaeche(double radius) {

        return pi * radius * radius;
    }

    public static void main(String[] args) {
        CheckListeAusUnterrricht meineZahlenausgaben = new CheckListeAusUnterrricht();

        double flaeche = meineZahlenausgaben.kreisflaeche(3.0);

        System.out.println(flaeche);

        /**
         //Thomas//
         long x;
         x = 100000000;


         while (x>=1) {
         System.out.println(x);
         x--;
         }

         //Till//
         double a = 5;
         double b = 3;
         double z = a / b;
         System.out.println(z);

         double x = 5.0/3.0;
         System.out.println(x);
         */
        //Robin//
        /*
		Scanner s = new Scanner(System.in);
		double m = s.nextDouble();


		if ((m>0) && (m<7)){
			System.out.println("Note");
			}
		if ((m>7) || (m<=0)) {
			System.out.println("sonst was");
		} */
        //rahol
        System.out.println("hi wie heiﬂt du?");
        String name = "wErner";

        //if(name.equals("Werner")) {
		/*
		Josua
		if( name.toUpperCase().equals( "Werner".toUpperCase() )){
			System.out.println("hallo werner");
		}
		else {
			System.out.println("hallo Fremder");
		}

		String operator = ("+");

		char operator2 = '+';

		double kommazahl = 2.66;*/

		/*
		  Artur

		String a = "Hallo Welt ";
		String b = "Moin";

		String c = a+b;

		System.out.println(c);


		*/
        //Akash
		/*
		String zahl = "55";

		int x = Integer.parseInt(zahl);
		*/


        char a1 = 'c';
        char a2 = '3';
        char a3 = 'p';
        char a4 = 'o';
        StringBuffer buffer1 = new StringBuffer();
        buffer1.append(a1);
        buffer1.append(a2);
        buffer1.append(a3);
        buffer1.append(a4);
        System.out.println(a1 + a2 + a3 + a4);
        System.out.println(buffer1);


    }


}
