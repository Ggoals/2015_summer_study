import java.util.Scanner;


public class code_1997 {
	public static void main(String args[]) {
		int day, total;
		
		Scanner sc = new Scanner(System.in);
		
		day = sc.nextInt();
		
		total = sc.nextInt();
		
		int arr[] = getCount1AndCount2(day, total);
		
		int result[] = getResult(arr, total);
		
		System.out.println(result[0]);
		System.out.println(result[1]);
		
		sc.close();
	}
	
	public static int[] getCount1AndCount2(int day, int total) {
		int rtnArr[] = new int[2];
		
		int AB[][] = { { 1, 0 }, { 0, 1} };
		
		for(int i = 3; i <= day; i++) {
			if(i % 2 != 0) {
				AB[0][0] = AB[0][0] + AB[1][0];
				AB[0][1] = AB[0][1] + AB[1][1];
			} else {
				AB[1][0] = AB[0][0] + AB[1][0];
				AB[1][1] = AB[0][1] + AB[1][1];
			}
		}
		
		if(day % 2 == 0) {
			rtnArr = AB[1];
		} else {
			rtnArr = AB[0];
		}
		
		return rtnArr;
	}
	
	public static int[] getResult(int arr[], int total) {
		int result[] = new int[2];
		
		
		int endPoint = total / arr[0];
		for(int i = endPoint; i >= 1; i--) {
			if( (total - (i * arr[0])) % arr[1] == 0 ) {
				result[0] = i;
				result[1] = (total - (i * arr[0])) / arr[1];
			}
		}
		
		
		
		return result;
	}
}
