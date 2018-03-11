import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MazeGame extends JPanel {
	private JFrame frame;
	private int x;
	private int y;
	private Maze m;
	private Brick[][] bricks;

	public MazeGame(String gt, String loc) {
		setFrame(new JFrame(gt));
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().setSize(MazeConstants.WINDOW_WIDTH, MazeConstants.WINDOW_HEIGHT);
		getFrame().setVisible(true);
		getFrame().setResizable(false);
		getFrame().setBackground(Color.RED);

		JOptionPane.showMessageDialog(null, "Welcome to " + gt);

		x = 0;
		y = 0;
		setM(new Maze(loc));
		bricks = new Brick[getM().getRows()][getM().getCols()];

		for (int i = 0; i < getM().getRows(); i++) {
			for (int j = 0; j < getM().getCols(); j++) {
				bricks[i][j] = new Brick((i) * MazeConstants.DEFAULT_DIMENSIONS + MazeConstants.DEFAULT_DIMENSIONS,
						(j) * MazeConstants.DEFAULT_DIMENSIONS + MazeConstants.DEFAULT_DIMENSIONS,
						getM().getCell(i, j));
				getFrame().add(new Brick((i) * MazeConstants.DEFAULT_DIMENSIONS, (j) * MazeConstants.DEFAULT_DIMENSIONS,
						getM().getCell(i, j)));
				getFrame().revalidate();
				getFrame().repaint();
				System.out.println("Should be a " + getM().getCell(i, j));

			}
		}
	}

	public Brick[][] setupGrid(JFrame cr, Maze m) {
		Brick[][] bricks = new Brick[m.getRows()][m.getCols()];

		for (int i = 0; i < m.getRows(); i++) {
			for (int j = 0; j < m.getCols(); j++) {
				bricks[i][j] = new Brick((i) * 10 + 10, (j) * 10 + 10, m.getCell(i, j));
				cr.add(new Brick((i) * 100, (j) * 100, m.getCell(i, j)));
				cr.revalidate();
				cr.repaint();
				// System.out.println("Should be a " + m.getCell(i, j));

			}
		}
		return bricks;

	}

	public void updateLocation(int r, int c) throws InterruptedException {
		// System.out.println(curRow + " " + curCol);

		bricks[r][c] = new Brick(r * 100, c * 100, -2);

		getFrame().add(bricks[r][c]);
		System.out.println("Repainting " + r + " " + c);
		getFrame().revalidate();
		getFrame().repaint();
		Thread.sleep(250);
		getFrame().remove(bricks[r][c]);
		bricks[r][c] = new Brick(r * 100, c * 100, 3);
		getFrame().add(bricks[r][c]);
		getFrame().revalidate();
		getFrame().repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (x > 0 && y > 0) {
			getM().setCell(x, y, 0);
			bricks[x][y] = new Brick((x) * MazeConstants.DEFAULT_DIMENSIONS + MazeConstants.DEFAULT_DIMENSIONS,
					(y) * MazeConstants.DEFAULT_DIMENSIONS + MazeConstants.DEFAULT_DIMENSIONS, 0);
			getFrame().add(bricks[x][y]);
			getFrame().revalidate();
			getFrame().repaint();

		}
	}

	public Maze getM() {
		return m;
	}

	public void setM(Maze m) {
		this.m = m;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}
