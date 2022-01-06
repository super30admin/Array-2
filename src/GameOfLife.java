public class GameOfLife {
    // Time Complexity : O(m*n)
    // Space Complexity : O(1)
    public void gameOfLife(int[][] board) {
        if(board == null)
            return;

        int[][] dir = {{-1,-1},{-1,0},{-1,1},{0,1},{0,-1},{1,-1},{1,0},{1,1}};
        int m = board.length;
        int n = board[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int lives = countOfAlivesAround(board,dir,i,j);

                if(board[i][j] == 1 && ( lives<2 || lives >3)){
                    board[i][j] = 2;
                }
                if(board[i][j] == 0 && lives ==3){
                    board[i][j] = 3;
                }

            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == 2 ){
                    board[i][j] = 0;
                }

                if(board[i][j] == 3){
                    board[i][j] = 1;
                }
            }
        }

    }

    private int countOfAlivesAround(int[][] board,int[][] dir,int i,int j){
        int count =0;
        for(int[] d : dir){
            int r = d[0]+i;
            int c = d[1]+j;
            if((r) >=0 && (i+r) <board.length && (c) >=0 && (c) < board[0].length && (board[r][c] ==1 || board[r][c] ==2))
                count++;
            }
        return count;
    }
}
