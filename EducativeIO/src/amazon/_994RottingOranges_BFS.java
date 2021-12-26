package amazon;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 
 */
public class _994RottingOranges_BFS {
 class Cell{
	 int row;
	 int col;
	 Cell(int row, int col){
		 this.row=row;
		 this.col =col;
	 }
	 int getRow() {
		 return this.row;
	 }
	 int getCol() {
		 return this.col;
	 }
 }
 
 public void rottenOranges(int [][] basket) {
	 int r = basket.length;
	 int c = basket[0].length;
	 
	 Queue<Cell> queue = new LinkedList<>();
	 
	 for(int i=0;i<r;i++)
		 for(int j=0;j<c;j++)
			 if(basket[i][j]==2) {
				 queue.offer(new Cell(i, j));
				 break;
			 }
	 
	 int mins=0;
	 int [] r_dir = {-1, 0, 1, 0};
	 int [] c_dir = {0, 1, 0, -1};
	 
	 while(!queue.isEmpty()) {
		int n = queue.size();
		mins++;
		for(int i=0;i<n;i++) {
			Cell cell = queue.poll();
			int row = cell.getRow();
			int col = cell.getCol();
			for(int dir=0;dir<4;dir++) {
				
				int nextRow = row+r_dir[dir];
				int nextCol = col+c_dir[dir];
				if(nextRow>=0 && nextRow<r && nextCol>=0 && nextCol<c && basket[nextRow][nextCol]!=0) {
					queue.offer(new Cell(nextRow, nextCol));
					basket[nextRow][nextCol]=0;
				}
			}
		}
	 }
	 
	 System.out.println("after "+mins+" mins....");
 }
	public static void main(String[] args) {
		int[][] basket = {
				{2, 1, 1},
				{1, 1, 0},
				{0, 1, 1}
		};
		
		new _994RottingOranges_BFS().rottenOranges(basket);
		

	}

}
