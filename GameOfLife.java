//Time Complexity: O(m*n)
//Space Complexity: O(m*n)
public class GameOfLife {
    public void gameOfLife(int[][] board) {

        int m = board.length;
        int n = board[0].length;
        int[][] dir = new int[][]{{0,1},{0,-1},{-1,0},{1,0},{1,-1},{1,1},{-1,-1},{-1,1}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int countLive = countLive(board, i, j, dir);
                if(board[i][j]==1){
                    if(countLive<2 || countLive>3 ){
                        board[i][j]=2;
                    }
                }
                else{
                    if(countLive==3){
                        board[i][j]=3;
                    }
                }

            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==2){
                    board[i][j]=0;
                }
                else if(board[i][j]==3){
                    board[i][j]=1;
                }
            }
        }
    }

    private int countLive(int[][]board,int i,int j,int[][] dirs){
        int count = 0;
        for(int[] dir: dirs){
            int row = i + dir[0];
            int col = j + dir[1];
            if(row >= 0 && row<board.length && col >= 0 && col <board[0].length && (board[row][col]==2 || board[row][col]==1)){
                count++;
            }
        }
        return count;
    }
}
