

// Time Complexity : O(M * N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class GameOfLife {
    static int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}, {-1,-1}, {-1,1}, {1,-1},{1,1}};

    public static void main(String[] args) {
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        gameOfLife(board);
    }

    public static void gameOfLife(int[][] board) {
        if(board == null || board.length == 0)
            return;

        int m = board.length;
        int n = board[0].length;

        for(int i=0; i<m ; i++){
            for(int j=0; j<n ; j++){
                int liveCount = numberOfLives(board, i, j);

                // 1 to 0 -> 3
                // Lives
                if(board[i][j] == 1 && (liveCount > 3 || liveCount < 2))
                    board[i][j] = 3;

                // 0 to 1 -> 2
                if(board[i][j] == 0 && liveCount == 3)
                    board[i][j] = 2;
            }
        }

        for(int i=0; i<m ; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == 3)
                    board[i][j] = 0;

                if(board[i][j] == 2)
                    board[i][j] = 1;
            }
        }
    }

    public static int numberOfLives(int[][] board, int i, int j){
        int count = 0;
        // Calculate value for each directions
        for(int[] d : dir){
            int nr = i + d[0];
            int nc = j + d[1];
            // check if the number is 1 or changed from 1 to 0 (3)
            if(nr>=0 && nc>=0 && nr<board.length && nc<board[0].length && (board[nr][nc]==1 || board[nr][nc]==3))
                count++;
        }
        return count;
    }
}
