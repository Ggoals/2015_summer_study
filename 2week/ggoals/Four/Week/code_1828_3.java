package Four.Week;

import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class code_1828_3 {
	public static void main(String args[]) {
		int count;
		
		Scanner sc = new Scanner(System.in);
		
		count = sc.nextInt();
		
		List<int[]> lst = new ArrayList<int[]>();
		
		for(int i = 0; i < count; i++) {
			lst.add(new int[]{ sc.nextInt(), sc.nextInt() });
		}
		
		lst.sort(new intArrayCompare());
		
		for(int i = 1; i < lst.size(); i++) {
			if(lst.get(i - 1)[0] == lst.get(i)[0] && lst.get(i - 1)[1] == lst.get(i)[1]) {
				lst.remove(i);
				i--;
			}
		}
		
		
		
		int arr[][] = lst.toArray(new int[lst.size()][2]);
		
		int minCount = getMinRefrigerator(arr);
		
		System.out.println(minCount);
		
		
		sc.close();
	}
	
	public static int getMinRefrigerator(int arr[][]) {
		int refrigeratorCount = 0;
		
		List<int[]> foodSet = new ArrayList<int[]>();
		
		
		for(int i = 0; i < arr.length; i++) {
			foodSet.add(arr[i]);
		}
		
		
		while(foodSet.size() >0) {
			HashMap<String, Integer> counts = new HashMap<String, Integer>();
			
			int[] first = foodSet.iterator().next();
			for(int i = 0; i < foodSet.size(); i++) {
				if(foodSet.get(i)[0] > first[1]) continue;
				for(int j = foodSet.get(i)[0]; j <= foodSet.get(i)[1] && j <= first[1]; j++) {
					counts.put(Integer.toString(j), counts.getOrDefault(Integer.toString(j), 0) + 1);
				}
			}
			
			int maxCount = 0;
			int point = Integer.MAX_VALUE;
			
			
			for(int i = first[0]; i <= first[1]; i++) {
				if(counts.getOrDefault(Integer.toString(i), 0) > maxCount) {
					maxCount = counts.getOrDefault(Integer.toString(i), 0);
					point = i;
				}
			}
			
			for(int i = 0; i < foodSet.size(); i++) {
				if(foodSet.get(i)[0] <= point && foodSet.get(i)[1] >= point) {
					
					foodSet.remove(i);
					i--;
				}
				
			}
			
			refrigeratorCount++;
		}
		
		
		
		
		return refrigeratorCount;
	}
	
	public static class intArrayCompare implements Comparator<int[]> {
		
		@Override
		public int compare(int[] arg1, int[] arg2) {
			return arg1[1] - arg2[1];
		}
	}
	
}
