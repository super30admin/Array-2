// Time Complexity : O(M*N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    //coordinates of 8 neighbors at i, j
    int[] x = {-1, -1, -1, 0, +1, +1, +1, 0};
    int[] y = {-1, 0, +1, +1, +1, 0, -1, -1};
    
    private int countNeighbors(int[][] board, int i, int j)
    {
        int count = 0;
        for(int k=0; k<8; k++){
            int row=i+x[k], col=j+y[k];
            if(isValid(board, row, col))
                if(board[row][col] == 1 || board[row][col] == -1)
                    count++;
        }
        return count;
    }
    private boolean isValid(int[][] board, int row, int col){
        return row>=0 && col>=0 && row<board.length && col<board[0].length;
    }
    
    public void gameOfLife(int[][] board) {
    for(int i=0;i<board.length;i++)
    {
        for(int j=0;j<board[0].length;j++)
        {
            //Markers 0-->1 2 and 1-->0 -1
            int count=countNeighbors(board, i, j);
            if(board[i][j] == 1){ // alive
                if (count < 2 || count > 3) //becomes dead
                    board[i][j] = -1;
            } else { // dead
              if (count == 3) //becomes alive
                    board[i][j] = 2;  
            }
            
        }
    }
    for(int i=0;i<board.length;i++)
        for(int j=0;j<board[0].length;j++)
            if (board[i][j] == 2)
                board[i][j]=1;
            else if (board[i][j] == -1)
                board[i][j]=0;
    }
}