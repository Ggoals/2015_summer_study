
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
//50Á¡
public class AL1006 {
	public static List<String> path = new ArrayList<String>();
	public static int[][] plane;
	public static int row;
	public static int column;
	public static int[] from;
	public static int[] to;
	public static int current;
	public static int next;
	public static int max=99999;
	public static int cnt = 0;
	
	
	public static void main(String[] args){		
		Scanner sn = new Scanner(System.in);
		from = new int[3];
		to = new int[3];
		row = sn.nextInt();
		column = sn.nextInt();		
		plane =  new int[row][column];
		
		for(int x = 0; x<row;x++){
			for(int y=0; y<column; y++){
				int tmp = sn.nextInt();
				plane[x][y] = (tmp==1)?-1:0;
			}
		}
		 
		for(int i=0; i<6; i++){
			if(i<3) from[i] = sn.nextInt()-1;
			else to[i-3] = sn.nextInt()-1;
		}
		
		
		searchNode(from[0],from[1],from[2]);
		System.out.println(plane[to[0]][to[1]]);
		//display();
				
	}	
	
	
	public static void searchNode(int x, int y, int dir){	
		moveToEast(x,y,dir);
		moveToWest(x,y,dir);
		moveToSouth(x,y,dir);
		moveToNorth(x,y,dir);
		
	}
	
	public static boolean checkEnd(int x, int y){
		if(x==to[0]&&y==to[1]) return true;
		else return false;
	}
	
	public static void setEnd(int x, int y, int dir){
		if(dir!=to[2]){
			if(dir==0){
				if(to[2]==1) plane[x][y] =  plane[x][y]+2;
				else  plane[x][y]++;
			}else if(dir==1){
				if(to[2]==0) plane[x][y] =  plane[x][y]+2;
				else  plane[x][y]++;
			}else if(dir==2){
				if(to[2]==3) plane[x][y] =  plane[x][y]+2;
				else plane[x][y]++;
			}else{
				if(to[2]==2) plane[x][y] =  plane[x][y]+2;				
				else plane[x][y]++;
			}
		} 
		max =  plane[x][y];	
	}
	
	public static void moveToEast(int x, int y, int dir){
		if(checkPossibility(x,y,0)){					// Go 1
			if(dir==0) next = plane[x][y]+1;
			else if(dir==1) next = plane[x][y]+3;
			else next = plane[x][y]+2;
			
			if(next<=max&&((plane[x][y+1]==0)||next<=plane[x][y+1])){
				plane[x][y+1] = next;
				if(checkPossibility(x,y+1,0)){			// Go 2
					if((plane[x][y+2]==0)||(next<=plane[x][y+2])){
						plane[x][y+2] = next;
						if(checkPossibility(x,y+2,0)){	// Go 3
							if((plane[x][y+3]==0)||(next<=plane[x][y+3])){
								plane[x][y+3] = next;
								if(checkEnd(x,y+3)){ setEnd(x,y+3,0);}
								else searchNode(x,y+3,0);
							}							
						}
						if(checkEnd(x,y+2)){ setEnd(x,y+2,0);}
						else searchNode(x,y+2,0);
					}					
				}
				if(checkEnd(x,y+1)){ setEnd(x,y+1,0);}
				else searchNode(x,y+1,0);
			} 			
		}
	}
	
	public static void moveToWest(int x, int y, int dir){
		if(checkPossibility(x,y,1)){					// Go 1
			if(dir==1) next = plane[x][y]+1;
			else if(dir==0) next= plane[x][y]+3;
			else next = plane[x][y]+2;
		
			if(next<=max&&((plane[x][y-1]==0)||(next<=plane[x][y-1]))){
				plane[x][y-1] = next;
				
				if(checkPossibility(x,y-1,1)){			// Go 2
					
					if((plane[x][y-2]==0)||(next<=plane[x][y-2])){
						plane[x][y-2] = next;
						if(checkPossibility(x,y-2,1)){
							if((plane[x][y-3]==0)||(next<=plane[x][y-3])){
								plane[x][y-3] = next;
								if(checkEnd(x,y-3)){ setEnd(x,y-3,1);}
								else searchNode(x,y-3,1);
							}							
						}
						if(checkEnd(x,y-2)){ setEnd(x,y-2,1); }
						else searchNode(x,y-2,1);
					}					
				}
				if(checkEnd(x,y-1)){  setEnd(x,y-1,1); }
				else searchNode(x,y-1,1);
			} 			
		}
	}
	
