import java.awt.Color;
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
		frame.setBackground(Color.BLACK);

		JOptionPane.showMessageDialog(null, "Welcome to Maze Builder");
		JOptionPane.showMessageDialog(null, "Use the arrow keys to make a maze ending in the bottom right corner");

		x = 0;
		y = 0;
		m = new Maze("default.txt");
		bricks = new Brick[m.getRows()][m.getCols()];

		for (int i = 0; i < m.getRows(); i++) {
			for (int j = 0; j < m.getCols(); j++) {
				bricks[i][j] = new Brick((i) * MazeConstants.DEFAULT_DIMENSIONS + MazeConstants.DEFAULT_DIMENSIONS,
						(j) * MazeConstants.DEFAULT_DIMENSIONS + MazeConstants.DEFAULT_DIMENSIONS, m.getCell(i, j));
				frame.add(new Brick((i) * MazeConstants.DEFAULT_DIMENSIONS, (j) * MazeConstants.DEFAULT_DIMENSIONS,
						m.getCell(i, j)));
				frame.revalidate();
				frame.repaint();
				System.out.println("Should be a " + m.getCell(i, j));

			}
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (x > 0 && y > 0) {
			m.setCell(x, y, 0);
			bricks[x][y] = new Brick((x) * MazeConstants.DEFAULT_DIMENSIONS + MazeConstants.DEFAULT_DIMENSIONS,
					(y) * MazeConstants.DEFAULT_DIMENSIONS + MazeConstants.DEFAULT_DIMENSIONS, 0);
			frame.add(bricks[x][y]);
			frame.revalidate();
			frame.repaint();

		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
			System.out.println("left");
			System.out.println(x);

			if (x > 0)
				x--;
			System.out.println(x);

		}

		if (key == KeyEvent.VK_RIGHT) {
			System.out.println("right");
			System.out.println(x);

			if (x < m.getRows())
				x++;
			System.out.println(x);

		}

		if (key == KeyEvent.VK_UP) {
			System.out.println("up");
			System.out.println(y);
			if (y > 0)
				y--;
			System.out.println(y);
		}

		if (key == KeyEvent.VK_DOWN) {
			System.out.println("down");
			System.out.println(y);

			if (y < m.getCols())
				y++;
			System.out.println(y);

		}

		if (x > 0 || y > 0) {
			m.setCell(x, y, 0);
			bricks[x][y] = new Brick((x) * MazeConstants.DEFAULT_DIMENSIONS + MazeConstants.DEFAULT_DIMENSIONS,
					(y) * MazeConstants.DEFAULT_DIMENSIONS + MazeConstants.DEFAULT_DIMENSIONS, m.getCell(x, y));
			frame.add(bricks[x][y]);
			frame.revalidate();
			frame.repaint();
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}
