package trees;
/*
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iv/
 * SOL: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iv/discuss/1613419/Clean-Java-Recursive
 */
public class LC_LowestCommonAncestor {
public Node LCA(Node root, Node[] nodes) {
	System.out.println("\n\nroot right now: "+root.data);
	boolean inLeft = false;
	boolean inRight= false;
	for(Node n: nodes) {
		if(n==root)
			return root;
		if(contains(root.left, n)) {
			inLeft = true;
			System.out.println(n.data+" found in left subtree of "+root.data);
		}
		else if(contains(root.right, n)) {
			inRight= true;
			System.out.println(n.data+" found in right subtree of "+root.data);
		}
	}
	
	if(inLeft && inRight) {
		System.out.println("1. return "+root.data);
		return root;
	}
	else if(inLeft) return LCA(root.left, nodes);
	else return LCA(root.right, nodes);
}
public boolean contains(Node node, Node thisNode) {
	if(node==null)
		return false;
	
	return node==thisNode || contains(node.left, thisNode) || contains(node.right, thisNode);
}
	public static void main(String[] args) {
		Node eight=  new Node(8, null, null);
		Node zero = new Node(0, null, null);
		Node one = new Node(1, zero, eight);
		Node seven = new Node(7, null, null);
		Node four = new Node(4, null, null);
		Node two = new Node(2, seven, four);
		Node six = new Node(6, null, null);
		Node five = new Node(5, six, two);	
	    Node three = new Node(3, five, one);

	    Node[] nodes = {seven, two, six, four};
	    
	    new LC_LowestCommonAncestor().LCA(three, nodes);
	}

}
