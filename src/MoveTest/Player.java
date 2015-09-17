package MoveTest;

import java.awt.event.KeyEvent;
import java.util.List;

public class Player extends GameObject {

    public Player(int x, int y, int worldsize_x, int worldsize_y, List<Shot> shots, String[] graphicsUrl) {
        super(x, y, worldsize_x, worldsize_y, shots, graphicsUrl);
    }

    public void update(float timeSinceLastFrame) {
        super.update(timeSinceLastFrame);

        if (Keyboard.isKeyDown(KeyEvent.VK_W)) f_posy -= 300 * timeSinceLastFrame;
        if (Keyboard.isKeyDown(KeyEvent.VK_S)) f_posy += 300 * timeSinceLastFrame;
        if (Keyboard.isKeyDown(KeyEvent.VK_D)) f_posx += 300 * timeSinceLastFrame;
        if (Keyboard.isKeyDown(KeyEvent.VK_A)) f_posx -= 300 * timeSinceLastFrame;


        if (f_posx < 0) f_posx = 0;
        if (f_posy < 0) f_posy = 0;
        if (f_posx > worldsize_x - bounding.width) f_posx = worldsize_x - bounding.width;
        if (f_posy > worldsize_y - bounding.height) f_posy = worldsize_y - bounding.height;

        bounding.x = (int) f_posx;
        bounding.y = (int) f_posy;


    }
}