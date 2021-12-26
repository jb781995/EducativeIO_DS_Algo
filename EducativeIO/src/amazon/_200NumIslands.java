package amazon;
/*
 * https://leetcode.com/problems/number-of-islands/
 * solution: https://leetcode.com/problems/number-of-islands/solution/
 */
public class _200NumIslands {

	private static int numIslands = Integer.MAX_VALUE;
    private char[][] board;
    private int rowNum=0;
    private int colNum=0;
    private boolean flag = false;
    
    public int getFood(char[][] grid) {
       this.board = grid;
       this.rowNum = grid.length;
       this.colNum = grid[0].length;
        
        backtrack(0, 0, 0);
        
        return numIslands==Integer.MAX_VALUE?-1: numIslands;
        
    }
    
    public void backtrack(int row, int col, int island){
       
    	numIslands = island;
        int[] rows= {0, 1, -1, 0};
        int[] cols= {1, 0, 0, -1};
        this.board[row][col]='X';
        for(int i=0;i<4;i++){
            int r=row+ rows[i];
            int c=col+ cols[i];
            if(r<0 || r>=this.rowNum || c<0 || c>=this.colNum)
               continue; 
            if(this.board[r][c]=='X')
            	continue;
            backtrack(r, c, island);
                
            }
        this.board[row][col] = '0';
    }
	public static void main(String[] args) {
		char[][] grid = {
				{'X','X', 'X', 'X'},
				{'X', '*', '0', 'X'},
				{'X', '0', '0', 'X'},
				{'X', '#', '0', 'X'}
		};

		System.out.println("min steps to get food:\n"+new _200NumIslands().getFood(grid));
	}


}
