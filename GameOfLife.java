/*
intuition: As you go - to preserve original state change the numbers to other than 0 or 1
Time complexity : O (m X n)
Space complexity : O(1)
*/
public class GameOfLife {
        public static void gameOfLife(int[][] board) {

            int m = board.length;
            int n = board[0].length;
            for(int i = 0 ; i < m; i++){
                for(int j = 0; j < n; j++){
                    int countAlives = countAlives(board,i,j);
                    if(board[i][j] == 1 && (countAlives < 2 || countAlives > 3)){
                        board[i][j] = 5; //make it dead
                    }

                    if(board[i][j] == 0 && countAlives == 3){
                        board[i][j] = 4; //make it alive
                    }
                }
            }

            for(int i = 0 ; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(board[i][j] == 5){
                        board[i][j] = 0;
                    } else if (board[i][j] == 4){
                        board[i][j] = 1;
                    }
                }
            }

        }

        private static int countAlives(int[][] board, int r, int c){
            int dirs[][] = new int[][]{{0,1},{0,-1},{-1,0},{1,0},{1,1},{-1,1},{1,-1},{-1,-1}};
            int result = 0;

            for(int[] dir : dirs){
                int nr = r + dir[0];
                int nc = c + dir[1];

                //check them if they are valid
                //bound check

                if(nr >=0 && nc>=0 && nr < board.length && nc < board[0].length && (board[nr][nc] == 1 || board[nr][nc] == 5)){ //5 was originally 1
                    result++;
                }
            }

            return result;
        }

    public static void main(String[] args) {
        int [][] board = new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}};


        int m = board.length;
        int n = board[0].length;

        System.out.println("Original");

        for(int i = 0 ; i < m; i++){
            for(int j = 0; j < n; j++) {
                System.out.print(" " + board[i][j]);
            }
            System.out.println();
        }
        gameOfLife(board);

        System.out.println("\n\n\n After game of life");

        for(int i = 0 ; i < m; i++){
            for(int j = 0; j < n; j++) {
                System.out.print(" " + board[i][j]);
            }
            System.out.println();
        }

    }

}
