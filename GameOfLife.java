package Day12;

//Time complexity: O(2(m*n)) -> O(m*n)
//As we are traversing the matrix twice
//Space Complexity: O(1)
//Here the board matrix is given matrix, though we are returning it as resultmatrix we are using input matrix
//for manipulation and it won't count as auxiliary space
public class GameOfLife {

    //global variables
    private int m;
    private int n;

    public void gameOfLife(int[][] board) {

        m = board.length;
        n = board[0].length;

        //Edge case
        //return just the control as return type is void
        if(board == null || board.length == 0) return;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                //private method to count number of neighbors alive
                int count = countLive(board, i ,j);

                //Element alive and under populated or over populated, node changes from 1->0 i.e it dies
                //Representing change of state from 1->0 as -1
                if(board[i][j] == 1 && (count< 2 || count > 3)){
                    board[i][j] = -1;
                }

                //Element dead and number of live neighbors is exactly 3, then element changes its state from 0->1
                //Representing change of state from 0->1 as 2
                if(board[i][j] == 0 && count == 3){
                    board[i][j] = 2;
                }

                //Not checking for condition 2 where live element continues to live if alive neighbors' count
                //will be 2 or 3
            }
        }

        //To check -1 and 2 states and replace it with 0 and 1 respectively
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == -1){
                    board[i][j] = 0;
                }
                else if(board[i][j] == 2){
                    board[i][j] = 1;
                }
            }
        }

    }


    private int countLive(int[][] board, int i, int j){
        //Standard definition
        int [][] direction = { {0,1}, {0,-1}, {1,0}, {-1,0}, {-1,-1}, {-1,1}, {1,-1} ,{1,1}};

        int count = 0;

        for(int[] dir : direction){
            int r = i + dir[0];
            int c = j + dir[1];

            //checking for the row or column indices go negative
            //in such cases we don't take any action
            if( r >= 0 && r < m && c >= 0 && c < n){
                if(board[r][c] == 1 || board[r][c] == -1){
                    count++;
                }
            }

        }
        return count;
    }

    public static void main(String args[]){
        GameOfLife obj = new GameOfLife();

        int[][] matrix = new int [][] {{0,1,0}, {0,0,1}, {1,1,1,},{0,0,0}};

        System.out.println("Input");
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        obj.gameOfLife(matrix);

        System.out.println("Output");
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }


    }
}
