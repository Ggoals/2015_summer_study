import java.util.Scanner;

public class code_1295 {
	public static void main(String args[]) {
		int arrCount;
		
		Scanner sc = new Scanner(System.in);
		
		arrCount = sc.nextInt();
		int inpArr[] = new int[arrCount];
		
		for(int i = 0; i < arrCount; i++) {
			inpArr[i] = sc.nextInt();
		}
		
		int srchNumCount;
		srchNumCount = sc.nextInt();
		int srchArr[] = new int[srchNumCount];
		
		for(int i = 0; i < srchNumCount; i++) {
			srchArr[i] = sc.nextInt();
		}
		
		
		for(int i = 0; i < srchNumCount; i++) {
			System.out.println( getResult(inpArr, srchArr[i]) );
		}
		
		sc.close();
	}
	
	public static int getResult(int[] inpArr, int srchNum) {
		int index = inpArr.length / 2;
		
		int lb = 0;
		int rb = inpArr.length -1;
		
		if(inpArr[lb] == srchNum) {
			return 1;
		}
		
		if(inpArr[rb] == srchNum) {
			return inpArr.length;
		}
		
		while(rb - lb > 1) {
			if(inpArr[index] > srchNum) {
				rb = index;
				index = (lb + rb) / 2;
			}
			else if(inpArr[index] < srchNum) {
				lb = index;
				index = (lb + rb) / 2;
			}
			else if(inpArr[index] == srchNum) {
				return index + 1;
			}
			
		}
		
		return 0;
	}
}


