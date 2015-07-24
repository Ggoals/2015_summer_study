import java.util.Scanner;
import java.util.HashMap;

public class code_2518 {
	public static void main(String args[]) {
		int count;
		
		Scanner sc = new Scanner(System.in);
		count = sc.nextInt();
		
		String arr[][] = new String[count][2];
		HashMap<String, String> map = new HashMap<String, String>();
		
		for(int i = 0 ; i < arr.length;i++) {
			arr[i][0] = sc.next();
			arr[i][1] = sc.next();
			
			map.put(arr[i][0], arr[i][1]);
		}
		
		count = sc.nextInt();
		
		String arr2[] = new String[count];
		for(int i = 0;i < count; i++) {
			arr2[i] = sc.next();
		}
		
		changeArr2(map, arr2);
		
		for(int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i]);
		}
		
		sc.close();
	}
	
	public static void changeArr2(HashMap<String, String> map, String arr2[]) {
		for(int i = 0; i < arr2.length; i++) {
			if(map.get(arr2[i]) != null) {
				arr2[i] = map.get(arr2[i]);
			}
		}
	}
}
