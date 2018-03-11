import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

@SuppressWarnings("serial")
public class PlayerMaze extends MazeGame implements KeyListener {

	public PlayerMaze(String choice) {
		super("Player Maze", choice);
		getFrame().addKeyListener(this);

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
		Brick[][] grid = super.getBricks();
		int r = grid.length;
		int c = grid[0].length;
		int x = super.getX();
		int y = super.getY();
		Brick currentBrick = super.getBrick(x, y);
		System.out.println(currentBrick.getBlockType());
		if (e.getKeyCode() == (KeyEvent.VK_RIGHT)) {
			// TODO move the current player right
			System.out.println("right");
			if (y + 1 < r) {
				super.remove(super.getBrick(x, y + 1));

				super.getBrick(x, y + 1).setBlockType(1);
				super.setY(y + 1);
				super.add(super.getBrick(x, y + 1));

				super.validate();
				super.repaint();
			}

		}
		if (e.getKeyCode() == (KeyEvent.VK_LEFT)) {
			// TODO move the player left
			System.out.println("left");
			if (y - 1 != 0) {
				super.remove(super.getBrick(x, y - 1));
				super.getBrick(x, y - 1).setBlockType(1);
				super.setY(y - 1);
				super.add(super.getBrick(x, y - 1));
				super.validate();
				super.repaint();
			}
		}
		if (e.getKeyCode() == (KeyEvent.VK_DOWN)) {
			// TODO move down
			System.out.println("down");
			if (x + 1 < c) {
				super.remove(super.getBrick(x + 1, y));

				super.getBrick(x + 1, y).setBlockType(1);
				super.setX(x + 1);
				super.add(super.getBrick(x + 1, y));

				super.validate();
				super.repaint();
			}
		}
		if (e.getKeyCode() == (KeyEvent.VK_UP)) {
			// TODO move up
			System.out.println("up");
			if (x - 1 != 0) {
				super.remove(super.getBrick(x - 1, y));

				super.getBrick(x - 1, y).setBlockType(1);
				super.setX(x - 1);
				super.add(super.getBrick(x - 1, y));

				super.validate();
				super.repaint();
			}
		}
		getFrame().revalidate();
		getFrame().repaint();

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}