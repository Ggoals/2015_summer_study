import java.util.ArrayList;
import java.util.Scanner;

public class AL2612 {
	static int num,virusLH;
	static ArrayList al = new ArrayList();
	static int[] minVirus;
	public static void main(String[] args){
		

		
		Scanner sn = new Scanner(System.in);
		num = sn.nextInt(); virusLH = sn.nextInt();
		
		int min = 100;
		int index = 0;
		// get virus arrays from input
		for(int i=0; i<num;i++){
			
			int l = sn.nextInt();
			int[] arr = new int[l];
			for(int j=0;j<l;j++) {
				arr[j] = sn.nextInt();
			}
			if(arr.length<min){
				min = arr.length;
				index = i;
			}
			al.add(arr);			
		}		
		minVirus= (int[])al.get(index);
		if(checkVirus()) System.out.println("YES");
		else System.out.println("NO");
	}
	
	static boolean checkVirus(){
		
		boolean check= true;
		
		for(int i=0;i<minVirus.length-virusLH;i++){
			check = true;
			int[] arr = new int[virusLH];
			
			for(int j=0;j<virusLH;j++){
				arr[j] = minVirus[j+i];
			}
			
			int cnt =0;
			while((cnt<al.size())&&check){
				check = checkVirus(arr,(int[])al.get(cnt));
				cnt++;				
			}
			if(check) break;
		}
		return check;
	}
	
	static boolean checkVirus(int[] v, int[] s){
		boolean check = true;
		
		for(int i=0;i<s.length-virusLH+1;i++){
			check = true;
			
			for(int j=0;j<virusLH;j++){
				if(v[j] != s[j+i]){
					check = false;
					break;
				}
			}
			if(!check){
				check = true;
				for(int j=0;j<virusLH;j++){
					if(v[virusLH-j-1]!=s[j+i]){
						check=false;
						break;
					}
				}
			}
			if(check==true) break;
		}
		
		
		return check;
	}
}
