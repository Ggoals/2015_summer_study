package SixWeek;

import java.util.*;

public class TSP {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		
		for(int i = 0; i < count; i++) {
			int size = sc.nextInt();
			tspAlgorithm tsp = new tspAlgorithm(size);
			System.out.println(tsp.caculateTSP(1, 8));
		}
		
		
		
		sc.close();
	}
}

class tspAlgorithm {
	private int _size;
	private int _distance[][];
	private int _memory[][];
	
	public tspAlgorithm(int size) {
		this._size = size;
		this._distance = new int[size][size];
		this._memory = new int[size][1<<size];
	}
	
	public int caculateTSP(int from, int toFlag) {
		
		int memo = _memory[from][toFlag]; // _memory[][] 가 0 로 초기화 되어 있어야 함.
	    if (memo != 0) {
	        return memo;
	    }
	    if (__builtin_popcount(toFlag) == 1) {
	        int to = __builtin_ctz(toFlag);
	        return _distance[from][to];
	    }
	 
	    memo = 99999999; // 그냥 충분히 큰 수를 사용해도 된다
	    for (int i = 0; i < _size /* the nuber of cities */; i++) {
	        if ( !(toFlag & (1 << i)) ) continue;
	 
	        int v = _distance[from][i] + caculateTSP(i, (toFlag & ~(1<<i)));
	        memo = Math.min(memo, v);
	    }
	    return memo;
	}
}
