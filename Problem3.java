// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this : no

public class Problem3 {

    //Brute force
    //Traversing through the matrix and returning the live cells in a new matrix


    //second approach
    //Making temporary change in the same matrix
    //if a dead cell becomes live , set it to 2 0->1->2
    //if a live cell becomes dead, set it to 3 1->0->3
    //we will be using an extra variable instead of extra space

    //taking global
    int m;
    int n;
    int[][] dirs;


    public void gameOfLife(int[][] board) {

        m = board.length;
        n = board[0].length;

        if(board==null || m ==0) return;

        dirs = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0},{-1,-1}, {-1,1}, {1,1}, {1,-1}};

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){

                //count the live neighbors
                int countAlive = countAlive(board,i,j);
                if(board[i][j] == 1 && (countAlive < 2 || countAlive > 3)){
                    board[i][j] = 3;
                }
                if(board[i][j] == 0 && countAlive == 3){

                    board[i][j] =2;
                }
            }

        }

        //again going back to original matrix
        for(int i=0; i<m; i++){

            for(int j=0; j<n; j++){
                if(board[i][j] ==3)   board[i][j] =0;

                if(board[i][j] ==2) board[i][j] =1;

            }
        }

    }


    //function to count the number of alive neighbors
    private int countAlive(int[][]board, int i, int j){

        //direction matrix to count the 8 neighbors
        int result =0;
        for(int[] dir: dirs){

            //getting new row
            //going to each direction and calucalting neighbors
            int r = i + dir[0];
            int c = j+ dir[1];
            if(r>=0 && c>=0 && r<m && c<n &&  ( board[r][c]==1 || board[r][c] ==3))
            {
                result++;
            }
        }
        return result;

    }

}
