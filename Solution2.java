//Time Complexity: O(M*N)
//Space Complexity: O(1)
//Game of Life

class Solution2 {
    public void gameOfLife(int[][] board) {
        int[][] dirs= new int[][]{{0,1},{0,-1},{-1,0},{1,0},{-1,1},{-1,-1},{1,1},{1,-1}};
        int m = board.length;
        int n = board[0].length;
        for(int i=0; i< m; i++){
            for(int j=0; j< n; j++){
                int count = countAlives(board,i,j);
                if(board[i][j] == 1 && (count < 2  || count >3 )){
                    board[i][j] = 5;
                }
                if(board[i][j] == 0 && count ==3){
                    board[i][j] = 4;
                }                
            }
        }

        for(int i=0; i< m; i++){
            for(int j=0; j< n; j++){
                if(board[i][j] == 5){
                    board[i][j] = 0;
                }
                if(board[i][j] == 4){
                    board[i][j] = 1;
                }                
            }
        }
      }

    private int countAlives(int[][] board, int r, int c ){
        //right
        int[][] dirs= new int[][]{{0,1},{0,-1},{-1,0},{1,0},{-1,1},{-1,-1},{1,1},{1,-1}};
        int result = 0;
        for(int [] dir : dirs){
            int nr = r+ dir[0];
            int nc =c + dir[1];

            //bound check 
            if(nr >=0 && nc >= 0 && nr < board.length && nc < board[0].length && 
             (board[nr][nc] == 1 || board[nr][nc] == 5)){
                result++;
             }
        }
        return result;
    }
}
