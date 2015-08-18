package hw0725;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex1141 {
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner in = new Scanner(System.in);
		
		
		int n = in.nextInt();
		int[] hair = new int[n+1];
		
		for(int i=1; i<=n; i++){
			hair[i]=in.nextInt();
		}
		
		BadHairDay bhd = new BadHairDay(hair);
		System.out.println(bhd.sum());
		
		in.close();
		
	}
}

class BadHairDay{
	
	int[] hair;
	int[] stack;
	int lo =0;
	
	public BadHairDay(int[] hair){
		this.hair = hair;
		stack = new int[hair.length];
	}
	
	long sum(){
		long sum = 0;
		push(hair[1]);//h[1]�� ���� stack[1]�� ����
		for(int i=2; i<hair.length; i++){ 
			if(stack[lo] > hair[i]){ // ���� �Ұ� ���� ��� 
				sum += lo;  //�� �� �ִ� ���� �Ӹ� ��+
				push(hair[i]); 
			}else{ //���ų� �� ū �Ұ� ���� ���
				while(lo > 0){ 
					pop(); //�� �� �ִ� ���� �Ӹ� cnt ����. hair[i] ��ġ�� �ٽ� ������ ������ 
					if(stack[lo] > hair[i]) break; //�ٽ� ������ �� ũ�� ��ġ ���� ����
				}
				if(lo != 0) sum += lo;
				push(hair[i]);
			}
		}
		return sum;
	}
	
	void push(int num){
		stack[++lo] = num;
	}
	void pop(){
		lo--;
	}
}
