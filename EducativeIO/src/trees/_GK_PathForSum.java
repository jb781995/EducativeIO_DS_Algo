package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * https://www.educative.io/courses/grokking-the-coding-interview/B815A0y2Ajn
 */
public class _GK_PathForSum {
private List<ArrayList<Node>> paths = new ArrayList<ArrayList<Node>>();
private LinkedList<Node> sumPaths = new LinkedList<>();
private static int sum=0;
private boolean [] visited;
public List<ArrayList<Node>> paths(Node root, int sum) {
	if(root==null)
		return null;
	paths = new ArrayList<ArrayList<Node>>();
	sumPaths = new LinkedList<Node>();
	sumPaths.add(root);
	return paths;
}
public void backtrack(Node node, int sumUntilNow) {
	if(node.data+sumUntilNow==sum) {
		this.paths.add(new ArrayList<>(sumPaths));
		return;
	}
	
	visited[node.data] = true;
	
	
}

public int sumPaths(Node node, int sumUntilNow) {
	if(node==null)
		return sumUntilNow;
	sumUntilNow+=node.data;
	sumPaths.add(node);
	int lsum = sumPaths(node.left, sumUntilNow);
	
	int rsum = sumPaths(node.right, sumUntilNow);
	if(lsum==sum && rsum == sum)
		this.paths.add(new ArrayList<>(sumPaths));
	sumPaths.removeLast();
	return sumUntilNow;
}
	public static void main(String[] args) {
		Node seven_2 = new Node(7, null, null);
		Node two = new Node(2, null, null);
		Node five = new Node(5, null, null);
		Node four = new Node(4, null, null);
		Node nine = new Node(9, two, seven_2);
		Node seven_1 = new Node(7, four, five);
		Node one = new Node(1, seven_1, nine);
		
		sum=12;
		_GK_PathForSum obj = new _GK_PathForSum();
		obj.sumPaths(one, 0);
		
		System.out.println("\n\n"+obj.paths);

	}

}
