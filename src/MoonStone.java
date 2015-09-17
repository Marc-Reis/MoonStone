import javax.swing.*;

/**
 * Created by reisma on 24.06.15.
 */
public class MoonStone {

    /**
     * Startpunkt des Spiels durch main Methode - wie bei jedem (Java) Programm
     * Es können argumente bei aufruf (java MoonStone -GoodMode) übergeben werden,
     * diese landen im und als String im String Array.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Wir erzeugen aus der Klasse Frame eine neues Objekt und speichern dieses (dessen "Referenz, Zeiger") auf f
        // Der Frame ist der Fensterrahmen in dem Unser Spiel läuft/ gezeichnet wird
        MoonFrame f = new MoonFrame("test");

        // Klicken wir auf das x zum schießen im Fenster, so müssen wir festlegen was geschehen soll - in diesem Fall
        // Wird das Programm beendet (Exit) wenn das fenster geschlossen wird (close)
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Wir setzen die Auflösung/größe unseres Fensters
        f.setSize(800, 600);
        // Ein Fenster ist zu erst noch nicht sichtbar, bis wir im sagen das es sich zeigen soll
        // (solange kann man im "verborgenen" daran arbeiten
        f.setVisible(true);
        // Das Fenster darf nicht in seiner größe verändert werden.
        f.setResizable(false);


        // Der Game Loop
        // - Input abfragen,
        // - unserem Objekt der Klasse Frame sagen, dass es sich zeichnen darf
        //

        while (true) {
            // Input Verarbeiten - beachten Sie das Koordinatensystem! (y  hat positive Werte nach "unten" statt oben!)
            //
            if (f.getUp()) {
                f.player_posy -= 5;
            }
            if (f.getDown()) {
                f.player_posy += 5;
            }
            if (f.getRight()) {
                f.player_posx += 5;
            }
            if (f.getLeft()) {
                f.player_posx -= 5;
            }

            // Zeichnen des Grafikinhalte
            f.repaintScreen();

            // while(true) ist eine endlosschleife, für gewähren anderen Prozessen auf der CPU auch noch Rechenzeit!
            try {
                // Wir VERSUCHEN den Thread für 15 ms schlafen zu lassen (kann mehr oder weniger sein!)
                Thread.sleep(15);
            } catch (InterruptedException e) {
                // der "Versuch" kann scheitern,
                // in dem Fall fangen wir den fehler ab und geben ihn auf der Kommandozeile aus
                e.printStackTrace();
            }
        }
    }


}
