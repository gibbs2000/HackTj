
public class Maze {
	private int[][] maze;

	public Maze(int rows, int cols) {
		maze = new int[rows][cols];
	}

	public int[][] getMaze() {
		return maze;
	}

	public void setCell(int row, int col, int val) {
		maze[row][col] = val;
	}

	public int getCell(int row, int col) {
		return maze[row][col];
	}

	public int getRows() {
		return maze.length;
	}

	public int getCols() {
		return maze[getRows()].length;
	}

}
