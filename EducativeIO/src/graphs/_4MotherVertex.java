package graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * 
 */
public class _4MotherVertex {
	
	private List<ArrayList<Node>> adj;
	private boolean[] visited;
	
	private Stack<Integer> stack;
	private int v;
	private int count=0;
	
	private int motherNode = Integer.MIN_VALUE;
	
	_4MotherVertex(int v){
		this.v = v;
		this.count = v;
		visited = new boolean[v];
		stack = new Stack<>();
		adj = new ArrayList<ArrayList<Node>>();
		for(int i=0;i<v;i++)
			adj.add(new ArrayList<Node>());
	}
	
	public  void addNeighbors(int thisVertex, int neighbor, int cost) {
		this.adj.get(thisVertex).add(new Node(neighbor, cost));
	}
	
	/*
	 * approach -1: check manually for individual source
	 */
	public void motherVertex(int source) {
		if(helper(source))
			System.out.println("The mother node: "+this.motherNode);
		else
			System.out.println("This source is not a Mother node");
	}
	
	/*
	 * approach -2: reset visited, stack and count for each node 
	 * in the graph no manual intervention needed. Just pass on 
	 * the adj(graph) as an input
	 */
	public void motherVertex(List<ArrayList<Node>> adj) {
		int i=0;
		for(i=0;i<this.v;i++) {
			this.count = this.v;
			visited = new boolean[v];
			stack = new Stack<>();
			if(helper(i)) {
				System.out.println("The mother node: "+i);
				break;
			}
			else
				System.out.println(i+" is not a mother vertex, "+this.motherNode);
		}
	}
	
	public boolean helper(int node) {
		this.visited[node] = true;
		stack.push(node);
		this.count--;
		if(this.count==0)
			return true;
		for(Node neighbor: this.adj.get(node)) {
			if(this.visited[neighbor.vertex]==false) {
				if(helper(neighbor.vertex)) {
					this.motherNode = node;
					return true;
				}
				
				stack.pop();
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		_4MotherVertex o = new _4MotherVertex(4);
		_4MotherVertex o2 = new _4MotherVertex(7);
		
		o.addNeighbors(0, 2, 2);
		o.addNeighbors(1, 0, 6);
		o.addNeighbors(1, 2, 4);
		o.addNeighbors(2, 3, 3);
		// comment/uncomment the below to see change in output
		//o.addNeighbors(2, 1, 10);
		//o.motherVertex(0);
		o.motherVertex(o.adj);
		
		System.out.println("------------------------------");
		
		// below example: https://www.geeksforgeeks.org/find-a-mother-vertex-in-a-graph/
		// correct answer
		o2.addNeighbors(0, 1, 3);
		o2.addNeighbors(0, 2, 3);
		o2.addNeighbors(1, 3, 3);
		o2.addNeighbors(4, 1, 3);
		o2.addNeighbors(6, 4, 3);
		o2.addNeighbors(5, 6, 3);
		o2.addNeighbors(5, 2, 3);
		o2.addNeighbors(6, 0, 3);
		
		//o2.motherVertex(3);
		o2.motherVertex(o2.adj);
		
		

	}

}
