package trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/*
 * https://www.educative.io/courses/grokking-the-coding-interview/B815A0y2Ajn
 * 
 */
public class _GK_AllPaths {
List<ArrayList<Node>> allPaths = new ArrayList<ArrayList<Node>>();
LinkedList<Node> paths = new LinkedList<Node>();
private int max = Integer.MIN_VALUE;
public List<ArrayList<Node>> allPaths(Node node) {
	if(node==null)
		return null;
	paths(node);
	return allPaths;
		
}

public void paths(Node node) {
	if(node !=null) {
	paths.add(node);
	paths(node.left);
	paths(node.right);
	if(node.left==null && node.right==null) {
		this.allPaths.add(new ArrayList<>(paths));
	}
	paths.removeLast();
	}
	
	
}
public int findMaxPathSum(Node node) {
	 return maxSum(node, 0);
	 
}

public int maxSum(Node node, int sum) {
	if(node==null)
		return sum;
	sum+=node.data;
	int left = maxSum(node.left, sum);
	int right = maxSum(node.right, sum);
    if(left>right && left>max) {
    	max = left;
    	System.out.println("if: "+max);
    }
    else if(right>left && right>max) {
    	max = right;
    	System.out.println("else if: "+max);
    }
    else {
    	max = sum;
    	System.out.println("else: "+max+"\n\n");
    }
	return max;
	
}
	public static void main(String[] args) {
		Node seven_2 = new Node(7, null, null);
		Node two = new Node(2, null, null);
		Node five = new Node(5, null, null);
		Node four = new Node(4, null, null);
		Node nine = new Node(9, two, seven_2);
		Node seven_1 = new Node(7, four, five);
		Node one = new Node(1, seven_1, nine);
		
		_GK_AllPaths obj = new _GK_AllPaths();
		System.out.println("\n"+obj.allPaths(one));
		System.out.println("\n\nmax sum path: "+obj.findMaxPathSum(one));
		
		List<int[]> list = new ArrayList<>();
		int n=4;
		for(int i=0;i<n;i++)
			list.add(new int[2]);
		
		for(int i=0;i<n;i++)
			list.add(new int[] {i+1, i+2, i+3});
		
		for(int[] a: list)
			System.out.println(Arrays.toString(a));
		
		Queue<Integer> q = new LinkedList<Integer>();
		Queue<Integer> q2 = new Stack<>();
	}

}
