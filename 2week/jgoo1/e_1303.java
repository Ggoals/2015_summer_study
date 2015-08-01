import java.util.Scanner;

public class e_1303 {
	public static void main(String args[]){
		
		Scanner s = new Scanner(System.in);
		
		int num1, num2;
		
		num1 = s.nextInt();
		num2 = s.nextInt();
		getAnswer(num1,num2);
	}
		
	public static void getAnswer(int pNum1, int pNum2){
		for(int i=1; i<=pNum1*pNum2; i++){
			if(i%5 == 0){
				System.out.println(i);
			}else{
				System.out.print(i + " ");
			}
			
			
		}
	}
	
	//or
	/*
	 * import java.util.Scanner;

public class Main{
	public static void main(String args[]){
		//e_1303 test = new e_1303();
		Scanner s = new Scanner(System.in);
		
		int num1, num2;
		int count = 1;
		
		num1 = s.nextInt();
		num2 = s.nextInt();
		
		while(count<= num1*num2){
			if(count%num2 == 0){
				System.out.println(count);
			}else{
				System.out.print(count + " ");
			}
			count++;
			
		}
		
		//getAnswer(num1,num2);
	}
}
	 * */
}
