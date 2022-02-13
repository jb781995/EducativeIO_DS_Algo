package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class _LC_FirstNonRepeatingChar {
	
	// runtime -  O(n)
 public char firstNonRepeatingChar(String word) {
	 List<Character> uniqueChars = new ArrayList<>();
	 TreeMap<Character, Integer> charCounts = new TreeMap<>();
	 
	 // O(n)
	 for(Character ch: word.toCharArray()) {
		 Integer i = charCounts.getOrDefault(ch, new Integer(0)); // O(log n);
		 i++;
		 charCounts.put(ch, i);
	 }
	 System.out.println(charCounts);
	 
	 // O(n)
	 for(Map.Entry<Character, Integer> map: charCounts.entrySet()) {
		 if(map.getValue()==1)
			 return map.getKey();
	 }
	 
	 return ' ';
	 
 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String word = "bharadwaj";
		_LC_FirstNonRepeatingChar obj = new _LC_FirstNonRepeatingChar();
		System.out.println("\nfirst non-repeating char: "+obj.firstNonRepeatingChar(word));
		//System.out.println("\n\n"+obj);
	}

}
