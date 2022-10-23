//TC O(m*n)
//SC O(1)
//works in leetcode
//use new values for next gen states for dead and alive
public class GameOfLife {
    static int DEAD = 0;
    static int LIVE = 1;
    static int LIVE_TO_DEAD = 3;
    static int DEAD_TO_LIVE = 4;

    static int[][] directions =   {
            {-1,0}, //UP
            {1,0},//DOWN
            {0,-1},//LEFT
            {0,1},//RIGHT
            {-1,-1},//UP-LEFT
            {-1,1},//UP-RIGHT
            {1,-1},//DOWN-LEFT
            {1,1} //DOWN-RIGHT
    };

    public static  void gameOfLife(int[][] board) {

        int m = board.length;
        int n = board[0].length;

        for(int i =0;i<m;i++){

            for(int j=0;j<n;j++){
                int liveNeigh = getLiveNeighs(board, i,j);
                if(board[i][j] == LIVE){

                    if(liveNeigh < 2 || liveNeigh > 3){ // dies
                        board[i][j] =  LIVE_TO_DEAD;
                    }

                } else
                {  // for DEAD
                    if (liveNeigh ==3)
                        board[i][j] = DEAD_TO_LIVE;
                }
            }


        }
        for(int i =0;i<m;i++){

            for(int j=0;j<n;j++){
                if(board[i][j] == LIVE_TO_DEAD){
                    board[i][j] = DEAD;
                }
                if(board[i][j] == DEAD_TO_LIVE ){
                    board[i][j] = LIVE;
                }

            }
        }


    }

    static int getLiveNeighs(int[][] board, int i, int j){
        int liveNeigh = 0;
        int m = board.length;
        int n = board[0].length;

        for(int [] direction : directions){
            int neighI = i + direction[0];
            int neighJ = j + direction[1];
            if(neighI>= 0 && neighI < m && neighJ >=0 && neighJ <n ){
                if(board[neighI][neighJ] == LIVE || board[neighI][neighJ] == LIVE_TO_DEAD)
                    liveNeigh ++;
            }
        }

        return liveNeigh;
    }

    public static void main(String [] args){
        int [][] board = { { 0,1,0},{0,0,1},{1,1,1},{0,0,0}  };
        gameOfLife(board);

        for(int i =0;i<board.length;i++){

            for(int j=0;j<board[0].length;j++){
                System.out.println( board[i][j]);
            }
        }
    }
}
