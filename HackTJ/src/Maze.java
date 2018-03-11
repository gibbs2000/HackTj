import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Maze {
	private int[][] maze;

	public Maze() {
		maze = createFromFile(fileReader(getInput()));
	}

	public Maze(String fLoc) {
		maze = createFromFile(fileReader(fLoc));
	}

	public Maze(int[][] m) {
		maze = m;
	}

	/**
	 * Returns the maze in its entirety
	 * 
	 * @return the maze
	 */
	public int[][] getMaze() {
		return maze;
	}

	/**
	 * Changes the value of a specific cell
	 * 
	 * @param row
	 *            the row of the cell to be changed
	 * @param col
	 *            the column of the cell to be changed
	 * @param val
	 *            the value to be assigned to the given cell
	 */
	public void setCell(int row, int col, int val) {
		maze[row][col] = val;
	}

	/**
	 * Returns the value of a given cell
	 * 
	 * @param row
	 *            the row of the given cell
	 * @param col
	 *            the column of the given cell
	 * @return the value of a given cell
	 */
	public int getCell(int row, int col) {
		return maze[row][col];
	}

	/**
	 * Returns the number of rows
	 * 
	 * @return the number of rows
	 */
	public int getRows() {
		return maze.length;
	}

	/**
	 * Returns the number of columns
	 * 
	 * @return the number of columns
	 */
	public int getCols() {
		return maze[getRows() - 1].length;
	}

	/**
	 * Reads in a file
	 * 
	 * @param s
	 *            file name
	 * @return a Scanner representing the given file
	 */
	public Scanner fileReader(String s) {
		File f = new File(s);
		Scanner grid = null;

		try {
			grid = new Scanner(f);
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
			System.exit(0);
		}

		return grid;
	}

	/**
	 * Prompts the user for a file name and returns the input as a String
	 * 
	 * @return the user-submitted file name
	 */
	public String getInput() {
		Scanner keyboard = new Scanner(System.in);
		String fileName;

		// Open input file:

		System.out.print("\nEnter input file name: ");
		fileName = keyboard.nextLine().trim();

		keyboard.close();
		return fileName;
	}

	/**
	 * This takes in a scanner and then converts into an int[][]
	 * 
	 * @param fileGrid
	 *            the scanner containing the grid
	 * @return a 2D array of ints that represents the maze
	 */
	public int[][] createFromFile(Scanner fileGrid) {

		ArrayList<int[]> temp = new ArrayList<int[]>();
		while (fileGrid.hasNextLine()) {

			String line = fileGrid.nextLine();
			ArrayList<String> unparsed = new ArrayList<String>(Arrays.asList(line.split("\t")));
			for (int i = unparsed.size() - 1; i >= 0; i--) {
				if (unparsed.get(i).equals(""))
					unparsed.remove(i);
			}

			int[] row = new int[unparsed.size()];

			for (int i = 0; i < unparsed.size(); i++) {
				row[i] = Integer.parseInt(unparsed.get(i));
			}

			temp.add(row);
		}
		int[][] ret = new int[temp.size()][temp.get(0).length];
		for (int i = 0; i < temp.size(); i++)
			ret[i] = temp.get(i);
		return ret;
	}

	@Override
	public String toString() {
		String op = "";
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[j].length; j++) {
				op += maze[i][j] + "\t";
			}
			op += "\n";
		}
		return op;
	}
}
