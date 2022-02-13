package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * educative.io/courses/grokking-the-coding-interview/RMV1GV1yPYz
 */
public class _GrokkingProductLessThanTarget {
	
 public List<List<Integer>> pairs(int[] arr, int target){
	 if(arr.length<1)
		 return null;
	 //Arrays.sort(arr);
	 List<List<Integer>> result = new ArrayList<List<Integer>>();
	 
	 for(int i=0;i<arr.length;i++) {
		 if(arr[i]<target) {
			 result.add(Arrays.asList(arr[i]));
			 int product= arr[i];
			 createPairs(arr, product, target, i+1, result);
		 }
	 }
	 return result;
 }
 
 public void createPairs(int[] arr, int product, int target, int j, List<List<Integer>> result) {
	 int end = arr.length;
	 ArrayList<Integer> elements = new ArrayList<Integer>();
	 elements.add(arr[j-1]);
	 System.out.println("\n\n");
	 while(j<end) {
		 product*= arr[j];
		 System.out.println(""+product+" with "+arr[j]);
		 if(product<target) {
			 elements.add(arr[j]);
			 result.add(elements);
		}
		 else {
			 product/=arr[j];
		 }
		 j++;
	 }
 }
	public static void main(String[] args) {
		// [2, 5, 3, 10] - > [2, 3, 5, 10]
   int[] arr = {2, 5, 3, 10};
   int[] arr2 = {8, 2, 6, 5};
   _GrokkingProductLessThanTarget obj = new _GrokkingProductLessThanTarget();
   
   System.out.println(""+obj.pairs(arr2, 50));
   
	}

}
