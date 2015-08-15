package Four.Week;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class code_1300 {
	public static void main(String args[]) {
		int count, groupCount;
		
		Scanner sc = new Scanner(System.in);
		count = sc.nextInt();
		groupCount = sc.nextInt();
		
		int arr[] = new int[count];
		for(int i = 0; i < count; i++) {
			arr[i] = sc.nextInt();
		}
		
		getAndPrintMinMaxArr(arr, groupCount);
		
		
		
		sc.close();
	}
	
	public static void getAndPrintMinMaxArr(int[] arr, int groupCount) {
		Queue<Double> queue = new LinkedList<Double>();
		
		
		double total = 0;
		
		for(int i = 0; i < arr.length; i++) {
			total += arr[i];
			queue.add((double)arr[i]);
		}
		
		double average = total / (double)groupCount;
		
		List<ArrayList<Integer>> balancedList = new ArrayList<ArrayList<Integer>>();
		
		
		ArrayList<Integer> elementList = new ArrayList<Integer>();
		boolean isNewElements = false;
		double sum = 0;
		
		while(!queue.isEmpty()) {
			
			Double peek = queue.peek();
			
			if(groupCount == 1) {
				while(!queue.isEmpty()) {
					elementList.add(queue.poll().intValue());
				}
				balancedList.add(elementList);
				break;
			}
			
			
			if(Math.abs(peek + sum - average) < Math.abs(sum - average)) {
				elementList.add(queue.poll().intValue());
				sum += peek;
				continue;
			} 
			else if(Math.abs(peek + sum - average) == Math.abs(sum - average)) {
				elementList.add(queue.poll().intValue());
				sum += peek;
				continue;
			} 
			else {
				balancedList.add(elementList);
				elementList = new ArrayList<Integer>();
				sum = 0;
				groupCount--;
				continue;
			}
			
			
		}
		
		int maxIndex = -1;
		int tempMaxValue = 0;
		for(int i = 0; i < balancedList.size(); i++) {
			
			int listSum = 0;
			for(int j = 0; j < balancedList.get(i).size(); j++) {
				listSum += balancedList.get(i).get(j);
			}
			
			if(listSum > tempMaxValue) {
				tempMaxValue = listSum;
				maxIndex = i;
			}
		}
		
		
		System.out.println(tempMaxValue);
		
		for(int i = 0; i < balancedList.size(); i++) {
			System.out.print( balancedList.get(i).size()+ " ");
		}
	}
}
