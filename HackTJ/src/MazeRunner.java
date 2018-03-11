import javax.swing.JOptionPane;

public class MazeRunner {
	public static void main(String[] args) {
		String[] choices = { "Build", "Solve", "Watch" };
		String[] mazes = { "m1.txt", "m2.txt", "m3.txt" };
		JOptionPane.showMessageDialog(null,
				"Welcome to Maze Runner\nBuild your own maze for the computer to solve, solve one of our prebuilt mazes, or watch the computer solve it live");
		Object choice = JOptionPane.showInputDialog(null, "Choose game mode", "Input", JOptionPane.INFORMATION_MESSAGE,
				null, choices, choices[0]);
		if (((String) choice).equals(choices[0])) {
			BuildMaze m = new BuildMaze();
		} else if (((String) choice).equals(choices[1])) {
			Object maze = JOptionPane.showInputDialog(null, "Which maze do you want to solve?", "Player Solver",
					JOptionPane.INFORMATION_MESSAGE, null, mazes, mazes[0]);
		} else {

			Object maze = JOptionPane.showInputDialog(null, "Which maze do you want to watch the computer solve?",
					"Maze Auto-Solver", JOptionPane.INFORMATION_MESSAGE, null, mazes, mazes[0]);
			BuildMaze m = new BuildMaze((String) maze);
		}

	}
}
