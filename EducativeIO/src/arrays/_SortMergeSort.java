package arrays;

import java.util.Arrays;

public class _SortMergeSort {
	
public void merge(int[] arr, int low, int high) {
	if(low<high) {
		int mid = low + (high-low)/2;
		merge(arr, low, mid);
		merge(arr, mid+1, high);
		sort(arr, low, mid, high);
	}
}

public void sort(int [] arr, int low, int mid, int high) {
	int n1 = mid-low+1;
	int n2 = high-mid;
	
	int[] arr1 = new int[n1];
	int[] arr2 = new int[n2];
	
	// whatever the current low is, from there on..
	for(int i=0;i<n1;i++)
		arr1[i] = arr[low+i];
	
	//whatever the current middle is, from there on.. 
	for(int i=0;i<n2;i++)
		arr2[i] = arr[mid+i+1];
	
	int i=0, j=0;
	
	// the array arr has been sorted before, we have to continue from 
	// low which we have got this time, therefore k=low. So sort from
	// there on..
	int k=low;
	while(i<n1 && j<n2) {
		if(arr1[i]<arr2[j]) {
			arr[k] = arr1[i++];
		}
		else if(arr2[j]<arr1[i]) {
			arr[k]=arr[j++];
		}
		k++;
	}
	
	while(i<n1) 
	  	arr[k++] = arr1[i++];
	
	while(j<n2)
		arr[k++]= arr2[n2++];
	
	System.out.println("sorted so far.. "+Arrays.toString(arr));
}
	
public static void main(String[] args) {
		int [] arr = {-1, 110, 0, 59, 2, 6, 1, -30};
		int low =0;
		int high = arr.length-1;
		
		_SortMergeSort obj = new _SortMergeSort();
		obj.merge(arr, low, high);

	}

}
