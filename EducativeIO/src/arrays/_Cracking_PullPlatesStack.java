package arrays;

import java.util.Arrays;
import java.util.Stack;

public class _Cracking_PullPlatesStack {
 public void pullPlates(int pos, int end, int space, int [] plates) {
	 while(pos<end) {
			plates[pos] = plates[pos+1];
			System.out.println(Arrays.toString(plates));
			pos++;
		}
		space++;
		while(space>0) {
			plates[end] = 0;
			end--;
			space--;
		}
		System.out.println("\n\n"+Arrays.toString(plates));
		
 }
 
	public static void main(String[] args) {
		int [] plates = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 , 13, 14, 15};
		
		int pos = 5;
		int space = 0;
		int end = plates.length-1;
		
		System.out.println(Arrays.toString(plates)+"\n\n");
		_Cracking_PullPlatesStack obj = new _Cracking_PullPlatesStack();
		obj.pullPlates(pos, end, space, plates);	
		System.out.println("\n\n");
		obj.pullPlates(3, end, space, plates);
		System.out.println("\n\n");
		obj.pullPlates(9, end, space, plates);
		System.out.println("\n\n");
		obj.pullPlates(9, end, space, plates);
		
		int x = 5;
		int y= 3;
		
		System.out.println("\n\n");
		for(int i=2; i<4;i++)
			if(x!=i && (x<y || (y<x)))
				System.out.println("chuttad");
		
		String s="3";
		int x1 = 4;
		int y1=6;
		s+="+"+x1+"+"+y1;
		
		StringBuffer sb = new StringBuffer();
		sb.append(s);
		sb.append("+");
		sb.append(x1);
		sb.append("+");
		sb.append(y1);
		System.out.println("\n\n"+s+", "+sb);
		

	}

}
