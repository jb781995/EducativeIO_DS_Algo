package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/*
 * https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-in-java-using-priorityqueue/
 */
public class _Dijkstra_ShortestPath {
	
 private int V;
 private List<List<Node>> adj;
 private int[] distance;
 private PriorityQueue<Node> pq;
 private Set<Integer> settled;
 
 _Dijkstra_ShortestPath(int V){
	 this.V = V;
	 distance = new int[V];
	 this.adj = new ArrayList<>();
	 this.pq = new PriorityQueue<Node>(V, new Node());
	 this.settled = new HashSet<>();
 }
 
 class Node implements Comparator<Node>{
	 
	 private int node, cost;
	 
	 Node(){}
	 
	 Node(int node, int cost){
		 this.node = node;
		 this.cost = cost;
	 }
	 
	 /*
	  * sort in the descending order of weights i.e 
	  * greatest weight at index-0 and least weight
	  * at index-n
	  */
	 @Override
	 public int compare(Node a, Node b) {
		 if(a.cost<b.cost)
			 return -1;
		 else if(a.cost>b.cost)
			 return 1;
		 else
			 return 0;
	 }
	 
	 @Override
	 public String toString() {
		 return "-> "+this.node+" @ cost: "+this.cost;
	 }
	 
 }
 
 public void dijkstra(List<List<Node>> adj, int source) {
	 this.adj = adj;
	 
	//initially setting all the nodes to Integer.MAX for this source
	 for(int i=0;i<this.V;i++)
		 this.distance[i] = Integer.MAX_VALUE;
	 
	 this.distance[source] = 0; // distance to self is always 0
	 this.pq.add(new Node(source, 0)); // distance to self is always 0
	 
	 while(this.settled.size()<this.V) {
		 if(pq.isEmpty())
			 return;
		 
		 int u = pq.poll().node;
		 
		 if(settled.contains(u))
			 continue;
		 
		 settled.add(u);
		 addNeighbor(u);
		 
	 }
	 
	 System.out.println("\n\n"+Arrays.toString(distance));
 }
 
 public void addNeighbor(int u) {
	 int edgeDist = -1;
	 int newDist = -1;
	 
	 System.out.println("----------------------------------------------------");
	 
	 for(int i=0;i<this.adj.get(u).size();i++) {
		 Node v = this.adj.get(u).get(i);
		 
		 if(!this.settled.contains(v.node)) {
			 edgeDist = v.cost;
			 newDist = this.distance[u]+edgeDist;
			 System.out.println("edgeDist: "+edgeDist+", distance[u]: "+distance[u]+", newDist: "+newDist);
			 if(newDist< this.distance[v.node]) 
				 this.distance[v.node] = newDist;
			 this.pq.add(new Node(v.node, this.distance[v.node]));
			 printPQ();
		 }
	 }
	 
 }
 
 public void printPQ() {
	 System.out.println("\n\n");
	 for(Node node: this.pq)
		 System.out.println(node);
 }
	public static void main(String[] args) {
		int V = 5;
		
		List<List<Node>> adjList = new ArrayList<>();
		_Dijkstra_ShortestPath obj = new _Dijkstra_ShortestPath(V);
		
		
		for(int i=0;i<V;i++)
			adjList.add(new ArrayList<Node>());
		
		adjList.get(0).add(obj.new Node(1, 9));
		adjList.get(0).add(obj.new Node(2, 6));
		adjList.get(0).add(obj.new Node(3, 5));
		adjList.get(0).add(obj.new Node(4, 3));
		
		adjList.get(2).add(obj.new Node(1, 2));
		adjList.get(2).add(obj.new Node(3, 4));
		
		obj.dijkstra(adjList, 0);
		

	}

}
