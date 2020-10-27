// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :nopes
// Your code here along with comments explaining your approach
/*
1. Just count the elements from all the direction through countLives method
2. Return those count and modify the original array with 2,3
   For 0->1->3 replace alive i.e 1 value with 3 if count ==3
   For 1->0->2 replace dead value i.e 0 with 2 in case count is <2 and >3
3. Change the original array back to 0/1 modified version not the original version.
 */

class Solution {
    int m,n;
    public void gameOfLife(int[][] board) {

        if(board==null||board.length==0)
            return;

        m=board.length;
        n=board[0].length;

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                int lives=countLives(board,i,j);

                if(board[i][j]==1&&(lives<2||lives>3))
                {
                    board[i][j]=2;
                }
                if(board[i][j]==0&&lives==3)
                {
                    board[i][j]=3;
                }
            }
        }

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]==3)
                {
                    board[i][j]=1;
                }
                if(board[i][j]==2)
                {
                    board[i][j]=0;
                }
            }
        }

    }
    private int countLives(int[][] board,int i,int j)
    {
        int count=0;

        int[][] dirs={{-1,0},{0,1},{1,0},{0,-1},{-1,-1},{-1,1},{1,-1},{1,1}};

        for(int[] dir:dirs)
        {
            int r= i+dir[0];
            int c= j+dir[1];

            if(r>=0&&c>=0&&r<m&&c<n&&(board[r][c]==1||board[r][c]==2))
            {
                count++;
            }
        }