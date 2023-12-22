// Time Complexity : O(mn), where m is the number of rows and n is the number of columns
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

class Solution {
    private int m;
    private int n;
    private int[][] dirs;

    public void gameOfLife(int[][] board) {
        m = board.length;
        n = board[0].length;
        dirs = new int[][]{{0,-1}, {0, 1}, {-1, 0}, {1, 0}, {-1,-1}, {-1,1}, {1,-1}, {1,1}};

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int aliveCount = aliveCount(board, i, j);
                if(board[i][j] == 1 && (aliveCount < 2 || aliveCount > 3))
                    board[i][j] = 2;
                if(board[i][j] == 0 && aliveCount == 3)
                    board[i][j] = 3;
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 2)
                    board[i][j] = 0;
                else if(board[i][j] == 3)
                    board[i][j] = 1;
            }
        }
    }

    private int aliveCount(int[][] board, int i, int j){
        int count = 0;
        for(int[] dir: dirs){
            int row = i + dir[0];
            int col = j + dir[1];

            if(row >= 0 && row < m && col >= 0 && col < n && (board[row][col] == 1 || board[row][col] == 2))
                count++;
        }
        return count;
    }
}// Time Complexity : O(mn), where m is the number of rows and n is the number of columns
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    private int m;
    private int n;
    private int[][] dirs;

    public void gameOfLife(int[][] board) {
        m = board.length;
        n = board[0].length;
        dirs = new int[][]{{0,-1}, {0, 1}, {-1, 0}, {1, 0}, {-1,-1}, {-1,1}, {1,-1}, {1,1}};

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int aliveCount = aliveCount(board, i, j);
                if(board[i][j] == 1 && (aliveCount < 2 || aliveCount > 3))
                    board[i][j] = 2;
                if(board[i][j] == 0 && aliveCount == 3)
                    board[i][j] = 3;
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 2)
                    board[i][j] = 0;
                else if(board[i][j] == 3)
                    board[i][j] = 1;
            }
        }
    }

    private int aliveCount(int[][] board, int i, int j){
        int count = 0;
        for(int[] dir: dirs){
            int row = i + dir[0];
            int col = j + dir[1];

            if(row >= 0 && row < m && col >= 0 && col < n && (board[row][col] == 1 || board[row][col] == 2))
                count++;
        }
        return count;
    }
}