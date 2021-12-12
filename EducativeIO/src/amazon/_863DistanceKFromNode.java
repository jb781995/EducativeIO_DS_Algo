package amazon;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
 */
public class _863DistanceKFromNode {
	    private int counter =-10000;
	    private List<Integer> nodesTwoPlacesAway = null;
	    private int k = 0;
	    
	    public List<Integer> distanceK(Node root, Node target, int k) {
	         this.nodesTwoPlacesAway = new ArrayList<Integer>();
	         this.k = k;
	         
	        if(root==null)
	            return null;
	        int targetVal = target.data;
	        
	        helperFunc(root, this.counter, targetVal);
	        return nodesTwoPlacesAway;
	    }
	    
	    public void helperFunc(Node node, int counter, int target){
	        if(node==null)
	            return;
	        
	       
	        if(node!=null && counter>=0){
	            System.out.print("    "+node.data);
	             counter++;
	            System.out.println(".."+counter+"\n\n");
	        }
	        
	         if(counter == this.k){
	            this.nodesTwoPlacesAway.add(node.data);
	            return;
	        }
	        
	        if(node.data == target)
	            counter = 0;
	        
	        helperFunc(node.left, counter, target);
	        //counter--;
	        helperFunc(node.right, counter, target);
	        //counter = -10000;
	    }
	    
	public static void main(String[] args) {
		
		Node four=  new Node(4, null, null);
		Node seven = new Node(7, null, null);
		Node eight=  new Node(8, null, null);
		Node zero = new Node(0, null, null);
		Node two = new Node(2, seven, four);
		Node six = new Node(6, null, null);
		Node one = new Node(1, zero, eight);
		Node five = new Node(5, six, two);	
	    Node three = new Node(3, five, one);
	    
	    new _863DistanceKFromNode().distanceK(three, five, 2);

	}

}
