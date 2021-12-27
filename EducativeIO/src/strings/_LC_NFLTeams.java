package strings;

import java.util.ArrayList;
import java.util.List;

public class _LC_NFLTeams {
	public String findContestMatch(int n) { 
        if(n<2)
            return String.valueOf(n);
       
      List<String> initial = new ArrayList<String>();
      for(int i=0;i<n;i++)
            initial.add(Integer.toString(i+1));  
      List<String> finalTeams =  formTeams(n, initial); 
      StringBuffer sb = new StringBuffer();
      sb.append(finalTeams);
      System.out.println("fintalTeams: "+sb);
        
        String result = new String("(");
        for(int i=1; i<sb.length()-1;i++) {
         if(sb.charAt(i)==' ')
        	 continue;
        	result+=sb.charAt(i);
        }
        return result+")";
        
    }
    
    public List<String> formTeams(int n, List<String> initial){
        List<String> result = new ArrayList<String>();
        
        int i=0, j=initial.size()-1;
       StringBuffer sb ;
        while(i<j){
        	sb = new StringBuffer();
            sb.append("("+initial.get(i) + ","+initial.get(j)+")");
            System.out.println("sb---"+sb);
            i++;
            j--;
            result.add(String.valueOf(sb));
            //sb.append(",");
        }
        
       System.out.println(result+"\n"+result.size()+"\n");
        if(result.size()>2 && result.size()%2==0)
           result= formTeams(result.size(), result);
        
        List<String> matchedTeams = result;
        System.out.println("\n\n teams: "+matchedTeams);
        return matchedTeams;
        
    }
	public static void main(String[] args) {
		int n= 8;
		System.out.println("\n\nNFL teams: \n"+new _LC_NFLTeams().findContestMatch(n));

	}

}