	public static void moveToSouth(int x, int y, int dir){
		if(checkPossibility(x,y,2)){					// Go 1
			if(dir==2) next= plane[x][y]+1;
			else if(dir==3) next= plane[x][y]+3;
			else next = plane[x][y]+2;
			
			if(next<=max&&((plane[x+1][y]==0)||next<=plane[x+1][y])){
				plane[x+1][y] = next;
				if(checkPossibility(x+1,y,2)){			// Go 2
					if((plane[x+2][y]==0)||(next<=plane[x+2][y])){
						plane[x+2][y] = next;
						if(checkPossibility(x+2,y,2)){
							if((plane[x+3][y]==0)||(next<=plane[x+3][y])){
								plane[x+3][y] = next;
								if(checkEnd(x+3,y)){ setEnd(x+3,y,2); }
								else searchNode(x+3,y,2);
							}							
						}
						if(checkEnd(x+2,y)){ setEnd(x+2,y,2); }
						else searchNode(x+2,y,2);
					}					
				}
				if(checkEnd(x+1,y)){ setEnd(x+1,y,2); }
				else searchNode(x+1,y,2);
			} 			
		}
	}	
	
	public static void moveToNorth(int x, int y, int dir){
		if(checkPossibility(x,y,3)){					// Go 1
			if(dir==3) next = plane[x][y]+1;
			else if(dir==2) next = plane[x][y]+3;
			else next = plane[x][y]+2;
			
			if(next<=max&&((plane[x-1][y]==0)||next<=plane[x-1][y])){
				plane[x-1][y] = next;
				if(checkPossibility(x-1,y,3)){			// Go 2
					if((plane[x-2][y]==0)||(next<=plane[x-2][y])){
						plane[x-2][y] = next;
						if(checkPossibility(x-2,y,3)){	// Go 3
							if((plane[x-3][y]==0)||(next<=plane[x-3][y])){
								plane[x-3][y] = next;
								if(checkEnd(x-3,y)){ setEnd(x-3,y,3); }
								else searchNode(x-3,y,3);
							}							
						}
						if(checkEnd(x-2,y)){  setEnd(x-2,y,3); }
						else searchNode(x-2,y,3);
					}					
				}
				if(checkEnd(x-1,y)){  setEnd(x-1,y,3);   }
				else searchNode(x-1,y,3);
			} 			
		}
	}	
	
	public static boolean checkPossibility(int x, int y, int dir){
		if(dir==0){
			if((y<column-1)&&!((x==from[0])&&(y+1==from[1]))){
				if(plane[x][y+1] != -1){	return true;	}
			}
		}else if(dir==1){
			if((y>0)&&!((x==from[0])&&(y-1==from[1]))){
				if(plane[x][y-1] != -1){ 	return true; 	}
			}
		}else if(dir==2){
			if((x<row-1)&&!((x+1==from[0])&&(y==from[1]))){
				if(plane[x+1][y] != -1){ 	return true; 	}
			}
		}else if(dir==3){
			if((x>0)&&!((x-1==from[0])&&(y==from[1]))){
				if(plane[x-1][y] != -1){ 	return true;	}
			}
		}
		
		return false;
	}
	
	public static void display(int fx, int fy,int tx, int ty){
		if(cnt<50){
			System.out.println("From: " +fx + ","+ fy+" To: " + tx +","+ty);
			for(int x = 0; x<row;x++){
				for(int y=0; y<column; y++){
					int tmp2 = plane[x][y];
					if(tmp2>=0&&tmp2<10) System.out.print("0"+tmp2+ " ");
					else System.out.print(tmp2 + " ");
				}
				System.out.println();
			}
			System.out.println();
			cnt++;
		}
		
	}
	
	public static void display(){
		
		for(int x = 0; x<row;x++){
			for(int y=0; y<column; y++){
				int tmp2 = plane[x][y];
				if(tmp2>=0&&tmp2<10) System.out.print("0"+tmp2+ " ");
				else System.out.print(tmp2 + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
