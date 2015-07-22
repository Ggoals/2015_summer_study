import java.util.Scanner;
import java.util.ArrayList;

public class code_2809 {
	public static void main(String args[]) {
		int num;
		
		Scanner sc = new Scanner(System.in);
		
		num = sc.nextInt();
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		
		list.add(1);
		for(int i = 2; i < num; i++) {
			if(num % i == 0 ) {
				if(list.get(list.size() - 1) * i >= num ) {
					break;
				}
				list.add(i);
			}
		}
		
		int size = list.size();
		for(int i = size - 1; i >= 0; i--) {
			list.add( num / list.get(i) );
		}
		
		for(int i= 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		
		sc.close();
	}
}
