package amazon;

import java.util.Arrays;
import java.util.List;

public class _295MedianFinder {

	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(1,2, 3);
		int size = nums.size();
		
		if(size>1 && size%2==0) {
			double i = (double)(nums.get(size/2-1)+nums.get(size/2))/2;
			System.out.println("if "+i);
			}
		else {
			double j = nums.get(size/2);
			System.out.println("else "+j);
		}
			
	}

}
