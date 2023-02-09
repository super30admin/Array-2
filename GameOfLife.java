// Since method return type is void, we should make changes
// and store final result in input matrix itself.
// TC = O(m*n) m = no of rows and n = no of columns
// SC = O(1)
public class GameOfLife {
    int m;
    int n;
    int[][] dirs;
    private int countAlive(int row,int col,int[][] board){
        int alive_neighbors = 0;

        for(int[] each:dirs){
            int nr = each[0]+row;
            int nc = each[1]+col;
            if(nr>=0 && nr<m && nc>=0 && nc<n && (board[nr][nc] == 1|| board[nr][nc] == 3)){
                alive_neighbors++;
            }
        }
        return alive_neighbors;
    }
    public void gameOfLife(int[][] board) {
        m = board.length;
        n = board[0].length;
        dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,1},{1,-1}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int alive = countAlive(i,j,board);
                if((board[i][j] == 1) && (alive<2 || alive>3)){
                    board[i][j] = 3;
                }
                else if(board[i][j] == 0 && alive==3){
                    board[i][j] = 2;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == 3){
                    board[i][j] = 0;
                }
                else if(board[i][j] == 2){
                    board[i][j] = 1;
                }
            }
        }

    }
}
