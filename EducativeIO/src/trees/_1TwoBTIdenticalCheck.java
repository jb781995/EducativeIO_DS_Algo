package trees;
/*
 * https://www.educative.io/module/lesson/data-structures-in-java/3w83PlNV8GQ
 * Check if two binary trees are identical
 * 
 * Memory complexity: O(h) as the recursion stack would need memory as much as that 
 * of the height of a tree. It will be O(logn) for a balanced tree, otherwise O(n)
 */
public class _1TwoBTIdenticalCheck {
	
	/* approach-1: DFS. our code. this is a naive solution. this checks all the way until
	* it reaches the leaf of each tree. we can stop and return false from the middle if the
	* data between both the trees at any intermediate level is not matching. check approach-2
	* for that. much cleaner and removes unnecessary DFS traversal of trees until the leaf nodes.
	*/
	public static boolean areEqual(Node n1, Node n2) {
		if(n1==null && n2!=null)
			return false;
		if(n1!=null && n2==null)
			return false;
		if(n1==null && n2== null)
			return true;
		if(areEqual(n1.left, n2.left)==false)
			return false;
			
		if(n1.data != n2.data)
			return false;
		if(areEqual(n1.right, n2.right)==false)
			return false;
		
		return true;
	}

	/*
	 * approach-2: DFS. cleaner code. return false if data any any intermediate level is not
	 * matching because that's the one thing we check if n1 and n2 are both NOT NULL.
	 */
	public static boolean areIdentical(Node n1, Node n2) {
		if(n1==null && n2==null)
			return true;
		if(n1!=null && n2!=null) {
			return ((n1.data==n2.data) && 
					areIdentical(n1.left, n2.left) &&
					areIdentical(n1.right, n2.right));
			
		}
		return false;
	}
	public static void main(String[] args) {
	
		Node threehundred_1=  new Node(300, null, null);
		Node onetwentyfive_1 = new Node(125, null, null);
		Node twohundred_1 = new Node(200, onetwentyfive_1, threehundred_1);
		Node fifteen_1 = new Node(15, null, null);
		Node seventyfive = new Node(75, null, null);
		Node twentyfive_1 = new Node(25, fifteen_1, null);
		Node fifty_1 = new Node(50, twentyfive_1, seventyfive);	
	    Node hundred_1 = new Node(100, fifty_1, twohundred_1);
	    
		Node threehundred_2=  new Node(300, null, null);
		Node onetwentyfive_2 = new Node(125, null, null);
		Node twohundred_2 = new Node(200, onetwentyfive_2, threehundred_2);
		Node fifteen_2= new Node(15, null, null);
		Node twentyfive_2 = new Node(25, fifteen_2, null);
		Node fifty_2 = new Node(50, twentyfive_2, null);	
	    Node hundred_2 = new Node(100, fifty_2, twohundred_2);
	    
	    System.out.println("are equal? "+areEqual(hundred_1, hundred_2));
	    hundred_1.print(hundred_1);
	    System.out.println();
	    hundred_2.print(hundred_2);
	    
  
	}

}
