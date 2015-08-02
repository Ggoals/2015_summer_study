import java.util.Scanner;

public class code_1124_2 {
	public static int squares[][] = new int[100][100];
	
	public static void main(String args[]) {
		int count;
		
		Scanner sc = new Scanner(System.in);
		
		count = sc.nextInt();
		
		int axis[][] = new int[count][2];
		for(int i = 0; i < count; i++) {
			axis[i][0] = sc.nextInt();
			axis[i][1] = sc.nextInt();
		}
		
		drawSquares(axis);
		
		System.out.println(getMaxArea());
		
		
		sc.close();
	}
	
	public static void drawSquares(int axis[][]) {
		for(int i = 0; i < axis.length; i++) {
			for(int  x = axis[i][0]; x < axis[i][0] + 10; x++) for(int y = axis[i][1]; y< axis[i][1]+10; y++) {
				squares[y][x] = 1;
			}
		}
		
		for(int i = 0; i < squares.length; i++) {
			for(int j = 0; j< squares[i].length; j++) {
				if(j != 0 && squares[i][j] >= 1)
					squares[i][j] = squares[i][j-1] + 1;
			}
		}
	}
	
	public static int getMaxArea() {
		int maxArea = 0;
		
		for(int y = 0; y < squares.length; y++){
			for(int x = 0; x < squares[y].length; x++) {
				int width = 100;
				int height = 1;
				
				for(int i = y; i >= 0 && squares[i][x] >= 1 ;i--, height++) {
					if(width > squares[i][x]) width = squares[i][x];
					if(width * height > maxArea) maxArea = width * height;
				}
			}
		}
		
		
		return maxArea;
	}
}