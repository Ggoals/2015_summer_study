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
			
		input = sn.nextLine().toCharArray();	// input�� Char �迭 ���·� ����
		l =input.length;						// input ����
		value = new int[l+1][l+1];				// KOI�������� ���� �ִ밪�� �����ϴ� �迭 		 
												// e.g) value[2][5]: 2�� 5���̿� �ִ� KOI�������� �ִ밪 
		for(i=1;i<=l;i++)
			value[i][i]=0;						// ����0 ������ �� 0���� �ʱ�ȭ
		
		
		/*
		 * g: ���������� g+1���� ��ŭ �˻� (g�� �����ϸ鼭 search ������ ����)
		 * �������� i, ������ j(i+g)
		 * */
		for(g=1;g<l;g++){						
			for(i=1;i<=l-g;i++){								
				j=i+g;							
				value[i][j]=0;					// ���� �� KOI�����ڰ� �ʱ�ȭ
				
				if(g==1){ 						// ���� 2�ΰ�� 'at' Ȥ�� 'gc'�˻�. �˻� �� ��� ���̰� 2�� �迭�� ����, �ƴϸ� 0�� ����						
					if(input[i-1]=='a'&&input[j-1]=='t') value[i][j]=2;
					else if(input[i-1]=='g'&&input[j-1]=='c') value[i][j]=2;
					else value[i][j]=0;			
				}else{
					// ������(i)�� ����(j)�� ���� (a,t) Ȥ�� (g,c) �� �˻� �ɰ�� ���̰�(i+1���� j-1����)+2�� ���� value[i][j]�� ����
					if(input[i-1]=='a' && input[j-1]=='t')  
						assign(i,j,value[i+1][j-1]+2);
					else if(input[i-1]=='g' && input[j-1]=='c')
						assign(i,j,value[i+1][j-1]+2);
					
					
					// i���� j ������ KOI �ִ밪 search �� ����
					for(k=i;k<j;k++)
						assign(i,j,value[i][k]+value[k+1][j]);
					
				}
			}
		}
		
		System.out.println(value[1][l]);
		
	}
	
	
	/*
	 * f ���� t������ KOI������ �ִ밪�� v���� ����
	 * v���� �� Ŭ ���  KOI������ �ִ밪�� v������ ����
	 */
	public static void assign(int f, int t, int v){
		if(value[f][t]<v)
			value[f][t]=v;
	}
	
	
}
