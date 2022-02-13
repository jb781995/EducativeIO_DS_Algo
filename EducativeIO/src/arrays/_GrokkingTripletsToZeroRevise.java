package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _GrokkingTripletsToZeroRevise {
 public List<List<Integer>> triplets(int [] arr){
	 if(arr.length<3)
		 return null;
	 
	 Arrays.parallelSort(arr);
	 List<List<Integer>> result = new ArrayList<List<Integer>>();
	 for(int i=0;i<arr.length-2;i++) {
		 createPairs(arr, -arr[i], i+1, result);
	 }
	 return result;
 }
 public void createPairs(int[] arr, int target, int j, List<List<Integer>> result) {
	 int end = arr.length;
	 while(j<end) {
		 int sum = arr[j] + arr[end];
		 if(sum==target) {
			 result.add(Arrays.asList(-target, arr[j], arr[end]));
			 j++;
			 end--;
		 }else if(target<sum)
			 end--;
		 else
			 j++;
	 }
 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
