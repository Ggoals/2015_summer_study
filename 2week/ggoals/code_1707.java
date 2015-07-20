
import java.util.Scanner;

public class code_1707{
	public static String LEFT = "left";
	public static String RIGHT = "right";
	public static String DOWN = "down";
	public static String UP = "up";
	
	public static void main(String args[]) {
		int count = 0;
		
		
		Scanner sc = new Scanner(System.in);
		count = sc.nextInt();
		
		
		int square[][] = new int[count][count];
		square = getSquare(count);
		
		for(int i = 0; i < square.length; i++) {
			for(int j = 0; j < square[i].length; j++) {
				System.out.print(square[i][j] + " ");
			}
			System.out.println("");
		}
		
		sc.close();
	}
	
	public static int[][] getSquare(int count) {
		int square[][] = new int[count][count];
		
		String direction = RIGHT;
		int number = 1;
		int x = 0, y = 0;
		square[0][0] = 1;
		
		for(int i = 0; i < (2 * count) -1 ; i++) {
			
			while(true) {
				if(direction == RIGHT) {
					if(y + 1 < count && square[x][y + 1] == 0) {
						y++;
						number++;
						square[x][y] = number;
					}
					else {
						break;
					}
				}
				else if(direction == DOWN) {
					if(x + 1 < count && square[x + 1][y] == 0) {
						x++;
						number++;
						square[x][y] = number;
					}
					else {
						break;
					}
				}
				else if(direction == LEFT) {
					if(y - 1 >= 0 && square[x][y - 1] == 0) {
						y--;
						number++;
						square[x][y] = number;
					}
					else {
						break;
					}			
				}
				else if(direction == UP) {
					if(x - 1 >= 0 && square[x- 1][y] == 0) {
						x--;
						number++;
						square[x][y] = number;
					}
					else {
						break;
					}
				}
				
			}
			
			direction = changeDirection(direction);
		}
		
		return square;
	}
	
	public static String changeDirection(String prevDirection) {
		if(prevDirection.equals(RIGHT)) {
			prevDirection = DOWN;
		}
		else if(prevDirection.equals(DOWN)) {
			prevDirection = LEFT;
		}
		else if(prevDirection.equals(LEFT)) {
			prevDirection = UP;
		}
		else if(prevDirection.equals(UP)) {
			prevDirection = RIGHT;
		}
		
		return prevDirection;
	}
	
}