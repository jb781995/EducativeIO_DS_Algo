package trees;

import java.util.ArrayList;

/*
 * cracking the coding-interview page-131 exercise 4.8
 * print all paths which sums up to a value
 */
public class _Cracking_AllPathSum {
	
	void allPath(Node root, ArrayList<Integer>buffer, int value, int level){
		 buffer.add(root.data);
		 int temp = value;
		 for(int i= level; i>-1;i--){
		  temp -= buffer.get(i);
		  if(temp==0) 
		   print(buffer, i, level);
		 }
		 
		 ArrayList<Integer> c1 = (ArrayList<Integer>)buffer.clone(); // shallow copy. change in either won't impact the other
		 ArrayList<Integer> c2 = (ArrayList<Integer>)buffer.clone();
		 
		 allPath(root.left, c1, value, level+1);
		 allPath(root.right, c2, value, level+1);
		}

		void print(ArrayList<Integer> buffer, int start, int end){
		 for(int i=start; i<=end;i++)
		  System.out.print(buffer.get(i)+" ");
		 System.out.println("\n");
		}
		
	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		// creates a shallow copy. change in either list won't impact the other
		ArrayList<Integer> clone = (ArrayList<Integer>) list1.clone();
		System.out.println(list1+"\nclone:\n"+clone);
		list1.add(0, 111);
		System.out.println("\n\n"+list1+"\nclone:\n"+clone);
		clone.add(1, 2222);
		System.out.println("\n\n"+list1+"\nclone:\n"+clone);
		

	}

}
