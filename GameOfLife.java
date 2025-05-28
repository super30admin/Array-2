import java.util.*;

public class GameOfLife {
    static void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        // -1 is dead -2 is alive
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int live = countLives(board, i, j);
                if(board[i][j] == 1 && (live > 3 || live < 2)) {
                    board[i][j] = -1;
                } else if (board[i][j] == 0 && live == 3){
                    board[i][j] = -2;
                }
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == -1) board[i][j] = 0;
                if(board[i][j] == -2) board[i][j] = 1;
            }
        }

    }
    static int countLives(int[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;

        int count = 0;
        int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0, 1}, {-1,-1}, {-1, 1}, {1,-1}, {1,1}};

        for(int[] d : dir) {
            int cr = i + d[0];
            int cc = j + d[1];
            if(cr >= 0 && cr < m && cc >= 0 && cc < n
                    && (board[cr][cc] == 1 || board[cr][cc] == -1)) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[][]  board  = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        for(int[] b : board) {
            System.out.println(Arrays.toString(b));
        }
        System.out.println("After changes :");
        gameOfLife(board);
        for(int[] b : board) {
            System.out.println(Arrays.toString(b));
        }
    }
}
