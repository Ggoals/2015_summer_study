import java.util.Scanner;
import java.util.Stack;

public class code_1221 {
	public static void main(String args[]) {
		int count;
		
		Scanner sc = new Scanner(System.in);
		
		count = sc.nextInt();
		
		String arr[] = new String[count];
		for(int i = 0; i < count; i++) {
			arr[i] = sc.next();
		}
		
		System.out.println(getResult(arr));
		
		sc.close();
	}
	
	public static int getResult(String arr[]) {
		Stack<Integer> numbers = new Stack<Integer>();
		
		int num1;
		int num2;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i].equals("+")) {
				num2 = numbers.pop();
				num1 = numbers.pop();
				numbers.push(num1 + num2);
			}
			else if(arr[i].equals("-")) {
				num2 = numbers.pop();
				num1 = numbers.pop();
				numbers.push(num1 - num2);
			}
			else if(arr[i].equals("*")) {
				num2 = numbers.pop();
				num1 = numbers.pop();
				numbers.push(num1 * num2);		
			}
			else if(arr[i].equals("/")) {
				num2 = numbers.pop();
				num1 = numbers.pop();
				numbers.push(num1 / num2);
			}
			else {
				numbers.push(Integer.parseInt(arr[i]));
			}
		}
		
		return numbers.pop();
	}
}
