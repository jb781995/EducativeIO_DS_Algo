package strings;
/*
 * https://www.educative.io/module/lesson/data-structures-in-java/BnXvppEnKqQ
 */
public class _8LongestPalindromicSubsequence_Recursion {
	
	/*
	 * approach-1: time= O(2^n), space = O(n) because of stack space used for recursive calls
	 */
public static int lpsRecur(String s, int start, int end) {
	if(start>end)
		return 0;
	if(start==end)
		return 1;
	// case-1:
	if(s.charAt(start)==s.charAt(end)) {
		System.out.println(s.charAt(start)+"=="+s.charAt(end));
		return 2+lpsRecur(s, start+1,end-1);
	}
	
	// case-2:
	System.out.println("c1: ");
	int c1 = lpsRecur(s, start+1, end);
	System.out.println("c2: ");
	int c2 = lpsRecur(s, start, end-1);
	return Math.max(c1, c2);
}
	public static void main(String[] args) {
		String s = "cddpd";
		System.out.println("\n\nresult: "+lpsRecur(s, 0, s.length()-1));

	}

}
