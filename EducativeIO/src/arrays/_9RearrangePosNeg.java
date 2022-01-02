package arrays;

import java.util.Arrays;

/*
 * https://www.educative.io/module/lesson/data-structures-in-java/3YK5yDgGkMA
 */
public class _9RearrangePosNeg {
 public static void rearrange(int[] arr) {
	 int j=0;
	 int n= arr.length;
	 int i=0;
	 while(i<n) {
		 if(arr[i]<0 && i!=j) {
			 int temp = arr[j];
			 arr[j] = arr[i];
			 arr[i]=temp;
			 j++;
		 }
		 i++;
	 }
	 System.out.println("rearranged: "+Arrays.toString(arr));
 }
 
 public static int[] rearrange2(int [] arr) {
	 int n= arr.length;
	 int i=0;
	 int j=i+1;
	 while(j<n) {
		 if(arr[j]<0) {
			 int temp = arr[j];
			 arr[j] = arr[i];
			 arr[i] = temp;
			 i++;
		 }
		 j++;
	 }
	 return arr;
 }
	public static void main(String[] args) {
		int [] arr= {2, 4, -6, 8, -5, -10};
		rearrange(arr);
		System.out.println("\n\n"+Arrays.toString(rearrange2(arr)));
       
	}

}
