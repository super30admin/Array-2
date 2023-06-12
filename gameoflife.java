// Time Complexity : O(mn)
// Space Complexity : O(1) as dirs[][] array is constant 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
// as we need to update the same array we are taking 2 numbers so that we can identify when 1->0 (2) and 0-> 1(-1) and also we need to check the neighbours on the original array
// we need to calculate the number of alive neighbours and then apply the rules. 
// now we to change 2 and -1 accordingly. 
// to find the alive neighbours we have taken dirs array at each i,j we add the each direction and if that is bounds and board[i][j]>1 we can increment count
class Solution {
    private int dirs[][] = new int[][]{{0,1},{0,-1},{-1,0},{1,0},{-1,-1},{-1,1},{1,1},{1,-1}};
    public void gameOfLife(int[][] board) {
        //1 -> 0 2
        // 0> 1 -> -1
        int m= board.length; // rows
        int n= board[0].length; // col;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                int aliveN = alive(board, i, j, m ,n);
                if(board[i][j]==1)
                {
                    if(aliveN <2 || aliveN > 3)
                        board[i][j] = 2;
                    
                }else {
                    // dead cell 
                    if(aliveN ==3)  
                        board[i][j]= -1;
                }
            }
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]==-1)
                    board[i][j]=1;
                else if(board[i][j]==2)
                    board[i][j]=0;
            }
        }
    }
    private int alive(int board[][], int i, int j, int m , int n){
        int countalive =0;
        for(int dir[]:dirs){
            int rowindex = i+ dir[0];
            int colindex = j+ dir[1];
            if((rowindex>=0) && (rowindex<m) && (colindex>=0) && (colindex<n) && (board[rowindex][colindex]>0))
                countalive++;
        }
        return countalive;
    }
}