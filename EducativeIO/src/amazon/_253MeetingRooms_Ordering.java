package amazon;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class _253MeetingRooms_Ordering {

	public int meetingRooms(int [][] times) {
		Integer[] start = new Integer[times.length];
		Integer[] end = new Integer[times.length];
		
		for(int i=0;i<times.length;i++) {
			start[i] = times[i][0];
			end[i] = times[i][1];
			}
		
		Arrays.sort(start, new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				return a-b;
			}
		});
		
		Arrays.sort(end, new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				return a-b;
			}
		});
		
		int meetingRooms=0, stp=0, ept=0;
		
		while(stp<times.length) {
			if(start[stp]>end[ept]) {
				meetingRooms-=1;
				ept++;
			}
			stp++;
			meetingRooms++;
		}
		return meetingRooms;
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
		
	}

}
