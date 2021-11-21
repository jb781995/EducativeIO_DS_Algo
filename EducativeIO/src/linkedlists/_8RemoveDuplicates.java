package linkedlists;

import java.util.HashSet;
import java.util.Set;

public class _8RemoveDuplicates {
	
public static Node removeDuplicates(Node node) {
	Set<Integer> uniqueNodes = new HashSet<>();
	Node n = node;
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
	
	return node;
}
	public static void main(String[] args) {
		Node node = new Node();
		node.insert(7);
		node.insert(14);
		node.insert(21);
		node.insert(14);
		node.insert(22);
       
		node.print(node.head);
		System.out.println("\nafter removing the duplicates: ");
		node.print(removeDuplicates(node.head));
	}

}
