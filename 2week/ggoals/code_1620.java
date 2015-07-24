import java.util.Scanner;

public class code_1620 {

	public static void main(String args[]) {
		String phoneNum;
		
		int plusNum, selectedIdx;
		
		Scanner sc = new Scanner(System.in);
		phoneNum = sc.next();
				
		plusNum = sc.nextInt();
		selectedIdx = sc.nextInt();
		
		String pass = getPass(phoneNum, plusNum, selectedIdx);
		
		System.out.println(pass);
		
		sc.close();
	}
	
	public static String getPass(String phoneNum, int plusNum, int selectedIdx) {
		if(phoneNum.charAt(phoneNum.length() - 1) == '-') {
			phoneNum += "0";
		}
		
		String arr[] = phoneNum.split("-");
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i].length() > 4) {
				return "INPUT ERROR!";
			}
		}
		
		String selectedStr = arr[selectedIdx - 1];
		for(int i = arr[selectedIdx - 1].length(); i < 4; i++) {
			selectedStr = "0" + selectedStr;
		}
		
		
		String realPass = "";
		int tempValue = 0;
		for(int i = 0; i < 4; i++) {
			tempValue=0;
			tempValue += (Integer.parseInt(Character.toString( selectedStr.charAt(i) )) + plusNum);
			tempValue = tempValue % 10;
			realPass += Integer.toString(tempValue);
		}
		
		return realPass;
	}
}
