//Time Complexity: O(M×N), where M is the number of rows and N is the number of columns of the Board.
//Space Complexity: O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

public class GameOfLife {
    //Time Complexity: O(M×N), where M is the number of rows and N is the number of columns of the Board.
    //Space Complexity: O(1)

    /// for inplace we need to change live-->dead (-1) and dead--> alive to 2
    public void gameOfLife(int[][] board) {
        for(int i=0; i< board.length; i++){
            for(int j=0; j< board[0].length; j++){
                int alive = 0;
                if(board[i][j] == 1){
                    // if cell is alive
                    alive = getNeighboringAliveCount(i, j, board);
                    //Any live cell with fewer than two live neighbors dies, as if caused by under-population.
                    if(2 > alive){
                        board[i][j] = -1;
                    }else if(alive > 3){
                        board[i][j] = -1;
                    }
                }else{
                    alive = getNeighboringAliveCount(i, j, board);
                    // if cell is dead
                    if(alive == 3){
                        board[i][j] = 2;
                    }
                }
            }
        }

        for(int i=0; i< board.length; i++){
            for(int j=0; j< board[0].length; j++){
                if(board[i][j] > 0){
                    board[i][j] = 1;
                }else{
                    board[i][j] = 0;
                }

            }
        }

    }

    public int getNeighboringAliveCount(int i, int j, int[][] board){
        int alive = 0;
        int newI = 0, newJ = 0;
        int[][] directions = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        for(int[] direction : directions){
            newI = i + direction[0];
            newJ = j + direction[1];
            if(newI >= board.length || newI < 0 || newJ >= board[0].length || newJ < 0){
                continue;
            }
            if(board[newI][newJ] == 1 || board[newI][newJ] == -1){
                alive++;
            }
        }

        return alive;
    }
}