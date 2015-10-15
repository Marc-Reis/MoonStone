package MoveTest;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by reisma on 07.07.15.
 */
public class GameObject {


    private final java.util.List<Enemy> enemy;
    private final String[] graphicsUrl;
    protected Rectangle bounding;
    protected float f_posx;
    protected float f_posy;
    protected int worldsize_x;
    protected int worldsize_y;
    private int health;
    // private BufferedImage look;
    // Enemy
    protected BufferedImage[] look;

    protected java.util.List<Shot> shots;

    protected float timeSinceLastShot = 0;
    protected final float SHOTFREQUENZY = 0.1f;
    //Enemy
    private final static float NEEDEDANYTIME = 1;
    private float anyTime = 0;

    public GameObject(int x, int y, int worldsize_x, int worldsize_y, java.util.List<Shot> shots, java.util.List<Enemy> enemy, String[] graphicsUrl) {
        this.enemy = enemy;
        this.graphicsUrl = graphicsUrl;

        loadAnimationResource(graphicsUrl);

        bounding = new Rectangle(x, y, look[0].getWidth(), look[0].getHeight());
        f_posx = x;
        f_posy = y;
        this.worldsize_x = worldsize_x;
        this.worldsize_y = worldsize_y;
        this.shots = shots;

        bounding = new Rectangle(x, y, look[0].getWidth(), look[0].getHeight());
        setHealth(100);
    }

    public void update(float timeSinceLastFrame) {
        if ( collisionCheck() ){
            setHealth(getHealth() > 0 ? (getHealth() - 10) :  0);
        }
        if(getHealth() > 0) {
            timeSinceLastShot += timeSinceLastFrame;
            if (shots != null &&
                timeSinceLastShot > SHOTFREQUENZY && Keyboard.isKeyDown(KeyEvent.VK_SPACE) &&
                this.getClass() == Player.class) {
                timeSinceLastShot = 0;

                    shots.add(new Shot(f_posx + look[0].getWidth() / 2 - Shot.getLook().getWidth() / 2,
                            f_posy + look[0].getHeight() / 2 - Shot.getLook().getHeight() / 2,
                            500, 0, shots));


            }
        }
        anyTime += timeSinceLastFrame;
        if (anyTime >= NEEDEDANYTIME) anyTime = 0;
    }

    public Rectangle getBounding() {
        return bounding;
    }

    public BufferedImage getLook() {

        // Ist ein Bild da? nee? dann null zurück geben, sonst das bild aus der folgenden Schleife
        if (look.length == 0) return null;
        // Für alle Bilder (Texturen z.B. für die Animation von Enemy und Spieler)
        for (int i = 0; i < look.length; i++) {
            // [0 bis 1] < 1 / 2 (* 1) ... 1 / 2(*2) -> Erste wenn ein Zeitpunkt überschritten ist, wird das nächste animationsbild geliefert
            // ¡-x--¡---¡  erster look 0.5, zweiter 1.0 ->
            if (anyTime < NEEDEDANYTIME / look.length * (i + 1)) {
                return look[i];
            }
        }
        return look[look.length - 1];
        //Non Enemy
        // return look;
    }

    private void loadAnimationResource(String[] url) {

        look = new BufferedImage[url.length];
        try {
            for (int x = 0; x < url.length; x++) {
                look[x] = ImageIO.read(Enemy.class.getClassLoader().getResourceAsStream(url[x]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean collisionCheck() {
        if( this.getClass() != Enemy.class) {
            for (Enemy e : enemy) {
                if (getBounding().intersects(e.getBounding())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
