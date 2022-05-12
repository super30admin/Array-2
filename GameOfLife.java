/**
Time Complexity : O(M*N) M = rows , N = columns in matrix
Space Complexity : O(M*N) M = rows , N = columns in matrix
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
**/
class Solution 
{
    private final int dirs[][] = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
    int rows;
    int cols;
    
    public void gameOfLife(int[][] board) 
    {
        rows = board.length;
        cols = board[0].length;
        int result[][] = new int[rows][cols];
        
        for(int i =0 ;i < rows ; i++)
        {
            for(int j =0 ;j < cols; j++)
            {
                int neighbourCount = findNeighbourCount(board, i , j);
                
                if(board[i][j] == 1 && neighbourCount < 2)
                {
                    result[i][j] = 0;
                }
                else if(board[i][j] == 1 && neighbourCount > 3)
                {
                    result[i][j] = 0;
                }
                else if(board[i][j] == 0 && neighbourCount ==3)
                {
                    result[i][j] = 1;
                }
                else
                {
                    result[i][j] = board[i][j];
                }
            }
        }
        for(int i =0 ;i < rows ; i++)
        {
            for(int j =0 ;j < cols; j++)
            {
                board[i][j] = result[i][j];
            }
        }
    }
    
    private int findNeighbourCount(int[][] board, int i, int j)
    {
        int neighbourCount = 0;
        
        for(int m = 0 ; m < dirs.length; m++)
        {
                int rowIndex = i + dirs[m][0];
                int colIndex = j + dirs[m][1];
                
                boolean isValidRow = rowIndex >=0 && rowIndex < rows;
                boolean isValidCol = colIndex >=0 && colIndex < cols;
                boolean isValidNeighbour = isValidRow && isValidCol;
                
                if(isValidNeighbour && board[rowIndex][colIndex] == 1)
                {
                    neighbourCount++;       
                }
                
        }
        
        return neighbourCount;
    }
}