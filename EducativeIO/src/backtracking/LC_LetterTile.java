package backtracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * https://leetcode.com/problems/letter-tile-possibilities/discuss/1604998/Java-Backtracking
 */
public class LC_LetterTile {

	public int numberOfTiles(String str) {
		Set<String> unique = new HashSet<>();
		boolean [] visited = new boolean[str.length()];
		Arrays.fill(visited, false);
		backtrack(str, "", visited, unique);
		System.out.println("\n\n"+unique);
		return unique.size()-1;
		
		}
	public void backtrack(String str, String current, boolean[] visited, Set<String> unique) {
		if(current.length()>str.length())
			return;
		unique.add(current);
		
		System.out.println("--"+current+", visited: "+Arrays.toString(visited));
		for(int i=0;i<str.length();i++) {
			if(!visited[i]) {
				visited[i] = true;
				String s = current+str.charAt(i);
				backtrack(str, s, visited, unique);
				visited[i] = false;
				System.out.println("			"+current+", visited: "+Arrays.toString(visited));
			}
		}
	}
	public static void main(String[] args) {
		System.out.println("\n\n\n\n"+new LC_LetterTile().numberOfTiles("abc"));
	}

}
