package amazon;
/*
 * https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/solution/
 */
public class _1010SongPairs {

	/*
	 * approach-2
	 */
public void songPairs(int [] trackLength) {
	int [] remainders = new int[60];
	int count = 0;
	for(int i=0;i<trackLength.length;i++) {
		if(trackLength[i]%60==0)
			count+= remainders[0];
		else {
			count+=remainders[60-trackLength[i]%60];
		}
		remainders[trackLength[i]%60]++;
	}
	
	System.out.println("song pairs: "+count);
}
	public static void main(String[] args) {
		int[] trackLength = {60, 30, 150, 100, 40, 80, 120};
		new _1010SongPairs().songPairs(trackLength);
	}

}
