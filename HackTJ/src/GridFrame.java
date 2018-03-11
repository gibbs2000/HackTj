
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GridFrame extends JFrame {
	private int width = 1;
	private int height = 1;

	private int[][] table = new int[100][100];

	public static void main(String args[]) {
		new GridFrame(9, 14);
	}

	public GridFrame(int[][] numbers) {
		super("PathFinder");

		this.table = numbers;
		width = numbers[0].length;
		height = numbers.length;

		IDKwhattocallthis();
	}

	public GridFrame(int w, int h) {
		super("PathFinder");
		width = w;
		height = h;
		fillTable();

		IDKwhattocallthis();
	}

	public void IDKwhattocallthis() {
		setContentPane(new DrawPane());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.black);
		setSize(50 * width, 50 * height);
		setResizable(false);
		setVisible(true);
	}

	public void fillTable() {
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[0].length; j++) {
				table[i][j] = new Random().nextInt(3) - 1;
			}
		}
	}

	class DrawPane extends JPanel {
		@Override
		public void paintComponent(Graphics g) {
			g.setColor(Color.WHITE);
			for (int i = 0; i < width; i++) {
				for (int j = 0; j < height; j++) {
					if (table[i][j] == 1)
						g.setColor(Color.GREEN);
					g.fillRect(getWidth() / width * i, getHeight() / height * j, getWidth() / width,
							getHeight() / height);
					g.setColor(Color.WHITE);
				}
			}
		}

	}

}
