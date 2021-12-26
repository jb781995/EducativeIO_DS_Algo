package amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
 * https://leetcode.com/problems/design-search-autocomplete-system/
 */
public class _642AutoComplete {
	class HistorySearch implements Comparator<HistorySearch>{
		int hotIdx;
		String sentence;
		HistorySearch(){}
		
		HistorySearch(String sentence, int hotIdx){
			this.sentence = sentence;
			this.hotIdx = hotIdx;
		}
		
		public int getHotIdx() {
			return this.hotIdx;
		}
		
		public String getSentence() {
			return this.sentence;
		}
		
		@Override
		public int compare(HistorySearch s1, HistorySearch s2) {
			if(s1.getHotIdx()>s2.getHotIdx()) {
				System.out.println(s1.getSentence()+"."+s1.getHotIdx()+" > "+s2.getSentence()+"."+s2.getHotIdx());
				return 1;
			}
			else if(s1.getHotIdx()<s2.getHotIdx()) {
				System.out.println(s1.getSentence()+"."+s1.getHotIdx()+" < "+s2.getSentence()+"."+s2.getHotIdx());
				return -1;
			}
			else {
				System.out.println(s1.getSentence()+" compare "+s2.getSentence());
				return s1.getSentence().compareTo(s2.getSentence());
			}
		}
	}
	private String history = new String();
	   private List<String> matches;
	 private String[] sentences;
	 private int[] times;
	 
	    public void autocompleteSystem(String[] sentences, int[] times) {
	        this.sentences = sentences;
	        this.times = times;
	       
	       }
	    
	    public List<String> input(char c) {
	        this.history+=c;
	        this.matches = new ArrayList<String>();
	        System.out.println(this.history);
	        PriorityQueue<HistorySearch> hotSearches = new PriorityQueue<>(3, new HistorySearch());
	        PriorityQueue<String> pq = new PriorityQueue<String>(3, new Comparator<String>(){
		          @Override
		            public int compare(String s1, String s2){
		                return s1.compareTo(s2);
		            }
		        });
		        
		        for(int i=0;i<sentences.length;i++){
		            String thisString = sentences[i];
		            
		            if(thisString.indexOf(this.history)==0) {
		            	if(hotSearches.size()==3) {
		            		//pq.remove();
		            		hotSearches.remove();
		            	}
		            	hotSearches.add(new HistorySearch(thisString, times[i]));
		            	pq.add(thisString);
		            }
		            
		        }
		        
		        while(!hotSearches.isEmpty())
		        	this.matches.add(hotSearches.poll().getSentence());
		        
		        return matches;
	        
	    }


	public static void main(String[] args) {
		String [] sentences = {"i love you","island", "iroman", "i love leetcode"};
		int[] times = {5, 3, 2, 2};
		
		_642AutoComplete obj = new _642AutoComplete();
		obj.autocompleteSystem(sentences, times);
		System.out.println();
		System.out.println(obj.input('i'));
		

	}

}
