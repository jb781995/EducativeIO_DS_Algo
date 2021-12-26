package amazon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _253MeetingRooms_PQ_LC {
	
 public int meetingRooms(int [][] times) {
	 
	 // we will add end-time in this pq and sort in ascending order
	 PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
		 @Override
		 public int compare(Integer a, Integer b) {
			 return a-b;
		 }
	 });
	 
	 // sort times on start time
	 Arrays.sort(times, new Comparator<int[]>() {
		 @Override
		 public int compare(int[] a, int[] b) {
			 return a[0] - b[0];
		 }
	 });
	 for(int i=0;i<times.length;i++)
		 pq.add(times[i][1]);
	 
	 while(!pq.isEmpty())
		 System.out.println(pq.poll());
	 System.out.println("\n");
	 System.out.println("sorted times on start time:\n"+Arrays.deepToString(times));
	 pq.add(times[0][1]);
	 
	 for(int i=1;i<times.length;i++) {
		 
		 if(times[i][0]> pq.peek()) {
			 System.out.println("meeting: "+times[i][0]+", "+times[i][1]+". Start Time: "+times[i][0]+", Peeks:"
				 		+ " "+pq.peek());
				 pq.poll();
		 }
		 
		 System.out.println("adding end time: "+times[i][1]);
		 pq.add(times[i][1]);
	 }
	 
	 return pq.size();
 }
	public static void main(String[] args) {
		int [][] times = {
				{1, 10},
				{2, 7},
				{3, 19},
				{8, 12},
				{10, 20},
				{11, 30}
		};

		System.out.println("\n\nmeeting rooms required:\n"+new _253MeetingRooms_PQ_LC().meetingRooms(times));
	}

}
