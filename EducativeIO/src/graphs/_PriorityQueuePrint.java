package graphs;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _PriorityQueuePrint {

	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer a , Integer b) {
			 return a-b;	
			}
		});

		pq.add(1);
		pq.add(100);
		pq.add(20);
		pq.add(-1);
		pq.add(1000);
		
		for(Integer i: pq)
			System.out.print(", "+i);
		
		System.out.println("\npq size: "+pq.size());
		
	}

}
