class Solution {

    int[][] dir = new int[][]{ {-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1} }; // to iterate through 8 directions to check live count
    int m = 0; // no. of rows
    int n = 0; // no. of cols;

    public void gameOfLife(int[][] board) {
        // 1 with neighbor < 2 live dies
        // 1 with 2 0r 3 lives
        // 1 with neighbor > 3 lives dead
        // 0 with neighbor = 3 live lives

        m = board.length; // no. of rows
        n = board[0].length; // no. of cols;

        //iterate through board (mxn)
        for( int i = 0; i<m; i++ ){
            for( int j = 0 ; j<n; j++ ){
                int count = getCount( board , i , j ); // get the count of live cells
                if( board[i][j] == 1 && (count < 2 || count > 3) ){
                    board[i][j] = 2; // dead now , Live earlier
                }
                else if( board[i][j] == 0 && count == 3 ){
                    board[i][j] = 3; // live now , dead earlier
                }
            }
        }
        for( int i = 0; i<m; i++ ){ // reset the 2 & 3 in terms of 0s & 1s
            for( int j = 0 ; j<n; j++ ){

                if( board[i][j] == 2){
                    board[i][j] = 0;
                }
                else if( board[i][j] == 3 ){
                    board[i][j] = 1;
                }
            }
        }

    }

    private int getCount( int[][] board, int i , int j){
        int count = 0;
        for( int[] arr : dir ){
            int r = arr[0] + i;
            int c = arr[1] + j;
            if( r>=0 && c>=0 && r<m && c<n && (board[r][c] == 1 || board[r][c] == 2) ){
                count++;
            }
        }

        return count;
    }
}