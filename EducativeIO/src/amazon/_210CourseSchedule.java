package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 * https://leetcode.com/problems/course-schedule-ii/solution/
 */
public class _210CourseSchedule {
	
 private HashMap<Integer, List<Integer>> adj;
 private int [] visited;
 private boolean possible = true;
 private int [] order;
 private List<Integer> courseOrder;
 private int WHITE = 0;
 private int GREY = 1;
 private int BLACK = 2;
 
 public void backtrack(int course) {
	 
	 if(this.possible==false)
		  return;
	 this.visited[course] = GREY;
	 
	 for(int neighbor : this.adj.getOrDefault(course, new ArrayList<>())) {
		 if(visited[neighbor]==this.WHITE)
			 backtrack(neighbor);
		 else if( this.visited[neighbor]== GREY){
			this.possible = false;
			 }
	 }
	 
	 this.visited[course] = BLACK;
	 this.courseOrder.add(course);
 }
	public int [] courseOrder(int [][] courses) {
		if(courses.length==0)
			 return new int[0];
		int n=courses.length;
		
	    this.adj = new HashMap<>();
	    this.visited = new int[n];
	    this.courseOrder = new ArrayList<>();
	    
	    for(int i=0;i<n;i++) {
	    	int mandatory = courses[i][1];
	    	int thisCourse = courses[i][0];
	    	List<Integer> list = adj.getOrDefault(mandatory, new ArrayList<Integer>());
	    	list.add(thisCourse);
	    	adj.put(mandatory, list);
	    	this.visited[i] = WHITE;
	    }
	    
	    for(int i=0;i<n;i++) {
	    	if(this.visited[i]==WHITE)
	    		backtrack(i);
	    }
	    
	    
	    	if(this.possible) {
	    		this.order = new int[n];
	    		for(int i=0;i<n;i++)
	    			this.order[i] = this.courseOrder.get(n-i-1);
	    	}
	    	else
	    	this.order = new int[0];
	    
	   return order;
	}
	public static void main(String[] args) {
		int [][] courses= {
				{2, 1},
				{3, 2},
				{1, 4},
				{5, 4},
				{4, 6},
				{5, 6}
		};
		
		System.out.println("course order:\n"+Arrays.toString(new _210CourseSchedule().courseOrder(courses)));
	}

	
}
