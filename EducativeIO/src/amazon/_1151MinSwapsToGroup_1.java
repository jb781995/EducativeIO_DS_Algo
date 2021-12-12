package amazon;
/*
 * https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together/solution/
 * Time complexity: two for loops. Each O(n). So, O(n)+ O(n) = O(n)
 * Space complexity: No extra memory. So, O(1)
 */ 
public class _1151MinSwapsToGroup_1 {
	
 public int minSwaps(int [] binaryArr) {
	 // window size = number of 1s in the binary array
	 int winSize = 0;
	 for(int i: binaryArr)
		 winSize+=i; // since array consist of only 1s and 0s, adding each element
	 				//would give us the total number of 1s
	 
	 int currentOnesInWindow = 0;
	 int maxOnesInWindow = 0;
	 int L=0, R=0;
	 for(int i=0;i<binaryArr.length;i++) {
		 R=i;
		 currentOnesInWindow+=binaryArr[R];
		 if(i>=winSize) {
			 currentOnesInWindow-= binaryArr[L++];
		 }
		 maxOnesInWindow =  Math.max(currentOnesInWindow, maxOnesInWindow);
	 }
	 
	 return winSize-maxOnesInWindow;
 }
	public static void main(String[] args) {
		int [] binaryArr = {1,0,1,0,1,0,0,1,1,0,1};
		System.out.println("number of swaps:\n"+new _1151MinSwapsToGroup_1().minSwaps(binaryArr));

	}

}
