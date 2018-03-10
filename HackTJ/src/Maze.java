import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Maze {
	private int[][] maze;

	public Maze() {
		readFromFile();
	}

	public void readFromFile() {
		Scanner keyboard = new Scanner(System.in);
		String fileName;

		// Open input file:

		System.out.print("\nEnter input file name: ");
		fileName = keyboard.nextLine().trim();

		Scanner sc = fileReader(fileName);
		maze = createGrid(sc);

		keyboard.close();
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

	/**
	 * reads in a file
	 * 
	 * @param s
	 *            file name
	 * @return scanner representing the given file
	 */
	public Scanner fileReader(String s) {
		File f = new File(s);
		Scanner daGrid = null;

		try {
			daGrid = new Scanner(f);
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
			System.exit(0);
		}

		return daGrid;
	}

	/**
	 * This takes in a scanner and then converts into an int[][]
	 * 
	 * @param fileGrid
	 *            the scanner containing the grid
	 * @return a 2D array of ints that represents the maze
	 */
	public int[][] createGrid(Scanner fileGrid) {
		String line;

		ArrayList<int[]> temp = new ArrayList<int[]>();
		while (fileGrid.hasNextLine()) {

			line = fileGrid.nextLine();
			// String[] unparsed = line.split(" ");
			ArrayList<String> unparsed = new ArrayList<String>(Arrays.asList(line.split(" ")));
			for (int i = unparsed.size() - 1; i >= 0; i--) {
				if (unparsed.get(i).equals(""))
					unparsed.remove(i);
			}

			int[] row = new int[unparsed.size()];

			for (int i = 0; i < unparsed.size(); i++) {
				// System.out.println(unparsed.get(i));
				row[i] = Integer.parseInt(unparsed.get(i));
			}

			temp.add(row);
		}
		int[][] ret = new int[temp.size()][temp.get(0).length];
		for (int i = 0; i < temp.size(); i++)
			ret[i] = temp.get(i);
		return ret;
	}
}
