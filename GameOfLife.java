// Time Complexity :O(m*n), m->no. of rows, n->no. of columns
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


class GameOfLife {
    public void gameOfLife(int[][] board) {
        int row = board.length, col=board[0].length;
        //iterating through the board
        for(int r=0; r<row; r++){
            for(int c=0; c<col; c++){
                //get counts of live neihgbors of current element
                int liveNeighbors = countLiveNeigbors(r,c,board, row, col);

                //current element is 1 and live neighbors less than 2 or more than 3
                if(board[r][c]==1 && (liveNeighbors<2||liveNeighbors>3)){
                    //mark current element as 2 i.e. dead->0 but previously alive
                    board[r][c] = 2;
                }
                //current element is 0 and live neighbors equal to 3
                else if(board[r][c]==0 && (liveNeighbors==3)){
                    //mark current element as 3 i.e. alive->1
                    board[r][c] = 3;
                }

            }
        }

        //iterating through the board
        for(int r=0; r<row; r++){
            for(int c=0; c<col; c++){

                //current element is 2 i.e. dead (but previously alive) change it to 0
                if(board[r][c]==2 ){
                    board[r][c] = 0;
                }
                //current element is 3 i.e. alive(but previously dead)  mark as 1
                else if(board[r][c]==3){
                    board[r][c] = 1;
                }

            }
        }

    }

    //method to count number of alive neighbors
    public int countLiveNeigbors(int r, int c, int[][] board, int row, int col){
        // all possible nighbors
        //           Right  Left   Down    Up   TopLeft TopRight BottomLeft BottomRight
        int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}, {-1,-1}, {-1,1}, {1,-1}, {1,1}};

        //lives count
        int live=0;

        // checking all neighbors
        for(int i=0; i<dir.length; i++){

            int newR = r + dir[i][0];
            int newC = c + dir[i][1];
            //checking boundary
            if(newR>=0 && newR<row && newC>=0 && newC<col && (board[newR][newC]==1||board[newR][newC]==2)){
                //updating live count
                live++;
            }
        }
        return live;
    }
}
