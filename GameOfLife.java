// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// We use different numbers to record changes to the same matrix so that we can update simultaneously in the first pass
// In our case, we have taken updating 1->0 as 2 and 0->1 as 3 
// In the next pass, we can replace 2 with 0 and 3 with 1 to get final answer

class Solution {
    int[][] dirs;
    public void gameOfLife(int[][] board) {
        int m = board[0].length;
        int n = board.length;
        dirs = new int[][]{{-1,-1},{-1,1},{-1,0},{0,-1},{0,1},{1,1},{1,-1},{1,0}};
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
            {
                int count = countLiveNeighbors(board,i,j,n,m);
                if(board[i][j]==1 && (count<2 || count>3))
                    board[i][j] = 2;
                if(board[i][j]==0 && count==3)
                    board[i][j] = 3;
            }
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
            {
                if(board[i][j]==2)
                    board[i][j] = 0;
                if(board[i][j]==3)
                    board[i][j] = 1;
            }  
    }

    private int countLiveNeighbors(int[][] board, int i, int j, int n, int m)
    {
        int count=0;
        for(int[] dir:dirs){
            int r = i+dir[0];
            int c = j+dir[1];
            if(c>=0 && c<m && r>=0 && r<n){
                if(board[r][c]==1||board[r][c]==2)
                        count++;
            }
        }

        return count;
    }
}