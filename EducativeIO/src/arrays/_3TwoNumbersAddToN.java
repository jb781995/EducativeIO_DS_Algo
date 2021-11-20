package arrays;

import java.util.Arrays;

public class _3TwoNumbersAddToN {
	public static int[] findSum(int[] arr, int n) 
	  {
	    int[] result = new int[2];
	    int i=0;
	    int j= arr.length-1;
	    Arrays.sort(arr);
	    while(i<j){
	      int sum = arr[i]+arr[j];
	      if(sum>n){
	        System.out.println(sum+">"+n);
	       j--;
	      }
	      else if(sum<n){
	        System.out.println(sum+"<"+n);
	       i++;
	      }
	      else{
	        System.out.println(sum+"=="+n+", arr[i]="+arr[i]+", arr[j]="+arr[j]);
	         result[0]= arr[i];
	         result[1] = arr[j];
	         break;
	       }
	    }
	    return result;   // return the elements in the array whose sum is equal to the value passed as parameter 
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub bbbbb

	}

}
