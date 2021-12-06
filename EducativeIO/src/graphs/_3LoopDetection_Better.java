package graphs;

import java.util.ArrayList;
import java.util.List;

/*
 * https://www.geeksforgeeks.org/detect-cycle-in-a-graph/
 */
public class _3LoopDetection_Better {
	
private List<ArrayList<Node>> adj;
private int vertices;

_3LoopDetection_Better(int vertices){
	this.vertices = vertices;
	this.adj = new ArrayList<ArrayList<Node>>();
	for(int i=0;i<vertices;i++)
		adj.add(new ArrayList<Node>());
}

public void addNeighbors(int thisVertex, int neighbor) {
	this.adj.get(thisVertex).add(new Node(neighbor));
}

public boolean isCyclic() {
	
	// Mark all the vertices as not visited and
    // not part of recursion stack
    boolean[] visited = new boolean[this.vertices];
    boolean[] recStack = new boolean[this.vertices];
    
    for(int i=0;i<this.vertices;i++)
    	if(helper(i, visited, recStack))
    		return true;
    return false;
    
}

public boolean helper(int thisVertex, boolean[] visited, boolean[] stack) {
	
	// there is a cycle/loop
	if(stack[thisVertex])
		return true;
	
	if(visited[thisVertex])
		return false;
	
	visited[thisVertex] = true;
	stack[thisVertex] = true;
	
	for(Node neighbors: this.adj.get(thisVertex)) 
		if(helper(neighbors.vertex, visited, stack))
			return true;
		
	stack[thisVertex] = false;
	return false;
}
	public static void main(String[] args) {
		

	}

}
