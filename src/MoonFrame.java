import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by reisma on 01.07.15.
 * Wir erzeugen eine Klasse welche die basis für das Anzuzeigende Fenster beinhaltet.
 * Die Kommunikation die hierzu mit dem Betriebsystem notwendig ist und viele weitere Arbeiten erledigt
 * allerdings schon eine Klasse JFrame der Java Entwickler. Wir machen uns dies zu nutze und "erben" diese
 * Funktionalität in dem wir die Klasse mit "extends" erweitern.
 */
public class MoonFrame extends JFrame {

    // Variable welche den Titel des Fensters enthält.
    private static String title = "MoonStone";

    //
    private Screen screen;

    // Variablen zur spiecherung der Position des Spielers (als Kommazahl)
    float player_posx = 300;
    float player_posy = 300;
    // Under Spiele ist ein rechteck und benötigt noch eine größe
    private int player_size = 50;

    // Boolsche Werte zum speichern des zustandes true, wenn
    // die passende taste gedrückt wurde. (Hoch, runter, links, rechts)
    private boolean key_up = false;
    private boolean key_down = false;
    private boolean key_left = false;
    private boolean key_right = false;

    // Der Konstruktor der Klasse MoonFrame (heißt genauso, - kein void oder Rückgabetyp
    public MoonFrame() {
        // Mit super rufen wir die "erweiterte" Klasse an bzw. deren Kontruktor und können in diesem Fall
        // den Titel des Fenster übergeben - achtung, der title ist eine Besondere Variable eine Idee Warum?
        super(title);
        screen = new Screen();
        // Wir setzen die Ausmaße unserer Leinwand, in diesem Fall 800x600
        screen.setBounds(0, 0, 800, 600);
        // Unserem Frame können wir diese Leinwand mit geben, mittels add, als Komponente die im Fram liegen soll
        add(screen);
        // Damit wir überhaupt mitbekommen wenn eine Taste gedrückt wird, müssen wir einen "Listener" in diesem Fall
        // Keylistener hinzufügen. Dies zu verarbeiten erledigt dann unser KeyHandler.
        addKeyListener(new KeyHandler());
    }

    /**
     * Methoden zum Abfragen der gespeicherten Werte in den Variablen für die gedrückten Tasten
     *
     * @return
     */
    public boolean getUp() {
        return key_up;
    }

    public boolean getDown() {
        return key_down;
    }

    public boolean getLeft() {
        return key_left;
    }

    public boolean getRight() {
        return key_right;
    }

    /**
     * Methode welche wir aufrufen um die Leinwand neuzuzeichnen
     */
    public void repaintScreen() {
        screen.repaint();
    }

    /**
     * Innerklass (wir können eine Klasse die wir nur hier brauchen in einer Klasse selbst definieren )
     * Damit wir auch hier nicht wieder alles neu machen müssen nutzen wir den Java JLabel - eigentlich ein
     * Beschriftungsfeld - lässt sich aber gut missbrauchen um darin zu zeichnen
     */
    private class Screen extends JLabel {
        /**
         * Wir überschreiben die Methode paintComponent des JLabels, dann wird immer das gemacht
         * was wir in unserer überschriebenen Methode festgehalten haben
         *
         * @param g
         */
        @Override
        protected void paintComponent(Graphics g) {
            // Konstruktor der Super /Elternkalsse JLabel aufrufen - ohne gehts nicht!
            super.paintComponent(g);
            //unserem Graphics Objekt die farbe setzen (unser "malstift")
            g.setColor(Color.RED);
            // und damit en Rechteck ausmahlen. Die größe des rechtecks beziehen wir vom Spieler
            g.fillRect((int) player_posx, (int) player_posy, player_size, player_size);
        }
    }

    /**
     * Noch eine innere Klasse - sie implementiert, was  im KeyListener vorgeschrieben wurde (ein interface)
     * Ein Interface gibt nur den Kopf einer Methode an (Rückgabewertm Name und Parameter), die Signatur
     * Somit weiss jeder wie man die Methode aufruft, was drin geschieht kann man selbst festlegen - eine Schnittstelle
     * In diesem Fall Methoden um auf die Tastendrücke zu reagieren, Java nutzt diese um Bei einem Tastendruck
     * einen registrietes KeyHandler Objekt aufzurufen, dafür muss es aber eben wissen welceh Methoden es gibt, das legt
     * das Interface fest und wir hier was darin passiert.
     */
    private class KeyHandler implements KeyListener {

        /**
         * Reagiere darauf wenn eine Taste gedrückt wird
         * Der Tastendruck kommt als "KeyEvent" Objekt e zu uns
         *
         * @param e
         */
        @Override
        public void keyPressed(KeyEvent e) {
            // Prüfe ob des KeyEvents KeyCode (Taste) gleicher einer verdfinierte ist (z.B. "S") und reagiere entsprechend
            if (e.getKeyCode() == KeyEvent.VK_S) key_down = true;
            if (e.getKeyCode() == KeyEvent.VK_W) key_up = true;
            if (e.getKeyCode() == KeyEvent.VK_D) key_right = true;
            if (e.getKeyCode() == KeyEvent.VK_A) key_left = true;
        }

        /**
         * Wiw oben, aber hier wird auf das "los lassen" der Taste reagiert
         *
         * @param e
         */
        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_S) key_down = false;
            if (e.getKeyCode() == KeyEvent.VK_W) key_up = false;
            if (e.getKeyCode() == KeyEvent.VK_D) key_right = false;
            if (e.getKeyCode() == KeyEvent.VK_A) key_left = false;
        }

        //Unnötig - schaut aber doch mal selbst wo der Unterschied liegt!
        @Override
        public void keyTyped(KeyEvent arg0) {
        }

    }
}

