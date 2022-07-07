// TC: O(M*N)
// SC: O(1)


// Approach: 

// Since we have to convert the given array, we should have indicator. 
// 0 ---> 1 is represented as 2
// 1 ---> 0 is represented as 3

// Given conditions: 
// For alive(1): 
//   if adjacent and corner values < 2  and > 3 change current value to 3 (indication value for 0).
//   if adjacent and corner values == 3 or == 2 don't change current value
// For dead: 
//   if adjacent and corner values == 3 then change current value to 2 (indication value for 1).
//   else don't change

// Atlast change all values 3 to 0 and 2 to 1
    
    
class Solution {
    public void gameOfLife(int[][] board) {
     
        int n = board.length;
        int m = board[0].length;
        
        
        // 0 ---> 1 = 2
        // 1 ---> 0 = 3
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                int countAdjLives = adjLives(board, i, j);
                
                if(board[i][j] == 1) {
                    if(countAdjLives < 2) {
                        board[i][j] = 3;
                    } else if(countAdjLives == 2 || countAdjLives == 3) {
                        board[i][j] = board[i][j];
                    } else {
                        board[i][j] = 3;
                    }
                } else {
                    if(countAdjLives == 3) {
                        board[i][j] = 2;
                    }
                }
            }
        }
        
        
         for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(board[i][j] == 2) {
                    board[i][j] = 1;
                } else if(board[i][j] == 3){
                    board[i][j] = 0;
                }
            }
         }
        
    }
    
    private int adjLives(int[][] board, int r, int c) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0,1}, {-1, -1}, {-1, 1}, {1, 1}, {1, -1}};
        
        int n = board.length;
        int m = board[0].length;
     
        int count = 0;
        for(int[] dir: dirs) {
            int row = r + dir[0];
            int col = c + dir[1];
            if(row >= 0 && col >=0 && row < n && col < m && (board[row][col] == 1 || board[row][col] == 3)) {
                count++;
            } 
        }
    return count;
    }
}
