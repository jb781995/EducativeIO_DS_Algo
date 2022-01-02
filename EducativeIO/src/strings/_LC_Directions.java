package strings;
/*
 * https://leetcode.com/problems/execution-of-all-suffix-instructions-staying-in-a-grid/
 */
import java.util.Arrays;

public class _LC_Directions {
	// right, down, left, up
	int [] r_dir = {0, 1, 0, -1};
    int [] c_dir = {1, 0, -1, 0};
    int rowLen = 0;
    int colLen = 0;
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int row = startPos[0];
        int col = startPos[1];
        
        this.rowLen  = n;
        this.colLen = n;
        int[] result =  new int[s.length()];
        for(int i=0;i<s.length();i++) {
            result[i] = helper(s, i, row, col, 0);
        }
     System.out.println("\n\n"+Arrays.toString(result));
        return result;
        
    }
        
        public int helper(String s, int i, int row, int col, int count){
            int next_r = row; 
            int next_c = col;
            System.out.println("\n\n");
            for(int j=i;j<s.length();j++){
            
            if(s.charAt(j)=='R'){
                next_r+=r_dir[0];
                next_c+=c_dir[0];
            }
            else if(s.charAt(j)=='D'){
                next_r+=r_dir[1];
                next_c+=c_dir[1];
            }
            else if(s.charAt(j)=='L'){
                next_r+=r_dir[2];
                next_c+=c_dir[2];
            }
            else{
                next_r+=r_dir[3];
                next_c+=c_dir[3];
            }
            System.out.println(s.charAt(i)+"-> "+next_r+", "+next_c);
                if(next_r>=0 && next_r<rowLen && next_c>=0 && next_c<colLen){
                    count++;
                }
                else
                    break;
        }
            return count;
            
    }
	public static void main(String[] args) {
		int[] pos = {0, 1};
		new _LC_Directions().executeInstructions(3, pos, "RRDDLU");

	}

}
