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
	private List<MoveTest.Enemy> enemys;
	
	
	public Frame(Player player, Background bg, List<Shot> shots, List<MoveTest.Enemy> enemys){
		super("Movetest");
	    addKeyListener(new Keyboard());
	    this.player = player;
	    this.bg = bg;
	    this.shots = shots;
	    this.enemys = enemys;
	      
	}
	
	public void makeStrat(){
		 createBufferStrategy(2);
		    strat = getBufferStrategy();
	}
	
	
	public void repaintScreen()
	{
		Graphics g = strat.getDrawGraphics();
		draw(g);
		g.dispose();
		strat.show();
	}
	
	private void draw(Graphics g) {
		g.setColor(Color.RED);

		g.drawImage(bg.getLook(), bg.getX(), 0, null);
		g.drawImage(bg.getLook(), bg.getX() + bg.getLook().getWidth(),0, null);
		
		
		
		for(int i = 0; i<enemys.size(); i++){
			MoveTest.Enemy e = enemys.get(i);
			g.drawImage(e.getLook(), e.getBounding().x,e.getBounding().y,null);
		}
		
		for(int i = 0; i<shots.size(); i++){
			Shot b = shots.get(i);
			g.drawImage(Shot.getLook(), b.getBounding().x, b.getBounding().y, null);
		}
		
		g.drawImage(player.getLook(), player.getBounding().x,
				player.getBounding().y, null);
		
		}
	}
	
	
	
	
			
		

