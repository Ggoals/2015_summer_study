import java.util.Scanner;

public class code_2814 {
	public static void main(String args[]) {
		String binaryNum;
		
		Scanner sc = new Scanner(System.in);
		
		binaryNum = sc.nextLine();
		
		int count = 0;
		int length = binaryNum.length();
		int twicePow = 1;
		
		for(int i = length - 1; i >= 0 ; i--) {
			count += twicePow * Integer.parseInt(String.valueOf(binaryNum.charAt(i)));
			twicePow = twicePow * 2;
		}
		
		System.out.println(count);
		
		sc.close();
	}
}
