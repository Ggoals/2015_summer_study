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
		push(hair[1]);//h[1]의 값을 stack[1]에 넣음
		for(int i=2; i<hair.length; i++){ 
			if(stack[lo] > hair[i]){ // 앞의 소가 작을 경우 
				sum += lo;  //볼 수 있는 소의 머리 즐가+
				push(hair[i]); 
			}else{ //같거나 더 큰 소가 나올 경우
				while(lo > 0){ 
					pop(); //볼 수 있는 소의 머리 cnt 안함. hair[i] 위치가 다시 앞으로 지워짐 
					if(stack[lo] > hair[i]) break; //다시 비교했을 때 크면 위치 감소 멈춤
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
