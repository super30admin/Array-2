//Time Complexity = O(m*n)
//Space complexity = O(1)
class Solution {
    public void gameOfLife(int[][] board) {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                int count = countLives(board,i,j);
                if(count < 2 && board[i][j] == 1 ){
                    board[i][j] = 5;
                }
                if((count == 2 || count == 3) && board[i][j] == 1 ){
                    board[i][j] = 1;
                }
                if(count > 3 && board[i][j] == 1){
                    board[i][j] = 5;
                }
                if(count == 3 && board[i][j] == 0){
                    board[i][j] = 4;
                }
            }           
        }
         for(int i=0; i<board.length; i++){
                for(int j=0; j<board[0].length; j++){
                    if(board[i][j] == 4){
                        board[i][j] = 1;
                    }
                    else if(board[i][j] == 5){
                        board[i][j] = 0;
                    }
                }
            }
    }

    private int countLives(int[][] board, int i, int j){
        int count = 0;
        int[][] directions = {{1,-1},{1,0},{1,1},{0,-1},{0,1},{-1,-1},{-1,0},{-1,1}};
        for(int [] dir : directions){
            if((i+dir[0]<0 || i+dir[0] >= board.length) || (j+dir[1]<0 || j+dir[1] >= board[0].length)){
                continue;
            }
            if(board[i+dir[0]][j+dir[1]] == 1 || board[i+dir[0]][j+dir[1]] == 5){
                count++;
            }
        }
        return count;

    }
}