/* 289. Game of Life
Time Complexity: O(m*n)
Space Complexity: O(1)
We are mutating the input matrix
*/

class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0)
            return;

        int m = board.length;
        int n = board[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int live_count = getLiveCount(board, i, j);
                //Rule 1 and 3
                if(board[i][j] == 1 && (live_count < 2 || live_count > 3))
                    board[i][j] = -1;
                //Rule 4
                if(board[i][j] == 0 && live_count == 3)
                    board[i][j] = 2;
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 2)
                    board[i][j] = 1;
                else if(board[i][j] == -1)
                    board[i][j] = 0;
            }
        }
    }

    public int getLiveCount(int[][] board, int i, int j){
        // i is Row; j is Column
        //Live ->Dead (-1), Dead-> Live (2)
        int lcount = 0;
        int m = board.length;
        int n = board[0].length;

        //Vertical Up
        if(i>0){
            if(board[i-1][j] == 1 || board[i-1][j] == -1)
                lcount++;
        }

        //Vertical Down
        if(i < m-1){
            if(board[i+1][j] == 1 || board[i+1][j] == -1)
                lcount++;
        }

        //Right
        if(j < n-1){
            if(board[i][j+1] == 1 || board[i][j+1] == -1)
                lcount++;
        }

        //Left
        if(j > 0){
            if(board[i][j-1] == 1 || board[i][j-1] == -1)
                lcount++;
        }

        //Bottom Right
        if(i < m-1 && j < n-1){
            if(board[i+1][j+1] == 1 || board[i+1][j+1] == -1)
                lcount++;
        }

        //Bottom Left
        if(i < m-1 && j > 0){
            if(board[i+1][j-1] == 1 || board[i+1][j-1] == -1)
                lcount++;
        }

        //Top Right
        if(i > 0 && j < n-1){
            if(board[i-1][j+1] == 1 || board[i-1][j+1] == -1)
                lcount++;
        }

        //Top Left
        if(i > 0 && j > 0){
            if(board[i-1][j-1] == 1 || board[i-1][j-1] == -1)
                lcount++;
        }

        return lcount;
    }
}