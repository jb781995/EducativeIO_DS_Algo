package linkedlists;
/*
 * 
 */
public class _7MiddleElement {
 public Node middleElement(Node node) {
	 Node slow = node;
	 Node fast = node;
	 while(slow!=null && fast!=null && fast.next!=null) {
		 //slow= slow.next;
		 fast=fast.next.next;
		 if(fast!=null)
			 slow=slow.next;
	 }
	 return slow;
 }
	public static void main(String[] args) {
		_7MiddleElement o = new _7MiddleElement();
		Node node = new Node();
		node.insert(5);
		node.insert(15);
		node.insert(25);
		node.insert(35);
		node.insert(45);
		System.out.println("middle element: "+o.middleElement(node.head).data);
		
	}

}
