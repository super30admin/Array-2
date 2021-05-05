// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
   For every element, we find all the 8 neighbours and find the number of alive
   (1->0) => -1  => If a alive element dies, we temporarily, make it -1
   (0->1) => 2   => If a dead element becomes alive, we temporarily, make it 2
    Based on the rules and changes, in the end we revert -1 to 0 and 2 to 1.
*/

class Solution {
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
    
    public void gameOfLife(int[][] board) {
        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[0].length;j++)
                helper(board,i,j);
        
         for(int i=0;i<board.length;i++)
            for(int j=0;j<board[0].length;j++)
                if(board[i][j]==-1) board[i][j]=0;
                else if(board[i][j]==2) board[i][j]=1;
    }
    
    private void helper(int[][] board, int i, int j){
        int alive=0;
        for(int[] dir : dirs){
            int p = i+dir[0];
            int q = j+dir[1];
            if(p>=0 && p<board.length && q>=0 && q<board[0].length && (board[p][q]==1 || board[p][q]==-1))
                alive+=1;
        }

        if(board[i][j]==1){
            if(alive<2) board[i][j]=-1;
            else if(alive>3) board[i][j]=-1;
        }

        if(board[i][j]==0 && alive==3)
            board[i][j]=2; 
    } 
}