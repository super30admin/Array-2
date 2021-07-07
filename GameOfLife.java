//space - constant
//time - O(mn)
class Solution {
    public void gameOfLife(int[][] board) {
        // Changes in a live cell
        // 1. neighbours < 2 or neighbours > 3 => cell becomes dead
        // 2. neighbours == 2 || neighbours == 3 => cell stays alive
        
        // Changes in a dead cell
        // 1. neighbours == 3 => cell becomes alive
        
        if(board == null || board.length == 0 || board[0].length == 0)
        {
            return;
        }
        
        int m = board.length;
        int n = board[0].length;
        
        //if cell value is 5 then it implies that the cell is dead but was alive
        //if cell value is 10 then it implies that cell is alive but was dead
        //this is because changes are made in place & if 0-1 are used, it causes wrong result in further calculations
        
        for(int i = 0; i < m; i++)
        {
            for(int j = 0 ; j < n; j++)
            {
                //cell is alive
                if(board[i][j] == 1)
                {
                    int neighbours = countLiveNeighbours(board, i, j, m, n);
                    if(neighbours < 2 || neighbours > 3)
                    {
                        board[i][j] = 5; //cell becomes dead
                    }
                }
                else
                {
                    int neighbours = countLiveNeighbours(board, i, j, m, n);
                    if(neighbours == 3)
                    {
                        board[i][j] = 10; //cell becomes alive
                    }
                }
            }
        }
        
        //in second pass change 5 and 10 to 0 and 1 respectively
        for(int i = 0; i < m; i++)
        {
            for(int j = 0 ; j < n; j++)
            {
                if(board[i][j] == 5)
                {
                    board[i][j] = 0;
                }
                else if(board[i][j] == 10)
                {
                    board[i][j] = 1;
                }
            }
        }
        return;
    }
    
    public int countLiveNeighbours(int[][] board, int row, int column, int m, int n) {
        //denotes all the 8 possible directions
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        int neighbours = 0;
        
        for(int[] direction : directions)
        {
            int neighbourRow = row + direction[0];
            int neighbourColumn = column + direction[1];
            
            if(neighbourRow >= 0 && neighbourRow < m && neighbourColumn >= 0 && neighbourColumn < n)
            {
                //so the current neighbour is a valid index in board
                if(board[neighbourRow][neighbourColumn] == 1 || board[neighbourRow][neighbourColumn] == 5)
                {
                    //the current neighbour is alive
                    neighbours++;
                }
            }
        }
        
        return neighbours;
    }
}
