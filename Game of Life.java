// Time complexity:O(m*n)
// space complexity:O(1)
// Any problem running the problem on leetcode:No
class Solution {
    public void gameOfLife(int[][] board) {
        //edge
        if(board==null || board.length==0) return;
        //1->0==2 ; 0->1==3
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                int count=helper(board,i,j);
                
                if(board[i][j]==0 && count==3) board[i][j]=3;
                else if(board[i][j]==1 && count>3) board[i][j]=2;
                else if(board[i][j]==1 && count<2) board[i][j]=2;
            }
        }
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]==2) board[i][j]=0;
                else if(board[i][j]==3) board[i][j]=1;
            }
        }
    }
    private int helper(int[][] board,int i,int j)
    {
        int count=0;
        int[][] dirs={{1,1},{0,-1},{-1,0},{1,0},{0,1},{-1,1},{1,-1},{-1,-1}};
        for(int[] dir:dirs)
        {
            int r=i+dir[0];
            int c=j+dir[1];
            if(r>=0 && r < board.length && c>=0 && c<board[0].length && (board[r][c]==1 || board[r][c] == 2)) count++;
        }
        return count;
    }
    
}
