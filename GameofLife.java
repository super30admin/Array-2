public class GameofLife {

    //we would keep the count of neighours then update the new matrix accordinly
// if we want to modify the same matrix then for any position if some cell is dying make it 2 instead of 0 
// if some cell get alive make it 3 instead of 1.this way we will keep track of the dead alive without 
//disturbing the results.

//TC - O(2mn) SC-O(1)
//for 8 dir TC- 8mn

//to move in corresponding direction- we will keep a dir array
// ex for [1,1] - dir- {left{0,-1}, right{0,+1}, up{-1,0}, down{+1,0}, 
//.                     upleft {-1,-1}, upright{-1, +1}, downleft{+1, -1}, downright{+1,+1}}


    int m;
    int n;
    public int[][] gameOfLife(int[][] board) {

        this.m = board.length;
        this.n = board[0].length;

        int[][] dirs = {{0,-1}, {0,+1}, {-1,0}, {+1,0},{-1,-1}, {-1, +1}, {+1, -1}, {+1,+1}};

        for(int i = 0; i < m; i++){
            for(int j = 0; j< n; j++){

                int countNbr = countAlive(board, dirs, i, j);

                if(board[i][j] == 1){

                if(countNbr < 2||countNbr > 3){
                    board[i][j] = 2; //alive - >dead
                } 
            }else if(board[i][j] == 0){
                  
                if(countNbr == 3){
                    board[i][j] = 3; //dead ->alive
                } 
                }
            }
        }
// change back board values to 1,0 from 2, 3
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 2){
                    board[i][j] = 0;
                }
              
                 else if(board[i][j] == 3){
                    board[i][j] = 1;
                }
            }
        }

        return board;

        
    }
// count alive method it will give all the alive cells in nbr
    private int countAlive(int[][] board, int[][] dirs, int i, int j){
        int count = 0;
        for(int[] dir : dirs){
            int r = dir[0] + i;
            int c = dir[1] + j;
              //have to check edge cases here if r, c are in the matrix after calculation
          if(r>=0 && c>=0 && r < m && c < n){
            if(board[r][c] == 1 || board[r][c]== 2){// will check with 1 as alive and
                                                     // 2 because it was previosly alive
                count++;
            }
          }
        }

        return count;



    }

    public static void main (String[] args)

    {
    
        GameofLife p = new GameofLife();
    
        int[][] board = new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
    
    
    
       int[][] answer = p.gameOfLife(board);

       for(int i = 0; i < board.length; i++){
        for(int j = 0; j < board[0].length; j++){
       System.out.println(answer[i][j]+ "    ");
        }}
    
    }


}

// In this question, we represent the board using a 2D array.
//  In principle, the board is infinite, which would cause problems when 
//  the active area encroaches upon the border of the array (i.e., live cells reach the border). 
//  How would you address these problems?
//we can keep a hashset where we will track all the existing live cells and there corrsponding nbr live cell
// and then apply consitions dead and alive 

    

