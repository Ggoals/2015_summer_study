import java.util.Scanner;

public class code_1002 {
	public static int GCD = 0;
	
	public static void main(String args[]) {
		int count;
		
		Scanner sc = new Scanner(System.in);
		count = sc.nextInt();
		
		int arr[] = new int[count];
		
		for(int i = 0; i < count; i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println(getGCD(arr) + " " + getLCM(arr));
		
		sc.close();
	}
	
	public static int getGCD(int[] originArr) {
		if(originArr.length == 1) {
			return originArr[0];
		}
		
		int[] arr = originArr.clone();
		
		int num1Idx = 0;
		int num2Idx = 1;
		while(true) {
			if(arr[num2Idx] > arr[num1Idx]) {
				int temp = arr[num2Idx];
				arr[num2Idx] = arr[num1Idx];
				arr[num1Idx] = temp;
			}
			
			arr[num1Idx] = arr[num1Idx] % arr[num2Idx];
			if(arr[num1Idx] == 0) {
				if(num2Idx != arr.length - 1) {
					num1Idx++;
					num2Idx++;
				} else {
					
					break;
				}	
			}
			else {
				continue;
			}
			
		}
		
		GCD = arr[num2Idx];
		return arr[num2Idx];
	}
	
	public static int getGCD(int num1, int num2) {
		while(true) {
			if(num2 > num1) {
				int temp = num2;
				num2 = num1;
				num1 = temp;
			}
			
			num1 = num1 % num2;
			if(num1 == 0) {
				break;	
			}
			else {
				continue;
			}
			
		}
		
		return num2;
	}
	
	public static int getLCM(int arr[]) {
		if(arr.length == 1) {
			return arr[0];
		}
		
		for(int i = 0; i < arr.length - 1; i++) {
			int num1 = arr[i];
			int num2 = arr[i+1];
			
			arr[i+1] = arr[i] / getGCD(num1, num2) * arr[i+1] ;
		}
		
		return arr[arr.length - 1];
	}
}
