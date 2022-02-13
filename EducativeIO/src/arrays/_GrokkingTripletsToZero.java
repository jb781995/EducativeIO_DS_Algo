package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 * https://www.educative.io/courses/grokking-the-coding-interview/gxk639mrr5r
 */
public class _GrokkingTripletsToZero {
	
	public static List<List<Integer>> searchTriplets(int[] arr) {
	    Arrays.sort(arr);
	    System.out.println(Arrays.toString(arr)+"\n\n");
	    List<List<Integer>> triplets = new ArrayList<>();
	    for (int i = 0; i < arr.length - 2; i++) {
	      if (i > 0 && arr[i] == arr[i - 1]) { 
	    	  // skip same element to avoid duplicate triplets
	    	  System.out.println("...skipping: "+arr[i]);
	        continue;
	      }
	      System.out.println("\n\nconsider: "+arr[i]);
	      searchPair(arr, -arr[i], i + 1, triplets);
	    }

	    return triplets;
	  }

	  private static void searchPair(int[] arr, int targetSum, int left, List<List<Integer>> triplets) {
	    int right = arr.length - 1;
	    System.out.println("targetSum: "+targetSum);
	    while (left < right) {
	      int currentSum = arr[left] + arr[right];
	      if (currentSum == targetSum) { // found the triplet
	        triplets.add(Arrays.asList(-targetSum, arr[left], arr[right]));
	        System.out.println("found triplet at "+left+", "+right);
	        left++;
	        right--;
	        while (left < right && arr[left] == arr[left - 1])
	          left++; // skip same element to avoid duplicate triplets
	        while (left < right && arr[right] == arr[right + 1])
	          right--; // skip same element to avoid duplicate triplets
	      } else if (targetSum > currentSum)
	        left++; // we need a pair with a bigger sum
	      else
	        right--; // we need a pair with a smaller sum
	    }
	  }
	public static void main(String[] args) {
		int [] arr = {-3, 0, 1, 2, -1, 1, -2};
		
		_GrokkingTripletsToZero obj = new _GrokkingTripletsToZero();
		obj.searchTriplets(arr);

	}

}
