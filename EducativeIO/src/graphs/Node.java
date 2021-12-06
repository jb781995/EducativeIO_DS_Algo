package graphs;

import java.util.ArrayList;
import java.util.List;

/*
 * A Graph's nodes are different than a LinkedList or Tree's nodes in that it requires two 
 * features: Vertex number, cost. In LL, we don't worry about the node number because 
 * we maintain next and prev pointers and in a BT we maintain left and right pointers.
 * But in Graph everything is about connectivity and the cost one has to pay for choosing a 
 * certain path across the given network. Almost every node could be reached by more than one 
 * path and therefore we need Vertex number and cost between two vertices. In LL, there is no 
 * way but to always begin from the Head. In BT, there's no way but to do a DFS or BFS in order 
 * to reach a node. In both of which cases, unlike Graphs, one has to follow a fixed path.
 */
public class Node {
	
	Node next, prev, head, tail;
	int vertex, cost;
		
	Node(){}
	/*
	 * int vertex is the vertex or node number of the supposed neighbor in the given Graph to which
	 * this Vertex is supposed to be connected with a cost denoted by int cost.
	 */ 
	Node(int vertex, int cost){
		this.cost = cost;
		this.vertex = vertex;
		this.next = null;
	}
	
	Node(int vertex){
		this.vertex = vertex;
	}
	
	public Node getHead() {
		return this.head;
	}
	
	public Node getTail() {
		return this.tail;
	}
	
	
	
	
}
