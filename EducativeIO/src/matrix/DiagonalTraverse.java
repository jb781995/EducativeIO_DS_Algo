package matrix;
/*
 * https://leetcode.com/problems/diagonal-traverse/solution/
 */
public class DiagonalTraverse {
	public static void printDiagonal(int [][] mat) {
		
		int i=0, j=0;
		int m = mat.length;
		int n = mat[0].length;
		
		boolean turn = false;
		while(i<m || j<n) {
			if(!turn) {
				do {
					System.out.print(mat[i--][j++]+" ");
				}while(i>=0);
				turn = true;
				System.out.println("   [i="+i+", j="+j+"]");
				i++;
				//i = (i==mat.length)?i--:i++;
				}
			else {
				do {
					System.out.print(mat[i++][j--]+" ");
				}while(j>=0);
				turn = false;
				System.out.println("   [i="+i+", j="+j+"]");
				j++;
				//j = (j==mat[0].length)?j--:j++;
				}
			 
		}
	}
		public static void main(String[] args) {
			int [][] grid =  {
	                {1, 2, 3, 4},
	                {5, 6, 7, 8},
	                {9, 10, 11, 12},
	                {13, 14, 15, 16}
	                 };
			
			printDiagonal(grid);

		}

}
