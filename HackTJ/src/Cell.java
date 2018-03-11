import java.awt.Color;
import java.awt.Graphics;

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
		switch (type) {
		case -1:
			g.setColor(Color.BLACK);
			break;
		default:
			g.setColor(Color.WHITE);
			break;

		}
		g.fillRect(x, y, MazeConstants.DEFAULT_DIMENSIONS, MazeConstants.DEFAULT_DIMENSIONS);
	}
}
