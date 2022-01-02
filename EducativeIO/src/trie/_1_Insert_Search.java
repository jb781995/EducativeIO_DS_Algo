package trie;

import java.util.HashMap;

public class _1_Insert_Search {
	private Node root;
	
 class Node{
	 HashMap<Character, Node> children;
	 boolean flag = false;
	 Node(){
		 children = new HashMap<>();
	 }
 }
 
 _1_Insert_Search(){
	 root= new Node();
 }
 
 public void insert(String word) {
	 Node node = root;
	 for(Character ch: word.toCharArray()) {
		 if(!node.children.containsKey(ch))
			 node.children.put(ch, new Node());
		 node = node.children.get(ch);
	 }
	 node.flag = true;
 }
 
 public boolean search(String word) {
	 Node node = root;
	 for(Character ch: word.toCharArray()) {
		 if(!node.children.containsKey(ch))
			 return false;
		 node = node.children.get(ch);
	 }
	 return node.flag;
 }
	public static void main(String[] args) {
		String word= "captain";
		_1_Insert_Search obj = new _1_Insert_Search();
		obj.insert(word);
		System.out.println("\nis present: "+obj.search("caption"));

	}

}
