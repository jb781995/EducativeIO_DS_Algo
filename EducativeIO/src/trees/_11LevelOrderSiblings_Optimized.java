package trees;

import java.util.LinkedList;
import java.util.Queue;

public class _11LevelOrderSiblings_Optimized {
	
public static void levelOrderSiblings(Node root) {
	Queue<Node> queue = new LinkedList<>();
	queue.add(root);
	while(!queue.isEmpty()) {
		int size = queue.size();
		Node previousNode =null;
		for(int i=0;i<size;i++) {
			Node currentNode = queue.poll();
			if(previousNode!=null) 
				previousNode.next = currentNode;
			
			previousNode = currentNode;
			if(currentNode.left!=null)
				queue.add(currentNode.left);
			if(currentNode.right!=null)
				queue.add(currentNode.right);
		}
	}
	}
	public static void main(String[] args) {
		Node threehundred_1=  new Node(300, null, null);
		Node onetwentyfive_1 = new Node(125, null, null);
		Node twohundred_1 = new Node(200, onetwentyfive_1, threehundred_1);
		Node fifteen_1 = new Node(15, null, null);
		Node twentyfive_1 = new Node(25, fifteen_1, null);
		Node fifty_1 = new Node(50, twentyfive_1, null);	
	    Node hundred_1 = new Node(100, fifty_1, twohundred_1);
   
	}

}
