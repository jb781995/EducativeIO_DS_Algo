package strings;

import java.util.Arrays;

/*
 * trim, split, substring
 */
public class _Ops_1 {

	public static void main(String[] args) {
		// trim
		String s = " bharadwaj  ";
		s=s.trim();
		System.out.println(s+".."); // removed leading and trailing spaces
		
		// split on whitespaces
		String s1 = "Bharadwaj Niraj Joshi";
		String[] arr = s1.split(" ");
		System.out.println("\n\n"+Arrays.toString(arr)); // returns an array
		
		// substring. access last character
		System.out.println("\n\n"+s1.substring(s1.length()-1, s1.length()));
		
		// strip. same as trim()
		String s2 = "Bharadwaj  ";
		s2 = s2.strip();
		System.out.println(s2+"__"); // has two variants - stripLeading(), stripTrailing()
	}

}
