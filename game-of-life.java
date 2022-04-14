class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0){
            return;
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                int count = countLives(board, i, j);
                if(board[i][j] == 1){
                    if(count < 2 || count > 3){
                        board[i][j] = 3;
                    }
                }else if(count == 3){
                    board[i][j] = 2;
                }
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j] == 3){
                    board[i][j] = 0;
                }
                if(board[i][j] == 2){
                    board[i][j] = 1;
                }
            }
        }
    }
    public int countLives(int[][] board, int i, int j){
        int count = 0;
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0},{-1,-1},{1,1},{-1,1},{1,-1}};
        for(int[] dir : dirs){
            int r = dir[0] + i;
            int c = dir[1] + j;
            if(r>=0 && r<board.length && c>=0 && c<board[r].length && (board[r][c] == 1
                                                                      || board[r][c] == 3)){
                count++;
            }
        }
        return count;
    }
}

// Time Complexity : O(mn)
// Space Complexity : O(1)