class Solution2{
    public void gameOfLife(int[][] board) {

        int m = board.length -1;
        int n = board[0].length -1;
        for(int r = 0; r <= m; r++){
            for(int c = 0; c <= n; c++)
            {
                int count = getCount(board, r, c);
                if(board[r][c] == 0 && count == 3){
                    board[r][c] = 2;
                }
                else if(board[r][c] == 1 && (count > 3 || count < 2)){
                    board[r][c] = 3;
                }
            }
        }
        for(int r = 0; r <= m; r++){
            for(int c = 0; c <= n; c++){
                if(board[r][c] == 2) board[r][c] = 1;
                else if(board[r][c] == 3) board[r][c] = 0;
            }
        }

    }
    private int getCount(int[][] board, int r, int c)
    {
        int[][] directions = {
                {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
        int count = 0;

        for(int i = 0; i < directions.length; i++ )
        {
            int x = r + directions[i][0];
            int y = c + directions[i][1];

            if(x >= 0 && y >= 0 && x < board.length && y < board[0].length){
                if(board[x][y] == 3 || board[x][y] == 1){
                    count++;
                }
            }

        }
        return count;
    }
}