public class GameOfLife {

    private int[][] dir = new int[][]
            {
                    { -1, -1 },     // UP LEFT
                    { -1, 1 },      // UP RIGHT
                    { 1, -1 },      // DOWN LEFT
                    { 1, 1 },     // DOWN RIGHT
                    { -1, 0 },     // UP
                    { 1, 0 },     // DOWN
                    { 0, -1 },     // LEFT
                    { 0, 1 }      // RIGHT
            };

    public static void main(String[] args) {
        GameOfLife gol = new GameOfLife();
        int[][] nums = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        gol.gameOfLife(nums);
        for(int[] innerArray:nums)
        {
            for(int i:innerArray)
            {
                System.out.print(i);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                int liveNeigh = getLiveNeigh(board, i, j);

                if(board[i][j] == 1)
                {
                    if(liveNeigh < 2 || liveNeigh > 3)
                        board[i][j] = -2;
                }
                else
                {
                    if(liveNeigh == 3)
                        board[i][j] = -1;
                }
            }
        }
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(board[i][j] == -1)
                    board[i][j] = 1;
                else if(board[i][j] == -2)
                    board[i][j] = 0;
            }
        }
    }

    private int getLiveNeigh(int[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;
        int count = 0;

        for(int[] d : dir)
        {
            int x = i + d[0];
            int y = j + d[1];

            if(x>=0 && x<m && y>=0 && y<n)
            {
                int state = board[x][y];
                if(state == 1 || state == -2)
                    count++;
            }
        }
        return count;
    }

}
