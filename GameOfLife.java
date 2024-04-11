//Time Complexity: O(m*n)
//Space Complexity: O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        
        int m = board.length;
        int n = board[0].length;
        
        for(int i = 0;i < m; i++){
            for(int j = 0; j < n; j++){
                int countlive = countlive(board,i,j);
                if(board[i][j]==1 && (countlive<2 || countlive >3)){
                    board[i][j] =-1;
                }else if(board[i][j]==0 && countlive==3){
                    board[i][j]=2;
                }
            }
        }

        for(int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (board[i][j] == -1) {
                    board[i][j] = 0;
                } else if (board[i][j] == 2) {
                    board[i][j] = 1;
                }
            }
        }

    }


    public int countlive(int[][]board, int r, int c){
        int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};
        int count = 0;
        for(int[] dir : dirs){

            int nr = dir[0] + r;
            int nc = dir[1] + c;

            if(nr >= 0 && nc >= 0 && nr < board.length && nc < board[0].length && (board[nr][nc]==-1|| board[nr][nc]==1) ){
                count++;
            }
        }
        return count;
    }
}
