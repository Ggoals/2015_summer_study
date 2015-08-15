package FiveWeek;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class code_1053 {
	public static HashMap<Integer, Long> memo = new HashMap<Integer, Long>();
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		while(true) {
			int number = sc.nextInt();
			
			if(number == -1) break;
			
			numbers.add(number);
		}
		
		for(int i = 0; i < numbers.size(); i++) {
			System.out.println( getFibonacci( numbers.get(i).intValue() ) );
		}
		
		sc.close();
	}
	
	public static long getFibonacci(int i) {
		if(i == 1) {
			return 1;
		}
		else if(i < 1) {
			return 0;
		}
		
		if(memo.get(i) != null) {
			return memo.get(i);
		}
		
		long rtnValue = getFibonacci(i - 1) + getFibonacci(i - 2);
		memo.put(i, rtnValue);
		return rtnValue;
	}
}
