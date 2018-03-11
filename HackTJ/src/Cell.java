import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Cell extends JPanel {

	private int x;
	private int y;
	private int type;

	public Cell(int x, int y, int val) {
		this.x = x;
		this.y = y;
		type = val;
		revalidate();
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g1 = (Graphics2D) g;
		g1.setStroke(new BasicStroke(5));
		g1.setColor(Color.CYAN);
		g1.drawRect(x * MazeConstants.DEFAULT_DIMENSIONS, y * MazeConstants.DEFAULT_DIMENSIONS,
				MazeConstants.DEFAULT_DIMENSIONS, MazeConstants.DEFAULT_DIMENSIONS);
		switch (type) {
		case -1:
			g.setColor(Color.BLACK);
			break;
		default:
			g.setColor(Color.WHITE);
			break;

		}
		g.fillRect(x * MazeConstants.DEFAULT_DIMENSIONS, y * MazeConstants.DEFAULT_DIMENSIONS,
				MazeConstants.DEFAULT_DIMENSIONS, MazeConstants.DEFAULT_DIMENSIONS);
	}
}
