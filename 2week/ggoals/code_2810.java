import java.util.Scanner;

public class code_2810 {
	public static void main(String args[]) {
		long width, height;
		
		Scanner sc = new Scanner(System.in);
		
		width = sc.nextInt();
		height = sc.nextInt();
		
		System.out.println(getMinTileCount(width, height));
		
		sc.close();
	}
	
	public static long getMinTileCount(long width, long height) {
		long gcm = getGCM(width, height);
		
		
		return width / gcm  * height / gcm ;
	}
	
	public static long getGCM(long num1, long num2) {
		while(true) {
			if(num1 > num2) {
				num1 = num1 % num2;
				if(num1 == 0) {
					return num2;
				}
			}
			else {
				num2 = num2 % num1;
				if(num2 == 0) {
					return num1;
				}
			}
		}
	}
}
