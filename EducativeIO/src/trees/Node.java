package trees;

import java.util.LinkedList;
import java.util.Queue;

public class Node {
        Node next, head, prev;
        Node left, right;
		int data;
        Node(){}
        Node(int data){
        	this.data = data;
        }
        Node(int data, Node left, Node right){
        	this.data = data;
        	this.left = left;
        	this.right = right;
        }
		

       /*
        * level order traversal/printing of the tree
        */
        public void print(Node head) {
        	Queue<Node> queue = new LinkedList<>();
        	queue.add(head);
        	while(!queue.isEmpty()) {
        		Node n = queue.poll();
        		if(n.left!=null)
        			queue.add(n.left);
        		if(n.right!=null)
        			queue.add(n.right);
        		System.out.print(n.data+" ");
        	}
        }
        
        /*
         * print based on the next pointer
         */
        public void printNext(Node node) {
        	Node n = node;
        	while(n!=null) {
        		System.out.print(n.data+" ");
        		n=n.next;
        	}
        }
        
        /*
         * print based on the next pointer and prev pointer
         * for doubly linked list behavior
         */
        public void printNextPrev(Node node) {
        	Node n = node;
        	while(n!=null && n.next!=null) {
        		if(n.prev==null) {
        			System.out.println(n.data+" -> "+n.next.data);
        			n=n.next;
        			continue;
        		}
        			
        		System.out.println(n.prev.data+" <- "+n.data+" -> "+n.next.data);
        		n=n.next;
        	}
        	System.out.println(n.prev.data+" <- "+n.data);
        }
        

        public Node getHead(){
            return head;
        }

}
