package Four.Week;

import java.util.Scanner;

public class code_1300 {
	public void main(String args[]) {
		int count, groupCount;
		
		Scanner sc = new Scanner(System.in);
		count = sc.nextInt();
		groupCount = sc.nextInt();
		
		int arr[] = new int[count];
		for(int i = 0; i < count; i++) {
			arr[i] = sc.nextInt();
		}
		
		int result[] = getMinMaxArr(arr, groupCount);
		
		
		int sum = 0;
		for(int i = 0; i < result.length; i++) {
			sum = arr[i];
		}
		
		System.out.println(sum);
		for(int i = 0; i < result.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
		
		sc.close();
	}
	
	public static int[] getMinMaxArr(int[] arr, int groupCount) {
		int elementCount[] = new int[groupCount];
		for(int i = 0; i < groupCount; i++) {
			elementCount[i] = 1;
		}
		
		
		int limitSum = arr.length;
		int sum = arr.length;
		while(true) {
			
			
			for(int i = 0; i < groupCount; i++) {
				
			}
		}
		
		
		return result;
	}
}
