import javax.swing.JOptionPane;

public class MazeRunner {
	public static void main(String[] args) throws InterruptedException {
		String[] modes = { "Build", "Solve", "Watch" };
		String[] mazes = { "m1.txt", "m2.txt", "m3.txt" };
		JOptionPane.showMessageDialog(null,
				"Welcome to Maze Runner\nBuild your own maze for the computer to solve, solve one of our prebuilt mazes, or watch the computer solve it live");
		Object mode = JOptionPane.showInputDialog(null, "Choose game mode", "Input", JOptionPane.INFORMATION_MESSAGE,
				null, modes, modes[0]);
		if (((String) mode).equals(modes[0])) {
			BuildMaze m = new BuildMaze();
		} else if (((String) mode).equals(modes[1])) {
			Object choice = JOptionPane.showInputDialog(null, "Which maze do you want to solve?", "Player Solver",
					JOptionPane.INFORMATION_MESSAGE, null, mazes, mazes[0]);
			PlayerMaze m = new PlayerMaze((String) choice);
		} else {

			Object choice = JOptionPane.showInputDialog(null, "Which maze do you want to watch the computer solve?",
					"Maze Auto-Solver", JOptionPane.INFORMATION_MESSAGE, null, mazes, mazes[0]);
			CompMaze m = new CompMaze((String) choice);

		}

	}
}
