import java.awt.Graphics;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class PlayerMaze extends JPanel implements KeyListener {
	
	JFrame frame;
	private int x;
	private int y;
	private Maze m;

	public PlayerMaze() {
		frame = new JFrame("Maze Maker");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(MazeConstants.WINDOW_HEIGHT, MazeConstants.WINDOW_WIDTH);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.addKeyListener(this);
		x = 0;
		y = 0;
		m = new Maze("default.txt");
		JOptionPane.showMessageDialog(null, "Welcome to Maze Builder");
		JOptionPane.showMessageDialog(null, "Use the DOWN and RIGHT arrow keys to make a maze");

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (x > 0 && y > 0) {
			m.setCell(x, y, 0);
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getID() == (KeyEvent.VK_RIGHT)) {
			if (y < MazeConstants.WINDOW_SIZE && m.getCell(x+1, y) != -1)
				x++;
		}
		if (e.getID() == (KeyEvent.VK_LEFT)) {
			if (x > 0 && m.getCell(x-1, y) != -1)
				x--;
		}
		if (e.getID() == (KeyEvent.VK_DOWN)) {
			if (y < MazeConstants.WINDOW_SIZE && m.getCell(x, y+1) != -1)
				y++;
		}
		if (e.getID() == (KeyEvent.VK_UP)) {
			if (y > 0 && m.getCell(x, y-1) != -1)
				y--;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	
}