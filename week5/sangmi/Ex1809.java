package hw0725;

import java.util.Scanner;

public class Ex1809 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int[] top = new int [n+1];
		
		for(int i=1;i<=n;i++){
			top[i] = in.nextInt();
		}
		
		Top t = new Top(top);
		t.shoot();
		for(int i=1;i<=n;i++){
			System.out.println(t.top[i] + " ");
		}
	}

}

class Top{
	int[] top;
	int[] stack;
	int sp = 0;
	
	public Top(int[] top){
		this.top = top;
		stack = new int[top.length];
	}
	
	void push(int n) {
		stack[++sp] = n;
	}
	
	int peek() {
		return stack[sp];
	}
	
	void shoot(){
		push(top.length -1);
		for(int i=top.length-2; i>0; i--){
			if(top[stack[1]]>top[i]){
				if(top[peek()] > top[i]){
					push(i);
				}else{
					while(true){
						top[peek()] = i;
						sp--;
						if(top[peek()]>top[i]){
							push(i);
							break;
						}
					}
				}
			}else{
				while(sp > 0){
					top[peek()] =i;
					sp--;
				}
				push(i);
			}
		}
		
		while(sp>0){
			top[peek()] = 0;
			sp--;
		}
	}
}
