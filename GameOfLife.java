// Time Complexity : O(mxn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I got confused for a while on where to add 2 and where to add 3.

class Solution {
    public void gameOfLife(int[][] board) {
        //state change 0 -> 1 => 2
        //state change 1 -> 0 => 3

        if(board == null || board.length == 0)
            return;

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == 0 || board[i][j] == 2){
                    int neighbors_alive = neighborCount(board, i, j);
                    if(neighbors_alive == 3)
                        board[i][j] = 2;
                }
                else{
                    int neighbors_alive = neighborCount(board, i, j);
                    if(neighbors_alive < 2 || neighbors_alive > 3)
                        board[i][j] = 3;
                    else if(neighbors_alive == 2 || neighbors_alive == 3)
                        board[i][j] = 1;
                }
            }
        }

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == 2)
                    board[i][j] = 1;
                else if(board[i][j] == 3)
                    board[i][j] = 0;
            }
        }
    }

    private int neighborCount(int[][] board, int i, int j){
        int count = 0;
        int x=0;
        int y=0;
//                      l        r       up       down    tl        tr       bl       br
        int[][] dir = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

        for(int k=0; k<8; k++){
            x = i + dir[k][0];
            y = j + dir[k][1];
            if(x >= 0 && y >=0 && x <= board.length - 1 && y <= board[0].length - 1){
                if(board[x][y] == 1 || board[x][y] == 3)
                    count++;
            }
        }
        return count;
    }
}
