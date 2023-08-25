import java.util.Arrays;
//TC=O(m*n)
//SC=O(1)
public class Problem448 {
    int[][] dirs;

    public void gameOfLife(int[][] board) {
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                int countAlive=countAlive(board,i,j,m,n);
                if(board[i][j]==1) {
                    if (countAlive < 2 || countAlive > 3)
                        board[i][j] = 2;
                }
                else {
                    if (countAlive == 3)
                        board[i][j] = 3;
                }
            }
        }
        for(int i=0;i<m;i++){
            for (int j=0;j<n;j++) {
                if(board[i][j]==2)
                    board[i][j]=0;
                else if(board[i][j]==3)
                    board[i][j]=1;
            }
        }
        System.out.println(Arrays.toString(board));
    }

    private int countAlive(int[][] board,int i, int j, int m, int n){
        dirs=new int[][]{{0,1},{0,-1},{-1,0},{1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
        int count=0;
        for(int[] dir: dirs){
            int nr=i+dir[0];
            int nc=j+dir[1];
            if(nr>=0 && nc>=0 && nr<m && nc<n && (board[nr][nc]==1 || board[nr][nc]==2))
                count++;
        }
        return count;
    }

        public static void main(String[] args) {
        Problem448 problem = new Problem448();
        problem.gameOfLife(new int[][]{{1,1},{1,0}});
    }
}
