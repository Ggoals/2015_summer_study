package Four.Week;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Queue;
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
         
        System.out.println(getMinMoveCount(width, height));
         
        sc.close();
    }
     
     
    public static int getMinMoveCount(int w, int h) {
        Queue<Moving> movings = new LinkedList<Moving>();
        int[][] movingMap = new int[h+2][w+2];
        //movingMap.put(init, 0);
         
        for(int i = 0; i < movingMap.length; i++) {
            for(int j = 0; j < movingMap[i].length; j++) {
                movingMap[i][j] = 999999;
            }
        }
         
         
        movings.add(new Moving(init, 0));
         
        Moving endMoving = new Moving(end, 999999);
        while(!movings.isEmpty()) {
            Moving currentMove = movings.poll();
             
            //System.out.println(currentMove.axis.x+ ","+ currentMove.axis.y+ ","+ currentMove.axis.direction+ ","+ currentMove.count);
             
             
             
            //마지막 점인경우
//          if(currentMove.isEndPoint(end)) {
//              
//              int turnCount = 0;
//              if(currentMove.axis.direction == end.direction) {
//                  turnCount = 0;
//              }
//              else if(Math.abs(currentMove.axis.direction - end.direction) == 2 || Math.abs(currentMove.axis.direction - end.direction) == 3) {
//                  turnCount = 1;
//              }
//              else if((currentMove.axis.direction == 3 && end.direction == 2) || (currentMove.axis.direction == 2 && end.direction == 3)) {
//                  turnCount = 1;
//              }
//              else {
//                  turnCount = 2;
//              }
//              
//              return currentMove.count + turnCount;
//          }
            
            
            //1. 동
            if(axis[currentMove.axis.y][currentMove.axis.x + 1] != 1) {
                 
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
                 
                Moving move = new Moving(afterAxis, currentMove.count + turnCount + 1);
                 
                if(movingMap[currentMove.axis.y][currentMove.axis.x + 1]+ 1 >= move.count) {
                    movingMap[currentMove.axis.y][currentMove.axis.x + 1] = move.count;
                    //movings.remove(move);
                    movings.add(move);
                	
                     
                    if(move.isEndPoint(end)) {
                        int _turnCount = 0;
                        if(move.axis.direction == end.direction) {
                            _turnCount = 0;
                        }
                        else if(Math.abs(move.axis.direction - end.direction) == 2 || Math.abs(move.axis.direction - end.direction) == 3) {
                            _turnCount = 1;
                        }
                        else if((move.axis.direction == 3 && end.direction == 2) || (move.axis.direction == 2 && end.direction == 3)) {
                            _turnCount = 1;
                        }
                        else {
                            _turnCount = 2;
                        }
                        if(endMoving.count > move.count + _turnCount) {
                            endMoving = move;
                        }
                    }
                }
                
                //1. 동 - 2번
                if(axis[currentMove.axis.y][currentMove.axis.x + 2] != 1) {
                	Axis afterAxis2 = new Axis(afterAxis.x + 1, afterAxis.y, afterAxis.direction);
                    Moving move2 = new Moving(afterAxis2, move.count );
                     
                    if(movingMap[move.axis.y][move.axis.x + 1]+ 1 >= move2.count) {
                        movingMap[move.axis.y][move.axis.x + 1] = move2.count;
                        //movings.remove(move2);
                        movings.add(move2);
                         
                        if(move2.isEndPoint(end)) {
                            int _turnCount = 0;
                            if(move2.axis.direction == end.direction) {
                                _turnCount = 0;
                            }
                            else if(Math.abs(move2.axis.direction - end.direction) == 2 || Math.abs(move2.axis.direction - end.direction) == 3) {
                                _turnCount = 1;
                            }
                            else if((move2.axis.direction == 3 && end.direction == 2) || (move2.axis.direction == 2 && end.direction == 3)) {
                                _turnCount = 1;
                            }
                            else {
                                _turnCount = 2;
                            }
                            if(endMoving.count > move2.count + _turnCount) {
                                endMoving = move2;
                            }
                        }
                    }
                     
                  //1. 동 - 3번
                    if(axis[currentMove.axis.y][currentMove.axis.x + 3] != 1) {
                    	Axis afterAxis3 = new Axis(afterAxis2.x + 1, afterAxis2.y, afterAxis2.direction);
                        Moving move3 = new Moving(afterAxis3, move2.count );
                         
                        if(movingMap[move2.axis.y][move2.axis.x + 1]+ 1 >= move3.count) {
                            movingMap[move2.axis.y][move2.axis.x + 1] = move3.count;
                            //movings.remove(move3);
                            movings.add(move3);
                             
                            if(move3.isEndPoint(end)) {
                                int _turnCount = 0;
                                if(move3.axis.direction == end.direction) {
                                    _turnCount = 0;
                                }
                                else if(Math.abs(move3.axis.direction - end.direction) == 2 || Math.abs(move3.axis.direction - end.direction) == 3) {
                                    _turnCount = 1;
                                }
                                else if((move3.axis.direction == 3 && end.direction == 2) || (move3.axis.direction == 2 && end.direction == 3)) {
                                    _turnCount = 1;
                                }
                                else {
                                    _turnCount = 2;
                                }
                                if(endMoving.count > move3.count + _turnCount) {
                                    endMoving = move3;
                                }
                            }
                        }
                         
                         
                    }
                }
                 
            }
             
            //2. 서
            if(axis[currentMove.axis.y][currentMove.axis.x - 1] != 1) {
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
                 
                
                Moving move = new Moving(afterAxis, currentMove.count + turnCount + 1);
                if(movingMap[currentMove.axis.y][currentMove.axis.x - 1]+ 1 >= move.count) {
                    movingMap[currentMove.axis.y][currentMove.axis.x - 1] = move.count;
                    //movings.remove(move);
                    movings.add(move);
                     
                    if(move.isEndPoint(end)) {
                        int _turnCount = 0;
                        if(move.axis.direction == end.direction) {
                            _turnCount = 0;
                        }
                        else if(Math.abs(move.axis.direction - end.direction) == 2 || Math.abs(move.axis.direction - end.direction) == 3) {
                            _turnCount = 1;
                        }
                        else if((move.axis.direction == 3 && end.direction == 2) || (move.axis.direction == 2 && end.direction == 3)) {
                            _turnCount = 1;
                        }
                        else {
                            _turnCount = 2;
                        }
                        if(endMoving.count > move.count + _turnCount) {
                            endMoving = move;
                        }
                    }
                }
                
                //1. 서 - 2번
                if(axis[currentMove.axis.y][currentMove.axis.x - 2] != 1) {
                	Axis afterAxis2 = new Axis(afterAxis.x - 1, afterAxis.y, afterAxis.direction);
                    Moving move2 = new Moving(afterAxis2, move.count );
                     
                    if(movingMap[move.axis.y][move.axis.x - 1]+ 1 >= move2.count) {
                        movingMap[move.axis.y][move.axis.x - 1] = move2.count;
                        //movings.remove(move2);
                        movings.add(move2);
                         
                        if(move2.isEndPoint(end)) {
                            int _turnCount = 0;
                            if(move2.axis.direction == end.direction) {
                                _turnCount = 0;
                            }
                            else if(Math.abs(move2.axis.direction - end.direction) == 2 || Math.abs(move2.axis.direction - end.direction) == 3) {
                                _turnCount = 1;
                            }
                            else if((move2.axis.direction == 3 && end.direction == 2) || (move2.axis.direction == 2 && end.direction == 3)) {
                                _turnCount = 1;
                            }
                            else {
                                _turnCount = 2;
                            }
                            if(endMoving.count > move2.count + _turnCount) {
                                endMoving = move2;
                            }
                        }
                    }
                     
                  //1. 서 - 3번
                    if(axis[currentMove.axis.y][currentMove.axis.x - 3] != 1) {
                    	Axis afterAxis3 = new Axis(afterAxis2.x - 1, afterAxis2.y, afterAxis2.direction);
                        Moving move3 = new Moving(afterAxis3, move2.count );
                         
                        if(movingMap[move2.axis.y][move2.axis.x - 1]+ 1 >= move3.count) {
                            movingMap[move2.axis.y][move2.axis.x - 1] = move3.count;
                            //movings.remove(move3);
                            movings.add(move3);
                             
                            if(move3.isEndPoint(end)) {
                                int _turnCount = 0;
                                if(move3.axis.direction == end.direction) {
                                    _turnCount = 0;
                                }
                                else if(Math.abs(move3.axis.direction - end.direction) == 2 || Math.abs(move3.axis.direction - end.direction) == 3) {
                                    _turnCount = 1;
                                }
                                else if((move3.axis.direction == 3 && end.direction == 2) || (move3.axis.direction == 2 && end.direction == 3)) {
                                    _turnCount = 1;
                                }
                                else {
                                    _turnCount = 2;
                                }
                                if(endMoving.count > move3.count + _turnCount) {
                                    endMoving = move3;
                                }
                            }
                        }
                         
                         
                    }
                }
            }
            //3. 남
            if(axis[currentMove.axis.y + 1][currentMove.axis.x] != 1) {
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
                 
               
                Moving move = new Moving(afterAxis, currentMove.count + turnCount + 1);
                if(movingMap[currentMove.axis.y + 1][currentMove.axis.x]+ 1 >= move.count) {
                    movingMap[currentMove.axis.y + 1][currentMove.axis.x] = move.count;
                    //movings.remove(move);
                    movings.add(move);
                     
                    if(move.isEndPoint(end)) {
                        int _turnCount = 0;
                        if(move.axis.direction == end.direction) {
                            _turnCount = 0;
                        }
                        else if(Math.abs(move.axis.direction - end.direction) == 2 || Math.abs(move.axis.direction - end.direction) == 3) {
                            _turnCount = 1;
                        }
                        else if((move.axis.direction == 3 && end.direction == 2) || (move.axis.direction == 2 && end.direction == 3)) {
                            _turnCount = 1;
                        }
                        else {
                            _turnCount = 2;
                        }
                        if(endMoving.count > move.count + _turnCount) {
                            endMoving = move;
                        }
                    }
                }
                
                //3. 남 - 2번
                if(axis[currentMove.axis.y + 2][currentMove.axis.x] != 1) {
                	Axis afterAxis2 = new Axis(afterAxis.x, afterAxis.y + 1, afterAxis.direction);
                    Moving move2 = new Moving(afterAxis2, move.count );
                     
                    if(movingMap[move.axis.y + 1][move.axis.x]+ 1 >= move2.count) {
                        movingMap[move.axis.y + 1][move.axis.x] = move2.count;
                        //movings.remove(move2);
                        movings.add(move2);
                         
                        if(move2.isEndPoint(end)) {
                            int _turnCount = 0;
                            if(move2.axis.direction == end.direction) {
                                _turnCount = 0;
                            }
                            else if(Math.abs(move2.axis.direction - end.direction) == 2 || Math.abs(move2.axis.direction - end.direction) == 3) {
                                _turnCount = 1;
                            }
                            else if((move2.axis.direction == 3 && end.direction == 2) || (move2.axis.direction == 2 && end.direction == 3)) {
                                _turnCount = 1;
                            }
                            else {
                                _turnCount = 2;
                            }
                            if(endMoving.count > move2.count + _turnCount) {
                                endMoving = move2;
                            }
                        }
                    }
                     
                  //3. 남 - 3번
                    if(axis[currentMove.axis.y + 3][currentMove.axis.x] != 1) {
                    	Axis afterAxis3 = new Axis(afterAxis2.x, afterAxis2.y + 1, afterAxis2.direction);
                        Moving move3 = new Moving(afterAxis3, move2.count );
                         
                        if(movingMap[move2.axis.y + 1][move2.axis.x]+ 1 >= move3.count) {
                            movingMap[move2.axis.y + 1][move2.axis.x] = move3.count;
                            //movings.remove(move3);
                            movings.add(move3);
                             
                            if(move3.isEndPoint(end)) {
                                int _turnCount = 0;
                                if(move3.axis.direction == end.direction) {
                                    _turnCount = 0;
                                }
                                else if(Math.abs(move3.axis.direction - end.direction) == 2 || Math.abs(move3.axis.direction - end.direction) == 3) {
                                    _turnCount = 1;
                                }
                                else if((move3.axis.direction == 3 && end.direction == 2) || (move3.axis.direction == 2 && end.direction == 3)) {
                                    _turnCount = 1;
                                }
                                else {
                                    _turnCount = 2;
                                }
                                if(endMoving.count > move3.count + _turnCount) {
                                    endMoving = move3;
                                }
                            }
                        }
                         
                         
                    }
                }
            }
            //4. 북
            if(axis[currentMove.axis.y - 1][currentMove.axis.x] != 1) {
                Axis afterAxis = new Axis(currentMove.axis.x, currentMove.axis.y - 1, 4);
                 
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
                 
                
                Moving move = new Moving(afterAxis, currentMove.count + turnCount + 1);
                if(movingMap[currentMove.axis.y - 1][currentMove.axis.x]+ 1 >= move.count) {
                    movingMap[currentMove.axis.y - 1][currentMove.axis.x] = move.count;
                    //movings.remove(move);
                    movings.add(move);
                     
                    if(move.isEndPoint(end)) {
                        int _turnCount = 0;
                        if(move.axis.direction == end.direction) {
                            _turnCount = 0;
                        }
                        else if(Math.abs(move.axis.direction - end.direction) == 2 || Math.abs(move.axis.direction - end.direction) == 3) {
                            _turnCount = 1;
                        }
                        else if((move.axis.direction == 3 && end.direction == 2) || (move.axis.direction == 2 && end.direction == 3)) {
                            _turnCount = 1;
                        }
                        else {
                            _turnCount = 2;
                        }
                        if(endMoving.count > move.count + _turnCount) {
                            endMoving = move;
                        }
                    }
                }
                
                //4. 북 - 2번
                if(axis[currentMove.axis.y - 2][currentMove.axis.x] != 1) {
                	Axis afterAxis2 = new Axis(afterAxis.x, afterAxis.y - 1, afterAxis.direction);
                    Moving move2 = new Moving(afterAxis2, move.count );
                     
                    if(movingMap[move.axis.y - 1][move.axis.x] + 1 >= move2.count) {
                        movingMap[move.axis.y - 1][move.axis.x] = move2.count;
                        //movings.remove(move2);
                        movings.add(move2);
                         
                        if(move2.isEndPoint(end)) {
                            int _turnCount = 0;
                            if(move2.axis.direction == end.direction) {
                                _turnCount = 0;
                            }
                            else if(Math.abs(move2.axis.direction - end.direction) == 2 || Math.abs(move2.axis.direction - end.direction) == 3) {
                                _turnCount = 1;
                            }
                            else if((move2.axis.direction == 3 && end.direction == 2) || (move2.axis.direction == 2 && end.direction == 3)) {
                                _turnCount = 1;
                            }
                            else {
                                _turnCount = 2;
                            }
                            if(endMoving.count > move2.count + _turnCount) {
                                endMoving = move2;
                            }
                        }
                    }
                     
                  //4. 북 - 3번
                    if(axis[currentMove.axis.y - 3][currentMove.axis.x] != 1) {
                    	Axis afterAxis3 = new Axis(afterAxis2.x, afterAxis2.y - 1, afterAxis2.direction);
                        Moving move3 = new Moving(afterAxis3, move2.count );
                         
                        if(movingMap[move2.axis.y - 1][move2.axis.x]+ 1 >= move3.count) {
                            movingMap[move2.axis.y - 1][move2.axis.x] = move3.count;
                            //movings.remove(move3);
                            movings.add(move3);
                             
                            if(move3.isEndPoint(end)) {
                                int _turnCount = 0;
                                if(move3.axis.direction == end.direction) {
                                    _turnCount = 0;
                                }
                                else if(Math.abs(move3.axis.direction - end.direction) == 2 || Math.abs(move3.axis.direction - end.direction) == 3) {
                                    _turnCount = 1;
                                }
                                else if((move3.axis.direction == 3 && end.direction == 2) || (move3.axis.direction == 2 && end.direction == 3)) {
                                    _turnCount = 1;
                                }
                                else {
                                    _turnCount = 2;
                                }
                                if(endMoving.count > move3.count + _turnCount) {
                                    endMoving = move3;
                                }
                            }
                        }
                         
                         
                    }
                }
            }
        }
         
        return endMoving.count;
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
