package FiveWeek;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class code_1053_2 {
	public static ArrayList<int[][]> memo = new ArrayList<int[][]>();
	public static int maxMemo = 2;
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		while(true) {
			int number = sc.nextInt();
			
			if(number == -1) break;
			
			numbers.add(number);
		}
		
		
		
		for(int i = 0; i < numbers.size(); i++) {
//			if( numbers.get(i).intValue() > 1000) {
//				System.out.println( 100 );
//			}
			System.out.println( getFibonacci( numbers.get(i)) );
		}
		
		sc.close();
	}
	
	public static long getFibonacci(int i) {
		if(i < 1) {
			return 0;
		}
		if(i == 1) {
			return 1;
		}
		int fibonachi[][] = { {1, 1}, {1, 0} };
		
		int tempFibo[][] = {{1, 1}, {1, 0}};
		
		int fibonachi0[][] = { {1, 1}, {1, 0} };
		
		int currentIndex = 1;
		
		while(currentIndex < i) {
			tempFibo = new int[2][2];
			tempFibo[0][0] = fibonachi[0][0];
			tempFibo[0][1] = fibonachi[0][1];
			tempFibo[1][0] = fibonachi[1][0];
			tempFibo[1][1] = fibonachi[1][1];
			
			if(i >= currentIndex * 2) {
				currentIndex = currentIndex * 2;
				
				int tempCurrent = currentIndex;
				int tpow = -1;
				while(true) {
					if(tempCurrent == 1) {
						break;
					}
					tempCurrent = tempCurrent/ 2;
					tpow++;
				}
				
				if(memo.size() > tpow && tpow >= 0) {
					int temp[][] = new int[2][2]; 
					temp = memo.get(tpow);
					fibonachi[0][0] = temp[0][0];
					fibonachi[0][1] = temp[0][1];
					fibonachi[1][0] = temp[1][0];
					fibonachi[1][1] = temp[1][1];
					
					
				} else {
					fibonachi[0][0] =  (tempFibo[0][0] * tempFibo[0][0] +  tempFibo[0][1] * tempFibo[1][0]) % 10000;
					fibonachi[0][1] =  (tempFibo[0][0] * tempFibo[0][1] +  tempFibo[0][1] * tempFibo[1][1]) % 10000;
					fibonachi[1][0] =  (tempFibo[1][0] * tempFibo[0][0] +  tempFibo[1][1] * tempFibo[1][0]) % 10000;
					fibonachi[1][1] =  (tempFibo[1][0] * tempFibo[0][1] +  tempFibo[1][1] * tempFibo[1][1]) % 10000;
					
					
					int temp[][] = new int[2][2]; 
					temp[0][0] = fibonachi[0][0];
					temp[0][1] = fibonachi[0][1];
					temp[1][0] = fibonachi[1][0];
					temp[1][1] = fibonachi[1][1];
					
					//System.out.println("putMap --->");
					//System.out.println(currentIndex + " : " + temp[0][0] + "," + temp[0][1]);
					//System.out.println("    "+ temp[1][0] + "," + temp[1][1]);
					
					memo.add(temp);
					
				}
				continue;
			}
			else if(i - 1 == currentIndex){
				currentIndex++;
				
				fibonachi[0][0] =  (tempFibo[0][0] * fibonachi0[0][0] +  tempFibo[0][1] * fibonachi0[1][0]) % 10000;
				fibonachi[0][1] =  (tempFibo[0][0] * fibonachi0[0][1] +  tempFibo[0][1] * fibonachi0[1][1]) % 10000;
				fibonachi[1][0] =  (tempFibo[1][0] * fibonachi0[0][0] +  tempFibo[1][1] * fibonachi0[1][0]) % 10000;
				fibonachi[1][1] =  (tempFibo[1][0] * fibonachi0[0][1] +  tempFibo[1][1] * fibonachi0[1][1]) % 10000;
				
				continue;
			}
			else if(i - currentIndex >= 2){
				int plusIndex = 2;
				
				while(true) {
					if(plusIndex * 2 < i - currentIndex) {
						plusIndex *= 2;
					} else {
						break;
					}
				}
				
				int tempCurrent = plusIndex;
				int tpow = -1;
				while(true) {
					if(tempCurrent == 1) {
						break;
					}
					tempCurrent = tempCurrent/ 2;
					tpow++;
				}
				
				int temp[][] = new int[2][2]; 
				temp = memo.get(tpow);
				
				//System.out.println("getMap --->" + plusIndex);
				//System.out.println(plusIndex + " : " + temp[0][0] + "," + temp[0][1]);
				//System.out.println("    "+ temp[1][0] + "," + temp[1][1]);
				
				fibonachi[0][0] =  (tempFibo[0][0] * temp[0][0] +  tempFibo[0][1] * temp[1][0]) % 10000;
				fibonachi[0][1] =  (tempFibo[0][0] * temp[0][1] +  tempFibo[0][1] * temp[1][1]) % 10000;
				fibonachi[1][0] =  (tempFibo[1][0] * temp[0][0] +  tempFibo[1][1] * temp[1][0]) % 10000;
				fibonachi[1][1] =  (tempFibo[1][0] * temp[0][1] +  tempFibo[1][1] * temp[1][1]) % 10000;
				
				currentIndex += plusIndex;
				continue;
			}
 			
		}
		
		
		
		return fibonachi[0][1];
	}
}

