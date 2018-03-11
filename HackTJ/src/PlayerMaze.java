import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerMaze extends MazeGame implements KeyListener {

	public PlayerMaze(String choice) {
		super("Player Maze", choice);
		getFrame().addKeyListener(this);

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (getX() > 0 && getY() > 0) {
			getM().setCell(getX(), getY(), 0);
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getID() == (KeyEvent.VK_RIGHT)) {
			// TODO move the current player right
		}
		if (e.getID() == (KeyEvent.VK_LEFT)) {
			// TODO move the player left
		}
		if (e.getID() == (KeyEvent.VK_DOWN)) {
			// TODO move down
		}
		if (e.getID() == (KeyEvent.VK_UP)) {
			// TODO move up
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}