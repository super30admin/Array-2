// space complexity - o(1)
    //time - o(n*m)
    //Ran on leeetcode successfully : Yes
    // Problem faced  : No
    //Approach : get live neighbors count if cell is going from dead to live mark -2 , if cell going from live to dead mark -1
class Solution {
    public void gameOfLife(int[][] board) {

        // 0 to 1 -> -2
        // 1 to 0 -> -1


        for(int i=0; i<board.length; i++){
            for(int j =0; j<board[0].length; j++){

                int liveNeighbors = getLiveNeighbors(board, i, j);
                if(liveNeighbors < 2 && board[i][j] == 1){
                    board[i][j] = -1;
                }
                else if(liveNeighbors > 3 && board[i][j] == 1){
                    board[i][j] = -1;
                }
                else if(liveNeighbors == 3 && board[i][j] == 0){
                    board[i][j] = -2;
                }
            }
        }

        for(int i=0; i<board.length; i++){
            for(int j =0; j<board[0].length; j++){
                if(board[i][j] == -2){
                    board[i][j] = 1;
                }
                else if(board[i][j] == -1){
                    board[i][j] = 0;
                }
            }
        }

    }

    public int getLiveNeighbors(int[][]board, int x, int y){

        int count = 0 ;

        int[] xArr = {-1,-1,-1,0,0,1,1,1};
        int[] yArr = {-1,0,1,-1,1,-1,0,1};

        for(int i=0; i<xArr.length; i++){
            int newX = x + xArr[i];
            int newY = y + yArr[i];

            if(newX>=0 && newX<board.length && newY>=0 && newY< board[0].length &&
              Math.abs(board[newX][newY]) == 1 ){
                count++;
            }
        }

        return count;
    }
}
