import java.util.Arrays;

public class GameofLife {
    public void gameofLife(int[][] board) {
        int m=board.length;
        int n=board[0].length;
        int[][] dirs=new int [][]{{0,1},{0,-1},{-1,0},{1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                int count=countAlive(board,i,j,dirs);
                if(board[i][j]==1) {
                    if(count<2 || count>3) {
                        board[i][j]=2;
                    }

                }
                else{
                    if(count==3) {
                        board[i][j]=3;
                    }
                }
            }
        }
        for(int i=0;i<m; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j]==2) {
                    board[i][j]=0;
                }
                else if(board[i][j]==3) {
                    board[i][j]=1;
                }
            }
        }

    }
    public int countAlive(int[][] board, int i, int j, int[][] dirs) {
        int count=0;
        for(int[] dir:dirs){
            int nr=i+dir[0];
            int nc=j+dir[1];
            if(nr>=0 && nr<board.length && nc>=0 && nc<board[0].length && (board[nr][nc]==1 || board[nr][nc]==2)) {
                count++;
            }
        }
        return count;
        }
        public static void main(String[] args) {
        GameofLife gameofLife=new GameofLife();
        int[][] board= new int[][]{
                    {0, 1, 0},
                    {0, 0, 1},
                    {1, 1, 1},
                    {0, 0, 0}
            };
        gameofLife.gameofLife(board);
            for (int[] row : board) {
                System.out.println(Arrays.toString(row));
            }
        }
}
