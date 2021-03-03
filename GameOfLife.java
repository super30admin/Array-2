// TC - O(m X n), SC - O(1)

// Using constant space and dirs[][] array
class Solution {
    public void gameOfLife(int[][] board) {
        // Sanity check when board is null or length of board is 0
        if(board == null || board.length == 0){
            return;
        }
        int m = board.length;
        int n = board[0].length;
        // Iterate over each element in matrix and call findLiveOrDead method
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                board[i][j] = findLiveOrDead(board, i, j);
            }
        }
        
        
        /// Iterate over board matrix and if we encounter 3, change it to 0 and if we encounter 2, change it to 2
        for(int i=0; i<m; i++){
             for(int j=0; j<n; j++){
                 if(board[i][j] == 3){
                     board[i][j] = 0;
                 }else if(board[i][j] == 2){
                     board[i][j] = 1;
                 }
             }
        }
    }
    
    private static int findLiveOrDead(int[][] board, int i, int j){
        // Initalize ct variable to 0, this stores number of alive cells around current cell
        int ct = 0;
        int m = board.length - 1;
        int n = board[0].length - 1;
        // Initializing dirs array, these are 8 directions from current cell in matrix
        int[][] dirs = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};
        
        // Iterating over dirs array 
        for(int x=0; x<dirs.length; x++){
            // r is row and c is column of particular direction, we add up current i value to current dirs row or column value
            int r = i+dirs[x][0];
            int c = j+dirs[x][1];
            // Check if r and c is in boundary of matrix
            if(r >= 0 && r <= m && c >= 0 && c <= n){
                // if rth row and cth column is 1 or 3, increment ct, we use 3 because when state changed from 1 to 0, we store in 0 as 3 as we need constant space
                if(board[r][c] == 1 || board[r][c] == 3){
                    ct++;
                }
            }
        }
        
        // Rules check
        if(board[i][j] == 1 && ct < 2){
            return 3;
        }else if(board[i][j] == 1 && ct > 3){
            return 3;
        }else if(board[i][j] == 0 && ct == 3){
            return 2;
        }
        return board[i][j]; 
    }
}


// Using dirs[][] array and O(m X n) extra space
// class Solution {
//     public void gameOfLife(int[][] board) {
//         int m = board.length;
//         int n = board[0].length;
//         int[][] result = new int[m][n];
//         for(int i=0; i<m; i++){
//             for(int j=0; j<n; j++){
//                 result[i][j] = findLiveOrDead(board, i, j);
//             }
//         }
//         for(int i=0; i<m; i++){
//             for(int j=0; j<n; j++){
//                 board[i][j] = result[i][j];       
//             }
//         }
//     }
    
//     private static int findLiveOrDead(int[][] board, int i, int j){
//         int ct = 0;
//         int m = board.length - 1;
//         int n = board[0].length - 1;
//         int[][] dirs = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};
        
//         for(int x=0; x<dirs.length; x++){
//             int r = i+dirs[x][0];
//             int c = j+dirs[x][1];
//             if(r >= 0 && r <= m && c >= 0 && c <= n){
//                 if(board[r][c] == 1){
//                     ct++;
//                 }
//             }
//         }
//         if(board[i][j] == 1 && ct < 2){
//             return 0;
//         }else if(board[i][j] == 1 && ct > 3){
//             return 0;
//         }else if(board[i][j] == 0 && ct == 3){
//             return 1;
//         }
//         return board[i][j]; 
//     }
// }


// Using O(m X n) extra space
// class Solution {
//     public void gameOfLife(int[][] board) {
//         int m = board.length;
//         int n = board[0].length;
//         int[][] result = new int[m][n];
//         for(int i=0; i<m; i++){
//             for(int j=0; j<n; j++){
//                 result[i][j] = findLiveOrDead(board, i, j);
//             }
//         }
//         for(int i=0; i<m; i++){
//             for(int j=0; j<n; j++){
//                 board[i][j] = result[i][j];       
//             }
//         }
//     }
    
//     private static int findLiveOrDead(int[][] board, int i, int j){
//         int ct = 0;
//         int m = board.length - 1;
//         int n = board[0].length - 1;
//         if(j-1 >= 0){
//             if(board[i][j-1] == 1){  
//                 ct++;
//             }
//         }
//         if(j-1 >= 0 && i-1 >= 0){
//             if(board[i-1][j-1] == 1){  
//                 ct++;
//             }
//         }
//         if(i-1 >= 0){
//             if(board[i-1][j] == 1){  
//                 ct++;
//             }
//         }
//         if(i-1 >= 0 && j+1 <= n){
//             if(board[i-1][j+1] == 1){  
//                 ct++;
//             }
//         }
//         if(j+1 <= n){
//             if(board[i][j+1] == 1){  
//                 ct++;
//             }
//         }
//         if(i+1 <= m && j+1 <= n){
//             if(board[i+1][j+1] == 1){  
//                 ct++;
//             }
//         }
//         if(i+1 <= m ){
//             if(board[i+1][j] == 1){  
//                 ct++;
//             }
//         }
//         if(i+1 <= m && j-1 >= 0){
//             if(board[i+1][j-1] == 1){  
//                 ct++;
//             }
//         }
//         if(board[i][j] == 1 && ct < 2){
//             return 0;
//         }else if(board[i][j] == 1 && ct > 3){
//             return 0;
//         }else if(board[i][j] == 0 && ct == 3){
//             return 1;
//         }
//         return board[i][j];
//     }
// }