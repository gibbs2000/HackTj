import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BuildMaze extends JPanel implements KeyListener {
	JFrame frame;
	private int x;
	private int y;
	private Maze m;
	private Brick[][] bricks;

	public BuildMaze() {
		frame = new JFrame("Maze Builder");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(MazeConstants.WINDOW_SIZE, MazeConstants.WINDOW_SIZE);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.addKeyListener(this);
		x = 0;
		y = 0;
		m = new Maze("default.txt");
		bricks = new Brick[m.getRows()][m.getCols()];

		for (int i = 0; i < m.getRows(); i++) {
			for (int j = 0; j < m.getCols(); j++) {
				bricks[i][j] = new Brick((i) * 10 + 10, (j) * 10 + 10, m.getCell(i, j));
				frame.add(new Brick((i) * MazeConstants.DEFAULT_DIMENSIONS, (j) * MazeConstants.DEFAULT_DIMENSIONS,
						m.getCell(i, j)));
				frame.revalidate();
				frame.repaint();
				System.out.println("Should be a " + m.getCell(i, j));

			}
		}
		JOptionPane.showMessageDialog(null, "Welcome to Maze Builder");
		JOptionPane.showMessageDialog(null, "Use the arrow keys to make a maze");

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
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
			System.out.println("left");

			if (x > 0)
				x--;
		}

		if (key == KeyEvent.VK_RIGHT) {
			System.out.println("right");
			if (x < m.getRows())
				x++;
		}

		if (key == KeyEvent.VK_UP) {
			System.out.println("up");

			if (y > 0)
				y--;
		}

		if (key == KeyEvent.VK_DOWN) {
			System.out.println("down");

			if (y < m.getCols())
				y++;
		}

		if (x > 0 && y > 0) {
			m.setCell(x, y, 0);
			bricks[x][y] = new Brick((x) * 10 + 10, (y) * 10 + 10, m.getCell(x, y));
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}
