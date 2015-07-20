import java.util.Scanner;
import java.util.Stack;

public class code_2498 {

	public static void main(String args[]) {
		long count1, count2;
		
		Scanner sc = new Scanner(System.in);
		count1 = sc.nextInt();
		count2 = sc.nextInt();
		
		if(count1 > count2 ) {
			long temp = count1;
			count1 = count2;
			count2 = temp;
		}
		
		Stack<Integer> st = new Stack<Integer>();
		for(int i = 1; i <= count2; i++) {
			if(count2 % i == 0) {
				if(!st.empty() && (count2 / i) <= st.peek()) {
					break;
				} else {
					st.push(i);
				}
			}
		}
		
		while(!st.empty()) {
			long stPeek = st.pop();
			
			if(count1 * stPeek > count2 / stPeek) {
				continue;
			}
			else {
				count1 = count1 * stPeek;
				count2 = count2 / stPeek;
				break;
			}
		}
		
		System.out.println(count1 + " " + count2);
		
		sc.close();
	}
	
}
