import java.util.ArrayList;
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
		int count = 1;
		
		int tempArr[] = getMinArr(arr);
		
		
		List<Integer> lst = new ArrayList<Integer>();
		
		for(int i = 0; i < tempArr.length; i++) {
			if(tempArr[i] != 1 && lst.indexOf(tempArr[i]) < 0) {
				lst.add(tempArr[i]);
			}
		}
		
		int maxNum = 1;
		
		for(int i = 0; i < lst.size(); i++) {
			if(lst.get(i) > maxNum) {
				maxNum = lst.get(i);
			}
		}
		
		int maxCommonDevision = 1;
		for(int i = maxNum; i >= 1; i--) {
			boolean isAllDevision = true;
			
			for(int j = 0; j < lst.size(); j++) {
				if(lst.get(j) % i != 0) {
					isAllDevision = false;
					break;
				}
			}
			
			if(isAllDevision) {
				maxCommonDevision = i;
				break;
			}
		}
		
		
		for(int i = 0; i < lst.size(); i++) {
			count = count * lst.get(i) / maxCommonDevision;
		}
		
		if(lst.size() == 1) {
			count = count * maxCommonDevision;
		}
		
		
		return count;
	}
	
	public static int[] getMinArr(int[] arr) {
		int tempArr[] = new int[arr.length];
		int temp;
		int count;
		
		for(int i = 0; i < tempArr.length; i++) {
			count = 1;
			temp = arr[i];
			
			while(true) {
				if(temp == i + 1){
					break;
				}
				
				temp = arr[temp - 1];
				count++;
			}
			
			tempArr[i] = count;
		}
		
		return tempArr;
	}
}



