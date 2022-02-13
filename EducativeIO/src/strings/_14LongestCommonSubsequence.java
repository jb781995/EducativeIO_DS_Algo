package strings;
/*
 * https://www.educative.io/module/lesson/data-structures-in-java/qARrkkw48Ak
 */
public class _14LongestCommonSubsequence {
private String LCS="";

/*
 * time complexity is O(m*n)
 */
public int lcs(String s1, String s2) {
	int max = 0;
	int [][] dp = new int[s1.length()+1][s2.length()+1];
	int i=1, j=1;
	for(i=1;i<=s1.length();i++) {
		for(j=1;j<=s2.length();j++) {
			if(s1.charAt(i-1)==s2.charAt(j-1))
				dp[i][j] = 1 + dp[i-1][j-1];
			else
				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			max = Math.max(max, dp[i][j]);
		}
	}
	
	return max;
	}
	public static void main(String[] args) {
		String s1= "cbda";
		String s2="abdca";
		_14LongestCommonSubsequence obj = new _14LongestCommonSubsequence();
		System.out.println("\n\nLCS: "+obj.lcs(s1, s2));

	}

}
