import java.util.Scanner;

public class code_1438 {
	public static void main(String args[]) {
		int count;
		Scanner sc = new Scanner(System.in);
		
		count = sc.nextInt();
		
		int arr[][] = new int[count][2];
		for(int i = 0; i < count; i++){
			arr[i][0] = sc.nextInt(); //x ÁÂÇ¥
			arr[i][1] = sc.nextInt(); //y ÁÂÇ¥
		}
		
		System.out.println(getArea(arr));
		
		sc.close();
	}
	
	public static int getArea(int[][] arr) {
		
		int [][] square = new int[100][100];
		
		for(int i = 0; i < arr.length; i++){
			for(int j =arr[i][1]; j < arr[i][1] + 10; j++) {
				for(int k = arr[i][0]; k < arr[i][0] + 10; k++) {
					square[k][j] = 1;
				}
			}
		}
		
		int area = 0;
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				area += square[i][j];
			}
		}
		
		return area;
	}
}
