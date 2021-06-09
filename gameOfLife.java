//Time Complexity:  O(m x n) where m is number of rows and n is number of columns.
//Space Complexity: O(1)

class Solution {
    public void gameOfLife(int[][] board) {
        
        // 0 to 1 change would be temporarily marked as 2
        // 1 to 0 change would be temporarily marked as 3
        
        int m = board.length; int n = board[0].length;
        
        for(int i=0; i< m; i++){
            for(int j=0; j<n; j++){
                int count = countLives(board, i,j,m,n);
                
                if(board[i][j] == 1 && (count <2 || count >3)){
                    // cell would be marked dead because of under or over population
                    board[i][j] = 3;
                }
                if(board[i][j] == 0 && count == 3){
                    // cell would be marked dead because of under or over population
                    board[i][j] = 2;
                }
            }
        }
        
        // after traversing entire array and making all changes, replacing 3 with 0 and 2 with 1
        for(int i=0; i< m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 2){
                    board[i][j] = 1;
                }
                if(board[i][j] == 3){
                    board[i][j] = 0;
                }
            }
        }  
    }
    
    private int countLives(int[][] board, int i, int j, int m, int n){
//                        r     l       b      u    br     bl   ur      ul
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
        int count =0;
        for(int[] dir: dirs){
            int r = i + dir[0];
            int c = j + dir[1];
            if(r >=0 && r < m && c >=0 && c < n && (board[r][c] == 1 || board[r][c] == 3)){
                count++;
            }
        }
        return count;
        
    }
}