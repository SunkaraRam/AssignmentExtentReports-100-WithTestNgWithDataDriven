package SunkaraRam.Assignment;

import java.util.ArrayList;
import java.util.Iterator;

public class Capgemini {
	
	public static void main(String[] args) {
		
		ArrayList<Integer> al=new ArrayList<>();
		
		for (int i = 1; i <=100 ; i++) {
			
			if (i%2==0) {
		
			al.add(i);
					
			}
			
			
		}
		
		for (int j = 0; j <al.size() ; j++) {
			
			if (j%2==0) {
				
				System.out.println(al.get(j));
				
			}
			
		}
		
	}

}
