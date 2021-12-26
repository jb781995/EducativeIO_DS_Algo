package trees;
/*
 * https://www.educative.io/module/lesson/data-structures-in-java/RM2yl29kpqK
 * runtime complexity: O(n), memory: O(h), where h= height of the tree
 */
public class _12IsValidBST {
  
	public static boolean isValidBST(Node node) {
		return helper(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	public static boolean helper(Node node, int min, int max) {
		if(node==null)
			return true;
		if(node.data<min || node.data>max)
			return false;
		else
			System.out.println(" "+node.data+" > "+min+", and "+node.data+" < "+max);
		
		return helper(node.left, min, node.data) && helper(node.right, node.data, max); 
	}
	public static void main(String[] args) {
		Node threehundred_1=  new Node(300, null, null);
		Node onetwentyfive_1 = new Node(125, null, null);
		Node twohundred_1 = new Node(200, onetwentyfive_1, threehundred_1);
		Node seventyfive_1 = new Node(75, null, null);
		Node twentyfive_1 = new Node(25, null, null);
		Node fifty_1 = new Node(50, twentyfive_1, seventyfive_1);	
	    Node hundred_1 = new Node(100, fifty_1, twohundred_1);
	    
	    
	    
	    System.out.println("is valid? "+isValidBST(hundred_1));
	    
	    int xx = Integer.MIN_VALUE;
	    xx--;
	    System.out.println("\n\n"+xx);

	}

}
