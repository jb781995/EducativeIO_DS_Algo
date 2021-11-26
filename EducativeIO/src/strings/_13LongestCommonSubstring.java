package strings;
/*
 *  https://www.educative.io/module/lesson/data-structures-in-java/xoGADK2BOor
 */
public class _13LongestCommonSubstring {

	public static int lcs(String s1, String s2) {
		int[][] dp = new int[s1.length()+1][s2.length()+1];
		int max=0;
		for(int i=1;i<s1.length();i++)
			for(int j=1;j<s2.length();j++)
				if(s1.charAt(i)==s2.charAt(j)) {
					dp[i][j] = 1+(dp[i-1][j-1]);
					max = Math.max(max, dp[i][j]);
				}
		return max;
	}
	public static void main(String[] args) {
		String s1= "cbda";
		String s2="abdca";
		System.out.println("LCS: "+lcs(s1, s2));

	}

}
