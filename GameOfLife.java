// Time Complexity : O(m*n)
// Space Complexity :0(m*n) for dirs matrix
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : nothing

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int m= board.length;
        int n= board[0].length;

        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int count = getLiveCount(dirs, board, i, j, m, n);
                if(board[i][j]==0) {
                    if (count == 3) {
                        board[i][j] = 3; //dead->alive
                    }
                }else if(board[i][j]==1){
                    if(count<2 || count>3){
                        board[i][j]=2; //alive->dead
                    }
                }
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]==3){
                    board[i][j]=1;
                }else if(board[i][j]==2){
                    board[i][j]=0;
                }
            }
        }


    }

    private int getLiveCount(int[][] dirs, int[][] board, int i, int j, int m, int n){
        int count=0;
        for(int[] dir: dirs){
            int nr = i+ dir[0];
            int nc = j+ dir[1];

            if(nr >=0 && nr<m && nc>=0 && nc<n){
                if(board[nr][nc]==1 || board[nr][nc]==2){
                    count++;
                }
            }

        }
        return count;
    }


    public static void main(String args[]) {
        GameOfLife game= new GameOfLife();
        int[][] board= {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        game.gameOfLife(board);
    }
}
