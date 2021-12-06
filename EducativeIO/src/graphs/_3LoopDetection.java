package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
 * https://www.educative.io/module/lesson/data-structures-in-java/qVG1PDyWmGR
 * Cycle Detection in a Directed Graph
 * refer graph.jpg in this folder for graph reference  
 * 
 *                Time Complexity: O(V+E)= Vertices + Edges
 */
public class _3LoopDetection {
	
	private List<ArrayList<Node>> adj;
	private int V;
	private boolean[] visited;
	private boolean flag = false;
	private Stack<Integer> stack;
	
	_3LoopDetection(int V){
		this.V = V;
		visited = new boolean[V];
		stack = new Stack<>();
		adj = new ArrayList<ArrayList<Node>>();
		for(int i=0;i<V;i++)
			adj.add(new ArrayList<Node>());
				
	}
	
	public  void addNeighbors(int thisVertex, int neighbor, int cost) {
		this.adj.get(thisVertex).add(new Node(neighbor, cost));
	}
	
	public boolean detectLoop(int source) {
		helper(source);
		if(flag)
			return true;
		return false;
	}
	
	/*
	 * helper function to detect loops
	 */
	public void helper(int node) {
		if(stack.contains(node)) {
			this.flag = true;
			System.out.println(node+" already present. loop detected");
			return;
		}
		this.visited[node] = true;
		stack.push(node);
		System.out.println("visited: "+Arrays.toString(this.visited));
		for(Node neighbors: this.adj.get(node)) {
			 System.out.println("   "+node+"'s neighbor "+neighbors.vertex);
			 helper(neighbors.vertex);
			  if(flag)
				  return;
			
			 stack.pop();
			 
		}
		//return flag;
	}
	public static void main(String[] args) {
		
		_3LoopDetection o = new _3LoopDetection(4);
		_3LoopDetection o2 = new _3LoopDetection(3);
		
		List<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
		for(int i=0;i<3;i++)
			graph.add(new ArrayList<Node>());
		
		/*
		 * 
			graph.get(0).add(new Node(1, 9));
			graph.get(0).add(new Node(2, 6));
			graph.get(0).add(new Node(3, 5));
			graph.get(0).add(new Node(4, 3));
			
			graph.get(2).add(new Node(1, 2));
			graph.get(2).add(new Node(3, 4));
		 */
		
		
		
		 // alternatively, we can have a function with arguments to do this via 
		 // a function as below:
		  
//		  o.addNeighbors(0, 1, 9);
//		  o.addNeighbors(0, 2, 6);
//		  o.addNeighbors(0, 3, 5);
//		  o.addNeighbors(0, 4, 3);
//		  
//		  o.addNeighbors(2, 1, 6);
//		  o.addNeighbors(2, 3, 4);
		
		
		
		// to detect loops, we don't really care about the weights, but since the method
		// and constructor has been designed like that, we're passing it on as a third 
	    // parameter. Below is the graph with loop
		o.addNeighbors(0, 1, 2);
		o.addNeighbors(0, 2, 3);
		
		o.addNeighbors(1, 2, 4);
		
		o.addNeighbors(2, 3, 3);
		o.addNeighbors(2, 0, 6);
		
		//Below is the graph with no loop
		o2.addNeighbors(0, 1, 5);
		o2.addNeighbors(0, 2, 1);
		
		o2.addNeighbors(1, 2, 4);
		  
		  if(o.detectLoop(0))
			  System.out.println("\nloop detected");
		  else
			  System.out.println("\nno loops");
		  System.out.println("------------------------------------------");
		  
		  if(o2.detectLoop(0))
			  System.out.println("\nloop detected");
		  else
			  System.out.println("\nno loops");
		  
	}

}
