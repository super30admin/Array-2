/**

[[0,1,0],
 [0,0,1],
 [1,1,1],
 [0,0,0]]

live cell (1) -> <2 -> 0
live cell (1) -> 2/3 -> 1
live cell (1) -> >3 -> 0
dead cell (0) -> 3 -> 1

TC - 2*O(m*n) where m is the number of rows and n is the number of cols.
SC - O(1)

**/

class Solution {
    
    int dirs[][] = {
        {0,1},
        {1,1},
        {1,0},
        {1,-1},
        {0,-1},
        {-1,-1},
        {-1,0},
        {-1,1}
    };
    
    public void gameOfLife(int[][] board) {
        
        int rows = board.length;
        int cols = board[0].length;
        
        for(int i=0; i<rows; i++)
        {
            for (int j=0; j<cols; j++)
            {
                if (board[i][j] == 0)
                {
                    findBasedOnRule(i, j, board, true, rows, cols);
                }
                else
                {
                    findBasedOnRule(i, j, board, false, rows, cols);
                }
            }
        }
        
        for(int i=0; i<rows; i++)
        {
            for (int j=0; j<cols; j++)
            {
                if (board[i][j] == -1)
                {
                    board[i][j] = 0;
                }
                else if (board[i][j] == 2)
                {
                    board[i][j] = 1;
                }
            }
        }
        
    }
    
    public void findBasedOnRule(int i, int j, int board[][], boolean isZero, int rows, int cols)
    {
        int countZero = 0;
        int countOne = 0;
        
        for(int dir[] : dirs)
        {
            int nx = dir[0] + i;
            int ny = dir[1] + j;
            
            if (nx>=0 && nx<rows && ny>=0 && ny < cols && (board[nx][ny] == 0 || board[nx][ny] == 2))
            {
                countZero++;
            }
            
            if (nx>=0 && nx<rows && ny>=0 && ny < cols && (board[nx][ny] == 1 ||  board[nx][ny] == -1))
            {
                countOne++;
            }
        }
        
        if (isZero && countOne == 3)
        {
                board[i][j] = 2;
        }
        
        if(!isZero)
        {
            if (countOne < 2)
            {
                board[i][j] = -1;
            }
            
            if (countOne > 3)
            {
                board[i][j] = -1;
            }
        }
    }
}