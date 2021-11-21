package linkedlists;

public class _6DetectLoopInSLL {
	
 public boolean isLoop(Node node) {
	Node slow = node;
	Node fast = node;
	while(slow!=null && fast!=null && fast.next!=null) {
		slow= slow.next;
		fast=fast.next.next;
		System.out.println("slow: "+slow.data+", fast: "+fast.data);
		if(slow==fast)
			return true;
	}
	 
	return false;
 }
	public static void main(String[] args) {
		_6DetectLoopInSLL o = new _6DetectLoopInSLL();
		
		Node node = new Node();
		//System.out.println("loop?"+o.isLoop(head));
		
		}

}
