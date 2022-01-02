package arrays;

import java.util.Arrays;

/*
 * https://www.educative.io/module/lesson/data-structures-in-java/3jo4DJ5R1pR
 */
public class _4ArrProdExceptItself {
	public static int[] findProduct(int arr[])  
	  {
		int n= arr.length;
		int[] result = new int[n];
		int temp=1;
		
		for(int i=0;i<n;i++) {
			result[i]= temp;
			temp*=arr[i];
		}
		System.out.println("left to right pass: "+Arrays.toString(result));
		temp=1;
		for(int i=n-1;i>=0;i--) {
			result[i]*=temp;
			temp*=arr[i];
		}
		System.out.println("\nright to left pass: "+Arrays.toString(result));
		
		return result;
	  }
	
	// I revised the code a bit
	public static int[] findProduct2(int [] arr) {
		int n= arr.length;
		int[] result = new int[n];
		
		result[0] = 1;
		
		// this function was revised
		for(int i=1;i<n;i++)
			result[i] = arr[i-1]*result[i-1];
		
		System.out.println("left to right pass: "+Arrays.toString(result));
		
		int temp=1;
		for(int i=n-1; i>=0;i--) {
			result[i]*=temp;
			temp*=arr[i];
		}
		
		return result;
	}
	public static void main(String[] args) {
		int [] arr = {1, 2, 3, 4};
		int [] arr2 = {5, 6, 7, 8};
		int [] arr3 = {-1, 2, -3, 4, -5};
		System.out.println("result: "+Arrays.toString(findProduct(arr)));
	}

}
