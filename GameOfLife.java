/* Time Complexity :  O(m*n)
   Space Complexity :  O(1) 
   Did this code successfully run on Leetcode : Yes
   Any problem you faced while coding this : No
*/

class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length, n=board[0].length;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                int neigh = findNeigh(board,i,j);
                //System.out.println(i + "," + j + "=" + neigh);
                if(board[i][j]==1)
                {
                    if(neigh<2 || neigh >3)
                        board[i][j]=2;
                }
                else
                {
                    if(neigh==3)
                        board[i][j]=3;
                }
            }
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]==2)
                    board[i][j]= 0 ;
                if(board[i][j]==3)
                    board[i][j]= 1;
            }
        }
    }
    private int findNeigh(int[][] board, int i, int j)
    {
        int count=0;
        int left=0,right=0,top=0,topl=0,topr=0,bot=0,botl=0,botr = 0;
        if(j!=0 && (board[i][j-1]==1 || board[i][j-1]==2)) //left
            count++;
        if(j!=board[0].length-1 && (board[i][j+1]==1 || board[i][j+1]==2)) //right
            count++;
        if(i!=0 && (board[i-1][j]==1 || board[i-1][j]==2)) //top
            count++;
        if(i!=board.length-1 && (board[i+1][j]==1 || board[i+1][j]==2))//bottom
            count++;
        if(i!=0) //topl
        {
            if(j!=0 && (board[i-1][j-1]==1 || board[i-1][j-1]==2))
                count++;
            if(j!=board[0].length-1 && (board[i-1][j+1]==1 || board[i-1][j+1]==2))//topr
                count++;
        }
        if(i!=board.length-1) //bottoml
        {
            if(j!=0 && (board[i+1][j-1]==1 || board[i+1][j-1]==2))
                count++;
            if(j!=board[0].length-1 && (board[i+1][j+1]==1 || board[i+1][j+1]==2)) //bottomr
                count++;
        }
        return count;
        
    }
}