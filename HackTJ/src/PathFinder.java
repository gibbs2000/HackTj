
public class PathFinder {
	int[][] grid;

	public PathFinder(Maze m) {
		grid = m.getMaze();
	}

	public int lookUp(int r, int c) {
		try {
			return grid[r - 1][c];
		} catch (ArrayIndexOutOfBoundsException e) {
			return -1;
		}
	}

	public int lookLeft(int r, int c) {
		try {
			return grid[r][c - 1];
		} catch (ArrayIndexOutOfBoundsException e) {
			return -1;
		}
	}

	public int lookDown(int r, int c) {
		try {
			return grid[r + 1][c];
		} catch (ArrayIndexOutOfBoundsException e) {
			return -1;
		}
	}

	public int lookRight(int r, int c) {
		try {
			return grid[r][c + 1];
		} catch (ArrayIndexOutOfBoundsException e) {
			return -1;
		}
	}

	public int optimalPath(int r, int c) throws InterruptedException {
		int up = -1;
		int left = -1;
		if (lookUp(r, c) == -1 && lookLeft(r, c) == -1 && r == 0 && c == 0) {
			return grid[r][c];
		} else {
			Thread.sleep(1000);
			System.out.println("paused");
			if (lookUp(r, c) != -1)
				up = optimalPath(r - 1, c);
			if (lookLeft(r, c) != -1)
				left = optimalPath(r, c - 1);
			return grid[r][c] + Math.max(up, left);
		}
	}

	public int optimalPathFromTop(int r, int c, int goalR, int goalC) {
		int down = -1;
		int right = -1;
		if (lookDown(r, c) == -1 && lookRight(r, c) == -1 && r == goalR && c == goalC) {
			return grid[r][c];
		} else {
			if (lookDown(r, c) != -1)
				down = optimalPathFromTop(r + 1, c, goalR, goalC);
			if (lookRight(r, c) != -1)
				right = optimalPathFromTop(r, c + 1, goalR, goalC);
			return grid[r][c] + Math.max(down, right);
		}
	}

}
