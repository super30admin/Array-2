import java.util.*;

//Time Complexity : O(r*c)
//Space Complexity : O(r*c)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class Solution {
    public void gameOfLife(int[][] board) {

        int m = board.length, n = board[0].length;

        int [][]gol = new int[m][n];

        int dirs[][]={
            {-1,0},
            {-1,1},
            {0,1},
            {1,1},
            {1,0},
            {1,-1},
            {0,-1},
            {-1,-1}
        };

        for(int i=0;i<board.length; i++){

            for(int j=0;j<board[0].length ; j++){

                int lives=0;

                for(int dir[] : dirs){
                    int x = dir[0] + i;
                    int y = dir[1] + j;

                    if(x >= 0 && x < m && y >= 0 && y < n && board[x][y]==1){
                        lives++;
                    }
                }

                if (board[i][j] == 0 && lives == 3){
                    gol[i][j] = 1;
                }

                else if (board[i][j] == 1 && (lives == 3 || lives == 2)){
                    gol[i][j] = 1;
                }

            }

        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                board[i][j] = gol[i][j];
            }
        }
    }
}
