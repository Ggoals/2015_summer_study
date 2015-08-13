package FiveWeek;

import java.util.Scanner;

public class code_1701 {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		
		String input = sc.nextLine();
		
		System.out.println(getMaxKOICount(input));
				
		sc.close();
	}
	
	public static int getMaxKOICount(String input) {
		int max = 0;
		
		int atCount = 0;
		int gcCount = 0;
		int tempKOICount = 0;
		
		
		for(int i = 0; i < input.length(); i++) {
			
			
			if(input.charAt(i) == 'a') {
				atCount++;
				tempKOICount++;
			}
			else if(input.charAt(i) == 'c') {
				
				gcCount--;
				if(gcCount < 0) {
					gcCount++;
//					tempKOICount = 0;
//					
//					
//					atCount = 0;
//					gcCount = 0;
				} else {
					tempKOICount++;
				}
			}
			else if(input.charAt(i) == 'g') {
				gcCount++;
				tempKOICount++;
			}
			else if(input.charAt(i) == 't') {
				
				atCount--;
				if(atCount < 0) {
					atCount++;
					
//					tempKOICount = 0;
//					atCount = 0;
//					gcCount = 0;
					
				} else {
					tempKOICount++;
				}
			}
			
			if(atCount == 0 && gcCount == 0) {
				if(max < tempKOICount) {
					max = tempKOICount;
					
					if(max == 500) break;
				}
			}
		}
		
		return tempKOICount - atCount - gcCount;
	}
}
