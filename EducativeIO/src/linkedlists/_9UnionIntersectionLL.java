package linkedlists;

import java.util.HashSet;
import java.util.Set;

/*
 * 
 */
public class _9UnionIntersectionLL {
	Node head;
		class Node{
			Node next;
			int data;
			Node(){}
			Node(int data){
				this.data = data;
				this.next= null;
			}
		}

	public void insert(int data) {
		if(this.head==null) {
			this.head = new Node(data);
			return;
		}
		Node newNode = new Node(data);
		Node n = this.head;
		while(n.next!=null)
			n=n.next;
		n.next = newNode;
	}
	
	public void print() {
		Node n = this.head;
		while(n!=null) {
			System.out.println(n.data+" ");
			n=n.next;
		}
	}
	
	public Node getHead() {
		return this.head;
	}
	public static _9UnionIntersectionLL union(_9UnionIntersectionLL one, _9UnionIntersectionLL two) {
		_9UnionIntersectionLL.Node oneRoot= one.getHead();
		_9UnionIntersectionLL.Node secondRoot = two.getHead();
		while(oneRoot.next!=null)
			oneRoot = oneRoot.next;
		oneRoot.next = secondRoot;
		one.removeDuplicates();
		return one;
	}

	public void removeDuplicates() {
		Set<Integer> uniqueNodes = new HashSet<>();
		Node n = this.head;
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
		_9UnionIntersectionLL o1 = new _9UnionIntersectionLL();
		o1.insert(15);
		o1.insert(8);
		o1.insert(14);
		o1.insert(22);
		System.out.println("list one:");
		o1.print();
		
		_9UnionIntersectionLL o2 = new _9UnionIntersectionLL();
		o2.insert(7);
		o2.insert(14);
		o2.insert(21);
		o2.insert(22);
        System.out.println("list two:");
        o2.print();
        
		System.out.println("Union:");
        union(o1, o2).print();
	}

}
