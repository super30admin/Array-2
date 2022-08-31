// Time complexity: O(m*n)
// Space complexity: O(m*n)

// Approach: we basically have a new 2D array where we store all values after state changes due to rules mentioned in problem. Then we need to copy back elements from newstate 2D array into original array. The dirs array is important. This is what we use to go in all 8 directions from any element. The calculate neighbor lives function goes in every direction using this dir array and checks for boundary cases and if neighbor element is 1, then it will increment the number of lives and finally return

class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        int[][] newState = new int[m][n];
        int[][] dirs = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}, {-1, 1}, {-1,-1}, {1,1}, {1,-1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int neighborLives = CalculateNeighborLives(board, i, j, m, n, dirs);
                if (board[i][j] == 0 && neighborLives == 3) {
                    newState[i][j] = 1;
                }
                else if (board[i][j] == 1 && (neighborLives < 2 || neighborLives > 3)) {
                    newState[i][j] = 0;
                }
                else {
                    newState[i][j] = board[i][j];
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = newState[i][j];
            }
        }
        
    }
    
    private int CalculateNeighborLives(int[][] board, int i, int j, int m, int n, int[][] dirs) {
        int result = 0;
        for (int[] dir : dirs) {
            int newr = i + dir[0];
            int newc = j + dir[1];
            
            if (newr >= 0 && newr < m && newc >=0 && newc < n && board[newr][newc] == 1) {
                result++;
            }
        }
        return result;
    }
}