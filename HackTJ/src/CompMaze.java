import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class CompMaze extends MazeGame {
	public CompMaze(String choice) throws InterruptedException {
		super("Maze Auto-Solver", choice);
		JOptionPane.showMessageDialog(null, "Watch the computer beat the maze as fast as possible");

		PathFinder p = new PathFinder(getM());
		try {
			p.optimalPathFromTop(0, 0, getM().getRows() - 1, getM().getCols() - 1, this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
	}

}
