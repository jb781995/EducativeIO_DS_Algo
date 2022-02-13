package amazon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
 * https://leetcode.com/problems/meeting-rooms-ii/
 */
public class _253MeetingRooms {
 class Times implements Comparator<Times>{
	 int start;
	 int end;
	 Times(){}
	 Times(int start, int end){
		 this.start = start;
		 this.end = end;
	 }
	 public int getStart() {
		return start;
	}
	 public int getEnd() {
		return end;
	}

	 @Override
	 public int compare(Times start, Times end) {
//		 if(start.getStart()>end.getEnd())
//			 return 1;
//		 else if(start.getStart()<end.getEnd())
//			 return -1;
//		 else
//			 return 0;
		 return start.getStart()-end.getEnd();
	 }
	 
	 @Override
	 public String toString() {
		 return "["+this.getStart()+", "+this.getEnd()+"]";
	 }
 }
 
 public void timeObjs(int [][] time) {
	 // we will sort Times object based on greater start time
	 PriorityQueue<Times> queue = new PriorityQueue<>(new Times());
	 
	 for(int i=0;i<time.length;i++) {
		 queue.add(new Times(time[i][0], time[i][1]));
		 //System.out.println(queue.peek());
	 }
	 
	 List<Times> times  = new ArrayList<>();
	 for(Times t: queue)
		 System.out.println(t);
	 
	 System.out.println("\n\n"+times+"\n\n");
	 //int rooms =time.length>0?1:0;
	 int rooms=0;
	 for(int i=1;i<times.size();i++) {
		 if(times.get(i).getStart()<times.get(i-1).getEnd())
			 rooms++;
	 }
	 
	 System.out.println("number of rooms required: "+rooms);
 }
 
 public static void main(String[] a) {
	 int [][] meetings = {
			 {0, 30},
			 {5, 10},
			 {15, 20}
	 };
	 
	 int [][] meetings2 = {
			 {7, 10},
			 {2, 4}
	 };
	 int [][] times = {
				{1, 10},
				{2, 7},
				{3, 19},
				{8, 12},
				{10, 20},
				{11, 30}
		};
	 
	new _253MeetingRooms().timeObjs(times); 
 }
}
