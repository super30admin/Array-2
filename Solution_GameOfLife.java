//TC: O(rows*cols)
//SC: O(1)
//Did it run on leetcode: Yes
public class Solution_GameOfLife {
    public int countAlive(int[][] board, int[][] dir, int i, int j, int rows, int cols){

        int count = 0;
        for(int k = 0; k < dir.length; k++){
            int cr = i + dir[k][0];
            int cc = j + dir[k][1];
            if((cr >= 0 && cr < rows) && (cc >= 0 && cc < cols)){
                if(board[cr][cc] == 1 || board[cr][cc] == 2)
                    count++;
            }
        }
        return count;
    }
    public void gameOfLife(int[][] board) {

        int rows = board.length;
        int cols = board[0].length;

        int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}, {-1, -1}, {-1, 1}, {1, 1}, {1, -1}};

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                int alive = countAlive(board, dir, i, j, rows, cols);
                if(board[i][j] == 1 && (alive < 2 || alive > 3)){
                    board[i][j] = 2;
                }
                if(board[i][j] == 0 && (alive == 3)){
                    board[i][j] = 3;
                }
            }
        }

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(board[i][j] == 2){
                    board[i][j] = 0;
                }
                if(board[i][j] == 3){
                    board[i][j] = 1;
                }
            }
        }
    }
}
