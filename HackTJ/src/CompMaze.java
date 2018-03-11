import javax.swing.JOptionPane;

public class CompMaze extends MazeGame {
	public CompMaze(String choice) {
		super("Maze Auto-Solver", choice);
		JOptionPane.showMessageDialog(null, "Watch the computer beat the maze as fast as possible");

		PathFinder p = new PathFinder(getM());
		p.optimalPathFromTop(0, 0, getM().getRows() - 1, getM().getCols() - 1);
	}

}
