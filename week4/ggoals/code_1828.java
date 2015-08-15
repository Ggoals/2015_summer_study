package Four.Week;

import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class code_1828 {
	public static void main(String args[]) {
		int count;
		
		Scanner sc = new Scanner(System.in);
		
		count = sc.nextInt();
		
		int arr[][] = new int[count][2];
		
		for(int i = 0; i < count; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		HashSet<String> foodSet = new HashSet<String>();
		for(int i = 0; i < arr.length; i++) {
			foodSet.add(arr[i][0] + "," + arr[i][1]);
		}
		
		
		ArrayList<int[]> noDuplicateArr = new ArrayList<int[]>();
		for(Iterator<String> i = foodSet.iterator(); i.hasNext(); ){
			String item = i.next();
			int tempArr[] = {Integer.parseInt(item.split(",")[0]), Integer.parseInt(item.split(",")[1]) };
			noDuplicateArr.add(tempArr);
		}
		
		
		
		List<int[]> noDuplicateList = new ArrayList<int[]>();
		for(int i = 0; i < arr.length; i++) {
			noDuplicateList.add( arr[i]);
		}
	
		int minCount = getMinRefrigerator(noDuplicateList);
		
		System.out.println(minCount);
		
		
		sc.close();
	}
	
	public static int getMinRefrigerator(List<int[]> foodList) {
		int refrigeratorCount = 0;
		
		HashSet<int[]> foodSet = new HashSet<int[]>();
		
		
		int minAndMax[] = getMinAndMax(foodList);
		
		for(int i = 0; i < foodList.size(); i++) {
			foodSet.add(foodList.get(i));
		}
		
		
		while(foodSet.size() >0) {
			HashMap<String, Integer> counts = new HashMap<String, Integer>();
			
			for(Iterator<int[]> i = foodSet.iterator(); i.hasNext(); ) {
				int[] item = i.next();
				for(int j = item[0]; j <= item[1]; j++) {
					counts.put(Integer.toString(j), counts.getOrDefault(Integer.toString(j), 0) + 1);
				}
			}
			
			int maxCount = 0;
			int point = Integer.MAX_VALUE;
			
			for(int i = minAndMax[0]; i <= minAndMax[1]; i++) {
				if(counts.getOrDefault(Integer.toString(i), 0) > maxCount) {
					maxCount = counts.getOrDefault(Integer.toString(i), 0);
					point = i;
				}
			}
			
			ArrayList<int[]> lst = new ArrayList<int[]>(); 
			
			for(Iterator<int[]> i = foodSet.iterator(); i.hasNext(); ) {
				int[] item = i.next();
				if(item[0] <= point && item[1] >= point) {
					lst.add(item);
					//foodSet.remove(item);
				}
			}
			
			for(int i = 0; i < lst.size(); i++) {
				foodSet.remove(lst.get(i));
			}
			
			refrigeratorCount++;
		}
		
		
		
		
		return refrigeratorCount;
	}
	
	public static int[] getMinAndMax(List<int[]> lst) {
		int minAndMax[] = {Integer.MAX_VALUE, 0};
		
		for(int i = 0; i < lst.size(); i++) {
			if(lst.get(i)[0] < minAndMax[0]) minAndMax[0] = lst.get(i)[0];
			if(lst.get(i)[1] > minAndMax[1]) minAndMax[1] = lst.get(i)[1];
		}
		
		return minAndMax;
	}
}
