package MoveTest;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.List;

import javax.swing.JFrame;

public class Frame extends JFrame{
	

	final Player player; 
	final Background bg;
	
	private BufferStrategy strat;
	private List<Shot> shots;
	private List<Enemy> enemys;

	/**
	 * Der Konstruktor, er wird aktuell in der Klasse MoveTest in der main Methode aufgerufen, damit an dieser Stelle der
	 * Rahmen zum "zeichnen" des Spiels existiert.
	 * Er erhält als Argument folgende Objekte um diese Zeichnen zu können:
	 * 	ein Spieler Objekt, den hinter Grund als Background Objekt, ein Objekt einer Liste welche wiederrum 0-n Shot Objekte enthält
	 * 	und ein Objekt einer Liste welche 0-n Enemy Objekte enthält.
	 * @param player
	 * @param bg
	 * @param shots
	 * @param enemys
	 */
	public Frame(Player player, Background bg, List<Shot> shots, List<Enemy> enemys){
		super("Movetest");
	    addKeyListener(new Keyboard());
	    this.player = player;
	    this.bg = bg;
	    this.shots = shots;
	    this.enemys = enemys;
	      
	}

	/**
	 * Wir können verschiedene Strategien für das Buffern von Bildern (Screens) darzustellen, dies wird ihr festgelegt
	 * und ebenfalls in der MoveTest:main für das Objekt "f" der Klasse Frame genutzt.
	 */
	public void makeStrat(){
		 createBufferStrategy(2);
		    strat = getBufferStrategy();
	}

	/**
	 * Wird in main's GameLoop der Klasse MoveTest aufgerufen und sorgt dafür, dass
	 * Die Bufferstrategie angewandt wird, unsere Grapic gezeichnet wird (ruft draw auf)
	 * und danach dieser speicher für "graphics" frei gemacht wird
	 * die BufferStrategie wird genutzt um nun das Bild anzuzeigen
	 */
	public void repaintScreen()
	{
		Graphics g = strat.getDrawGraphics();
		draw(g);
		g.dispose();
		strat.show();
	}

	/**
	 * Wird durch repaintScreen aufgerufen (intern). Setzt die Farbe (fals keine Texturen)
	 * Zeichnet den Hintergrund (sieht "endlos" aus, da zwei nebeneinander gesetzt werden).
	 * Geht die Liste aller Enemys durch , schnappt sich je durchlauf einen und Zeichnet diesen
	 * Geht die Liste der Shots durch, schnappt sich je durchlauf einen und Zeichnet diesen
	 * Schnappt sich den Spieler und zeichnet sich diesen (noch keine Schleife)
	 * done.
	 * @param g
	 */
	private void draw(Graphics g) {
		g.setColor(Color.RED);

		g.drawImage(bg.getLook(), bg.getX(), 0, null);
		g.drawImage(bg.getLook(), bg.getX() + bg.getLook().getWidth(),0, null);
		
		
		
		for(int i = 0; i<enemys.size(); i++){
			Enemy e = enemys.get(i);
			g.drawImage(e.getLook(), e.getBounding().x,e.getBounding().y,null);
		}
		
		for(int i = 0; i<shots.size(); i++){
			Shot b = shots.get(i);
			g.drawImage(Shot.getLook(), b.getBounding().x, b.getBounding().y, null);
		}
		
		g.drawImage(player.getLook(), player.getBounding().x,
				player.getBounding().y, null);
		g.drawString("Health: "+player.getHealth(),10,10);
		
		}

	}
	
	
	
	
			
		

