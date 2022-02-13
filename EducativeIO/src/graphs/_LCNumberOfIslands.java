package graphs;

public class _LCNumberOfIslands {
 public void numberOfIslands(int[][] islands) {
	 int result = 0;
	 
	 for(int i=0;i<islands.length;i++)
		 for(int j=0;j<islands.length;j++) {
			 if(islands[i][j]==1) {
				 result++;
				 helper(islands, i, j);
			 }
		 }
	 System.out.println("number of islands: "+result);
 }
 
 public boolean helper(int[][] islands, int r, int c) {
	 if(r<0 || r>= islands.length || c<0 || c>=islands.length || islands[r][c]==0)
		 return false;
	 islands[r][c] = 0;
	 
	 helper(islands, r+1, c);
	 helper(islands, r, c+1);
	 helper(islands, r, c-1);
	 helper(islands, r-1, c);
	 
	return true;		 
 }
	public static void main(String[] args) {
		int [][] islands = {
				{1, 1, 1},
				{1, 0, 0},
				{1, 0, 1}
		};
		
		_LCNumberOfIslands obj = new  _LCNumberOfIslands();
		obj.numberOfIslands(islands);
	}

}
