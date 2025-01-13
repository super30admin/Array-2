// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// count the live cells in the neighnouring 8 cells and update the cell value based on the rules

public class GameOfLife {
        public void gameOfLife(int[][] board) {
            if(board == null || board.length ==0){
                return;
            }
            int n = board.length;
            int m = board[0].length;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    int liveCells = checkNeighbours(board, i, j);
                    if(board[i][j] == 1){
                        if(liveCells < 2 || liveCells > 3){
                            board[i][j] =2;
                        }
                    }else if(board[i][j] == 0){
                        if(liveCells == 3){
                            board[i][j] =3;
                        }
                    }
                }
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(board[i][j] == 2){
                        board[i][j] = 0;
                    }else if (board[i][j] == 3){
                        board[i][j] = 1;
                    }
                }
            }
        }

        public int checkNeighbours(int[][] board, int i, int j){
            int count =0;
            int[][] dirs = {{0,-1},{0,1},{1,0},{-1,0},{-1,-1},{-1,1},{1,-1},{1,1}};  // L R D U UL UR LL LR
            for(int[] dir : dirs){
                int nr = i + dir[0];
                int nc = j + dir[1];
                if(nr >=0 && nr <board.length && nc >=0 && nc <board[0].length && (board[nr][nc] == 1 || board[nr][nc] == 2)){
                    count++;
                }
            }
            return count;
        }
}
