/**
 * Created by reisma on 30.06.15.
 */

package MoveTest;

import javax.swing.JFrame;

public class MoveTest {
    public static void main(String[] args) {
        Frame f = new Frame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(800, 600);
        f.setVisible(true);
        f.setResizable(false);
        


        while(true){
            if(f.getUp())f.player_posy-=5;
            if(f.getDown())f.player_posy+=5;
            if(f.getRight())f.player_posx+=5;
            if(f.getLeft())f.player_posx-=5;


            f.repaintScreen();


            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
