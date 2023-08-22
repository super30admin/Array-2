// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class gameOfLife {
        int m,n;
    public void gameOfLife(int[][] board) {
        if(board==null || board.length==0){return;}
        m=board.length;
        n=board[0].length;
        //1 -> 0 --> 2
        //0 -> 1 --> 3

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int countliveneighbours=countlive(board,i,j);
                //if we have a live cell
                if(board[i][j]==1){
                    if(countliveneighbours<2 || countliveneighbours>3 ){
                        board[i][j]=2;
                    }
                }
                // if we have dead cell
                else if(board[i][j]== 0 ){
                    if(countliveneighbours == 3){
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

    private int countlive(int[][] board,int row, int col){
        int[][]dirs={{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}}; // U L D R UL UR LL LR
        int count=0;

        for(int i=0;i<8;i++){
            //new row
            int nr  = row + dirs[i][0];
            int nc = col + dirs[i][1];
            // checking you are within bounds of the matrix, eg 1st row left or up is invalid
            // 1 means it was already alive, 2 means it was alive originally even though later declared dead
            // so both 1,2 count as alive so count++
            if(nr>=0 && nr<m && nc>=0 && nc<n && (board[nr][nc]==1 || board[nr][nc]==2)){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
    gameOfLife rs = new gameOfLife();
    int[][] matrix1 = {
            {0, 1, 0},
            {0, 0, 1},
            {1, 1, 1},
            {0, 0, 0}
        };
    int[][] matrix2 = {
            {1, 1},
            {1, 0}
        };

    rs.gameOfLife(matrix1);
    rs.gameOfLife(matrix2);

     for (int[] row : matrix1) {
            System.out.print(Arrays.toString(row));// ans = [0,0,0][1,0,1][0,1,1][0,1,0]
        }

        System.out.println("");

        for (int[] row : matrix2) {
            System.out.print(Arrays.toString(row));// ans = [1,1][1,1]
        }
}

}