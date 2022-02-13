package trees;
/*
 * https://www.educative.io/module/lesson/data-structures-in-java/x188PXZyV2P
 */
import java.util.Stack;

public class _14BTPerimeter {

	public static void leftPerimeter(Node node, StringBuilder result) {
		while(node!=null) {
			int val = node.data;
			if(node.left!=null)
				node=node.left;
			else if(node.right!=null)
				node= node.right;
			else break;
			result.append(String.valueOf(val)+" ");
		}
	}
	
	public static void leafNodes(Node node, StringBuilder result) {
		if(node!=null) {
			leafNodes(node.left, result);
			leafNodes(node.right, result);
			if(node.left==null && node.right==null)
				result.append(String.valueOf(node.data)+" ");
		}
	}
	
	public static void rightPerimeter(Node node, StringBuilder result) {
		while(node!=null) {
			int val = node.data;
			if(node.right!=null)
				node=node.right;
			else if(node.left!=null)
				node = node.left;
			else break;
			result.append(String.valueOf(val)+" ");
			
		}
	}
	
	public static String displayTree(Node node) {
		StringBuilder result = new StringBuilder();
		if(node!=null) {
			result.append(String.valueOf(node.data)+" ");
			leftPerimeter(node.left, result);
			if(node.left!=null || node.right!=null)
				leafNodes(node, result);
			rightPerimeter(node.right, result);
		}
		return result.toString();
	}
	public static void main(String[] args) {
		Node fourhundred_1 = new Node(400, null, null);
		Node threehundred_1=  new Node(300, null, fourhundred_1);
		Node onetwentyfive_1 = new Node(125, null, null);
		Node twohundred_1 = new Node(200, null, threehundred_1);
		Node fifteen_1 = new Node(15, null, null);
		Node twentyfive_1 = new Node(25, fifteen_1, null);
		Node seventy_1 = new Node(70, null, null);
		Node sixty_1 = new Node(60, null, seventy_1);
		Node fifty_1 = new Node(50, twentyfive_1, sixty_1);	
	    Node hundred_1 = new Node(100, fifty_1, twohundred_1);
	    
	    System.out.println("tree perimeter:\n"+displayTree(hundred_1));

	    /*
	     * while(node!=null){
	     *  if(node.left!=null)
	     *   node = node.left;
	     *  else if(node.right!=null)
	     *  node= node.right;
	     *  else 
	     *  break;
	     * }
	     * 
	     * leaf(Node node){
	     * if(node!=null){
	     *  leaf(node.left);
	     *  leaf(node.right);
	     *  if(node.left==null && node.right==null)
	     *    sb.append(node.data)
	     * }
	     * }
	     */
	}

}
