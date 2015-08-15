import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class AL1701 {
	static int l;
	static char[] input;
	static int[][] value;	
	
	public static void main(String[] args){
		int i,j,g,k;
		Scanner sn = new Scanner(System.in);
			
		input = sn.nextLine().toCharArray();	// input을 Char 배열 형태로 저장
		l =input.length;						// input 길이
		value = new int[l+1][l+1];				// KOI유전자의 길이 최대값을 저장하는 배열 		 
												// e.g) value[2][5]: 2와 5사이에 있는 KOI유전자의 최대값 
		for(i=1;i<=l;i++)
			value[i][i]=0;						// 길이0 구간을 값 0으로 초기화
		
		
		/*
		 * g: 시작점부터 g+1길이 만큼 검색 (g가 증가하면서 search 범위가 증가)
		 * 시작점은 i, 끝점은 j(i+g)
		 * */
		for(g=1;g<l;g++){						
			for(i=1;i<=l-g;i++){								
				j=i+g;							
				value[i][j]=0;					// 범위 내 KOI유전자값 초기화
				
				if(g==1){ 						// 길이 2인경우 'at' 혹은 'gc'검색. 검색 될 경우 길이값 2를 배열에 지정, 아니면 0을 지정						
					if(input[i-1]=='a'&&input[j-1]=='t') value[i][j]=2;
					else if(input[i-1]=='g'&&input[j-1]=='c') value[i][j]=2;
					else value[i][j]=0;			
				}else{
					// 시작점(i)과 끝점(j)에 각각 (a,t) 혹은 (g,c) 가 검색 될경우 사이값(i+1부터 j-1까지)+2의 값을 value[i][j]에 저장
					if(input[i-1]=='a' && input[j-1]=='t')  
						assign(i,j,value[i+1][j-1]+2);
					else if(input[i-1]=='g' && input[j-1]=='c')
						assign(i,j,value[i+1][j-1]+2);
					
					
					// i부터 j 사이의 KOI 최대값 search 및 저장
					for(k=i;k<j;k++)
						assign(i,j,value[i][k]+value[k+1][j]);
					
				}
			}
		}
		
		System.out.println(value[1][l]);
		
	}
	
	
	/*
	 * f 부터 t까지의 KOI유전자 최대값과 v값을 비교후
	 * v값이 더 클 경우  KOI유전자 최대값을 v값으로 변경
	 */
	public static void assign(int f, int t, int v){
		if(value[f][t]<v)
			value[f][t]=v;
	}
	
	
}
