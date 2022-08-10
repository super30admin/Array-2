// Time Complexity : O(mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES

// In this problem, we are making two major decision, changing 1->0 (record with the number 2) and changing 0->1 (record with the number 3)
// we are using 2 and 3 because, once we modify the value we still wants to count the live neighbors of upcoming element.

class GameOfLife {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0)return;

        int m = board.length;
        int n = board[0].length;

        //direction array to find the neighbors
        int[][] direction = {{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};

        //iterate ove the board to chnage the cell to (1->0)->2 and (0->1)->3 by counting live neighbors.
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int numOfLiveCell = liveNeighbors(board, i, j, direction);

                if(board[i][j] == 1){
                    if(numOfLiveCell<2 || numOfLiveCell>3){
                        board[i][j] = 2;
                    }
                } else {
                    if(numOfLiveCell == 3){
                        board[i][j] = 3;
                    }
                }
            }
        }

        // chnaging 2->0 and 3->1
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 2){
                    board[i][j] = 0;
                } else if(board[i][j] == 3){
                    board[i][j] = 1;
                }
            }
        }

        return;
    }

    // count the neighbors
    private int liveNeighbors(int[][] board, int r, int c, int[][] dirs){
        int m = board.length;
        int n = board[0].length;
        int count = 0;

        for(int[] dir : dirs){
            int nr = r + dir[0];
            int nc = c + dir[1];
            if(nr>=0 && nr<m && nc>=0 && nc<n && (board[nr][nc] == 1 || board[nr][nc] == 2)){
                count ++;
            }
        }

        return count;
    }

}