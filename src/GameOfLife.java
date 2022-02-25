// Time Complexity:           O(m*n)
// Space Complexity:           O(1)
// where m is number of rows in matrix, n is number of columns in matrix
// Yes, this code ran successfully
// No, I didn't face any problem in this problem statement

public class GameOfLife {

    private int[][] dir = new int[][]                                 // setting up direction matrix
            {
                    { -1, -1 },     // UP LEFT
                    { -1, 1 },      // UP RIGHT
                    { 1, -1 },      // DOWN LEFT
                    { 1, 1 },       // DOWN RIGHT
                    { -1, 0 },      // UP
                    { 1, 0 },       // DOWN
                    { 0, -1 },      // LEFT
                    { 0, 1 }        // RIGHT
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

                if(board[i][j] == 1)                                    // if it's 1
                {
                    if(liveNeigh < 2 || liveNeigh > 3)                  // and live neighbors != 3 then it dies
                        board[i][j] = -2;                               // 1 => 0 : -2
                }
                else                                                    // if it's 0
                {
                    if(liveNeigh == 3)                                  // and live neighbors = 3 then it lives
                        board[i][j] = -1;                               // 0 => 1 : -1
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

    // Getting number of Live Neighbors
    private int getLiveNeigh(int[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;
        int count = 0;

        for(int[] d : dir)
        {
            int x = i + d[0];                                           // new x co-ordinate
            int y = j + d[1];                                           // new y co-ordinate

            if(x>=0 && x<m && y>=0 && y<n)
            {
                int state = board[x][y];
                if(state == 1 || state == -2)                           // if previous status was 1 then count that neighbor
                    count++;
            }
        }
        return count;
    }

}
