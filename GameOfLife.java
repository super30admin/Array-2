// Time Complexity : O(nm) n = rows m = column
// Space Complexity : O(1)

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0)
            return;
        
        // mark every cell that needs to be converted as following
        // 1 -> 0 mark it with 2 .. i.e if  cell == 2 old value was 1
        // 0 -> 1 mark it with 3 .. i.e if cell == 3 old value was 0
        // this will help us count the neighbors and know what to convert w/o using extra space
        for(int i = 0 ; i < board.length; i ++)
        {
            for(int j = 0 ; j < board[0].length; j++)
            {
                int lives = countLives(board, i, j);
                
                if(board[i][j] == 1)
                {
                        if(lives < 2 || lives > 3)
                        {
                            board[i][j] = 2;
                        }
                }
                else 
                {
                    if(lives == 3)
                    {
                        board[i][j] = 3;
                    }
                }
            }
        }
        
        // convert back to 0 and 1
        for(int i = 0 ; i < board.length; i ++)
        {
            for(int j = 0 ; j < board[0].length; j++)
            {
                    if(board[i][j] == 2)
                        board[i][j] = 0;
                else if(board[i][j] == 3)
                        board[i][j] = 1;
            }
            }
    }
    
    
    private int countLives(int[][] board, int i, int j)
    {                   // R    L       T      B        D1      D2     D3     D4
        int dirs[][] = {{0,1}, {0,-1}, {1,0}, {-1,0}, {-1,-1}, {1,1}, {-1,1}, {1,-1}};
        int count = 0;
        
        for(int [] dir : dirs)
        {
            int r = i + dir[0];
            int c = j + dir[1];
            
            if(r >= 0 && r < board.length && c >= 0 && c < board[0].length)
            {
                if(board[r][c] == 1 || board[r][c] == 2) // 2 because earlier it was 1
                    count++;
            }
        }
        return count;
    }
}
