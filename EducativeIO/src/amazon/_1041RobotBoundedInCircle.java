package amazon;
/*
 * https://leetcode.com/problems/robot-bounded-in-circle/solution/
 */
public class _1041RobotBoundedInCircle {
private int [][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

public boolean isBounded(String instructions) {
	int idx = 0;
	int x=0, y=0;
	for(char direction: instructions.toCharArray()) {
		if(direction=='L') 
			idx= (idx+1)%4;
		
		else if(direction=='R') 
			idx= (idx+3)%4;
		
		else
			x+=directions[idx][0];
			y+=directions[idx][1];
			
	}
	
	// after initial pass check: if robot has reached the origin or
	// is not facing the north
	return (x==0 && y==0) || idx!=0;
}
	public static void main(String[] args) {
		String instructions = "LGL";
		System.out.println("is bounded:\n"+new _1041RobotBoundedInCircle().isBounded(instructions));

	}

}
