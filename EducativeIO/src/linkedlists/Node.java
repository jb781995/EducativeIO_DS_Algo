package linkedlists;

public class Node {
        Node next, head;
		int data;
        Node(){}
		Node(int data){
			this.data = data;
			this.next=null;
		}

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

        public Node getHead(){
            return head;
        }

}
