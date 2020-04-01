//time complexity: O(n^2)
//space complexity: O(1)

class GameOfLifeSolution {
    
    public static int newLive = 2;
    public static int newDie = 3;
    
    public void gameOfLife(int[][] board) {
        if (board.length == 0 || board[0].length == 0)
            return;
    
        for (int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                int liveNeighbors = countLive(i, j, board);
                if(board[i][j] == 0)
                {
                    if(liveNeighbors == 3)
                        board[i][j] = newLive;
                }
                else if (board[i][j] == 1)
                {
                    if(liveNeighbors < 2)
                        board[i][j] = newDie;
                    else if(liveNeighbors == 2 || liveNeighbors == 3)
                        continue;
                    else if (liveNeighbors > 3)
                        board[i][j] = newDie;
                }
            }
        }
        
        for (int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                if(board[i][j] == 2)
                    board[i][j]=1;
                else if (board[i][j]==3)
                    board[i][j] = 0;
                
            }
        }
            
        
    }
    
    public int countLive(int i, int j, int[][] board)
    {
        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        int count = 0;
        for (int dir[]: directions)
        {
            int x = i+dir[0];
            int y = j+dir[1];
            
            if(x>=0 && y>=0 && x < board.length && y < board[0].length)
            {
                if (board[x][y] ==1 || board[x][y] == newDie)
                    count++;
            }
        }
        return count;
    }
}