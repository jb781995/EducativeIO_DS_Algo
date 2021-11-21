package linkedlists;

public class _5ReverseSLL {
  
	public Node reverseLL(Node node){
	if(node.next==null)
	return node;
	Node newHead = reverseLL(node.next);
    node.next.next = node;
	node.next = null;
	return newHead;
}
	public static void main(String[] args) {
		
		_5ReverseSLL o = new _5ReverseSLL();
		Node node = new Node();
		node.insert(5);
		node.insert(10);
		node.insert(15);
		node.insert(25);

		Node head = node.getHead();
		node.print(head);

		Node newHead = o.reverseLL(head);
		System.out.println();
		node.print(newHead);
	}

}
