package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 *  https://www.educative.io/courses/grokking-the-coding-interview/qVA27MMYYn0
 */
public class _GK_ZigZagTraversal {
  public void zigZag(Node node) {
	  Queue<Node> q = new LinkedList<>();
	  List<List<Integer>> ans = new ArrayList<List<Integer>>();
	  q.add(node);
	  
	  boolean rightToLeft = false;
	  while(!q.isEmpty()) {
		  int n= q.size();
		  List<Integer> zigZag = new ArrayList<>();
		  for(int i=0;i<n;i++) {
			  Node thisNode = q.poll();
			  if(rightToLeft)
				  zigZag.add(0, thisNode.data);
			  else
				  zigZag.add(thisNode.data);
			  
			  if(thisNode.left!=null)
				  q.add(thisNode.left);
			  if(thisNode.right!=null)
				  q.add(thisNode.right);
		  }
		  ans.add(zigZag);
		  rightToLeft = !rightToLeft;
	  }
	  
	  System.out.println("\n"+ans);
  }
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);
		System.out.println(numbers);
		numbers.add(0, 2);
		System.out.println(numbers);
		numbers.add(0, 3);
		System.out.println(numbers);
		
		Node threehundred_1=  new Node(300, null, null);
		Node onetwentyfive_1 = new Node(125, null, null);
		Node twohundred_1 = new Node(200, onetwentyfive_1, threehundred_1);
		Node fifteen_1 = new Node(15, null, null);
		Node seventyfive_1 = new Node(75, null, null);
		Node twentyfive_1 = new Node(25, fifteen_1, null);
		Node fifty_1 = new Node(50, twentyfive_1, seventyfive_1);	
	    Node hundred_1 = new Node(100, fifty_1, twohundred_1);
	    
	    System.out.println("\n\n");
	    new _GK_ZigZagTraversal().zigZag(hundred_1);

	}

}
