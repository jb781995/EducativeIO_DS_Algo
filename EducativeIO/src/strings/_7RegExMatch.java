package strings;
/*
 * https://www.educative.io/module/lesson/data-structures-in-java/B8N7NJ2gKJX
 */
public class _7RegExMatch {
	/*
	 * text= "fabbbc"
	 * pattern=".ab*c"
	 */
	public boolean regEx(String text, String pattern) {
		if(text.isEmpty() && pattern.isEmpty())
			return true;
		if(!text.isEmpty() && pattern.isEmpty())
			return false;
		
		if(pattern.length()>1 && pattern.charAt(1)=='*') {
			String remainingText = text;
			String remainingPattern = pattern.substring(2);
			for(int i=0;i<text.length();i++) {
				if(regEx(remainingText, remainingPattern))
					return true;
				if(remainingText.isEmpty())
					return false;
				if(remainingPattern.charAt(0)!='.' && remainingPattern.charAt(0)!=remainingText.charAt(0))
					return false;
				remainingText = remainingText.substring(1);
				
			}
		}
		
		if(text.isEmpty() || pattern.isEmpty())
			return false;
		
		if(pattern.charAt(0)=='.' || pattern.charAt(0)==text.charAt(0)) {
			String remainingText="";
			if(text.length()>=2)
				remainingText = text.substring(1);
			String remainingPattern="";
			if(pattern.length()>=2)
				remainingPattern = pattern.substring(1);
			return regEx(remainingText, remainingPattern);
				
		}
		return false;
	}
	
	/*
	 * approach-2: the same as above without using substrings: remainingText, remainingPattern
	 */
	public static boolean regEx2(String text, String pattern, int i, int j) {
		if(i==text.length() && j==pattern.length())
			return true;
		if(j<pattern.length()-1 && pattern.charAt(j+1)=='*') {
			for(int k=i;k<=text.length();k++) {
			if(regEx2(text, pattern, k, j+2))
				return true;
			
			if(k>=text.length())
				return false;
			
			if(pattern.charAt(j)!='.' && text.charAt(k)!=pattern.charAt(j))
				return false;
			
			}
			
		}else if(i<text.length() || j<pattern.length() || 
				pattern.charAt(j)=='.'||text.charAt(i)==pattern.charAt(j)) {
			return regEx2(text, pattern, i+1, j+1);
		}
		return false;
	}
	public static void main(String[] args) {
		String text= "fabbbc";
		String pattern = ".ab*c";
		//System.out.println("result: "+regExMatch(text, pattern));

	}

}
