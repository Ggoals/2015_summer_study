import java.util.Scanner;
import java.util.HashMap;

public class code_1124 {
	public static int axis[][] = new int[101][101];
	
	public static void main(String args[]) {
		int count;
		
		Scanner sc = new Scanner(System.in);
		
		count = sc.nextInt();
		Axis axisArr[] = new Axis[count];
		for(int i = 0; i < count; i++) {
			axisArr[i] = new Axis( sc.nextInt(), sc.nextInt() );
		}
		
		System.out.println(getMaxArea(axisArr));
		
		sc.close();
	}
	
	public static int getMaxArea(Axis axisArr[]) {
		int maxArea = 0;
		HashMap<Axis, Boolean> map = new HashMap<Axis, Boolean>();
		
		drawSquares(axisArr);
		
		int maxHorizonalSquare = getMaxHorizonalSquare();
		int maxVerticalSquare = getMaxVerticalSquare();
		
		return maxArea;
	}
	
	public static int getMaxHorizonalSquare() {
		int maxWidth = 0;
		int maxArea = 0;
		
		for(int i = 0; i < axis.length; i++) {
			for(int j = 0; j < axis.length; j++) {
				if(axis[i][j] == 1) {
					maxWidth ++;
				}
			}
			
		}
		return maxArea;
	}
	
	public static void drawSquares(Axis axisArr[]) {
		//TODO : draw!!
	}
	
}

class Axis {
	public int x;
	public int y;
	public Axis(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
