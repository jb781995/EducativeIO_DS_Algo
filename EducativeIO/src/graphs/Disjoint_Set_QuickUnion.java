package graphs;
import java.util.Arrays;

/*
 * https://leetcode.com/explore/learn/card/graph/618/disjoint-set/3840/
 */
public class Disjoint_Set_QuickUnion {
private static int [] root;
Disjoint_Set_QuickUnion(int size){
	int n = size+1;
	root = new int [n];
	for(int i=0;i<n;i++)
		root[i] = i;
}

public static int find(int x) {
	while(x!=root[x])
		x = root[x];
	
	return x;
}

public static void union(int x, int y) {
	int X = find(x);
	int Y = find(y);
	if(X!=Y)
		root[Y] = X;
	
	System.out.println("trie: "+Arrays.toString(root)+", X: "+X+", Y: "+Y);
}

public static boolean connected(int x, int y) {
	return find(x) == find(y);
}
	public static void main(String[] args) {
	
		Disjoint_Set_QuickUnion set = new Disjoint_Set_QuickUnion(5);
		union(1, 2);
		union(2, 3);
		union(4, 5);
		union(2, 4);
		
		System.out.println("root: \n"+Arrays.toString(root));
		
	}

}
