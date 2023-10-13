
//Time Complexity O (m * N)
// Space complexity O(1)
// Did this code successfully run on LeetCode : Yes
// Any problem you faced while coding this : No

//Approach: Calculate the live neighbours count by looking at the eight directions of a particular cell by taking
// care of the edge case boundary check, temporarily change the state  to 2 and 3 then change it back to 0,1,
public class GameOfLife {
    int rowsSize =0;
    int columnSize = 0;
    int[][] directions;
    final int  STAYS_ALIVE = 1, DEAD_TO_ALIVE = 2, ALIVE_TO_DEAD = 3;

    public void gameOfLife(int[][] board) {
        rowsSize = board.length;
        columnSize = board[0].length;
        directions = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}, {-1,-1}, {-1,1}, {1,-1}, {1,1}};

        for (int r =0; r <rowsSize; r++){
            for(int c = 0; c <columnSize; c++){
                int aliveNeighbours = getLiveNeighbours(board, r,c);
                if(board[r][c]== 1 &&
                        (aliveNeighbours <2 || aliveNeighbours > 3)){
                    board[r][c]= ALIVE_TO_DEAD;
                }else if(board[r][c]==0 && aliveNeighbours == 3){
                    board[r][c]= DEAD_TO_ALIVE;
                }
            }
        }

        for(int r = 0; r < rowsSize; r++){
            for(int c = 0; c < columnSize; c++){
                if(board[r][c] == ALIVE_TO_DEAD) board[r][c] = 0;
                else if(board[r][c] == DEAD_TO_ALIVE) board[r][c] = 1;
            }
        }
    }
    private int getLiveNeighbours(int[][] board, int row, int column){
        int aliveNeighbours = 0;
        for(int[] direction : directions){
            int neighbourRow = row + direction[0];
            int neighbourColumn = column + direction[1];
            if(neighbourRow < 0 || neighbourRow >= rowsSize
                    || neighbourColumn < 0 || neighbourColumn >= columnSize) continue;
            if(board[neighbourRow][neighbourColumn] == STAYS_ALIVE ||
                    board[neighbourRow][neighbourColumn] == ALIVE_TO_DEAD){
                aliveNeighbours++;
            }
        }
        return aliveNeighbours;
    }
}
