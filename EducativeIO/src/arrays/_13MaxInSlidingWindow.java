package arrays;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/*
 * https://www.educative.io/module/lesson/data-structures-in-java/3YQDLBARYl9
 */
public class _13MaxInSlidingWindow {

	public ArrayDeque<Integer> fun(int[] arr, int win){
		ArrayDeque<Integer> result = new ArrayDeque<Integer>();
		Deque<Integer> list = new LinkedList<>();
		
		for(int i=0;i<win;i++) {
			while(!list.isEmpty() && arr[i]>= arr[list.peekLast()]) {
				System.out.println("  because "+arr[i]+" > "+arr[list.peekLast()]);
				list.removeLast();
			}
			list.add(i);
		}
		System.out.println("*********** basic iteration 0-window over ***********");
		
		int n= arr.length;
		for(int i=win;i<n;i++) {
			result.add(arr[list.peek()]);
			System.out.println("result until now: "+result);
			while(!list.isEmpty() && list.peek() <= i-win) {
				System.out.println("--1 because "+list.peek()+" < "+(i-win));
				list.removeFirst();
			}
			
			while(!list.isEmpty() && arr[i]>=arr[list.peekLast()]) {
				System.out.println("--2 because "+arr[i]+" > "+arr[list.peekLast()]);
				list.removeLast();
			}
			list.add(i);
		}
		return result;
	}
	public static void main(String[] args) {

		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int [] arr2 = {10, 6, 9, -3, 23, -1, 34, 56, 67, -1, -4, -8, -2, 9, 10, 34, 67};
		int win = 3;
		new _13MaxInSlidingWindow().fun(arr2, win);

	}

}
