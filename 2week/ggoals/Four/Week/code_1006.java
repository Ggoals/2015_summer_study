package Four.Week;

import java.util.Scanner;
import java.util.Queue;
import java.util.HashSet;
import java.util.Set;
import java.util.LinkedList;

public class code_1006 {
	public static int axis[][];
	
	public static Axis init;
	public static Axis end;
	
	public static void main(String args[] ) {
		Scanner sc = new Scanner(System.in);
		
		int height = sc.nextInt();
		int width = sc.nextInt();
		
		axis = new int[height+2][width+2];
		
		
		for(int y = 1; y <= height; y++) {
			for(int x = 1; x <= width; x++) {
				axis[y][x] = sc.nextInt();
			}
		}
		
		for(int y = 1; y <= height; y++) {
			axis[y][0] = 1;
			axis[y][width + 1] = 1;
		}
		for(int x = 1; x <= width; x++) {
			axis[0][x] = 1;
			axis[height + 1][x] = 1;
		}
		
		end = new Axis(sc.nextInt(), sc.nextInt(), sc.nextInt());
		init = new Axis(sc.nextInt(), sc.nextInt(), sc.nextInt());
		
		System.out.println(getMinMoveCount());
		
		sc.close();
	}
	
	
	public static int getMinMoveCount() {
		Queue<Moving> movings = new LinkedList<Moving>();
		Set<Axis> movingSet = new HashSet<Axis>();
		movingSet.add(init);
		
		movings.add(new Moving(init, 0));
		
		while(!movings.isEmpty()) {
			Moving currentMove = movings.poll();
			
			System.out.println(currentMove.axis.x+ ","+ currentMove.axis.y+ ","+ currentMove.count);
			
			//도착점이면 리턴
			if(currentMove.isEndPoint(end)) {
				return currentMove.count;
			}
			//네방향 큐에 넣기, 넣기전에 이미 Map 에 있는지만 확인 + 막혀잇으면 넣지 말기. 있으면 넣지 말기
			//1. 동
			if(axis[currentMove.axis.y][currentMove.axis.x + 1] != 1
							&& !movingSet.contains(new Axis(currentMove.axis.x + 1, currentMove.axis.y, 0))) {
				
				Axis afterAxis = new Axis(currentMove.axis.x + 1, currentMove.axis.y, 1);
				
				int turnCount = 0;
				if(currentMove.axis.direction == 2) {
					turnCount = 2;
				}
				else if(currentMove.axis.direction == 1) {
					turnCount = 0;
				}
				else {
					turnCount = 1;
				}
				Moving move = new Moving(afterAxis, turnCount + 1);
				movingSet.add(afterAxis);
				movings.add(move);
			}
			
			//2. 서
			if(axis[currentMove.axis.y][currentMove.axis.x - 1] != 1
					&& !movingSet.contains(new Axis(currentMove.axis.x -1, currentMove.axis.y, 0))) {
				Axis afterAxis = new Axis(currentMove.axis.x - 1, currentMove.axis.y, 2);
				
				int turnCount = 0;
				if(currentMove.axis.direction == 1) {
					turnCount = 2;
				}
				else if(currentMove.axis.direction == 2) {
					turnCount = 0;
				}
				else {
					turnCount = 1;
				}
				Moving move = new Moving(afterAxis, turnCount + 1);
				movingSet.add(afterAxis);
				movings.add(move);
			}
			//3. 남
			if(axis[currentMove.axis.y + 1][currentMove.axis.x] != 1
					&& !movingSet.contains(new Axis(currentMove.axis.x, currentMove.axis.y + 1, 0))) {
				Axis afterAxis = new Axis(currentMove.axis.x, currentMove.axis.y + 1, 3);
				
				int turnCount = 0;
				if(currentMove.axis.direction == 4) {
					turnCount = 2;
				}
				else if(currentMove.axis.direction == 3) {
					turnCount = 0;
				}
				else {
					turnCount = 1;
				}
				Moving move = new Moving(afterAxis, turnCount + 1);
				movingSet.add(afterAxis);
				movings.add(move);
			}
			//4. 북
			if(axis[currentMove.axis.y - 1][currentMove.axis.x] != 1
					&& !movingSet.contains(new Axis(currentMove.axis.x, currentMove.axis.y - 1, 0))) {
				Axis afterAxis = new Axis(currentMove.axis.x, currentMove.axis.y - 1, 3);
				
				int turnCount = 0;
				if(currentMove.axis.direction == 3) {
					turnCount = 2;
				}
				else if(currentMove.axis.direction == 4) {
					turnCount = 0;
				}
				else {
					turnCount = 1;
				}
				Moving move = new Moving(afterAxis, turnCount + 1);
				movingSet.add(afterAxis);
				movings.add(move);
			}
		}
		
		return -1;
	}
	
	
}

class Moving {
	public Axis axis;
	public int count;
	
	public Moving(Axis axis, int count) {
		this.axis = axis;
		this.count = count;
	}
	
	public boolean isEndPoint(Axis endAxis) {
		if(this.axis.x == endAxis.x && this.axis.y == endAxis.y) {
			return true;
		}
		else {
			return false;
		}
	}
}

class Axis {
	public int x;
	public int y;
	public int direction;
	
	public Axis(int x, int y, int d) {
		this.x = x;
		this.y = y;
		this.direction = d;
	}
	
	@Override
	public int hashCode() {
		return ("__Axis" + x + y).hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this.x == ((Axis)obj).x && this.y == ((Axis)obj).y){
			return true;
		}
		
		return false;
	}
}
