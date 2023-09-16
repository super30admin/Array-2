// Time Complexity : O(n*m) as it is traversing through all elements in matrix
// Space Complexity : O(1) as we are altering elements in input matrix itself
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Problem3 {
    int m, n;

    public void gameOfLife(int[][] board) {
        m = board.length;
        n = board[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int countLiveNeighbors = countLiveNeighbors(board, i, j);
                if(board[i][j] == 1){
                    if(countLiveNeighbors < 2 || countLiveNeighbors > 3){
                        board[i][j] = 2;
                    }
                }else{
                    if(countLiveNeighbors == 3){
                        board[i][j] = 3;
                    }
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 2){
                    board[i][j] = 0;
                }else if(board[i][j] == 3){
                    board[i][j] = 1;
                }
            }
        }
    }

    public int countLiveNeighbors(int[][] board, int i, int j){
        int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        int count = 0;

        for(int[] dir : dirs){
            int nr = i + dir[0];
            int nc = j + dir[1];
            if(nr >= 0 && nr < m && nc >= 0 && nc < n && (board[nr][nc] == 1 || board[nr][nc] == 2)){
                count++;
            }
        }

        return count;
    }
}
