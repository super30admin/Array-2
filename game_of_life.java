class Solution{
    int m, n; // we are declaring 2 variables m and n in the global scope which stores the size of the board.
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0) return; // if the board is null or the the boards length is 0, we simply return;
        m = board.length; // m stores the no. of rows of the board.
        n = board[0].length; //n stores the no. of cols of the board.
        for(int i = 0; i <= m - 1; i++) { // we iterate through the rows of the board
            for(int j = 0; j <= n - 1; j++) { // we iterate through the cols of the board.
                int lives = countLives(board, i, j); // we create an integer variable called as lives, which stores the count of live cells in the board. we create a function called as countLives to which we pass the vales as board, and the respective indices.
                if(board[i][j] == 1) { // if a particular location in the board is having a value of 1 which is the live cell
                    if(lives < 2 || lives > 3) { // we check its surroundings and if its surroundings locations are having < 2 or > 3 lives
                        board[i][j] = 2; // we temporarily change its value to 2 to avoid overlapping
                    }
                }
                else { // we are initially having the values on the board as 1 or 0. this else case has the oard value as 0
                    if(lives == 3) { // if the cell with value 0 is have exactly 3 live neighbours,
                        board[i][j] = 3; // we temprarily change its value to 3 to avoid overlapping.
                    }
                }
            }
        }
        for(int i = 0; i < m; i++) { // we again iterate through the rows
            for(int j = 0; j < n; j++) { // we again iterate through the cols
                if(board[i][j] == 2) { // the location in the board which is having a value as 2
                    board[i][j] = 0; // we change it to 0, which means it is a dead cell;
                }
                else if(board[i][j] == 3){ // the location in the board which is having a value as 3
                    board[i][j] = 1; // we change it to 1, which means it is a live cell;
                }
            }
        }
    }
    private int countLives(int[][] board, int r, int c) { // we write a method for counting the lives. which has the input as board, r for row and c for col
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}}; // these are the directions which we want to move to.
        int count = 0; // we take a count variable which count the no. of lives.
        for(int[] dir : dirs) {
            int nr = r + dir[0]; // we compute the new row
            int nc = c + dir[1]; // we compute the new col
            if(nr >= 0 && nr < m && nc >= 0 && nc < n && (board[nr][nc] == 1 || board[nr][nc] == 2)) { // if this condition is satisfied
                count++; // we increment the count
            }
        }
        return count; // in the end, we return the count which gives the
    }
}
//tc and sc - O(m*n) and O(1)