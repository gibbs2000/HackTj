
public class MiscTester {

	public static void main(String[] args) {
		Maze m = new Maze("m1.txt");
		System.out.println(m);

		PathFinder p = new PathFinder(m);
		p.optimalPathFromTop(0, 0, m.getRows() - 1, m.getCols() - 1);
	}
}
