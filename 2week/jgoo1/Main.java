import java.util.Scanner;

public class Main{
	public static int size = 100;
	public static int gX = 0;
	public static int gY = 0;
	public static void main(String[] args){
		Scanner sn = new Scanner(System.in);
		
		int num = sn.nextInt();
		int[][] coordinates = new int[size][size]; 
		int[][] arr = new int[num][2];
		for(int i=0; i<num; i++){
			arr[i][0] = sn.nextInt();
			arr[i][1] = sn.nextInt();
		}
		
		
		for(int i=0;i<num;i++){
			for(int j=arr[i][0];j<arr[i][0]+10;j++){
				for(int k=arr[i][1];k<arr[i][1]+10;k++){
					coordinates[j][k] = 1;
				}				
			}
		}
		
		System.out.println(getSquareArea(coordinates));				
		
	}
	
	public static int getSquareArea(int[][] arr){
		int maximum = 100;
		int area1 = depthSearchArea(arr);
		maximum = (area1>maximum)?area1:maximum;
		int area2 = lengthSearchArea(arr);
		maximum = (area2>maximum)?area2:maximum;

		return maximum;
	}
	
	public static int depthSearchArea(int[][] arr){
		int maximum = 0;
		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++){
				if(arr[i][j] == 1){					
					int depth = searchDepth(arr,i,j);
					int area = getAreaWithDepth(arr,i,j,depth);
					maximum = (area>maximum)?area:maximum;
				}
			}
		}
		return maximum;
	}
	
	public static int searchDepth(int[][] arr, int x, int y){
		int cntD = 0;
		if((x+cntD)<size){
			while(arr[x+cntD][y]==1) {
				cntD++;
				if(x+cntD>=size) break;
			}
		}			
		return cntD;
	}
	
	public static int getAreaWithDepth(int[][]arr,int x, int y, int depth){
		int cnt = 1;
		if((y+cnt)<size){
			while(searchDepth(arr,x,y+cnt)>=depth){
				cnt++;
				if(y+cnt>=size) break;
			}
		}
		
		return cnt*depth;
	}
	public static int lengthSearchArea(int[][] arr){
		int maximum = 0;
		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++){
				if(arr[i][j] == 1){
					int length = searchLength(arr,i,j);
					int area = getAreaWithLength(arr,i,j,length);
					maximum = (area>maximum)?area:maximum;
					
				}
			}
		}
		return maximum;
	}
	
	
	public static int searchLength(int[][] arr, int x, int y){
		int cntL = 0;
		if((y+cntL)<size){
			while(arr[x][y+cntL]==1) {
				cntL++;
				if(y+cntL>=size) break;
			}
		}		
		return cntL;
	}
	
	public static int getAreaWithLength(int[][]arr,int x, int y, int length){
		int cnt = 1;
		if((x+cnt)<size){
			while(searchLength(arr,x+cnt,y)>=length){
				cnt++;
				if(x+cnt>=size) break;
			} 
		}
		return cnt*length;
	}
}