// Time Complexity : O(m*n)
// Space Complexity : O(1) // We are using the same input matrix
// Did this code successfully run on Leetcode : Yes

public class GameOfLife {


    public static void gameOfLife(int[][] board) {

        int m = board.length;
        int n = board[0].length;

        int[][] dirs = {{0,1},{0,-1},{-1,0},{1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
        //right,left,up,down,up left,up right, down left, down right

        // 0 -> 1 represented as 2
        // 1 -> 0 represented as 3

        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                int countAlive = countAlive(board, dirs, i, j, m, n);
                if(board[i][j] == 0) {
                   if(countAlive == 3)
                       board[i][j] = 2;
                }else{
                    if (countAlive < 2 || countAlive > 3) {
                        board[i][j] = 3;
                    }
                }
            }
        }

        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++) {
                if(board[i][j] == 2) board[i][j] = 1;
                if(board[i][j] == 3) board[i][j] = 0;

                System.out.print(board[i][j]+ " ");
            }
            System.out.println("");
        }
    }

    public static int countAlive(int[][] board, int[][] dirs, int i, int j, int m, int n)
    {
        int count = 0;
        for(int k=0; k<dirs.length; k++)
        {
            int row = i+ dirs[k][0];
            int col = j+ dirs[k][1];
            if(row >= 0 && col >= 0 && row <= m-1 && col <= n-1) {
                if (board[row][col] == 1 || board[row][col] == 3) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        gameOfLife(board);
    }

}
