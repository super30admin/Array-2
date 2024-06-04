/**
 Approach: Matrix traversal in all possible 8 directions

 Working:
     traverse through each element of the matrix
     get the live cell count for the current cell by checking the neighbours in all possible directions
     case 1: 0 -> 3 (dead -> live) if livecellcount = 3
     case 2:1 -> 2 (live to dead) if livecellcount <2 or >3

     traverse the matrix and change all 2, 3 values to original 0,1 value
 Time Complexity:O(m*n)
 Space Complexity: O(1)

 */

class GameOfLife {

    int m,n;
    public void gameOfLife(int[][] board) {

        if(board == null || board.length == 0) {
            return;
        }

        m=board.length;
        n=board[0].length;

        for(int i=0;i<m; i++) {
            for(int j=0;j<n; j++){

                int liveCellCount = getLiveCount(board, i,j);

                if(board[i][j] == 0 && liveCellCount == 3) {
                    board[i][j] = 3;
                }
                else if(board[i][j] == 1 && (liveCellCount<2 || liveCellCount>3)) {
                    board[i][j] = 2;
                }
            }

        }

        for(int i=0;i<m; i++) {
            for(int j=0;j<n; j++) {

                if(board[i][j] == 2) {
                    board[i][j] = 0;
                }

                if(board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }

    }

    private int getLiveCount(int[][] board, int row, int col) {

        int[][] direction = {
                {-1,-1}, //upper left
                {-1,0}, //upper
                {-1,1}, //upper right
                {0,-1}, // left
                {0,1}, //right
                {1,-1}, //lower left
                {1,0}, //lower
                {1,1}//lower right
        };


        int liveCellCount = 0;
        for(int k=0;k<direction.length; k++) {

            int[] dir = direction[k];

            int x = row+dir[0];
            int y = col+dir[1];

            if((x>=0 && x<m) && (y>=0 && y<n)) {

                if(board[x][y] == 1 || board[x][y] == 2) {
                    liveCellCount++;
                }
            }

        }
        return liveCellCount;
    }

}