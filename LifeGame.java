// Time Complexity : O(m*n) where m is number of rows and n is number of columns of matrix
// Space Complexity :O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class LifeGame {
    int newlydead = -1;
    int newlyalive = 2;
    public void gameOfLife(int[][] board) {
        
        if(board==null || board.length==0) return;
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                int sum = getNeignbourSum(i,j,board);
                if(board[i][j]==1)
                {
                    if(sum < 2 || sum > 3) 
                        board[i][j]=newlydead;
                }
                else if(board[i][j]==0)
                {
                    if(sum==3)
                        board[i][j] = newlyalive;
                }
            }
        }
        
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]==newlydead) board[i][j] = 0;
                if(board[i][j]==newlyalive) board[i][j] = 1;
            }
        }
    }
    
    private int getNeignbourSum(int i, int j,int[][] board)
    {
        int[][] dir = {{-1,-1,},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        int sum = 0;
         
        for(int k=0;k<dir.length;k++)
        {
            int a = i+dir[k][0];
            int b = j+dir[k][1];
            if(a>=0 && a<board.length && b>=0 && b<board[0].length && board[a][b]!=newlyalive && board[a][b]!=0)
                sum++;
        }
        return sum;
    }
}