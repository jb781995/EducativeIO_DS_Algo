package linkedlists;

import java.util.HashSet;
import java.util.Set;

//import linkedlists._9UnionIntersectionLL.Node;

public class _9UnionIntersectionLL_2 {
   Node head;
   
	public static Node union(Node node1, Node node2) {
		Node n1 = node1.getHead();
		while(n1.next!=null) 
			n1=n1.next;
		
		n1.next=node2.getHead();

		removeDuplicates(node1);
		
		// can't return node1.head because it would then try to call print() on it
		// which is equivalent of asking for 
		// head.head which doens't exist. So, it won't print anything
		return node1;
	}
	
	public static void removeDuplicates(Node node) {
		Set<Integer> uniqueNodes = new HashSet<>();
		Node n = node.head;
		uniqueNodes.add(n.data);

		while(n.next!=null) {
			if(!uniqueNodes.contains(n.next.data)) {
				uniqueNodes.add(n.next.data);
				n=n.next;
			}
			else {
				n.next = n.next.next;
			}
		}
	}
	public static void main(String[] args) {
		_9UnionIntersectionLL_2 o1 = new _9UnionIntersectionLL_2();
		_9UnionIntersectionLL_2 o2 = new _9UnionIntersectionLL_2();
		
		Node node1= new Node();
		node1.insert(15);
		node1.insert(8);
		node1.insert(14);
		node1.insert(22);
		node1.print(node1.getHead());
		o1.head = node1.getHead();
		
		Node node2 = new Node();
		node2.insert(7);
		node2.insert(14);
		node2.insert(22);
		node2.insert(21);
		System.out.println();
		node2.print(node2.getHead());
		o2.head = node2.getHead();
		
		System.out.println("\n****************************************");
		System.out.println("Union:");
		System.out.println("****************************************");
		union(node1, node2).print();

	}

}
