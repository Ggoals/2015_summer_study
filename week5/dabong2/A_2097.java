package jungol;
import java.io.*;
import java.util.*;

public class A_2097 {




    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
         
        int n = in.nextInt();
        Subway s = new Subway(n, in.nextInt());
        for(int i = 1; i <= n; ++i) {
            for(int j = 1; j <= n; ++j) {
                s.addEdge(i, j, in.nextInt());
            }
        }

        s.dijkstra();
            }
}

class Graph {
    protected int n;
    protected int[][] map;
    
    public Graph() {}
    public Graph(int n) {
        this.n = n;
        this.map = new int[n + 1][n + 1];
    }
    
    protected void addEdge(int u, int v, int weight) {
        map[u][v] = weight;
    }
}

class Subway extends Graph {
    private int m;
    private int[] distance;
    private int[] route;
    private boolean[] check;
    private ArrayList<Integer> list;
    
    public Subway() {}
    public Subway(int n, int m) {
        super(n);
        this.m = m;
        this.distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;
        this.route = new int[n + 1];
        this.check = new boolean[n + 1];
    }
    

    void dijkstra(){
        int min, pos = 0;
        
        for(int i = 1; i <= n; ++i) {
            min = Integer.MAX_VALUE;
            for(int j = 1; j <= n; ++j) {
                if(!check[j] && (distance[j] < min)) {
                    min = distance[j];
                    pos = j;
                }
            }
            check[pos] = true;
            for(int j = 1; j <= n; ++j) {
                if(distance[pos] + map[pos][j] < distance[j]) {
                    distance[j] = distance[pos] + map[pos][j];
                    route[j] = pos;
                }
            }
        }
        
        System.out.println(distance[m]);
        list = new ArrayList<>();
        pos = m;
        while(pos != 1) {
            list.add(pos);
            pos = route[pos];
        }
        list.add(1);
        for(int i = list.size() - 1; i >= 0; --i) {
        	System.out.print(list.get(i) + " ");
        }
    }
}

