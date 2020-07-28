//Time complexity=O(m*n)
//Space complexity=O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    //We have created dirs matrix to move in 8 directions
    int[][] dirs={{1,-1},{1,0},{0,1},{-1,0},{0,-1},{-1,1},{1,1},{-1,-1}};
    public void gameOfLife(int[][] board) {
        //0 - >1 2
        //1 - >0 3
        int m=board.length,n=board[0].length;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                int liv=0;
                for( int[] dir:dirs)
                {//Checking for the boundary conditions
                    if((i+dir[0])<0 || i+dir[0]>m-1 || j+dir[1]<0 || j+dir[1]>n-1)
                    {
                        continue;
                    }
                    //If the index we are at has a neighbour 1 then we are incrementing the count of liv and here we are taking 3 as input as it states the number was initially 1 and is changed to 0  
                    if(board[i+dir[0]][j+dir[1]]==1 || board[i+dir[0]][j+dir[1]]==3)
                        liv++;
                }
                if(board[i][j]==1 && (liv<2 || liv>3))//As per condition it should have only 3 neighbour as 1 not less or more than that otherwise it state changes from 1 to 0.
                    board[i][j]=3;
                if(board[i][j]==0 && liv==3)//For 0 state if should have 3 neighbour as 1
                    board[i][j]=2;
            }
            
        }
        //At the end convert all 3 -> 0 and 2 -> 1
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]==3)
                    board[i][j]=0;
                if(board[i][j]==2)
                    board[i][j]=1;
            }
        }
    }
}