package strings;
/*
 * https://www.educative.io/blog/crack-amazon-coding-interview-questions#questions
 * problem-24
 * solution: https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
 */
public class _45_24_StringPerms {
 
	public void perm(String s, int l, int r) {
		if(l==r)
			System.out.println(s);
		else {
			for(int i=l;i<=r;i++) {
				s = swap(s, l, i);
				perm(s, l+1, r);
			}
		}
	}
	public String swap(String s, int i, int j) {
		char temp;
		char[] arr = s.toCharArray();
		temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
		return String.valueOf(arr);
	}
	public static void main(String[] args) {
		String s = "abc";
		new _45_24_StringPerms().perm(s, 0, 2);

	}

}
