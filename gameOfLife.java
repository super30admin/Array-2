// Time Complexity :O(m*n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
/*Approach: Since we are altering the same input array; we are placing for every 1 that changes to 0 as 2
and 0->1 as 3. we changes the live and dead values based on the conditions given in the problem stmt.Complexity
we are revisiting the 2d array so formed to convert back 2's to 0 and 3's to 1. we are checking 8
directions {{0,1},{1,0},{1,1},{-1,-1},{-1,0},{0,-1},{1,-1},{-1,1}}
from element at (0,0) to count the no. of live cells present as its neighbor.*/


class Solution {
    int m;
    int n;
    public void gameOfLife(int[][] board) {
        if(board==null||board.length==0)
            return;
        m=board.length;
        n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int lives=countlives(board,i,j);
                if(board[i][j]==1){
                if(lives>3 ||lives<2)
                    board[i][j]=2;
                }
             else
             {   if(lives==3)
                         board[i][j]=3;
                    }

            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if( board[i][j]==2)
                     board[i][j]=0;
                else if( board[i][j]==3)
                     board[i][j]=1;
            }
        }
    }
        private int countlives(int[][] board,int x,int y){
            int count=0;

             int dir[][]={{0,1},{1,0},{1,1},{-1,-1},{-1,0},{0,-1},{1,-1},{-1,1}};
            for(int dirs[]:dir){
                int nx=x+dirs[0];
                 int ny=y+dirs[1];
                if(nx>=0 && nx<m && ny>=0&& ny<n &&( board[nx][ny]==1||board[nx][ny]==2))
                    count=count+1;
            }
            return count;
        }
}