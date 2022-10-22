// Time Complexity : O(m*n) // As we are traversing through whole matrix.
// Space Compelxity: O(1); // No extra space is used.

public class GameOfLife {
    private static final int LIVE =1;
    private static final int  DEAD =0;
    private static final int LIVE_TO_DEAD =2;
    private static final int DEAD_TO_LIVE =3;

    private static final int[][] directions = new int[][]{
            {-1,0},//up
            {1,0},//down
            {0,-1},//left
            {0,1},//right
            {-1,-1},//up-left
            {-1,1},// up-right
            {1,-1},//down-left
            {1,1} //down-right
    };


    public static void gameOfLife(int[][] board) {

        int m = board.length, n = board[0].length;
        int count;

        for(int i=0; i < m; i++){

            for(int j=0; j < n; j++){
                count = getNeighbours(board,i,j);

                if(board[i][j] ==1){
                    if(count < 2 || count > 3) board[i][j] = LIVE_TO_DEAD;
                }
                else {
                    if(count ==3) board[i][j] = DEAD_TO_LIVE;
                }
            }
        }

        for(int i=0; i< m; i++){
            for(int j=0; j < n; j++){
                if(board[i][j] == LIVE_TO_DEAD) board[i][j] = DEAD;
                if(board[i][j] == DEAD_TO_LIVE) board[i][j] = LIVE;
            }
        }

    }

    private static  int getNeighbours(int[][] board, int i, int j){
        int m = board.length, n = board[0].length;

        int count =0;

        for(int[] direction : directions){
            int nI = direction[0]+ i;
            int nJ = direction[1]+ j;

            if(nI >=0 && nI < m && nJ >=0 && nJ < n){
                if(board[nI][nJ] == LIVE || board[nI][nJ] == LIVE_TO_DEAD ){
                    count++;
                }
            }
        }

        return count;

    }
    public static void main(String[] args) {
     gameOfLife(new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}});
    }
}
