package prog_289_gameOfLife;

public class Solution {
    /*
    In this problem, we have given an array where we have m*n matrix.
    There are given rule which mean cell 0 is dead and cell 1 is alive
    1) 1 ----> 0 where N < 2
    2) 1 ----> 1 where N = 2 || N= 3
    3) 1 ----> 0 where N > 3
    4) 0 ----> 1 where N = 2
    We have to check all 8 neighbors of current cell and count alive cell's count.

    Brut Force Approach:
    1) In order to do this, we will create same copy of m*n matrix and we will keep updating the cell value based on
    its neighbors.
    In the problem which is given that we should not use any extra space.

    In place Approach with Directions Array:
    1) In this method, we will update value to 2 whenever changing 1 --> 0 ===> 2
       0 --> 1 ===> 3

Time Complexity  : 8 * O(m*n) => O(M*N)
Space Complexity : O(1)



    */

    public void gameOfLife(int[][] board) {
        int m = board.length ;
        int n = board[0].length ;
        //                           right.  left.    up.      down.   upleft.  upright.  downleft downright
        int[][] dirs = new int[][] {{0,1}, {0, -1}, {-1, 0}, {1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

        for(int i= 0;i < m;i++){
            for(int j=0;j < n; j++){
                int count = 0 ;
                count = findNeighborCount(board, i, j, dirs, m, n);
                if(board[i][j] == 1){
                    if(count < 2 || count > 3){
                        board[i][j] = 2 ;
                    }
                }

                else{
                    if(count == 3){
                        board[i][j] = 3 ;
                    }
                }
            }
        }
        for(int i= 0;i<m;i++){
            for(int j=0;j<n; j++){
                if(board[i][j] == 2){
                    board[i][j] = 0 ;
                }
                if(board[i][j] == 3){
                    board[i][j] = 1 ;
                }

            }
        }


    }

    public int findNeighborCount(int[][] board, int i, int j, int[][] dirs, int m, int n){
        int count = 0 ;
        for(int[] dir : dirs){ // We will check for every direction, if that cell value is alive or not. We are
            //iterating 8 times for every direction.
            int r = i + dir[0];
            int c = j + dir[1];
            if(r >= 0 && c >= 0 && r < m && c < n && (board[r][c] == 1 || board[r][c] == 2)){
                count ++ ;
            }
        }
        return count ;
    }
}
