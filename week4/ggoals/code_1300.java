package Four.Week;

import java.util.Scanner;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

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
		Stack<Double> stack = new Stack<Double>();
		
		
		int total = 0;
		
		for(int i = 0; i < arr.length; i++) {
			total += arr[i];
			stack.add(e)
		}
		
		List<List<Integer>> balancedList = new ArrayList<ArrayList<Integer>>();
		
		while(true) {
			
		}
		
		double average = total / groupCount;
		
		
		
		
		return result;
	}
}
