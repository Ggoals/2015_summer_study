import java.util.Scanner;
import java.lang.Math;

import java.util.Map;

public class code_1112 {
	public static void main(String[] args) {
		int length;
		float points[][] = new float [3][2];
		
		Map<Integer, Integer> map = null;
		
		map.put(1,  1);
		
		Scanner sc = new Scanner(System.in);
		length = sc.nextInt();
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 2; j++) {
				points[i][j] = sc.nextInt();
			}
		}
		
		System.out.println(getLength(length, points));
		
		sc.close();
	}
	
	public static float getLength(int length, float[][] points) {
		float result = length;
		
		//3번 접기
		for( int i = 0; i < points.length; i++) {
			float mid = (points[i][0] + points[i][1]) / 2;
			
			if(mid == points[i][0]) {
				continue; // 이미 접기도 전에 같은 지점에 점이 분은 경우 접지 않음.
			}
			
			
			
			for(int j = i + 1; j < points.length; j++) {
				points[j][0] = Math.abs(points[j][0] - mid);
				points[j][1] = Math.abs(points[j][1] - mid);
			}
			
			if(mid > result - mid) {
				result = mid;
			} else {
				result = result - mid;
			}
			
		}
		
		return Math.round(result * 10) / 10f;
	}
}
