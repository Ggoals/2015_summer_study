import java.util.Scanner;

public class code_1671 {
	public static void main(String args[]) {
		int count; 
		
		Scanner sc = new Scanner(System.in);
		
		count = sc.nextInt();
		
		int arr[][] = new int[count][2];
		for(int i = 0; i < count; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		System.out.println(getLength(arr));
		
		sc.close();
	}
	
	public static int getLength(int[][] arr) {
		int length = 0;
		
		int square[][] = new int[100][100];
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = arr[i][1]; j < arr[i][1] + 10; j++) {
				for(int k = arr[i][0]; k < arr[i][0] + 10; k++) {
					square[k][j] = 1;
				}
			}
		}
		
		
		for(int x = 0; x < square.length; x++) {
			for(int y = 0; y < square.length; y++) {
				if((x == 0 && square[x][y] == 1) || (x > 0 && square[x][y] == 1 && square[x-1][y] == 0)) {
					//left
					length++;
				}
				
				if((x == square.length-1 && square[x][y] == 1) || (x < square.length - 1 && square[x][y] == 1 && square[x+1][y] == 0)) {
					//right
					length++;
				}
				
				if((y == 0 && square[x][y] == 1) || (y > 0 && square[x][y] == 1 && square[x][y-1] == 0)) {
					//bottom
					length++;
				}
				
				if((y == square[x].length-1 && square[x][y] == 1) || (y < square[x].length-1 && square[x][y] == 1 && square[x][y+1] == 0)) {
					//up
					length++;
				}
			}
		}
		
		
		return length;
	}
}
