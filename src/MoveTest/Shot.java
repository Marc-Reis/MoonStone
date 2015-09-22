package MoveTest;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

public class Shot {
  
	private static BufferedImage look;
	
	static{
		 try {
				look = ImageIO.read(Shot.class.getClassLoader().getResourceAsStream("Gfx/Shot1.png"));
			} catch (IOException e) {
			  e.printStackTrace();
			}
		 }
	
	private float f_posx;
	private float f_posy;
	private float f_speedx;
	private float f_speedy;
	private Rectangle bounding;
	private List<Shot>shots;
	private float timeAlive;
	private final float TIMETOLIVE = 10;
	
	public Shot(float x,float y,float speedx, float speddy,List<Shot>shots){
		this.f_posx = x;
		this.f_posy = y;
	    this.f_speedx = speedx;
	    this.f_speedy = speddy;
	   bounding = new Rectangle((int)x,(int)y,look.getWidth(),look.getHeight());
	   this.shots = shots;
	}
	// Vor dem Zeichnen...
	public void update(float timeSinceLastFrame){
		// Wie lange lebt der schuss schon?
		timeAlive+=timeSinceLastFrame;
		// zu lange? dann fort damit!
		if(timeAlive>TIMETOLIVE){
			shots.remove(this);
		}
		// die Position bestimmen (Geschwindigkeit * vergangene Zeit)
		f_posx+=f_speedx*timeSinceLastFrame;
		f_posy+=f_speedy*timeSinceLastFrame;
		//Position der Boundingbox anpassen zur neuen Position
		bounding.x = (int)f_posx;
		bounding.y = (int)f_posy;
	}
	 
	public Rectangle getBounding(){
		return bounding;
	}
	public static BufferedImage getLook(){
		return look;
	}
	
	}
	

