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
		getFrame().setBackground(Color.WHITE);

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

	public void updateLocation(int r, int c) throws InterruptedException {
		// System.out.println(curRow + " " + curCol);

		bricks[x][y].setBlockType(-2);

		frame.add(bricks[r][c]);
		System.out.println("Repainting " + r + " " + c);
		frame.revalidate();
		frame.repaint();
		Thread.sleep(1000);
		frame.remove(bricks[r][c]);
		bricks[x][y].setBlockType(3);

		frame.add(bricks[r][c]);
		frame.revalidate();
		frame.repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

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

	public void setX(int x) {
		this.x = x;

	}

	@Override
	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public int getX() {
		return x;
	}

	public Brick getBrick(int i, int j) {
		return bricks[i][j];
	}

	public Brick[][] getBricks() {
		return bricks;
	}

	public void setBricks(Brick[][] bricks) {
		this.bricks = bricks;
	}

	public void setBrick(int i, int j, int x, int y, int val) {
		bricks[i][j] = new Brick(x, y, val);
	}

}
