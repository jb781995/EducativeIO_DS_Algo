package arrays;

import java.util.Arrays;
import java.util.PriorityQueue;
/*
 * There is a list of sprints and a total number of markers given. The sprints 
 * represent the end point of the markers that are to be traveled from one point 
 * to the next
	{2, 4, 1, 3}
	first we travel 2->4: 2, 3, 4
	next, 4->1: 4, 3, 2, 1
	next, 1->3: 1, 2, 3

The output should be the marker that is visited the maximum time and is the least among them
So, markers 2 and 3 are visited thrice and marker 2 being the least. So, the answer is 2

 */
public class _JohnDeere_SprintMarkers {

	public int markersVisitedMost(int[] markers) {
		int n = markers.length;
		int[] markersVisited = new int[n+1];
		int max = Integer.MIN_VALUE;
		
		int idx = 0;
		int i=0, j=i+1;
		while(j<n) {
			int start = markers[i]<markers[j]?markers[i]:markers[j];
			int end = markers[i]>markers[j]?markers[i]:markers[j];
			
			System.out.println("  start: "+start+", end: "+end);
			for(int m=start;m<=end;m++) { 
				markersVisited[m]=1+markersVisited[m];
				max = max>markersVisited[m]? max: markersVisited[m];
			}
			i++;j++;
			}
		
		System.out.println("marker status: "+Arrays.toString(markersVisited));
		for(int k=0;k<markersVisited.length;k++)
			if(markersVisited[k]==max)
				return k;
		
		return idx;
		
		
	}
	public static void main(String[] args) {
		//{2, 1, 3, 4}
		// {5, 2, 1, 4, 3}
		int [] markers  = {2, 4, 1, 3};
		_JohnDeere_SprintMarkers obj = new _JohnDeere_SprintMarkers();
		
		System.out.println("\n\nMost visited Marker: "+obj.markersVisitedMost(markers));
		
		

	}

}
