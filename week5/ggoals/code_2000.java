package FiveWeek;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class code_2000 {
	
	
	
	public static int change;
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int count = sc.nextInt();
		
		List<Integer> coins = new ArrayList<Integer>();
		
		for(int i = 0; i < count; i++) {
			coins.add(sc.nextInt());
		}
		
		change = sc.nextInt();
		
		//coins.sort(new coinArrComparator());
		
		getMinCoinCount(coins);
		
		sc.close();
	}
	
	public static void getMinCoinCount(List<Integer> coins) {
		int countArr[] = new int[change + 1];
		int lastCoin[] = new int[change + 1];
		
		int coinIdx = 0;
		
		
		
		
		if(change < coins.get(coinIdx)) {
			System.out.println("impossible");
			return;
		}
		
		for(int i = coins.get(coinIdx); i <= change; ) {
			countArr[i] = countArr[i - coins.get(coinIdx)] + 1;
			lastCoin[i] = coins.get(coinIdx);
			i += coins.get(coinIdx);
		}
		
		for(int i = 1; i < coins.size(); i++){
			for ( int j = coins.get(i); j <= change; j++) {
				if((countArr[j] > countArr[j - coins.get(i)] + 1 || countArr[j] == 0)
						&& (lastCoin[j - coins.get(i)] != 0 || j - coins.get(i) == 0)) {
					countArr[j] = countArr[j - coins.get(i)] + 1;
					lastCoin[j] = coins.get(i);
					
				}
			}
		}
		
		
		if(countArr[change] != 0) {
			System.out.println(countArr[change]);
		} else {
			System.out.println("impossible");
		}
		
		
		
	}
	
	
}
class coinArrComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		
		return o1 - o2;
	}		
}