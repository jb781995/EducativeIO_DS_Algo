package amazon;
/*
 * https://leetcode.com/problems/number-of-islands/
 * solution: https://leetcode.com/problems/number-of-islands/solution/
 */
public class _200NumIslands {
	
    private char[][] board;
    private int rowNum=0;
    private int colNum=0;
    private int numOfIslands = 0;
    
    public int getFood(char[][] grid) {
       this.board = grid;
       this.rowNum = grid.length;
       this.colNum = grid[0].length;
       int r=0, c=0;
       for(int i=0; i<rowNum;i++)
    	   for(int j=0;j<colNum;j++)
    		   if(grid[i][j]=='1') {
    			   r= i;
    			   c= j;
    			   this.numOfIslands++;
    			   backtrack(r, c, numOfIslands);
    		   }
    			   
       return  this.numOfIslands;
        
    }
    
    public void backtrack(int row, int col, int island){
        if(this.board[row][col]=='0')
        	return;
        
    	this.board[row][col]='X';
        int[] rows= {0, 1, -1, 0};
        int[] cols= {1, 0, 0, -1};
        
        for(int i=0;i<4;i++){
            int r=row+ rows[i];
            int c=col+ cols[i];
            if(r<0 || r>=this.rowNum || c<0 || c>=this.colNum || this.board[r][c]=='X')
               continue; 
            backtrack(r, c, island);
                
            }
       
    }
	public static void main(String[] args) {
		char[][] grid = {
				{'1','1', '1', '1'},
				{'1', '0', '0', '1'},
				{'1', '0', '0', '0'},
				{'1', '0', '0', '0'}
		};

		System.out.println("min steps to get food:\n"+new _200NumIslands().getFood(grid));
	}


}
