package disjointset;

import java.util.HashMap;
import java.util.Map;


public class DisjointSet {
	private Map<Integer, Integer> parent = new HashMap();

	// perform makeset operation
	public void makeSet(int[] universe)
	{
		// create n disjoint sets, one for each item
		for(int i: universe) {
			parent.put(i, i);
		}
	}

	// Find the root of the set to which k belongs
	public int Find(int k)
	{
		// if k is the root
		if (parent.get(k) == k) {
			return k;
		}

		// recur until we find the root
		return Find(parent.get(k));


	}

	// return the union of two subsets
	public void Union(int a, int b)
	{
		int x = Find(a);
		int y = Find(b);

		parent.put(x, y);

		System.out.println("joining " + x + " and " + y);
	}

}
