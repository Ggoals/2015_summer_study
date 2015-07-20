import java.util.Scanner;

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
		int count = 0;
		
		int compareArr[] = new int[arr.length];
		
		for(int i = 0; i < compareArr.length; i++) {
			compareArr[i] = i + 1;
		}
		
		boolean isEqual = false;
		
		while(true) {
			count++;
			isEqual = true;
			
			for(int i = 0; i < compareArr.length; i++) {
				//compareArr[i] = tempArr[arr[i] - 1];
				if(compareArr[i] != ( i + 1)) {
					isEqual = false;
				}
			}
			
			if(isEqual) {
				break;
			}
			
		}
		
		
		return count;
	}
}



