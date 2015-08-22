import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class NumberGame {
	static int[] board;
	static int EMPTY = -987654321;
	static int[][] cache;
	public static void main(String[] args){
		Scanner sn = new Scanner(System.in);
		int i,j,n,l;
		
		n=sn.nextInt();
		while(n>0){
			n--;
			
			int bl = sn.nextInt();		//board length
			board = new int[bl];
			cache = new int[bl][bl];
			for(i=0;i<bl;i++)
				board[i] = sn.nextInt();
				
			for(i=0;i<bl;i++) for(j=0;j<bl;j++) cache[i][j]= EMPTY;
			System.out.println(dp(0,bl-1));	
			
		}
		
	}
	static int dp(int left, int right){
		if(left>right) return 0;
		int val = cache[left][right];
		if(val!=EMPTY) return val;
		
		int val1,val2;
		val1 = board[left] - dp(left+1,right);
		val2 = board[right] - dp(left,right-1);
		val = (val1>val2)?val1:val2;
		if(right-left+1>=2){
		   int tmp = -dp(left+2,right);
		   val =(tmp>val)?tmp:val;
		   tmp = -dp(left,right-2);
		   val =(tmp>val)?tmp:val;
		}
		
		cache[left][right] = val;
		return val;
		
		
	}
	
}
