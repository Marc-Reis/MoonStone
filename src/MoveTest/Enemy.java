package MoveTest;

import java.util.List;

public class Enemy extends GameObject {
	public Enemy(int x, int y, int worldsize_x, int worldsize_y, List<Shot> shots, List<Enemy> enemy, String[] graphicsUrl) {
		super(x, y, worldsize_x, worldsize_y, shots, enemy, graphicsUrl);
	}


}