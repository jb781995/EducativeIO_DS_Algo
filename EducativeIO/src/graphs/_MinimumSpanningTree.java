package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _MinimumSpanningTree {
	private Edge[] edges;
	private int V, E;
	private int[] disjointSet;
	_MinimumSpanningTree(int V, int E){
		this.V = V;
		this.E = E;
		edges = new Edge[E];
		disjointSet = new int[E];
		for(int i=0;i<E;i++) {
			edges[i] = new Edge();
			disjointSet[i] = i; // initially every node is its own parent
		}
		
	}
  class Edge implements Comparable<Edge>{
	  int src, dest, weight;
	 
	  public int compareTo(Edge newEdge) {
		  return this.weight - newEdge.weight;
	  }
	  
	  @Override
	  public String toString() {
		  return "\n "+this.src+" <-> "+this.dest+" = "+this.weight;
	  }
  }
  
  public int find(int x) {
	  while(x!= disjointSet[x])
		  x = disjointSet[x];
	  return x;
  }
  
  public void union(int x, int y) {
	  int X = find(x);
	  int Y = find(y);
	  if(X!=Y)
		  disjointSet[Y] = X;
  }
  
  // int edge parameter is an edge number
  public void createEdge(int edge, int src, int dest,int weight) {
	  this.edges[edge].src = src;
	  this.edges[edge].dest = dest;
	  this.edges[edge].weight = weight;
  }
  
  public void createMST() {
	  
	  Arrays.sort(this.edges);
	  
	  System.out.println("Edges sorted on non-decreasing weights:\n"+Arrays.toString(edges));
	  System.out.println("\n");
	  
	  int e = 0;
	  int i = 0;
	  Edge[] result = new Edge[this.V-1];
	  while(e<this.V-1) {
		  Edge thisEdge = this.edges[i++];
		  System.out.println("               "+thisEdge);
		  
		  int X = find(thisEdge.src);
		  int Y = find(thisEdge.dest);
		  
		  if(X!=Y) {
			  union(X, Y);
			  result[e++] = thisEdge;
		  }
		  
	  }
	  
	  System.out.println("\n\nMST is formed with the below nodes:\n"+Arrays.toString(result));
	  
  }
	public static void main(String[] args) {
	
		_MinimumSpanningTree MST = new _MinimumSpanningTree(4, 5);
		
		MST.createEdge(0, 0, 1, 10);
		MST.createEdge(1, 0, 2, 6);
		MST.createEdge(2, 0, 3, 5);
		MST.createEdge(3, 1, 3, 15);
		MST.createEdge(4, 2, 3, 4);
		
		MST.createMST();
		
		
	}

}
