//import java.util.Scanner;
//
//public class code_1124 {
//	public static int axis[][] = new int[101][101];
//	public static int HORIZON = 1;
//	public static int VERTICAL = 2;
//	
//	public static void main(String args[]) {
//		int count;
//		
//		Scanner sc = new Scanner(System.in);
//		
//		count = sc.nextInt();
//		Axis axisArr[] = new Axis[count];
//		for(int i = 0; i < count; i++) {
//			axisArr[i] = new Axis( sc.nextInt(), sc.nextInt() );
//		}
//		
//		System.out.println(getMaxArea(axisArr));
//		
//		sc.close();
//	}
//	
//	public static int getMaxArea(Axis axisArr[]) {
//		
//		drawSquares(axisArr);
//		
//		int maxHorizonalSquare = getMaxHorizonalSquare();
//		int maxVerticalSquare = getMaxVerticalSquare();
//		
//		if(maxHorizonalSquare >= maxVerticalSquare) {
//			return maxHorizonalSquare;
//		}
//		else {
//			return maxVerticalSquare;
//		}
//		
//	}
//	
//	public static int getMaxHorizonalSquare() {
//		int maxWidth = 0;
//		int maxArea = 0;
//		
//		int tempMaxArea = 0;
//		
//		Axis leftPoint = new Axis(-1, -1);
//		Axis rightPoint = new Axis(-1, -1);
//		
//		for(int y = 0; y < axis.length; y++) {
//			int tempWidth = -1;
//			
//			
//			for(int x = 0; x < axis.length; x++) {
//				if(axis[y][x] == 1) {
//					tempWidth++;
//				}
//				else if(x != 0 && ( (x == axis.length -1 && axis[y][x] == 1) || axis[y][x-1] == 1)) {
//					
//					if(maxWidth == tempWidth && rightPoint.x == x && y -1 == rightPoint.y) {
//						tempMaxArea += maxWidth;
//						if(tempMaxArea > maxArea) {
//							maxArea = tempMaxArea;
//						}
//					}
//					else if(maxWidth <= tempWidth && (rightPoint.x != x || y -1 == rightPoint.y)) {
//						tempMaxArea = 0;
//					}
//					
//					if(maxWidth <= tempWidth) {
//						maxWidth = tempWidth;
//						
//						//left point
//						leftPoint.setAxis(x - maxWidth, y);
//						//right point
//						rightPoint.setAxis(x, y);
//					}
//					
//				} else {
//					tempWidth = -1;
//				}
//			}
//			
//		}
//		return maxArea;
//	}
//	
//	public static int getMaxVerticalSquare() {
//		int maxHeight = 0;
//		int maxArea = 0;
//		
//		int tempMaxArea = 0;
//		
//		Axis bottomPoint = new Axis(-1, -1);
//		Axis topPoint = new Axis(-1, -1);
//		
//		for(int x = 0; x < axis.length; x++) {
//			int tempHeight = -1;
//			
//			
//			for(int y = 0; y < axis.length; y++) {
//				if(axis[y][x] == 1) {
//					tempHeight++;
//				} 
//				else if(y != 0 && ((y == axis.length -1 && axis[y][x] == 1) || axis[y-1][x] == 1)) {
//					
//					if(maxHeight == tempHeight && topPoint.y == y && x -1 == topPoint.x) {
//						tempMaxArea += maxHeight;
//						if(tempMaxArea > maxArea) {
//							maxArea = tempMaxArea;
//						}
//					}
//					else if(maxHeight <= tempHeight && (topPoint.y != y || x -1 == topPoint.x)) {
//						tempMaxArea = 0;
//					}
//					
//					if(maxHeight <= tempHeight) {
//						maxHeight = tempHeight;
//						
//						//left point
//						bottomPoint.setAxis(x - maxHeight, y);
//						//right point
//						topPoint.setAxis(x, y);
//					}
//				}
//				else {
//					tempHeight = -1;
//				}
//			}
//			
//		}
//		return maxArea;
//	}
//	
//	public static void drawSquares(Axis axisArr[]) {
//		for(int i = 0; i < axisArr.length; i++) {
//			for ( int x = axisArr[i].x; x <= axisArr[i].x + 10; x++) {
//				for(int y = axisArr[i].y; y <= axisArr[i].y + 10; y++) {
//					axis[y][x] = 1;
//				}
//			}
//		}
//	}
//	
//}
//
//class Axis {
//	public int x;
//	public int y;
//	public Axis(int x, int y) {
//		this.x = x;
//		this.y = y;
//	}
//	
//	public void setAxis(int x, int y) {
//		this.x = x;
//		this.y = y;
//	}
//}
