import javax.swing.JOptionPane;

public class MazeRunner {
	public static void main(String[] args) {
		String[] choices = { "Build", "Solve", "Watch" };
		JOptionPane.showMessageDialog(null,
				"Welcome to Maze Runner\nBuild your own maze for the computer to solve, solve one of our prebuilt mazes, or watch the computer solve it live");
		Object choice = JOptionPane.showInputDialog(null, "Choose game mode", "Input", JOptionPane.INFORMATION_MESSAGE,
				null, choices, choices[0]);
		if (((String) choice).equals(choices[0])) {
			makeMaze m = new makeMaze();
		} else {

		}

	}
}
