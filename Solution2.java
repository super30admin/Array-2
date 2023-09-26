//Leetcode Problem : https://leetcode.com/problems/game-of-life/description/
// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * For every element, I check the number of neighbours. If the current element is alive(1) and it's number of neighbours are
 * either less than 2 or more than 3, I set it to 3(denoting dead cell). Similarly for a dead cell(0), if the number of neighbours
 * =3, I set it to 2(alive). Now I traverse through whole matrix replacing 2 with 1 and 3 with 0.
 */
class Solution {
    public void gameOfLife(int[][] board) {

        //0->1 : 2
        //1->0 : 3
        int rows = board.length;
        int columns = board[0].length;
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<columns;j++)
            {
                int neighbours = count(board,i,j,rows,columns);
                if(board[i][j]==1)
                {
                    if(neighbours<2 || neighbours>3)
                    {
                        board[i][j]=3;
                    }
                }
                else if(board[i][j]==0)
                {
                    if(neighbours==3)
                    {
                        board[i][j]=2;
                    }
                }
            }
        }
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<columns;j++)
            {
                if(board[i][j]==2)
                {
                    board[i][j]=1;
                }
                else if(board[i][j]==3)
                {
                    board[i][j]=0;
                }
            }
        }
   
    }

    public int count(int [][]board, int i, int j, int rows, int columns)
    {
        int neighbours = 0;
        int [][]directions = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        for(int []dirs : directions)
        {
            int r = i+dirs[0];
            int c = j+dirs[1];
            if(r>=0 && r<rows && c>=0 && c<columns)
            {
                if(board[r][c]==1 || board[r][c]==3)
                {
                    neighbours+=1;
                }
            }
        }
        return neighbours;
    }
}