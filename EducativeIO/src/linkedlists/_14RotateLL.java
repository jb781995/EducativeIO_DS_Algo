package linkedlists;

public class _14RotateLL {

private static Node head;
private static int rotate;

public static Node rotateLL(Node current) {
	if(current.next==null)
		return current;

	Node node= rotateLL(current.next);
	if(rotate>0) {
	--rotate;
    Node temp = head;
	current.next.next = head;
	head = node;
	System.out.println("head: "+temp.data+", new head: "+head.data+", current.next.next: "+current.next.next.data+"\n");
    current.next=null;

	}
	return current;
}

public static void main(String []a) {
	Node node = new Node();
	node.insert(1);
	node.insert(2);
	node.insert(3);
	node.insert(4);
	node.insert(5);
	head = node.head;
	rotate=3;
	rotateLL(head);
	node.print(head);
	System.out.println("\n\n**************");
	
}
}
