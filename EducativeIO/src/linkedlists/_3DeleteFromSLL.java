package linkedlists;
/*
 * https://www.educative.io/module/lesson/data-structures-in-java/gk6ynjm3q5k
 */
public class _3DeleteFromSLL {
	class Node{
		Node next;
		int data;
		Node(int data){
			this.data = data;
			this.next=null;
		}
	}
	Node head;
	public void insert(int data) {
		if(head==null) {
			head = new Node(data);
			return;
		}
		Node newNode = new Node(data);
		Node n = head;
		while(n.next!=null) {
			n= n.next;
		}
		n.next = newNode;
	}
	
	public void print(Node head) {
		Node n = head;
		while(n!=null) {
			System.out.print(n.data+" ");
			n=n.next;
		}
	}
	
	public void delete(int data) {
		Node n = head;
		while(n.next!=null) {
			if(n.next.data==data) {
				Node newNext = n.next.next;
				n.next = newNext;
				break;
			}
			n=n.next;
		}
	}
	public static void main(String[] args) {
		_3DeleteFromSLL o = new _3DeleteFromSLL();
		o.insert(5);
		o.insert(15);
		o.insert(25);
		o.insert(35);
		o.print(o.head);
		o.delete(15);
		System.out.println();
		o.print(o.head);
		o.delete(35);
		System.out.println();
		o.print(o.head);
		

	}

}
