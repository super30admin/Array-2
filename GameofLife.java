//Time complexity : O(m*n);
// space complexity : O(1)
package ThirdWeek;

import java.util.Arrays;

public class GameofLife {
   static int m;
    static int n;
public static int[][] gameOfLife(int[][] board ){
// Core logic 1 - >0 = 2 ; 0 -> 1 = 3 , Here 2 and 3 are place holder for 0 and 1 which have changed
    m=board.length;
    n=board[0].length;

    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){

            int count = countLives(board,i,j);
//Rule 1
            if(board[i][j] == 1 && (count <2 || count >3)){
                board[i][j] = 2;
            }
            //rule 2
            if(board[i][j] == 0 && ( count ==3)){
                board[i][j] = 3;
            }
        }
    }

    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){

            int count = countLives(board,i,j);
System.out.println();
            if(board[i][j] == 2 ){
                board[i][j] = 0;
            }
            if(board[i][j] == 3 ){
                board[i][j] = 1;
            }
        }
    }

    return board;
}


public static int countLives(int[][] board,int i,int j){
    int count=0;
    // All eight possible directions made
    int[][]dir = new int[][]{{0,1},{0,-1},{-1,0},{1,0},{-1,-1},{-1,1},{1,1},{1,-1}};


    for(int[] dirs : dir){
        int r= i+dirs[0];
        int c= j+dirs[1];
        if(r>=0 && c>=0 && r<n && c<n && (board[r][c] == 1 ||board[r][c] == 2) ){
            count++;
        }
    }
    return count;
}
    public static void main(String[] args) {
        int[][] arr = new int[][] {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        int[][] result = gameOfLife(arr);
        System.out.println(Arrays.deepToString(result));
    }

}
