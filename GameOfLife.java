// Time Complexity : O(rows*cols)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Got stuck in checking for the directions. Class notes helped to solve accordingly


// Your code here along with comments explaining your approach
public class GameOfLife {
    int rows;
    int cols;
    public void gameOfLife(int[][] board) {
        rows = board.length;
        cols = board[0].length;

        for(int i=0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                int nlives = countLives(board, i, j);

                // If live => neighbour lives are < 2 or >1
                if(board[i][j] == 1 && (nlives <2 || nlives > 3)){
                    board[i][j] = 2; // make it dead
                }

                //If dead => if 3 neighbours are dead
                if(board[i][j] == 0 && nlives == 3){
                    board[i][j] = 3; //make it live
                }
            }
        }// end of pass

        //to restore the original values
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(board[i][j] == 3){board[i][j] = 1;}
                if(board[i][j] == 2){board[i][j] =0;}
            }
        }//end of pass

    }

    private int countLives(int[][]board, int i, int j){
        int count = 0;
        int[][] direction ={{-1,0},{0,1},{1,0},{0,-1},{-1,-1},{1,-1},{-1,1},{1,1}};

        for(int[] dir: direction){
            int row = i + dir[0];
            int col = j + dir[1];

            //checking for boundary
            if(row >=0 && col>=0 && row<rows && col<cols){

                //checking for lives of neighbours
                if(board[row][col] == 1 || board[row][col] == 2){
                    count++;
                }
            }
        }//end of for
        return count;
    }
}
