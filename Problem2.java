public class Problem2 {

    // Time o(n^2), space: o(1)
    int[][] dirs = new int[][]{{0,1}, //right
            {0,-1}, //left
            {-1,0}, //top
            {1,0}, //bottom
            {-1,-1}, //left-top
            {-1,1}, //right-top
            {1,1}, //right-bottom
            {1,-1} //left-bottom
    };

    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;



        for(int i=0; i<m; i++){

            for(int j=0; j<n; j++){
                int neighbours = countNeighbours(board, i, j, m, n);

                if(board[i][j] == 1 && (neighbours < 2 || neighbours >3)){
                    board[i][j] = 2; // 2 is 0 state
                }
                if(board[i][j] == 0 && (neighbours == 3)){ // re-production
                    board[i][j] = 3;   // 3 is 1 state
                }
            }
        }

        for(int i=0; i<m; i++){

            for(int j=0; j<n; j++){
                if(board[i][j] == 3)
                    board[i][j] = 1;
                if(board[i][j] == 2)
                    board[i][j] = 0;
            }
        }
    }

    private int countNeighbours(int[][] board, int i, int j, int m, int n){

        int count = 0;
        for(int[] dir: dirs){
            int r = i+dir[0];
            int c = j+dir[1];
            if(r>=0 && r< m && c>=0 && c<n && (board[r][c] == 1 || board[r][c] == 2 )){
                count++;
            }
        }

        return count;
    }
}
