package matrix;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/matrix-block-sum/
 */
public class BlockSum {
	 public int[][] matrixBlockSum(int[][] mat, int k) {
		 int [][] result = new int[mat.length][mat[0].length];
		 int n= mat.length;
		 int m = mat[0].length;
		 
		 for(int i=0;i<n;i++) {
			 int r1 = i-k;
			 int r2 = i+k;
			 r1 = returnGoodIdx(r1, r2, n);
			 r2 = returnGoodIdx(r2, r2, n);
			 for(int j=0;j<m;j++) {
				 int c1 = j-k;
				 int c2 = j+k;
				 c1 = returnGoodIdx(c1, c2, m);
				 c2 = returnGoodIdx(c2, c2, m);
				 System.out.println("good idx: "+r1+", "+c1+" to "+r2+", "+c2+"\n\n");
				 
				 for(int a=r2;a>=r1;a--) {
					 if(a<0) {
						 a++;
						 continue;
					 }
					 for(int b=c2;b>=c1;b--) {
						 if(b<0) {
							 b++;
							 continue;
						 }
						 System.out.print("add? ");
						 result[i][j]+=mat[a][b];
						 System.out.println(result[i][j]);
					 }
				 }
				 System.out.println("result until now: "+Arrays.deepToString(result)); 
				 }
			
			 }
		 
		 return result;
	 }
	 
	 public int returnGoodIdx(int l, int n, int limit) {
		 int idx = l;
		 if(idx<0) {
			 while(idx<0 && idx<limit)
				 idx++;
		 }
		 else if(idx > n && idx >=limit) {
			 while(idx>n && idx< limit)
				 idx--;
		 }
		 return idx;
	 }
	 
	public static void main(String[] args) {
		int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
		int k = 1;
		System.out.println("result:\n"+Arrays.deepToString(new BlockSum().matrixBlockSum(mat, k)));

	}

}
