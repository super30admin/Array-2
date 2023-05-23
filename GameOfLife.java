import java.util.Arrays;


public class GameOfLife {

        private int[][] dir;
        public void gameOfLife(int[][] board) {

            int m = board.length;
            int n = board[0].length;

            // right, left, up, down, up left, up right, down left, down right
            dir = new int[][] {{0,1}, {0, -1}, {-1,0}, {1,0}, {-1,-1}, {-1,1}, {1,-1}, {1,1}};

            //
            for(int i =0; i < m; i++){
                for(int j =0; j < n; j++){ // O(m*n)

                    // count live neighbors for every element in board
                    int liveCount = CountLive(board, i, j, m, n);

                    if(board[i][j] == 1) {

                        // rule 1 and 3
                        if(liveCount < 2 || liveCount > 3){
                            board[i][j] = 2;
                        }
                    }
                    else if(board[i][j] == 0){
                        //rule 4
                        if(liveCount == 3){
                            board[i][j] = 3;
                        }
                    }
                }
            }

            // making 3 = 1 and 2 = 0 in result matrix
            for(int i =0; i < m; i++){
                for(int j =0; j < n; j++){

                    if(board[i][j] == 3){
                        board[i][j] = 1;
                    }
                    if(board[i][j] == 2){
                        board[i][j] = 0;
                    }
                }
            }



        }

        private int CountLive(int[][] board, int i, int j, int m, int n){

            int count = 0;

            // 1D array d iterates over 2D array dir
            for(int[] d: dir){

                int row = i + d[0];
                int col = j + d[1];

                // 2 or 1 indicate existence of 1 in original matrix
                if(row >= 0 && col >= 0 && row < m && col < n
                        && (board[row][col] == 2 || board[row][col] == 1)){
                    count++;
                }
            }
            return count;
        }

        /*
         Time Complexity: O(m*n)
         Space Complexity: O(1) as no extra space used and return is void,
         the original matrix itself is transformed */

         public static void main(String[] args){

             GameOfLife object = new GameOfLife();

             int[][] board =  {{0,1,0}, {0,0,1}, {1,1,1}, {0,0,0}};
             int rows = 4;
             int columns = 3;


             object.gameOfLife(board);

             for (int i = 0; i<rows; i++) {
                 for (int j = 0; j<columns; j++) {
                     System.out.print(board[i][j]);
                 }
                 System.out.println();
             }

         }

}
