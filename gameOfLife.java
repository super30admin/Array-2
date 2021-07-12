//TC: O(M*N)
//SC: O(1)
class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                int count = countLiveNeighbours(board, i, j, m, n);
                if(board[i][j] == 1 && (count < 2 || count > 3)) {
                    board[i][j] = 3;
                }
                if(board[i][j] == 0 && count == 3) {
                    board[i][j] = 2;
                }
            }
        }
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == 3)
                    board[i][j] = 0;
                else if(board[i][j] == 2)
                    board[i][j] = 1;                
            }            
        }
    }
    
    private int countLiveNeighbours(int[][] board, int i, int j, int m, int n) {
        int result = 0;
        int[][] dirs = new int[][]{{-1, -1}, {-1, 1}, {1, 1}, {1, -1}, {0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for(int[] dir : dirs) {
            int r = i+dir[0];
            int c = j+dir[1];
            if(r>=0 && r<m && c>=0 && c<n) {
                if(board[r][c] == 1 || board[r][c] == 3) {
                    result++;
                }
            }
        }
        return result;
    }
}









