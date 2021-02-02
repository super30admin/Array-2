// Time Complexity :O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this :There are so many bouundary conditions to look for in the method I was trying.
// Felt like hardcoding approaching.


// Your code here along with comments explaining your approach
class Solution {
    public void gameOfLife(int[][] board) {
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]==0)
                {
                    if(i==0)
                    { int count=0;
                     if(j==0){
                        if(board[][])
                        {
                            int n1=board[i][j+1];
                            int n2= board[i+1][j];
                            int n3= board[i+1][j+1];
                        }
                         }
                    }
                
            }
        }
        
    }
}
}