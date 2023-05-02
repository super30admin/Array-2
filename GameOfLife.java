//tc=O(m*n)
//sc=O(1)
class Solution {
    int m;
    int n;
    public void gameOfLife(int[][] board) {

        if (board == null || board.length == 0) {
            return;
        }
        m = board.length;
        n = board[0].length;
        // 2 : 1 -> 0
        // 3 : 0 -> 1

        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j++) {
                int count = countLiveNeighbors(i, j, board);
                if (board[i][j] == 1) {
                    if (count < 2 || count > 3) {
                        board[i][j] = 2;
                    }
                }
                else if (board[i][j] == 0) {
                    if (count == 3) {
                        board[i][j] = 3;
                    }
                }
            }
        }

         for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                }
                else if (board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
         }
        
    }

    private int countLiveNeighbors(int row, int col, int[][] board) {
        int count = 0;
        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}, {-1,-1}, {-1,1}, {1,-1}, {1,1}};
        // U D L F UL UR DL DR

        for (int i =0; i < 8; i ++) {
            int nr =  row + dirs[i][0];
            int nc = col + dirs[i][1];
            if ((nr >=0 && nr <m) && (nc >=0 && nc < n) && (board[nr][nc] == 1 || board[nr][nc] == 2)) {
                count ++;
            }
        }
        return  count;
    }
}