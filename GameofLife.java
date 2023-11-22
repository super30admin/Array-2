//TC:O(m*n)
//SC: O(1)
public class GameofLife {
    int[][] dirs;
    public void gameOfLife(int[][] board) {
        // up, down, left, right, diag up left, diag up right, diag down left, diag down right
        this.dirs = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1},{-1,-1}, {-1,1},{1,-1},{1,1}};

        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int count = countAliveNeighbours(board,i,j,m,n);
                if(board[i][j] == 1 && (count < 2 || count > 3)){
                    board[i][j] = 2; // dead now previously dead
                }else if(board[i][j] == 0 && count == 3)
                    board[i][j] = 3; // alive now previously dead
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 2) board[i][j] = 0;
                else if(board[i][j] == 3) board[i][j] = 1;
            }
        }

    }
    private int countAliveNeighbours(int[][] board, int i, int j, int m, int n){
        int count  = 0;
        for(int[] dir: dirs){
            int r = i + dir[0];
            int c = j + dir[1];

            if(r >= 0 && c >= 0 && r < m && c < n && (board[r][c] == 1 || board[r][c]==2)) count++;
        }
        return count;

    }
}
