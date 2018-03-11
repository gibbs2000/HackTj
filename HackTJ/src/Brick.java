import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Brick extends JPanel{
	private int x;
	private int y;
	private int blockType;
	
	public Brick(int xx, int yy, int val){
		x = xx;
		y = yy;
		blockType = val;
		revalidate();
		repaint();
	}
	
	public void paint(Graphics g){
		switch(blockType){
		case 1: case 0:
			g.setColor(Color.GREEN);
			break;
		default:
			g.setColor(Color.RED);
		}
		g.fillRect(x, y, 100, 100);
	}
	/*
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		switch(blockType){
		case 1: case 0:
			g.setColor(Color.GREEN);
			break;
		default:
			g.setColor(Color.RED);
		}
		g.fillRect(x, y, 10, 10);
		
	}*/
}
