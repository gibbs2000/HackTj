import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class makeMaze extends JPanel implements KeyListener {
	JFrame frame;
	int x;
	int y;

	public makeMaze() {
		frame = new JFrame("Maze Maker");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(MazeConstants.WINDOW_SIZE, MazeConstants.WINDOW_SIZE);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.addKeyListener(this);
		x = 0;
		y = 0;
	}

	public static void runMaze() {

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getID() == (KeyEvent.VK_RIGHT)) {
			if (y < MazeConstants.WINDOW_SIZE)
				x++;
		}
		if (e.getID() == (KeyEvent.VK_LEFT)) {
			if (x > 0)
				x--;
		}
		if (e.getID() == (KeyEvent.VK_DOWN)) {
			if (y < MazeConstants.WINDOW_SIZE)
				y++;
		}
		if (e.getID() == (KeyEvent.VK_UP)) {
			if (y > 0)
				y--;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}
