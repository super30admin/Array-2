//The algorithm simulates the Game of Life rules for the given board using a two-step process. 
//In the first step, it calculates the live neighbor count for each cell using the isLive method. 
//In the second step, it updates the cell states based on the rules of the Game of Life, marking cells as 2 for live cells and 3 for dead cells. 
//After processing all cells, it converts the marked cells back to 1 for live cells and 0 for dead cells. 
//The time complexity is O(n * m), space-O(1).
class Solution {
    public int isLive(int[][] board, int i, int j){
        int liveCount = 0;
        int r = board.length;
        int c = board[0].length;

        //Horizantal
        if(j - 1 >= 0){ // for left side
            if(board[i][j - 1] == 1 || board[i][j - 1] == 3)liveCount++;
        }
        if(j + 1 < c){ // for right side
            if(board[i][j + 1] == 1 || board[i][j + 1] == 3)liveCount++;
        }

        //vertical
        if(i - 1 >= 0){ // for up side
            if(board[i - 1][j] == 1 || board[i - 1][j] == 3)liveCount++;
        }
        if(i + 1 < r){ // for down side
            if(board[i + 1][j] == 1 || board[i + 1][j] == 3)liveCount++;
        }

        //digonal
        if(i - 1 >= 0 && j - 1 >= 0){ // for upper left side
            if(board[i - 1][j - 1] == 1 || board[i - 1][j - 1] == 3)liveCount++;
        }
        if(i - 1 >= 0 && j + 1 < c){ // for upper right side
            if(board[i - 1][j + 1] == 1 || board[i - 1][j + 1] == 3)liveCount++;
        }
        if(i + 1 < r && j - 1 >= 0){ // for lower left side
            if(board[i + 1][j - 1] == 1 || board[i + 1][j - 1] == 3)liveCount++;
        }
        if(i + 1 < r && j + 1 < c){ // for lower right side
            if(board[i + 1][j + 1] == 1 || board[i + 1][j + 1] == 3)liveCount++;
        }

        return liveCount;
    }
    public void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int count = isLive(board, i, j);

                if(board[i][j] == 0){
                    if(count == 3){
                        board[i][j] = 2; // making as a live cell and mark as 2 for further process
                    }
                }
                else if(board[i][j] == 1){
                    if(count < 2 || count > 3)board[i][j] = 3; //making as a dead cell and mark as 3 for further process
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 2)board[i][j] = 1;
                else if(board[i][j] == 3)board[i][j] = 0;
            }
        }
    }
}