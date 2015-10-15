package MoveTest;

import java.awt.event.KeyEvent;
import java.util.*;

import javax.swing.JFrame;
// Nix Test

public class MoveTest {
	public static void main(String[] args) {
		//List<Shot> shots = new Vector<Shot>();
        List <Shot> shots =  Collections.synchronizedList(new ArrayList<Shot>());
		List<Enemy> enemys = Collections.synchronizedList(new ArrayList<Enemy>());

		String[] playerUrls = new String[2];
		playerUrls[0] = "Gfx/Mega1.png";
        playerUrls[1] = "Gfx/Mega2.png";
		Player player = new Player(300, 300, 800, 600, shots, enemys, playerUrls);


		Background bg = new Background(100);

		String[] enemysUrls = new String[2];
		enemysUrls[0] =   "Gfx/Enemy1.png";
		enemysUrls[1] =   "Gfx/Enemy2.png";

		enemys.add(new Enemy(500,300, 800, 600, shots, enemys, enemysUrls));
		
		Frame f = new Frame(player, bg, shots, enemys);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(800, 600);
		f.setUndecorated(true);
	    f.setVisible(true);
		f.setResizable(false);
		f.setLocationRelativeTo(null);
//		DisplayMode displayMode = new DisplayMode(800, 600, 16, 75);
//		GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
//		GraphicsDevice device = environment.getDefaultScreenDevice();
		
//		device.setFullScreenWindow(f);
//		device.setDisplayMode(displayMode);
		
		f.makeStrat();
		
		long lastFrame = System.currentTimeMillis();
		while(true){
			if(Keyboard.isKeyDown(KeyEvent.VK_ESCAPE))System.exit(0);
			
			long thisFrame = System.currentTimeMillis();
			float timeSinceLastFrame = ((float)(thisFrame-lastFrame))/1000f;
			lastFrame=thisFrame;
			
			player.update(timeSinceLastFrame);
			bg.update(timeSinceLastFrame);


            for (Iterator<Shot> iter = shots.iterator(); iter.hasNext();) {
                Shot s = iter.next();
                if( s.update(timeSinceLastFrame) ){
                    iter.remove();
                };
            }

			/*for (Shot shot : shots) {
				shot.update(timeSinceLastFrame);
			}*/

			
			for(int i = 0; i<enemys.size(); i++){
				enemys.get(i).update(timeSinceLastFrame);
			}


			f.repaintScreen();
			
			try {
				Thread.sleep(15);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
