package graphs;

import java.util.Arrays;
/*
 * https://leetcode.com/explore/learn/card/graph/618/disjoint-set/3878/
 */
public class Disjoint_Set_QuickFind {
	private static int [] root;
	Disjoint_Set_QuickFind(int size){
		int n = size+1;
		root = new int [n];
		// because initially every vertex is going to be its own root
		for(int i=0;i<n;i++)
			root[i] = i;
	}

	// returns the root node of this vertex
	public static int find(int vertex) {
		return root[vertex];
	}

	public static void union(int x, int y) {
		int  X = find(x);
		int Y = find(y);
		if(X!=Y) {
			for(int i=0;i<root.length;i++) {
				if(root[i] == Y)
					root[i] = X;
			}
		}
		System.out.println("trie: "+Arrays.toString(root)+", X: "+X+", Y: "+Y);
	}

	public static boolean connected(int x, int y) {
		return find(x) == find(y);
	}
		public static void main(String[] args) {
			Disjoint_Set_QuickFind set = new Disjoint_Set_QuickFind(5);
			union(1, 2);
			union(2, 3);
			union(4, 5);
			union(2, 4);
			
			//System.out.println("\nconnected: "+connected(1,5));
			System.out.println("root: \n"+Arrays.toString(root));

		}

}
