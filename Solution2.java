// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * I iterate through the 2d array and use a helper function which gives me the number of alive neighbours for each element. According to the conditions given in the problem statement, If a 
 * living cell has to be killed, I set it's value to be 2 temporarily. Similarly if a dead cell has to be made alive, I set it's value to 3. I iterate through the array finally to set each 
 * 2 to 0 and 3 to 1.
 */
class Solution2 {
    int rows;
    int columns;

    public void gameOfLife(int[][] board) {
        this.rows = board.length;
        this.columns = board[0].length;

        //1->0 : 2
        //0->1 : 3
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<columns;j++)
            {
                int neighbours = numOfNeighbours(i,j,board);
                if(neighbours<2 && board[i][j]==1)
                {
                    board[i][j]=2;
                }
                else if(neighbours>3 && board[i][j]==1)
                {
                    board[i][j]=2;
                }
                else if(neighbours==3 && board[i][j]==0)
                {
                    board[i][j]=3;
                }
            }
        }
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<columns;j++)
            {
                if(board[i][j]==2)
                {
                    board[i][j]=0;
                }
                else if(board[i][j]==3)
                {
                    board[i][j]=1;
                }
            }
        }

    }

    public int numOfNeighbours(int i,int j,int [][]board)
    {
        int count=0;
        int [][]directions = {{0,1},{0,-1},{1,0},{-1,0},{-1,-1},{1,-1},{-1,1},{1,1}};
        for(int []dir : directions)
        {
            int row = i+dir[0];
            int column = j+dir[1];
            if(row>=0 && row<rows && column>=0 && column<columns)
            {
                if(board[row][column]==1 || board[row][column]==2)
                {
                    count++;
                }
            }
        }
        return count;

    }
}