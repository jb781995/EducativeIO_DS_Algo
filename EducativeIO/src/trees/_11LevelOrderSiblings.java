package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * https://www.educative.io/module/lesson/data-structures-in-java/7A3nXOnPP8y
 */
public class _11LevelOrderSiblings {
	
public static void createLinkedList(ArrayList<Node> nodes) {
	if(nodes==null)
		return;
	if(nodes.size()==1) {
		nodes.get(0).next=null;
		System.out.print("\nwelcome ");
		new Node().printNext(nodes.get(0));
	}
	else {
      //Node n = nodes.get(0);
		System.out.print("\nwelcome ");
      int size = nodes.size();
		for(int i=1;i<size;i++) {
			Node prev = nodes.get(i-1);
			prev.next = nodes.get(i);
		}
		nodes.get(nodes.size()-1).next =null;
		
		new Node().printNext(nodes.get(0));
	}
}	
public static List<ArrayList<Node>> levelOrderSuccessors(Node node){
	if(node==null)
		return null;
	List<ArrayList<Integer>> levelOrderSuccessors = new ArrayList<ArrayList<Integer>>();
	List<ArrayList<Node>> levels = new ArrayList<ArrayList<Node>>();
	Queue<Node> queue = new LinkedList<>();
	queue.add(node);
	while(!queue.isEmpty()) {
		int size = queue.size();
	   ArrayList<Integer> currentLevel = new ArrayList<>();
	   ArrayList<Node> currentLevelNode = new ArrayList<>();
	   for(int i=0;i<size;i++) {
		   Node n = queue.poll();
		   currentLevel.add(n.data);
		   currentLevelNode.add(n);
		   if(n.left!=null)
			   queue.add(n.left);
		   if(n.right!=null)
			   queue.add(n.right);
	   }
	   levelOrderSuccessors.add(currentLevel);
	   levels.add(currentLevelNode);
	}
	
	for(ArrayList<Node> list: levels) {
		createLinkedList(list);
	}
	
	return levels;
}
	public static void main(String[] args) {
		Node threehundred_1=  new Node(300, null, null);
		Node onetwentyfive_1 = new Node(125, null, null);
		Node twohundred_1 = new Node(200, onetwentyfive_1, threehundred_1);
		Node fifteen_1 = new Node(15, null, null);
		Node twentyfive_1 = new Node(25, fifteen_1, null);
		Node fifty_1 = new Node(50, twentyfive_1, null);	
	    Node hundred_1 = new Node(100, fifty_1, twohundred_1);
	    
	    //System.out.println("levels:\n"+levelOrderSuccessors(hundred_1));
	    levelOrderSuccessors(hundred_1);
	}

}
