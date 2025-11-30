// Time Complexity : O(mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// 1: To calculate the live cells next to a given cell without changing the original matrix, we employ a set of rules to change the value in place
// 2: For 0 -> 1 we change the value to 3 and for 1 -> 0 we change the value to 2
// 3: Thus for each direction we are able to calculate the number of live cells, and at the end of calculation we can easily revert the numbers back to their new form
class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length; //rows
        int n = board[0].length; // columns
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int countAlives = countAlive(board, i, j, m, n); // count all live cells around a given cell
                if (board[i][j] == 1 && (countAlives < 2 || countAlives > 3)) // has to be marked dead
                {
                    board[i][j] = 2;
                }
                if(board[i][j] == 0 && (countAlives == 3)) // dead cell -> alive
                {
                    board[i][j] = 3;
                }
            }
        }
        for(int i = 0; i<m;i++){
            for(int j = 0; j<n; j++){
                if(board[i][j] == 2){
                    board[i][j] = 0;
                }
                else if(board[i][j] == 3){
                    board[i][j] = 1;
                }
            }
        }

    }

    public int countAlive(int[][] board, int i, int j, int rows, int columns){
        int count = 0;
        int[][] directions = new int[][] {{0,1}, {0,-1}, {-1, 0}, {1,0}, {-1,1}, {-1, -1}, {1,1}, {1,-1}};
        for(int[] dir: directions){
            int nr = i + dir[0]; // new row index
            int nc = j + dir[1]; // new column index
            if(nr >= 0 && nc >=0 && nr < rows && nc < columns && (board[nr][nc] == 1 || board[nr][nc] == 2)){
                count++;
            }
        }
        return count;
    }
}