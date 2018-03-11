import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

public class BuildMaze extends MazeGame implements KeyListener {

	public BuildMaze() {
		super("Maze Builer", "default.txt");
		JOptionPane.showMessageDialog(null, "Use the arrow keys to make a maze ending in the bottom right corner");
		getFrame().addKeyListener(this);

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (getX() == getM().getRows() - 2 && getY() == getM().getCols() - 2) {
			System.out.println("Hewwo");
			getFrame().setVisible(false);
			getFrame().revalidate();
			getFrame().repaint();
			getFrame().dispose();
		}
		int key = e.getKeyCode();
		switch (key) {
		case KeyEvent.VK_LEFT:
			System.out.println("left");
			System.out.println(getX());

			if (getX() > 0 && getM().getCell(getX() - 1, getY()) < 0)
				x--;
			System.out.println(x);
			break;
		case KeyEvent.VK_RIGHT:
			System.out.println("right");
			System.out.println(x);

			if (x < getM().getRows() - 1 && getM().getCell(x + 1, y) < 0)
				x++;
			System.out.println(x);
			break;
		case KeyEvent.VK_UP:
			System.out.println("up");
			System.out.println(y);
			if (y > 0 && getM().getCell(x, y - 1) < 0)
				y--;
			System.out.println(y);
			break;
		case KeyEvent.VK_DOWN:
			System.out.println("down");
			System.out.println(y);

			if (y < getM().getCols() - 1 && getM().getCell(x, y + 1) < 0)
				y++;
			System.out.println(y);
			break;
		case KeyEvent.VK_R:
			resetBricks();
			System.out.println("r");
			break;
		}

		getM().setCell(x, y, 0);
		bricks[x][y] = new Brick((x) * MazeConstants.DEFAULT_DIMENSIONS + MazeConstants.DEFAULT_DIMENSIONS,
				(y) * MazeConstants.DEFAULT_DIMENSIONS + MazeConstants.DEFAULT_DIMENSIONS, getM().getCell(x, y));
		getFrame().add(bricks[x][y]);
		getFrame().revalidate();
		getFrame().repaint();

		if (getM().getCell(x, y - 1) >= 0 && getM().getCell(x, y + 1) >= 0 && getM().getCell(x + 1, y) >= 0
				&& getM().getCell(x - 1, y) >= 0)

		{
			JOptionPane.showMessageDialog(null, "You've backed yourself into a corner. Press R to reset", "Uh-oh", 2);
		}

	}

	private void resetBricks() {
		getFrame().removeAll();
		getFrame().revalidate();
		getFrame().repaint();

		x = 0;
		y = 0;
		setM(new Maze("default.txt"));
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
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}
