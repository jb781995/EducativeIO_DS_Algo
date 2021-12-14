package amazon;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/trapping-rain-water/
 * solution: https://leetcode.com/problems/trapping-rain-water/discuss/1622422/Simple-Java-O(n)-time-solution
 */
public class _42TrappingRainWater {
	
 public int trapRainWater(int[] height) {
	 int sum=0;
	 // pockets cannot be formed unless the array
	 // minimum length of 3
	 if(height.length<3)
		 return -1;
	 
	 int leftMax = 0;
	 int rightMax = 0;
	 
	 int[] right = new int [height.length];
	 int [] left = new int [height.length];
	 
	 for(int i=0;i<height.length;i++) {
		 if(height[i]>leftMax)
			 leftMax = height[i];
		 left[i] = leftMax;
	 }
	 System.out.println(Arrays.toString(left));
	 
	 for(int i=height.length-1; i>=0;i--) {
		 if(height[i]>rightMax)
			 rightMax =height[i];
		 right[i] = rightMax;
	 }
	 System.out.println(Arrays.toString(right));
	 System.out.println(Arrays.toString(height));
	 
	 // there's a small error in the code written in the solution. They've 
	 // written Math.min(leftMax, rightMax)-height[i]. This is incorrect. 
	 // the below gives correct answer
	 for(int i=0;i<height.length;i++) {
		 int water = Math.min(left[i], right[i]) - height[i];
		 System.out.print(water+", ");
		 sum+=water;
	 }
	 return sum;
 }
	public static void main(String[] args) {
		int [] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		
		System.out.println("\nmax water trapped:\n"+new _42TrappingRainWater().trapRainWater(height));

	}

}
