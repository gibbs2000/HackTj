import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class BuildMaze extends MazeGame implements KeyListener {

	public BuildMaze() {
		super("Maze Builder", "default.txt");
		JOptionPane.showMessageDialog(null, "Use the arrow keys to make a maze ending in the bottom right corner");
		getFrame().addKeyListener(this);

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (getX() == getM().getRows() - 2 && getY() == getM().getCols() - 2) {
			getFrame().setVisible(false);
			getFrame().revalidate();
			getFrame().repaint();
			getFrame().dispose();
		}
		if (getX() > 0 || getY() > 0) {
			getFrame().remove(super.getBrick(getX(), getY()));
			getM().setCell(getX(), getY(), 0);
			getBrick(getX(), getY()).setBlockType(0);
			getFrame().add(getBrick(getX(), getY()));
			getFrame().revalidate();
			getFrame().repaint();

		}
	}

	@Override
	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();
		switch (key) {
		case KeyEvent.VK_LEFT:
			System.out.println("left");
			System.out.println(getX());

			if (getX() > 0 && getM().getCell(getX() - 1, getY()) < 0)
				super.setX(getX() - 1);
			System.out.println(getX());
			break;
		case KeyEvent.VK_RIGHT:
			System.out.println("right");
			System.out.println(super.getX());

			if (super.getX() < getM().getRows() - 1 && getM().getCell(super.getX() + 1, super.getY()) < 0)
				super.setX(getX() + 1);

			System.out.println(super.getX());
			break;
		case KeyEvent.VK_UP:
			System.out.println("up");
			System.out.println(super.getY());
			if (this.getY() > 0 && getM().getCell(super.getX(), super.getY() - 1) < 0)
				super.setY(super.getY() - 1);
			System.out.println(super.getY());
			break;
		case KeyEvent.VK_DOWN:
			System.out.println("down");
			System.out.println(super.getY());

			if (super.getY() < getM().getCols() - 1 && getM().getCell(super.getX(), super.getY() + 1) < 0)
				super.setY(super.getY() + 1);
			System.out.println(super.getY());
			break;
		case KeyEvent.VK_R:
			resetBricks();
			System.out.println("r");
			break;
		}
		System.out.println(super.getM().getCell(super.getX(), super.getY()));

		getM().setCell(super.getX(), super.getY(), 0);
		setBrick(super.getX(), super.getY(),
				(super.getX()) * MazeConstants.DEFAULT_DIMENSIONS + MazeConstants.DEFAULT_DIMENSIONS,
				(super.getY()) * MazeConstants.DEFAULT_DIMENSIONS + MazeConstants.DEFAULT_DIMENSIONS,
				getM().getCell(super.getX(), super.getY()));
		getFrame().add(getBrick(super.getX(), super.getY()));
		getFrame().revalidate();
		getFrame().repaint();

		if (getM().getCell(super.getX(), super.getY() - 1) >= 0 && getM().getCell(super.getX(), super.getY() + 1) >= 0
				&& getM().getCell(super.getX() - 1, super.getY()) >= 0)

		{
			JOptionPane.showMessageDialog(null, "You've backed yourself into a corner. Press R to reset", "Uh-oh", 2);
		}

	}

	private void resetBricks() {
		getFrame().removeAll();
		getFrame().revalidate();
		getFrame().repaint();

		super.setX(0);
		super.setY(0);
		setM(new Maze("default.txt"));
		setBricks(new Brick[getM().getRows()][getM().getCols()]);

		for (int i = 0; i < getM().getRows(); i++) {
			for (int j = 0; j < getM().getCols(); j++) {
				setBrick(i, j, (i) * MazeConstants.DEFAULT_DIMENSIONS + MazeConstants.DEFAULT_DIMENSIONS,
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

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
