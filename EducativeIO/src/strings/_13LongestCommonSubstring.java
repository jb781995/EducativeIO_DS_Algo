package strings;

import java.util.ArrayList;
import java.util.List;

/*
 *  https://www.educative.io/module/lesson/data-structures-in-java/xoGADK2BOor
 */
public class _13LongestCommonSubstring {
 private static List<String> LCS;
	/*
	 * time complexity O(m*n) where m and n are lengths of two strings
	 */
	public static int lcs(String s1, String s2) {
		int[][] dp = new int[s1.length()+1][s2.length()+1];
		int max=0;
		String result = "";
		int i=1, j=1;
		LCS = new ArrayList<>();
		for(i=1;i<=s1.length();i++) {
			for(j=1;j<=s2.length();j++) {
				if(s1.charAt(i-1)==s2.charAt(j-1)) {
					dp[i][j] = 1+(dp[i-1][j-1]);
					max = Math.max(max, dp[i][j]);
				}
			}
			
			if(max>result.length()) {
				if(max<i)
					result=s1.substring(max-1, i-1);
				else
					result=s1.substring(i-1, max);
			LCS.add(0, result);
			System.out.println("IF..."+result);
			}
		}
		
		System.out.println("\nlongest common substring: "+result);
		return max;
	}
	public static void main(String[] args) {
		String s1= "cbda";
		String s2="abdca";
		System.out.println("\n\nLCS: "+lcs(s1, s2)+"\n LCS: "+LCS);

	}

}
