class Solution {
    /*
    Time comlexity: O(n * m)
    Space complexity: O(1)
    */
    public void gameOfLife(int[][] board) {
        // check if the board is empty or not
        if(board == null || board.length == 0 || board[0].length == 0){
            return;
        }
        
        int n = board.length;
        int m = board[0].length;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                // get the total number of lives count
                int count_l = countLives(board, i, j, n, m);
                
                // 2 means alive to dead
                // 3 means dead to alive
                
                // check for under and over population conditions
                if(board[i][j] == 1 && (count_l < 2 || count_l > 3)){
                    board[i][j] = 2;
                }
                // check for regeneration condition
                else if(board[i][j] == 0 && (count_l == 3)){
                    board[i][j] = 3;
                }
            }
        }
        
        // change all the 2s to 0 and all the 3s to 1
        for(int i = 0; i< n; i++){
            for(int j =0; j<m; j++){
                if (board[i][j] == 2){
                    board[i][j] = 0;
                }
                else if(board[i][j] == 3){
                    board[i][j] = 1;
                }
            }
        }
    }
    // this will count the total lives adjacent to the current node
    public int countLives(int[][] board, int i, int j, int n, int m){
        
        int count = 0;
        // directions adjacent to a node
        int[][] dir = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        
        // calculate r and c for each direction
        for(int dirs[]: dir){
            int r = i + dirs[0];
            int c = j + dirs[1];
            
            // check if the r and c are not out bounds and also count the number of lives
            if (r >= 0 && r < n  && c >= 0 && c < m && (board[r][c] == 1 || board[r][c] == 2)){
                count += 1;
            }
        }
        // return the count
        return count;
    }
}