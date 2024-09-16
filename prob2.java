// Time Complexity : O (m*n) , m = # of rows, n = # of cols
// Space Complexity : O (1) no extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, was using i, j instead of the new row and new column, nr, nc,  in countLive

public class prob2 {

    public static void gameOfLife(int[][] board){
        if(board == null || board.length == 0) return;
        int m = board.length; int n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int count = countLive(board, i, j, m, n);
                if((count < 2 || count > 3) && board[i][j] == 1){
                    board[i][j] = 3;
                }
                if(count == 3 && board[i][j] == 0){
                    board[i][j] = 2;
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 3){
                    board[i][j] = 0;
                }
                if(board[i][j] == 2){
                    board[i][j] = 1;
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        
    }

    private static int countLive(int[][] board, int i, int j, int m, int n){
        int[][] dirs = {{0,1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int count  = 0;
        for(int[] dir: dirs){
            int nr = i + dir[0];
            int nc = j + dir[1];
            if(nr >=0 && nr < m && nc >= 0 && nc < n && (board[nr][nc] == 1 || board[nr][nc] == 3)){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        gameOfLife(board);
        
    }
    
}
