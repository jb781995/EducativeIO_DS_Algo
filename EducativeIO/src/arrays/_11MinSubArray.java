package arrays;
/*
 * https://www.educative.io/module/lesson/data-structures-in-java/B6x1y023VOk
 */
public class _11MinSubArray {
	
 public int minSubArray(int [] arr) {
	 int n = arr.length;
	 int min_here = Integer.MAX_VALUE;
	 int result = Integer.MAX_VALUE;
	 for(int i=0;i<n;i++) {
		 if(min_here>0)
			 min_here=arr[i];
		 else
			 min_here+=arr[i];
		 result = Math.min(min_here, result);
	 }
	 return result;
 }
 
 public int maxSubArray(int[] arr) {
	 int result=Integer.MIN_VALUE;
	 int max_here= Integer.MIN_VALUE;
	 int n= arr.length;
	 
	 for(int i=0;i<n;i++) {
		 if(max_here<0)
			 max_here = arr[i];
		 else
			 max_here+=arr[i];
		 result = Math.max(max_here, result);
	 }
	 return result;
 }
	public static void main(String[] args) {
		int [] arr= {3, -4, 2, -3, -1, 7, -5};
		System.out.println("min sub array sum: "+new _11MinSubArray().minSubArray(arr));
		System.out.println("max sub array sum: "+new _11MinSubArray().maxSubArray(arr));

	}

}
