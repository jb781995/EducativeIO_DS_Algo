package amazon;
/*
 * https://leetcode.com/problems/shortest-path-to-get-food/
 * solution: https://leetcode.com/problems/shortest-path-to-get-food/discuss/1579099/Java-BFS-Easy-to-Follow
 */
public class _1730ShortPathToFood {
	private static int minSteps = Integer.MAX_VALUE;
    private char[][] board;
    private int rowNum=0;
    private int colNum=0;
    private boolean flag = false;
    
    public int getFood(char[][] grid) {
       this.board = grid;
       this.rowNum = grid.length;
       this.colNum = grid[0].length;
        
        int r = 0;
        int c = 0;
        for(int i=0;i<rowNum;i++)
            for(int j=0;j<colNum;j++)
                if(grid[i][j]=='*'){
                    r = i;
                    c = j;
                    break;
                }
  
        System.out.println("start point at:["+r+", "+c+"]");
        backtrack(r, c, 0);
        
        return minSteps==Integer.MAX_VALUE?-1: minSteps;
        
    }
    
   // int counter is # steps walked so far to reach this cell i.e row, col
    public void backtrack(int row, int col, int counter){
        if(this.board[row][col]=='0'){
        	//this.board[row][col] = 'X';
        	System.out.println(" valid step at:["+row+", "+col+"]");
            counter++;
        }
        else if(this.board[row][col]=='#'){
        	System.out.println("     found food at: ["+row+", "+col+"]. STEPS: "+counter);
            counter++;
            this.flag= true;
            minSteps = Math.min(counter, minSteps);
            return;
        }
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
            backtrack(r, c, counter);
                
            }
        this.board[row][col] = '0';
    }
	public static void main(String[] args) {
		char[][] grid = {
				{'X','X', 'X', 'X'},
				{'X', '*', '0', 'X'},
				{'#', '0', '0', '#'},
				{'X', '0', '0', 'X'},
				{'X', '0', '0', 'X'},
				{'X', '#', '0', 'X'},
				{'X', '0', '0', 'X'}
				
		};

		System.out.println("min steps to get food:\n"+new _1730ShortPathToFood().getFood(grid));
	}

}
