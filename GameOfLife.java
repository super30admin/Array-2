import java.util.Arrays;

// Time Complexity : O(m*n) where m and n are dimensions of matrix
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Couldn't think of the 2/3 modification thing.

class GameOfLife {
    int m;
    int n;
    int [][] dirs;
    public int[][] gameOfLife(int[][] board) {
        m = board.length;
        n = board[0].length;
        dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
        if(board==null || m==0) return board;
        //0-1-2
        //1-0-3
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int countAlive = countAlive(board,i,j);
                if(board[i][j] == 1 && (countAlive<2 || countAlive>3)){
                    board[i][j] = 3;
                }
                if(board[i][j]==0 && countAlive == 3){
                    board[i][j] = 2;
                }
            }
        }


        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==3) board[i][j] = 0;
                if(board[i][j]==2) board[i][j] = 1;
            }
        }

        return board;
    }

    private int countAlive(int[][]board, int i, int j){
        int result = 0;
        for(int [] dir: dirs){
            int nr = i + dir[0];
            int nc = j + dir[1];
            if(nr>=0 && nc>=0 && nr<m && nc<n && (board[nr][nc]==1 || board[nr][nc]==3)){
                result++;
            }
        }
        return result;
    }

    public static void main(String [] args){
        int[][] board = new int[][]{{0, 1, 0},{0, 0, 1},{1, 1, 1},{0, 0, 0}};
        GameOfLife gf = new GameOfLife();
        System.out.println(Arrays.deepToString(gf.gameOfLife(board)));
    }
}