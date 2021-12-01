package trees;

import java.util.Stack;

public class _14BTPerimeter {

	public static void leftPerimeter(Node node, StringBuilder result) {
		while(node!=null) {
			int val = node.data;
			if(node.left!=null)
				node=node.left;
			else if(node.right!=null)
				node= node.right;
			else break;
			result.append(String.valueOf(val)+" ");
		}
	}
	
	public static void leafNodes(Node node, StringBuilder result) {
		if(node!=null) {
			leafNodes(node.left, result);
			leafNodes(node.right, result);
			if(node.left!=null && node.right!=null)
				result.append(String.valueOf(node.data)+" ");
		}
	}
	
	public static void rightPerimeter(Node node, StringBuilder result) {
		Stack<Integer> right = new Stack<>();
		while(node!=null) {
			int val = node.data;
			if(node.right!=null)
				node=node.right;
			else if(node.left!=null)
				node = node.left;
			else break;
			right.push(val);
		}
		
		while(!right.isEmpty())
			result.append(String.valueOf(right.pop())+" ");
	}
	public static String displayTree(Node node) {
		StringBuilder result = new StringBuilder();
		if(node!=null) {
			result.append(String.valueOf(node.data)+" ");
			leftPerimeter(node.left, result);
			if(node.left!=null || node.right!=null)
				leafNodes(node, result);
			rightPerimeter(node.right, result);
		}
		return result.toString();
	}
	public static void main(String[] args) {
		Node threehundred_1=  new Node(300, null, null);
		Node onetwentyfive_1 = new Node(125, null, null);
		Node twohundred_1 = new Node(200, onetwentyfive_1, threehundred_1);
		Node fifteen_1 = new Node(15, null, null);
		Node twentyfive_1 = new Node(25, fifteen_1, null);
		Node fifty_1 = new Node(50, twentyfive_1, null);	
	    Node hundred_1 = new Node(100, fifty_1, twohundred_1);
	    
	    System.out.println("tree perimeter:\n"+displayTree(hundred_1));

	}

}
