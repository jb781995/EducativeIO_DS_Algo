package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * https://www.educative.io/module/lesson/data-structures-in-java/7DBx91GZKQ8
 */
public class _16AllSiblings {
public static Node allSiblings(Node node) {
	if(node==null)
		return null;
	//List<Node> allSiblings = new ArrayList<Node>();
	Queue<Node> queue = new LinkedList<>();
	queue.add(node);
	Node prev=null, head = null;
	while(!queue.isEmpty()) {
		int n = queue.size();
		for(int i=0;i<n;i++) {
			Node currentNode = queue.poll();
			if(head==null && prev==null) {
				head = currentNode;
				prev = currentNode;
			}
			else if(prev!=null && prev.next==null) {
				prev.next = currentNode;
				prev = currentNode;
				prev.next=null;
			}
			
			
			if(currentNode.left!=null)
				queue.add(currentNode.left);
			if(currentNode.right!=null)
				queue.add(currentNode.right);
			
		}
		prev.next = null;
	}
	return head;
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
	    
	    new Node().printNext(allSiblings(hundred_1));

	}

}
