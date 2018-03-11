import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Brick extends JPanel {
	private int x;
	private int y;
	private int blockType;

	public Brick(int xx, int yy, int val) {
		x = xx;
		y = yy;
		blockType = val;
		revalidate();
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(5));
		g2.setColor(Color.BLACK);
		g2.drawRect(x, y, MazeConstants.DEFAULT_DIMENSIONS, MazeConstants.DEFAULT_DIMENSIONS);
		switch (blockType) {
		case -1:
			//g2.setColor(Color.BLACK);
			//g2.fillRect(x, y, MazeConstants.DEFAULT_DIMENSIONS, MazeConstants.DEFAULT_DIMENSIONS);
			break;
		default:
			g2.setColor(Color.WHITE);
			g2.fillRect(x, y, MazeConstants.DEFAULT_DIMENSIONS, MazeConstants.DEFAULT_DIMENSIONS);

		}

	}

}
