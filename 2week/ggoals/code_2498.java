import java.util.Scanner;
import java.util.ArrayList;

public class code_2498 {

	public static void main(String args[]) {
		int count1, count2, count3;
		
		Scanner sc = new Scanner(System.in);
		count1 = sc.nextInt();
		count2 = sc.nextInt();
		
		if(count1 > count2 ) {
			int temp = count1;
			count1 = count2;
			count2 = temp;
		}
		
		count3 = count2 / count1;
		
		ArrayList<Integer> lst = new ArrayList<Integer>();
		for(int i = 1; i <= count3; i++) {
			if(count3 % i == 0) {
				if(lst.size() != 0 && i * lst.get(lst.size() - 1) >= count3) {
					break;
				} else {
					lst.add(i);
				}
			}
		}
		
		int lstSize = lst.size();
		for(int i = lstSize - 1; i >= 0; i--) {
			lst.add(count3 / lst.get(i));
		}
		
		int leftIdx, rightIdx;
		
		if(lst.size() % 2 == 1) {
			leftIdx = rightIdx = lst.size() / 2;
		} else {
			leftIdx = lst.size() / 2 - 1;
			rightIdx = lst.size() / 2;
		}
		while(true) {
			int leftNum = lst.get(leftIdx);
			int rightNum = lst.get(rightIdx);
			
			if(getGCD(leftNum, rightNum) == 1) {
				count1 = count1 * leftNum;
				count2 = count2 / leftNum;
				break;
			}
			else {
				leftIdx--;
				rightIdx++;
				continue;
			}
		}
		
		System.out.println(count1 + " " + count2);
		
		sc.close();
	}
	
	public static int getGCD(int num1, int num2) {
		while(true)
		{
			if(num1 > num2) {
				num1 = num1 % num2;
				
				if(num1 == 0) {
					break;
				}
			}
			else {
				num2 = num2 % num1;
				
				if(num2 == 0) {
					num2 = num1;
					break;
				}
			}
		}
		
		return num2;
	}
	
}
