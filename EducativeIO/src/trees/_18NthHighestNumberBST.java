package trees;

import java.util.Comparator;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * https://www.educative.io/module/lesson/data-structures-in-java/7Alwgw73m0r
 */
public class _18NthHighestNumberBST {
	
public void nthHighestNumber(Node node, int n) {
	Queue<Node> queue = new LinkedList<>();
	PriorityQueue<Integer> sortedQueue = new PriorityQueue<>(new Comparator<Integer> (){
			@Override
		public int compare(Integer a, Integer b) {
			if(a>b)
				return -1;
			else if(a<b)
				return 1;
			else
				return 0;
		}
	});
	
	queue.add(node);
	while(!queue.isEmpty()) {
		Node thisNode = queue.poll();
		sortedQueue.add(thisNode.data);
		
		if(thisNode.left!=null) 
			queue.add(thisNode.left);
		
		if(thisNode.right!=null) 
			queue.add(thisNode.right);
		
	}
	
	int i=1;
	while(!sortedQueue.isEmpty()) {
		if(i==n) {
			System.out.println(""+sortedQueue.poll());
			break;
		}
		sortedQueue.poll();
		i++;
	}
	
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
	    
	    new _18NthHighestNumberBST().nthHighestNumber(hundred_1, 5);

	}

}
