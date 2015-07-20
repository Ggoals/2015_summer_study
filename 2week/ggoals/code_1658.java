import java.util.Scanner;


public class code_1658 {
	public static void main(String args[]) {
		int num1 = 0;
		int num2 = 0;
		
		Scanner sc = new Scanner(System.in);
		
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		
		Code code = new Code(num1, num2);
		
		int arr[] = code.getMinAndMax();
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		sc.close();
	}
}

class Code {
	int num1, num2;
	
	public Code(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
	
	public int[] getMinAndMax() {
		int arr[] = {0, 0};
		
		int smallNumber = num1 > num2 ? num2 : num1;
		
		for(int i = smallNumber; ; i--) {
			if(num1 % i == 0 && num2 % i == 0) {
				arr[0] = i;
				break;
			}
			else if(i == 1) {
				arr[0] = 1;
				break;
			}
		}
		
		arr[1] = num1 * num2 / arr[0];
		
		
		return arr;
	}
}