package linkedlists;

public class Node {
        Node next, head;
		int data;
		int count=0;
        Node(){}
		Node(int data){
			this.data = data;
			this.next=null;
		}

        public void insert(int data) {
        	count++;
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
        
        /*
         * overloaded version of the print function in case when 
         * a Node instance is returned from some function and we 
         * wish to print based on that instance
         */
        public void print() {
        	Node n = this.head;
        	 while(n!=null) {
                 System.out.print(n.data+" ");
                 n=n.next;
             }
        }
        
        public int getCount() {
        	return this.count;
        }

        public Node getHead(){
            return head;
        }

}
