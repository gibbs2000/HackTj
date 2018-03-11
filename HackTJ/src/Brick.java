import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

@SuppressWarnings("serial")
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
	public void paint(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(5));
		g2.setColor(Color.BLACK);
		g2.drawRect(x, y, 100, 100);
		g2.setColor(Color.WHITE);
		switch(blockType){
		case 1: 
			g2.setColor(Color.RED);
			g2.fillRect(x, y, 100, 100);
			break;
		case 0:
			g2.setColor(Color.WHITE);
			g2.fillRect(x, y, 100, 100);
			break;
		case 3:
			g2.setColor(Color.WHITE);
			g2.fillRect(x, y, 100, 100);
			break;
		case -2:
			g2.setColor(Color.RED);
			g2.fillRect(x, y, 100, 100);
			break;
		default:
			g2.setColor(Color.BLACK);
			g2.fillRect(x, y, 100, 100);
		}
		
	}
	public int getBlockType(){
		return blockType;
	}
	public void setBlockType(int blockType){
		this.blockType = blockType;
	}

}
