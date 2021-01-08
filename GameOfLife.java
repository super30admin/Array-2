// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
// Your code here along with comments explaining your approach

class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int [][] newBoard = new int[m][n];
        for(int i=0;i<m;i++)   // Copy board
        {
            for(int j=0;j<n;j++)
            {
                newBoard[i][j] = board[i][j];
            }
        }
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                int score = 0;
                
                if(i-1>=0 && newBoard[i-1][j]==1) // Check for each neighbor
                {
                    score +=1;
                }
                
                if(i+1<m && newBoard[i+1][j]==1)
                {
                    score +=1;
                }
                
                if(j-1>=0 && newBoard[i][j-1]==1)
                {
                    score+=1;
                }
                
                if(j+1<n && newBoard[i][j+1]==1)
                {
                    score +=1;
                }
                
                if(i-1>=0 && j-1>=0 && newBoard[i-1][j-1]==1)
                {
                    score+=1;
                }
                
                if(i-1>=0 && j+1<n && newBoard[i-1][j+1]==1)
                {
                    score+=1;
                }
                
                if(i+1<m && j+1<n && newBoard[i+1][j+1]==1)
                {
                    score+=1;
                }
                
                if(i+1<m && j-1>=0 && newBoard[i+1][j-1]==1)
                {
                    score+=1;
                }
                
                if(newBoard[i][j]==1)        // Check rules and change state in original board
                {
                    if(score>=2 && score<=3)
                    {
                        board[i][j]=1;
                    }else{
                        board[i][j]=0;
                    }
                }else 
                {
                    if(score==3) board[i][j] = 1;
                }
                          
            }
        }
        
    }
}