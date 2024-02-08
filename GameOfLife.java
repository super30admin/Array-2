//Time Complexity = O(2mn) //Iterating twice.
//Space Complexity = O(1)
// Does it run on LeetCode successfully?: Yes
// Any difficulties: Clicking logic in an interview is key.
//                      I am still able to derive after watching video.
//                      This is tricky problem. Unless you practice, you can not solve it.

/*
As we have rules given for Game of Life. Based on that actual value holds significance. Hence, changing them to another number doesnt help.
Hence, I am changing it to 1-->0 : -1 and 0-->1: -2 and based on that performing calculations.
*/
import java.util.Arrays;
public class GameOfLife {

    private int[][] dirs;
    public void gameOfLife(int[][] board) {
        int m = board.length; // rows
        int n = board[0].length; // columns
                    //left right   up      down    up left  up right down right  //Go clockwise
        this.dirs = new int[][]{{0,-1}, {0,1}, {-1,0}, {1,0}, {-1,-1} , {-1,1}, {1,1}, {1,-1}};
//        1--> 0 : -1
//        0--> 1 : -2
        for(int i=0;i<m ; i++){
            for(int j=0; j<n;j++){
                int countalive = countAlive (board, i, j);
                if(board[i][j] == 1 && countalive < 2 || countalive > 3) {
                    // it dies
                    board[i][j] = -1;
                }else if(board[i][j] == 0 && countalive == 3){
                    //it becomes alive
                    board[i][j] = -2;
                }
            }
        }

        for(int i=0;i<m ; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == -1){
                    board[i][j] = 0;
                }
                if(board[i][j] == -2){
                    board[i][j] = 1;
                }
            }
        }
    }

    private int countAlive(int[][] board, int i, int j){
        int countalive=0;

        //iterate over its all neighbours
        for(int[] dir : dirs){
            int nr = i + dir[0]; //Neighbour row
            int nc = j + dir[1]; //Neighbour column

            //bounds check
            if(nr >= 0&& nc>=0 && nr<=board.length-1 && nc<=board[0].length-1
            && (board[nr][nc] == 1 || board[nr][nc] == -1)){
                 countalive++;
            }
        }

        return countalive;
    }
    public static void main(String[] args){
        GameOfLife obj = new GameOfLife();
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        obj.gameOfLife(board);
        System.out.println(Arrays.toString(board));//It doesn't print element. //Learning
    }
}