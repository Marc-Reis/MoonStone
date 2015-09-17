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


    protected Rectangle bounding;
    protected float f_posx;
    protected float f_posy;
    protected int worldsize_x;
    protected int worldsize_y;
    private int test;
    //    private BufferedImage look;
    // Enemy
    protected BufferedImage[] look;

    protected java.util.List<Shot> shots;

    protected float timeSinceLastShot = 0;
    protected final float SHOTFREQUENZY = 0.1f;
    //Enemy
    private final static float NEEDEDANYTIME = 1;
    private float anyTime = 0;

    public GameObject(int x, int y, int worldsize_x, int worldsize_y, java.util.List<Shot> shots, String[] graphicsUrl) {

        loadAnimationResource(graphicsUrl);

        bounding = new Rectangle(x, y, look[0].getWidth(), look[0].getHeight());
        f_posx = x;
        f_posy = y;
        this.worldsize_x = worldsize_x;
        this.worldsize_y = worldsize_y;
        this.shots = shots;

        bounding = new Rectangle((int) x, (int) y, look[0].getWidth(), look[0].getHeight());
    }

    public void update(float timeSinceLastFrame) {
        timeSinceLastShot += timeSinceLastFrame;
        if (shots != null  && timeSinceLastShot > SHOTFREQUENZY && Keyboard.isKeyDown(KeyEvent.VK_SPACE)) {
            timeSinceLastShot = 0;
            shots.add(new Shot( f_posx + look[0].getWidth() / 2 - Shot.getLook().getWidth() / 2,
                    f_posy + look[0].getHeight() / 2 - Shot.getLook().getHeight() / 2,
                    500, 0, shots));

        }
        anyTime += timeSinceLastFrame;
        if (anyTime >= NEEDEDANYTIME) anyTime = 0;
    }

    public Rectangle getBounding() {
        return bounding;
    }

    public BufferedImage getLook() {
        if (look.length == 0) return null;
        for (int i = 0; i < look.length; i++) {
            if (anyTime < (float) NEEDEDANYTIME / look.length * (i + 1)) {
                return look[i];
            }
        }
        return look[look.length - 1];
        //Non Enemy
       // return look;
    }

    private void loadAnimationResource(String[] url) {

        look = new BufferedImage[ url.length];
        try {
            for (int x = 0; x < url.length; x++) {
                look[x] = ImageIO.read(Enemy.class.getClassLoader().getResourceAsStream(url[x]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
