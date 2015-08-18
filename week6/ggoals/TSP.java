package SixWeek;

import java.util.*;

public class TSP {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();

		
		for(int i = 0; i < count; i++) {
			int size = sc.nextInt();
			tspAlgorithm tsp = new tspAlgorithm(size);
			
			for(int j = 0; j < size; j++) {
				for(int k = 0; k < size; k++) {
					tsp._distance[j][k] = sc.nextDouble();
				}
			}
			double min = Integer.MAX_VALUE;
			
			for(int j = 0; j < size; j++) {
				min = Math.min(min, tsp.caculateTSP(j, (1<<size) - 1));
			}
			System.out.println(min);
		}
		
		
		
		sc.close();
	}
}

class tspAlgorithm {
	private int _size;
	public double _distance[][];
	private double _memory[][];
	
	public tspAlgorithm(int size) {
		this._size = size;
		this._distance = new double[size][size];
		this._memory = new double[size][1<<size];
	}
	
	public double caculateTSP(int from, int toFlag) {
		
		
		double memo = _memory[from][toFlag]; 
	    if (memo != 0) {
	        return memo;
	    }
	    if (__builtin_popcount(toFlag) == 1) {
	        int to = __builtin_ctz(toFlag);
	        return _distance[from][to];
	    }
	 
	    memo = 99999999; 
	    for (int i = 0; i < _size /* the number of cities */; i++) {
	        if ( ( toFlag & (1 << i) ) == 0 ) continue;
	 
	        double v = _distance[from][i] + caculateTSP(i, ( toFlag & ~(1<<i) ) );
	        memo = Math.min(memo, v);
	    }
	    return memo;
	}
	
	private int __builtin_popcount(int num) {
		int count = 0;
		
		while(num > 0) {
			count += num % 2;
			num = num / 2;
		}
		
		return count;
	}
	
	private int __builtin_ctz(int num) {
		int count = -1;
		
		while(num > 0) {
			num = num /2;
			count++;
		}
		
		return count;
	}
}
