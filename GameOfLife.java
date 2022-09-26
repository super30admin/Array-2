// Time Complexity : O(M*N) where M is no. of rows and N is number of cols. Eight direction check is asymptotic
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


class Solution {
    int m,n;
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0) return;

        m = board.length;
        n = board[0].length;

        for(int i = 0; i<m; i++){
            for(int j =0; j<n; j++){
                int liveNeighbours = countLiveNeighbour(board, i, j);
                if(board[i][j] == 0){
                    if(liveNeighbours == 3){
                        board[i][j] = 3;
                    }
                } else {
                    if(liveNeighbours <2 || liveNeighbours > 3) {
                        board[i][j] = 2;
                    }
                }
            }
        }
        for(int i = 0; i<m; i++){
            for(int j =0; j<n; j++){
                if(board[i][j] == 3){
                    board[i][j] = 1;
                }
                if(board[i][j] == 2){
                    board[i][j] = 0;
                }
            }
        }
    }

    private int countLiveNeighbour(int[][] board, int i, int j){
        int count = 0;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0},{-1,-1},{1,-1},{1,1},{-1,1}};

        for(int[] dir: dirs){
            int nr = i + dir[0];
            int nc = j + dir[1];
            if(nc>=0 && nr>=0 && nr<=m-1 && nc<=n-1&& (board[nr][nc]==1 ||board[nr][nc]==2)) {
                count++;
            }
        }
        return count;
    }
}