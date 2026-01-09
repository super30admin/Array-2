public class GameOfLife {

    // Time Complexity:
    // O(m*n)

    // Space Complexity:
    // O(1)
    
    // Traverse the board and count live neighbors for each cell using 8 directions, treating 1 and 2 as originally alive.

    // Mark state transitions in-place using encoded values (1→2 for live→dead, 0→3 for dead→live) based on Game of Life rules.

    // Do a second pass to finalize the board by converting 2→0 and 3→1.
    public void GameOfLife(int[][] board)
    {
        int m = board.Length;
        int n = board[0].Length;
        // 1 -> 0 =2;
        // 0 -> 1 =3
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                int count = countAlive(board, i, j);
                if (board[i][j] == 1 && (count < 2 || count > 3))
                {
                    board[i][j] = 2;
                }
                if (board[i][j] == 0 && count == 3)
                {
                    board[i][j] = 3;
                }
            }
        }
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {

                if (board[i][j] == 2)
                {
                    board[i][j] = 0;
                }
                if (board[i][j] == 3)
                {
                    board[i][j] = 1;
                }
            }
        }
    }
    private int countAlive(int[][] board,int i,int j)
    {
        int count = 0;
        int[][] dirs = {new int[]{0,1},new int[]{0,-1},new int[]{-1,0},
        new int[]{1,0},new int[]{-1,-1},  new int[]{-1,1},new int[]{1,-1}, 
        new int[]{1,1}
};
        foreach (int[] dir in dirs)
        {
            int nr = i + dir[0]; //i is current index  + direction
            int nc = j + dir[1];

            if(nr >=0 && nc >=0 && nr < board.Length && nc < board[0].Length &&
            (board[nr][nc] == 1 || board[nr][nc] == 2 ))
            {
                count++;
            }
        }
       
        return count;
    }
}
