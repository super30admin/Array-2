// Time Complexity : O(m*n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    int m;
    int n;
    int[][] dir;
    public void gameOfLife(int[][] board) {
        m = board.length;
        n = board[0].length;
        if(board == null || board.length == 0)
            return;

        dir = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}, {-1,-1}, {-1,1}, {1,1}, {1,-1}};

        //0->1->2
        //1->0->3
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int countAlive = countAlive(board, i, j);
                if(board[i][j] == 1 && (countAlive < 2 || countAlive < 3)){
                    board[i][j] = 3;
                }
                if(board[i][j] == 0 && countAlive == 3){
                    board[i][j] = 2;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == 3)
                    board[i][j] = 0;
                if(board[i][j] == 2)
                    board[i][j] = 1;
            }
        }
    }
    private int countAlive(int[][] board, int i, int j){
        int result = 0;
        for(int[] dirs : dir){
            int newRow = i + dirs[0];
            int newCol = j + dirs[1];

            if(newRow >= 0 && newCol >= 0 && newRow < m && newCol < n &&
                    (board[newRow][newCol] == 1 || board[newRow][newCol] == 3)){
                result++;
            }
        }
        return result;

    }
}