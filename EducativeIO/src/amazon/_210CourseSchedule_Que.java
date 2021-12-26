package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/*
 * https://leetcode.com/problems/course-schedule-ii/solution/
 */
public class _210CourseSchedule_Que {
	
	 private HashMap<Integer, List<Integer>> adj;
	 private int [] indegree;
	 private int [] order;
	 
	 public int[] courseOrder(int [][] courses) {
		 if(courses.length==0)
			 return new int[0];
		 int n = courses.length;
		 Queue<Integer> q = new LinkedList<>();
		 this.indegree = new int[n];
		 this.adj = new HashMap<>();
		 this.order = new int[n];
		 for(int i=0;i<n;i++) {
			 int mandatory = courses[i][1];
		    	int thisCourse = courses[i][0];
		    	List<Integer> list = adj.getOrDefault(mandatory, new ArrayList<Integer>());
		    	list.add(thisCourse);
		    	adj.put(mandatory, list);
			 this.indegree[thisCourse]++;
		 }
		 System.out.println(adj+", indegree: "+Arrays.toString(indegree));
		 
		 for(int i=0;i<n;i++) 
			 if(this.indegree[i]==0)
				 q.add(i);
		 
		 int i=0;
		 while(!q.isEmpty()) {
			 int node = q.remove();
			 System.out.println(node);
			 this.order[i++] = node;
			 if(this.adj.containsKey(node)) {
				 for(int neighbor : this.adj.get(node)) {
					 if(this.indegree[neighbor]==0)
						 q.add(neighbor);
					 else {
						 this.indegree[neighbor]--;
					 }
				 }
			 }
		 }
		 
		 if(i>0)
			 return this.order;
		 return new int[0];
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
		
		
		System.out.println("\n\ncourses order:\n"+Arrays.toString(new _210CourseSchedule_Que().courseOrder(courses)));

	}

}
