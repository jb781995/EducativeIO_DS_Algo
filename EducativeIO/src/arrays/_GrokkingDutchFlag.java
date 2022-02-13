package arrays;

import java.util.Arrays;

/*
 * https://www.educative.io/courses/grokking-the-coding-interview/RMBxV6jz6Q0
 */
public class _GrokkingDutchFlag {

	public void flag(int[] arr) {
		int low=0, high=arr.length-1, i=0;
		while(i<high){
	     if(arr[i]==0) {
	    	 swap(arr, i, low);
	    	 System.out.println("0 swpped "+Arrays.toString(arr));
	    	 i++;
	    	 low++;
	     }
	     else if(arr[i]==1)
	    	 i++;
	     else if(arr[i]==2) {
	    	 swap(arr, i, high);
	    	 System.out.println("2 swpped "+Arrays.toString(arr));
	    	 high--;
	     }
	    	 
		}
		
		System.out.println("\n\nresult: "+Arrays.toString(arr));
	}
	public void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static void main(String[] args) {
		int [] arr = {0, 1, 2, 1, 0, 1, 0};
		//output: 0, 0, 0, 1, 1, 1, 2
		
		_GrokkingDutchFlag obj = new _GrokkingDutchFlag();
		obj.flag(arr);
	}

}
