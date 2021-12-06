package trees;

import java.util.LinkedList;
import java.util.Queue;

/*
 * https://www.educative.io/module/lesson/data-structures-in-java/g2rX9Y0QYOj
 */
public class _22MinDepthTree {
	
	// our own solution
 public static int minTreeDepth(Node node, int count) {
	 if(node==null)
		 return count;
	 count++;
	 int left = minTreeDepth(node.left, count);
	 int right = minTreeDepth(node.right, count);
	 
	 return Math.min(left, right);
 }
 
 // ------------------------------------------------------------------------- //
 // without recursion
 public static int minTreeDepth(Node node) {
	 if(node==null)
		 return 0;
	 int minDepth=0;
	 Queue<Node> queue = new LinkedList<>();
	 queue.add(node);
	 while(!queue.isEmpty()) {
		 minDepth++;
		 int size = queue.size();
		 for(int i=0;i<size;i++) {
			 Node currentNode = queue.poll();
			 if(currentNode.left==null && currentNode.right==null)
				 return minDepth;
			 if(currentNode.left!=null)
				 queue.add(currentNode.left);
			 if(currentNode.right!=null)
				 queue.add(currentNode.right);
		 }
	 }
	 return minDepth;
 }
//without recursion
 public static int maxTreeDepth(Node node) {
	 if(node==null)
		 return 0;
	 int maxDepth=0;
	 Queue<Node> queue = new LinkedList<>();
	 queue.add(node);
	 while(!queue.isEmpty()) {
		 maxDepth++;
		 int size = queue.size();
		 for(int i=0;i<size;i++) {
			 Node currentNode = queue.poll();
			 
			 if(currentNode.left!=null)
				 queue.add(currentNode.left);
			 if(currentNode.right!=null)
				 queue.add(currentNode.right);
		 }
	 }
	 return maxDepth;
 }
	public static void main(String[] args) {
		Node threehundred_1=  new Node(300, null, null);
		Node onetwentyfive_1 = new Node(125, null, null);
		Node twohundred_1 = new Node(200, onetwentyfive_1, threehundred_1);
		Node fifteen_1 = new Node(15, null, null);
		Node seventyfive_1 = new Node(75, null, null);
		Node twentyfive_1 = new Node(25, fifteen_1, null);
		Node fifty_1 = new Node(50, twentyfive_1, seventyfive_1);	
	    Node hundred_1 = new Node(100, fifty_1, twohundred_1);
	    
	    System.out.println("min tree depth: "+minTreeDepth(hundred_1, 0));
	    System.out.println("\nmin tree depth without recursion: "+minTreeDepth(hundred_1));
	    System.out.println("\nmax tree depth without recursion: "+maxTreeDepth(hundred_1));

	}

}
