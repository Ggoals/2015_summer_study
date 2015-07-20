import java.util.Scanner;

public class code_2074 {
	public static void main(String args[]) {
		int count = 0;
		
		
		Scanner sc = new Scanner(System.in);
		count = sc.nextInt();
		int square[][] = new int[count][count];
		try{
			square = getMagicSquare(count);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		for(int i = 0; i < square.length; i++) {
			for(int j = 0; j < square.length; j++ ) {
				System.out.print(square[i][j] + " ");	
			}
			System.out.println("");
		}
		
		sc.close();
	}
	
	public static int[][] getMagicSquare(int count) throws Exception {
		if(count < 2 || count > 100 || (count % 2) != 1) {
			throw new Exception("parameter error");
		}
		
		int square[][] = new int[count][count];
		
		int y = count / 2, x = 0;
		int number = 1;
		
		square[x][y] = number;
		
		while(true) {
			number++;
			if(number > count * count) {
				break;
			}
			
			if(x-1 >= 0 && y-1 >=0 && square[x-1][y-1] == 0) {
				x--;
				y--;
			}
			else if(x-1 >= 0 && y-1 >=0 && square[x-1][y-1] != 0) {
				x++;
			}
			else if( x-1 < 0 && y-1 < 0) {
				x++;
			}
			else if( x-1 < 0 ) {
				y--;
				x = count - 1;
			}
			else if( y-1 < 0 ) {
				x--;
				y = count -1;
			}
			else {
				break;
			}
			
			
			square[x][y] = number;
		}
		
		
		return square;
	}
}