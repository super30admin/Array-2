// Time Complexity :
//O(m *n)
// Space Complexity :
//O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Added conditions for dead and live cells, and using dirs condition changed values.
class Solution {
    int m,n;
    public void gameOfLife(int[][] board) {
        
        if(board == null || board.length == 0) {
            return;
        }
        m = board.length;
        n = board[0].length;
        //1->0 == 2 [2 indicates that a live cell becomes dead]
        //0->1 == 3 [3 indicates that a dead cell becomes live]

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int CountLiveNeighbors = CountLiveNeighbors(board, i, j );
                if(board[i][j] == 1) {
                    if(CountLiveNeighbors < 2 || CountLiveNeighbors > 3) {
                        board[i][j] = 2;
                    }
                }
                else if(board[i][j] == 0) {
                    if(CountLiveNeighbors == 3) {
                        board[i][j] = 3;
                    }
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 2) {
                    board[i][j] = 0;
                }
                else if(board[i][j] == 3) {
                    board[i][j] = 1;
                }


            }
        }
    }
    
    private int CountLiveNeighbors(int[][] board, int row, int col) {
        int count = 0;
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}}; //U D L R UL UR LL LR
        for(int[] dir : dirs) {
            int nr = row + dir[0];
            int nc = col + dir[1];
            if(nr >=0  && nr < m && nc >= 0 && nc < n && (board[nr][nc] == 1 || board[nr][nc] == 2)) {
                count++;
            }
        }
        return count; 
    
    }

}