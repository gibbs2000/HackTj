import java.awt.Color;

import javax.swing.JFrame;

public class Creator {
	public static void main(String[] args) {

		JFrame cr = new JFrame();

		cr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// sets size of window
		cr.setSize(900, 1400);
		cr.setVisible(true);
		cr.setBackground(Color.WHITE);

		Maze m = new Maze("m1.txt");
		System.out.println(m);

		PathFinder p = new PathFinder(m);

		Brick[][] bricks = new Brick[m.getRows()][m.getCols()];

		for (int i = 0; i < m.getRows(); i++) {
			for (int j = 0; j < m.getCols(); j++) {
				bricks[i][j] = new Brick((i) * 10 + 10, (j) * 10 + 10, m.getCell(i, j));
				cr.add(new Brick((i) * 100, (j) * 100, m.getCell(i, j)));
				cr.revalidate();
				cr.repaint();
				System.out.println("Should be a " + m.getCell(i, j));

			}
		}
	}
}
