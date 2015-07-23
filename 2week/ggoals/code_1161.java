import java.util.Scanner;


public class code_1161 {

		public static void main(String args[]) {
			int count;
			
			Scanner sc = new Scanner(System.in);
			count = sc.nextInt();
			
			moveHanoiBlock(1, 3, 2, count);
			
			sc.close();
		}
		
		public static void moveHanoiBlock(int from, int to, int mid, int count) {
			
			if(count == 1) {
				System.out.printf("%d : %d -> %d\n", 1, from, to);
				return;
			}
			
			moveHanoiBlock(from, mid, to,count - 1);
			System.out.printf("%d : %d -> %d\n", count, from, to);
			moveHanoiBlock(mid, to, from, count - 1);
			
		}
}
