class Solution {
    int [][]dirs;
    int m ;
    int n;
    public void gameOfLife(int[][] board) {
        m = board.length;
        n = board[0].length;
        dirs = new int [][] {{0,-1},{0,1},{1,0},{-1,0},{-1,-1},{1,-1},{-1,1},{1,1}};

        for(int i=0; i<m; i++){
            for(int j =0; j<n;j++){
                int alive = search(board, i,j);
                if(board[i][j] == 1 && (alive<2 || alive>3)){
                    board[i][j] = 2;
                }else if (board[i][j] == 0 && alive==3){
                    board[i][j] = 3;
                }
            }
        }

        for(int i=0; i<m; i++){
            for(int j =0; j<n;j++){
                if(board[i][j] == 3){
                    board[i][j] = 1;
                }else if(board[i][j] == 2){
                    board[i][j] = 0;
                }
            }
        }
    }
    private int search(int[][] board, int i, int j ){
        int count =0;
        for(int [] dir: dirs){
            int nr = i + dir[0];
            int nc = j + dir[1];
            if(nr>=0 && nr<m && nc>=0 && nc<n && (board[nr][nc] ==1 || board[nr][nc]== 2)){
                count++;
            }
        }
        return count;
    }
}