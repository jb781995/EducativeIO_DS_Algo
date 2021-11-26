package strings;
/*
 * https://www.educative.io/module/lesson/data-structures-in-java/gkD7AN7Bq7r
 */
public class _6PalindromicSubstrings {
/*
 * approach-1: n^3 solution.
 */
	public static int palindromicSS(String s) {
		int count = 0;
		for(int i=0;i<s.length();i++)
			for(int j=i+1; j<s.length();j++)
				if(isPalindrome(s, i, j)) {
					System.out.println(s.substring(i, j+1));
					count++;
				}
		return count;
	}
	public static boolean isPalindrome(String s, int i, int j) {
		while(j>i) {
			if(s.charAt(j)!=s.charAt(i))
				return false;
			i++;
			j--;
			
		}
		return true;
	}
	
	/*
	 * approach-2: n^2 solution
	 */
	public static int palindromicSSOptimized(String s) {
		int count=0;
		for(int i=0;i<s.length();i++) {
			count+= isPalindromOptimized(s, i, i+1);// odd length palindromes
			count+= isPalindromOptimized(s, i-1,i+1);// even length palindromes
		}
		return count;
	}
	public static int isPalindromOptimized(String s, int j, int k) {
		int count=0;
		while(j>=0 && k<s.length()) {
			if(s.charAt(k)==s.charAt(j)) {
				System.out.println(s.substring(j, k+1));
				j--;
				k++;
				count++;
			}
			else
				break;
		}
		return count;
	}
	public static void main(String[] args) {
		String str = "aabbbaa";
		int count1 = palindromicSS(str);
		System.out.println("------------------------------------------------");
		int count2 = palindromicSSOptimized(str);
		System.out.println("approach-1: "+count1+"\napproach-2: "+count2);

	}

}
