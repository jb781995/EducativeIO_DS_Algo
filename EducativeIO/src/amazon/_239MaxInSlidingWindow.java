package amazon;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

/*
 * https://leetcode.com/problems/sliding-window-maximum/discuss/1634889/Using-ArrayDeque-in-Java-O(n)-with-comments
 */
public class _239MaxInSlidingWindow {
 public int [] maxInSlidingWindow(int [] arr, int k) {
	 int n = arr.length;
	 if(n*k==0)
		 return new int[0];
	 
	 Deque<Integer> dq = new ArrayDeque<Integer>();
	 int[] result = new int [n-k+1];
	 
	 for(int i=0;i<n;i++) {
		 while(!dq.isEmpty() && dq.peekFirst()<= i-k)
			 dq.pollFirst();
		 
		 while(!dq.isEmpty() && arr[i]>arr[dq.peekLast()])
			 dq.pollLast();
		 
		 dq.addLast(i);
		 
		 if(i>=k-1)
			 result[i] = arr[dq.peekFirst()];
	 }
	 return result;
 }
	public static void main(String[] args) {
		int[] arr= {1, 3, -1, -3, 5, 3, 6, 7};
		
		System.out.println("\n\n"+Arrays.toString(new _239MaxInSlidingWindow().maxInSlidingWindow(arr, 3)));
		
		new ArrayList<Integer>().add(6);

	}

}
