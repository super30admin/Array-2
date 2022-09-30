//without using extra space

class Solution {
    int m, n;
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0)
            return;
        
        m = board.length;
        n = board[0].length;
        //0 ==> 1 ============> 2
        //1 ==> 0 ============> 3
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int countLives = countAlive(board, i, j);
                if(board[i][j] == 0){
                    if(countLives == 3)
                        board[i][j] = 2;
                }
                else{
                    if(countLives < 2 || countLives > 3)
                        board[i][j] = 3;
                }
            }
        }
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 2)
                    board[i][j] = 1;
                if(board[i][j] == 3)
                    board[i][j] = 0;
            }
        }
    }
    
    public int countAlive(int[][] board, int i, int j){
        int count = 0;
        int[][] dirs = new int[][] {{-1,0}, {1,0}, {0,-1}, {0,1}, {-1,-1}, {-1,1}, {1,-1}, {1,1}};
        
        for(int d[] : dirs){
            int nr = i + d[0];
            int nc = j + d[1];
            if(nr >= 0 && nr < m && nc >= 0 && nc < n && (board[nr][nc] == 1 || board[nr][nc] == 3))
                count++;
        }
        return count;
    }
}

//Time Complexity :O(m * n)
//Space Complexity :O(1)