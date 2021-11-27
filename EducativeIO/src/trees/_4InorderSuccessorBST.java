package trees;

import java.util.ArrayList;
import java.util.List;

/*
 * https://www.educative.io/module/lesson/data-structures-in-java/gkWzZXlDvz9
 */
public class _4InorderSuccessorBST {
	public static Node findMin(Node n) {
		if(n==null)
			return null;
		while(n.left!=null)
			n=n.left;
		return n;
	}
	public static Node successor(Node head, int d) {
		if(head.data > d) {
			
		}
		Node successor = null;
		
		while(head!=null) {
			if(head.data<d)
				head = head.right;
			else if(head.data>d) {
				successor = head;
				head= head.left;
			}
			else {
				// the below is useful when trying to find successor of the root node.
				// in this case, for 100 it would take 100.right=200 and then traverse
				// the left subtree of 200 all the way down and return 125
				if(head.right!=null)
					successor = findMin(head.right);
			}
			break;
		}
		return successor;
			
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
