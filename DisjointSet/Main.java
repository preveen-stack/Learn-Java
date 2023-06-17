import disjointset.DisjointSet;

class Main {
	public static void printSets(int[] universe, DisjointSet ds) {

		for (int i : universe) {
			System.out.println(ds.Find(i) + " ");
		}

		System.out.println();
	}

	public static void main(String[] args) {
		// universe of items
		int[] universe = { 1, 2, 3, 4, 5};

		// initialize disjointset class
		DisjointSet ds = new DisjointSet();

		// create a singleton for each element
		ds.makeSet(universe);
		printSets(universe, ds);

		ds.Union(4, 3); // 4 and 3 are in the same set
		printSets(universe, ds);

		ds.Union(2, 1); // 1 and 2 are in the same set
		printSets(universe, ds);

		ds.Union(1, 3); // 1, 2, 3, 4 are in the same set
		printSets(universe, ds);

	}
}
