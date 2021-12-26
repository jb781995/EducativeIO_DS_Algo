package amazon;
/*
 * https://leetcode.com/problems/rotting-oranges/
 */
public class _994RottingOranges {
	
	private int[][] mat;
	private int rowLen, colLen;
	private int minutes;
	
 public void rottingOranges(int [][] mat) {
	 this.mat = mat;
	 this.rowLen = mat.length;
	 this.colLen = mat[0].length;
	 int r=0,c=0;
	 
	 // the first occurrence of 2 is enough to begin the traversal
	 for(int i=0;i<rowLen;i++)
		 for(int j=0;j<colLen;j++)
			 if(mat[i][j]==2) {
				 r=i;
				 c=j;
				 break;
			 }
	 
	 backtrack(r, c, 0);
	 System.out.println("In "+this.minutes+" minutes..");
 }
 
 public void backtrack(int r, int c, int minutes) {
	 
	 System.out.println("       ("+r+", "+c+") : mins "+minutes);
	 this.minutes = Math.max(this.minutes,minutes);
	 minutes++;
	 int [] r_dir = {-1, 0, 1, 0};
	 int [] c_dir = {0, 1, 0, -1};
	 int val = this.mat[r][c];
	 
	 this.mat[r][c] = 0;
	 for(int i=0;i<4;i++) {
		 int row = r+r_dir[i];
		 int col = c+c_dir[i];
		 if(row<0 || row>=this.rowLen || col<0 || col>=this.colLen)
			 continue;
		 if(this.mat[row][col]!=0) {
		     backtrack(row, col,minutes);
		 }
	 }
	 
	 this.mat[r][c] = val;
	
 }
	public static void main(String[] args) {
		int[][] basket = {
				{0, 1, 1},
				{1, 2, 0},
				{0, 1, 1}
		};
		
		new _994RottingOranges().rottingOranges(basket);

	}

}
