package Four.Week;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;

public class code_1669 {
	public static void main(String args[]) {
		int count;
		Scanner sc = new Scanner(System.in);
		
		count = sc.nextInt();
		
		List<Sousage> sousages = new ArrayList<Sousage>();
		
		for(int i = 0; i < count; i++) {
			sousages.add(new Sousage(sc.nextInt(), sc.nextInt()));
		}
		
		sousages.sort(new SousageLComparator());
		int minCount = getChangeCount(sousages);

		System.out.println(minCount);
		
		sc.close();
	}	
	
	public static int getChangeCount(List<Sousage> sousages) {
		int count = 0;
		
		
		while(sousages.size() > 0){
			
			Sousage beforeMakingSousage = sousages.get(0);
			sousages.remove(0);
			for(int i = 0; i < sousages.size(); i++) {
				if(beforeMakingSousage.sw <= sousages.get(i).sw) {
					beforeMakingSousage = sousages.get(i);
					sousages.remove(i);
					i--;
				}
			}
			count++;
		}
		
		
		return count;
	}
	
	
	public static class SousageLComparator implements Comparator<Sousage> {

		@Override
		public int compare(Sousage arg0, Sousage arg1) {
			int compare = arg0.sl - arg1.sl;
			if(compare == 0){
				return arg0.sw - arg1.sw;
			}
			
			return compare;
		}
		
	}
}

class Sousage {
	int sw;
	int sl;
	
	public Sousage (int w, int l) {
		this.sw = w;
		this.sl = l;
	}
}
