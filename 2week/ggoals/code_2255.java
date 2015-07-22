import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.List;

public class code_2255 {

	public static void main(String args[]){
		int count = 0;
		Scanner sc = new Scanner(System.in);
		
		count = sc.nextInt();
		int arr[] = new int[count];
		
		for(int i = 0; i < count ; i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println(getTraceCount(arr));
		
		sc.close();
	}
	
	public static int getTraceCount(int[] arr) {
		int tempArr[] = new int[arr.length];
		int temp;
		int count;
		List<Integer> lst = new ArrayList<Integer>();
		HashMap<Integer, Boolean> lstMap = new HashMap<Integer, Boolean>(); 
		HashMap<Integer, Boolean> arrMap = new HashMap<Integer, Boolean>();
		
		
		for(int i = 0; i < tempArr.length; i++) {
			if(!arrMap.getOrDefault(i, true)) {
				continue;
			}
			count = 1;
			temp = arr[i];
			
			
			while(true) {
				if(temp == i + 1){
					break;
				}
				
				
				temp = arr[temp - 1];
				arrMap.put(temp - 1, false);
				
				count++;
			}
			
			if(count != 1 && lstMap.getOrDefault(count, true)) {
				lstMap.put(count, false);
				lst.add(count);
			}
		}
		
		
		
		int arr2[] = new int[lst.size()];
		for(int i = 0;i < arr2.length; i++) {
			arr2[i] = lst.get(i);
		}
		
		Arrays.sort(arr2);
		
		
		return getLCM(arr2);
	}
	
	
	
	public static int getGCD(int num1, int num2) {
		while(true) {
			if(num2 > num1) {
				num2 = num2 % num1;
				if(num2 == 0) {
					num2 = num1;
					break;	
				}
				else {
					continue;
				}
			}
			else {
				num1 = num1 % num2;
				if(num1 == 0) {
					break;	
				}
				else {
					continue;
				}
			}
		}
		
		return num2;
	}
	
	public static int getLCM(int arr[]) {
		if(arr.length == 1) {
			return arr[0];
		}
		
		for(int i = 0; i < arr.length - 1; i++) {
			
			arr[i+1] = arr[i] / getGCD(arr[i], arr[i+1]) * arr[i+1] ;
		}
		
		return arr[arr.length - 1];
	}
}



