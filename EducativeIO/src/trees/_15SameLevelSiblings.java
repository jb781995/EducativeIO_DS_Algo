package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * https://www.educative.io/module/lesson/data-structures-in-java/mEpDpEmA34O
 * Essentially same as 11
 */ 
public class _15SameLevelSiblings {

	public static void conenctLevel(ArrayList<Node> level) {
		if(level.size()==1) {
			System.out.println();
			level.get(0).next =null;
			new Node().printNext(level.get(0));
			
		}
		else {
			//new Node().head = level.get(0);
			System.out.println();
			Node node = new Node();
			node.head = level.get(0);
			int size = level.size();
			for(int i=1;i<size;i++) {
				node = level.get(i-1);
				level.get(i).prev = node;
				node.next=level.get(i);
			}
			level.get(size-1).next = null;
			node.printNext(node);
		}
	}
	public static void levelOrder(Node node) {
		List<ArrayList<Node>> levels = new ArrayList<ArrayList<Node>>();
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		while(!queue.isEmpty()) {
			int size = queue.size();
			//Node n = queue.poll();
			ArrayList<Node> level = new ArrayList<Node>();
			for(int i=0;i<size;i++) {
				Node n = queue.poll();
				if(n.left!=null)
					queue.add(n.left);
				if(n.right!=null)
					queue.add(n.right);
				level.add(n);
			}
			levels.add(level);
			
		}
		
		for(ArrayList<Node>level: levels)
			conenctLevel(level);
	}
	public static void main(String[] args) {
		Node threehundred_1=  new Node(300, null, null);
		Node onetwentyfive_1 = new Node(125, null, null);
		Node twohundred_1 = new Node(200, onetwentyfive_1, threehundred_1);
		Node fifteen_1 = new Node(15, null, null);
		Node twentyfive_1 = new Node(25, fifteen_1, null);
		Node fifty_1 = new Node(50, twentyfive_1, null);	
	    Node hundred_1 = new Node(100, fifty_1, twohundred_1);
	    
	    levelOrder(hundred_1);

	}

}
