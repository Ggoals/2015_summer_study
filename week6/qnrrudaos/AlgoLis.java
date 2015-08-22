package org.javatest.eclipse;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AlgoLis {
    static BufferedReader stdin
    		= new BufferedReader(new InputStreamReader(System.in));

    static int C;
    static int N;
    static int[] input;
    static int[] res;
	
    public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
        C = Integer.parseInt(stdin.readLine());
        res = new int[C];
        for(int c = 0; c < C; c++) {
            N = Integer.parseInt(stdin.readLine());
            input = new int[N];
            String[] tmp = stdin.readLine().split(" ");
            for(int n = 0; n < N; n++)
               input[n] = Integer.parseInt(tmp[n]);
            res[c] = solve();
        }
        for(int r : res)
            System.out.println(r);
    }
    
    static int solve() {
        int[] lis = new int[N];
        lis[0] = 1;
        int maxLisLen = Integer.MIN_VALUE;
        for(int k = 1; k < N; k++) {
            int max = Integer.MIN_VALUE;
            int iMax = Integer.MIN_VALUE;
            for(int j = 0; j < k; j++) {
                if(input[j] < input[k] && lis[j] > max) {
                    max = lis[j];
                    iMax = j;
                }
            }
            lis[k] = (max == Integer.MIN_VALUE) ? 1 : lis[iMax] + 1;
            if(lis[k] > maxLisLen)
                maxLisLen = lis[k];
        }
        return maxLisLen;
	}

}
