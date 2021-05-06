// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Rather than doing a direct state change, the idea is to use a temporary state. 
// We mark the temporary states as below.
//      1 -> 0: 2
//      0 -> 1: 3
// When we check for the number of lives for a given cell, we check for the original live cell and the temporary state as well.
// Finally when the board is completed, we return the state of the board from temporary to original.

public class GameOfLife {
    public static void playGame(int[][] board) {

        if(board == null || board.length == 0) return;
        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int lives = getLives(board, m, n, i, j);
                if(board[i][j] == 1 && (lives < 2 || lives > 3)){
                    board[i][j] = 2;
                }else if(board[i][j] == 0 && (lives == 3)){
                    board[i][j] = 3;
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 2){
                    board[i][j] = 0;
                }else if(board[i][j] == 3){
                    board[i][j] = 1;
                }
            }
        }
    }

    public static int getLives(int[][] board, int m, int n, int i, int j){

        int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}, {-1,-1}, {1,1}, {-1,1}, {1,-1}};
        int x = i, y = j, lives = 0;

        for(int[] direction: directions){
            x = i + direction[0];
            y = j + direction[1];
            
            if(!(x < 0 || x >= m || y < 0 || y >= n)){
                if(board[x][y] == 1 || board[x][y] == 2){
                    lives++;
                }
            }

        }

        return lives;
    }

    public static void printBoard(int[][] board){
        for(int[] row: board){
            System.out.println();
            for(int cell: row){
                System.out.print(cell + " ");
            }
        }
        System.out.println();
        System.out.println("<---->");
    }

    public static void main(String[] args) {
        int[][] board1 = new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        printBoard(board1);
        playGame(board1);
        printBoard(board1);

        int[][] board2 = new int[][]{{1,1},{1,0}};
        printBoard(board2);
        playGame(board2);
        printBoard(board2);
    }
}
