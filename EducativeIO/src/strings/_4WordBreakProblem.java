package strings;

import java.util.HashSet;
import java.util.Set;
/*
 * https://www.educative.io/module/lesson/data-structures-in-java/Y5G6Zyz4AnY
 * The algorithm will compute two strings from scratch in each iteration of the loop. 
 * Worst case scenario, there would be a recursive call of the second_word each time. 
 * This shoots the time complexity up to 2^n.
 */
public class _4WordBreakProblem {
/*
 * NOTE: watch the 14 slides slideshow. It helps a lot in understanding how stack/recursion 
 * unwinding happens and recursive function goes back to level-0 in case of failure in finding
 * a match
 */
	public static boolean canSegmentString(String s, Set<String> dictionary) {
	   String str="";
	   for(int i=0;i<s.length();i++) {
		   str= s.substring(0, i);
		   if(dictionary.contains(str)) {
			   String str2 = s.substring(i);
			   if(dictionary.contains(str2))
				   return true;
			   if(str2.length()<0 || str2==null|| canSegmentString(str2, dictionary))
				   return true;
		   }
	   }
	    return false;
	  }
	public static void main(String[] args) {
		Set<String> dictionary = new HashSet<String>();
		
	}

}
