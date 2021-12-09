package arrays;

import java.util.Arrays;

/*
 * 
 */
public class _10RearrangeMaxMin {
	public static void maxMin(int[] arr) {
      int n = arr.length;
	  int [] aux = new int[n];
	  int i=0, j=n-1;
	  boolean flag=false;
	  int count=0;
	  while(i<=j) {
		  if(flag) {
			  aux[count]=arr[i++];
			  flag= false;
		  }
		  else {
			  aux[count]=arr[j--];
			  flag=true;
		  }
		  count++;
	  }
	  
	  System.out.println("result: "+Arrays.toString(aux));
	  }
	
	public static void maxMin2(int[] arr) {
	    int maxIdx = arr.length - 1;
	    int minIdx = 0;
	    int maxElem = arr[maxIdx] + 1; // store any element that is greater than the maximum element in the array 
	    for( int i = 0; i < arr.length; i++) {
	      // at even indices we will store maximum elements
	      if (i % 2 == 0){  
	        arr[i] += (arr[maxIdx] % maxElem ) * maxElem;
	        System.out.println("-->"+Arrays.toString(arr));
	        maxIdx -= 1;
	      }
	      else { // at odd indices we will store minimum elements
	        arr[i] += (arr[minIdx] % maxElem ) * maxElem;
	        System.out.println("-->"+Arrays.toString(arr));
	        minIdx += 1;
	      }
	    }
	    // dividing with maxElem to get original values.
	    for( int i = 0; i < arr.length; i++) {
	      arr[i] = arr[i] / maxElem;
	    }
	  }

	public static void main(String[] args) {
		// i/p: {1, 2, 3, 4, 5, 6, 7} -- i/p array will be sorted
		// o/p: {7, 1, 6, 2, 5, 3, 4} -- o/p array [highest, smallest, second-highest, second, third-highest, third..]
		int[] arr= {1, 2, 3, 4, 5, 6, 7};
		
		// 7, 6, 5, 4, 3, 2, 1
		maxMin(arr);

	}

}
