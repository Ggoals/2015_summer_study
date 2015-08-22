package org.javatest.eclipse;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AlgoGrid {
    static BufferedReader stdin
    		= new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int W;
    static int[] res;
    static Memorizer mem;
	
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(stdin.readLine());
        res = new int[N];
        for(int n = 0; n < N; n++) {
            W = Integer.parseInt(stdin.readLine());
            mem = new Memorizer(W);
            res[n] = getWayToFill(0, 0);
        }
        for(int i = 0; i < N; i++)
            System.out.println((i + 1) + " " + res[i]);
    }
    
    /* 
     * TYPE is representing the condition of COLUMN 
     *      (left = upside) ('#' is block, '*' is empty tile)
     * - TYPE 0 =   ****   (next can be 0, 1, 3, 4 or jump two columns)
     * - TYPE 1 =   #**#   (next can be 0, 2)
     * - TYPE 2 =   *##*   (next can be 1)
     * - TYPE 3 =   ##**   (next can be 0, 4)
     * - TYPE 4 =   **##   (next can be 0, 3)
     */
    static int getWayToFill(int currCol, int blockType) {
        if(currCol == W)
            return 1;
        else if(currCol == (W - 1))
            return (blockType == 2) ? 0 : 1;
        
        int found = mem.get(currCol, blockType);
        if(found != -1)
            return found;
        
        int[] nextBlockType = new int[0];
        switch(blockType) {
            case 0  : nextBlockType = new int[]{0, 1, 3, 4}; break;
            case 1  : nextBlockType = new int[]{0, 2};       break;
            case 2  : nextBlockType = new int[]{1};          break;
            case 3  : nextBlockType = new int[]{0, 4};       break;
            case 4  : nextBlockType = new int[]{0, 3};       break;
            default : System.out.println("ERROR (NEVER REACHED)");
        }
        
        int way = 0;
        for(int i = 0; i < nextBlockType.length; i++)
            way += getWayToFill(currCol + 1, nextBlockType[i]);
        if(blockType == 0)
            way += getWayToFill(currCol + 2, 0);
        
        mem.put(currCol, blockType, way);
        return way;
    }
    
    static class Memorizer {
        int[][] wayMem;
        
        Memorizer(int colNum) {
            wayMem = new int[colNum][];
            for(int i = 0; i < colNum; i++) {
                wayMem[i] = new int[5];
                Arrays.fill(wayMem[i], -1);
            }
        }
        
        int get(int colNum, int blockType) {
            return wayMem[colNum][blockType];
        }
        
        void put(int colNum, int blockType, int way) {
            wayMem[colNum][blockType] = way;
        }
	}

}
