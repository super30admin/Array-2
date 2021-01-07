// Time Complexity : O(mn) where m in number of rows and n is number of columns
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes


class Solution {
    
    int m; int n;
    
    public void gameOfLife(int[][] board) {
        // 1 -> 0 2
        // 0 -> 1 3
        //edge case
        if(board == null || board.length == 0)
            return;    
        
        m = board.length;
        n = board[0].length;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                int count = countLives(i, j, board);
                if((count < 2 || count > 3) && board[i][j] == 1)
                    board[i][j] = 2;
                if(count == 3 && board[i][j] == 0)
                    board[i][j] = 3;
            }
        }
        
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(board[i][j] == 2)
                    board[i][j] = 0;
                if(board[i][j] == 3)
                    board[i][j] = 1;
            }
        }
        
    }
    
    public int countLives(int i, int j, int[][] board){
        int[][] dirs = {{0,1},{1,0},{1,1},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1}};
        int row, col;
        int count = 0;
        for(int[] dir: dirs){
            row = i + dir[0];
            col = j + dir[1];
            if(row>=0 && col>=0 && row<m && col<n){
                if(board[row][col] == 1 || board[row][col] == 2)
                    count++;
            }
        }
        return count;
    }

}