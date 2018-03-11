import javax.swing.JOptionPane;

public class MazeRunner {
	public static void main(String[] args) throws InterruptedException {
		String[] modes = { "Solve", "Watch" };
		String[] mazes = { "m1.txt", "m2.txt", "m3.txt" };
		JOptionPane.showMessageDialog(null,
				"Welcome to Maze Runner\nPlay one of our prebuilt mazes or watch the computer solve it live");
		Object mode = JOptionPane.showInputDialog(null, "Choose game mode", "Input", JOptionPane.INFORMATION_MESSAGE,
				null, modes, modes[0]);
		if (((String) mode).equals(modes[0])) {

			Object choice = JOptionPane.showInputDialog(null, "Which maze do you want to solve?", "Player Solver",
					JOptionPane.INFORMATION_MESSAGE, null, mazes, mazes[0]);
			PlayerMaze m = new PlayerMaze((String) choice);
			m.getM();
		} else {

			Object choice = JOptionPane.showInputDialog(null, "Which maze do you want to watch the computer solve?",
					"Maze Auto-Solver", JOptionPane.INFORMATION_MESSAGE, null, mazes, mazes[0]);
			CompMaze m = new CompMaze((String) choice);
			m.getM();

		}

	}
}
