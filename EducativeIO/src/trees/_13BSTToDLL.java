package trees;
/*
 * https://www.educative.io/module/lesson/data-structures-in-java/YVB8kkYWWj0
 * the solution is taken from leetcode
 */
public class _13BSTToDLL {
 private static Node head;
 private static Node prev;
 
 public static void treeToDLL(Node node) {
	 if(node==null)
		 return;
	 treeToDLL(node.left);
	 if(prev==null)
		 head = node;
	 else {
		 prev.next = node;
		 node.prev = prev;
	 }
	 prev = node;
	 treeToDLL(node.right);
 }
	public static void main(String[] args) {
		Node threehundred_1=  new Node(300, null, null);
		Node onetwentyfive_1 = new Node(125, null, null);
		Node twohundred_1 = new Node(200, onetwentyfive_1, threehundred_1);
		Node fifteen_1 = new Node(15, null, null);
		Node twentyfive_1 = new Node(25, fifteen_1, null);
		Node fifty_1 = new Node(50, twentyfive_1, null);	
	    Node hundred_1 = new Node(100, fifty_1, twohundred_1);
	    
	    treeToDLL(hundred_1);
	    new Node().printNextPrev(head);
	    /*
	     * helper(Node node){
	     * if(node == null)
	     *  return;
	     *  helper(node.left);
	     *  
	     *  if(prev==null)
	     *   head= node;
	     *   else{
	     *    prev.next = node;
	     *    node.prev = prev;
	     *   }
	     *   prev= node;
	     *   
	     *   helper(node.right);
	     * }
	     */

	}

}
