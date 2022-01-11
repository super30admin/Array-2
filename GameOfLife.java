/*
Time Complexity : O(n*m) where n and m are the dimensions of the board
                  in real it will be 8*m*n
                  as for each element visisted we visit another 8
Space Complexity : O(1) as we updated in place and dir created will always be
                  constant space irrespective of the dimesnions

Did this code successfully run on Leetcode : yes

Any problem you faced while coding this : no


Your code here along with comments explaining your approach:

followed the approach where if the conditions are met to change, 2 is added
to the existing value and while couting the lives, count all the elements
with odd values as 3 will be updated by adding 2 to 1 and 2 will be obtained
by adding 2 to 0 and in second pass we change the state of the board
*/

class Solution {
    public void gameOfLife(int[][] board)
    {

        int m = board.length;
        int n = board[0].length;

        for(int row = 0; row < m; row++){
            for(int col = 0; col < n; col++){
                // checked for live neighbors in all directions
                // by checking for original state of the board
                int neighbors = liveNeighbors(board,row,col,m,n);

                // checking will be different for current live and dead

                if(board[row][col] == 1){
                    if(neighbors < 2 || neighbors > 3){
                        board[row][col] += 2;
                    }
                }
                else{
                    if(neighbors == 3){
                        board[row][col] += 2;
                    }
                }
            }
        }

        // second pass will be to change it to the state acc to what we explored
        for(int row = 0; row < m; row++){
            for(int col = 0; col < n; col++){
                if(board[row][col] == 2)
                {
                    board[row][col] = 1;
                }
                else if(board[row][col] == 3)
                {
                    board[row][col] = 0;
                }
            }
        }
    }


    private boolean isValid(int r, int c, int m, int n){

       if(r < m && c < n && r >= 0 && c >=0)
           return true;

        return false;
    }

    private int liveNeighbors(int[][] board, int r, int c,int m, int n){

        // this arrays come handy as we can loop through this parallely
        // to explore all eight positions
        int[] rowDir = {-1,-1,-1,0,1,1,1,0};
        int[] colDir = {-1,0,1,1,1,0,-1,-1};
        int count = 0;

        /*
        we check in all 8 directions the ones that were originally alive
        therefore we also check for the ones who are now dead
        but were alive originally
        therefore we check for odd values as 3 was stored
        for the ones who were alive before and dead now
        */
        for(int i = 0; i < 8; i++){
            if(isValid(r+rowDir[i],c+colDir[i],m,n)
               && board[r+rowDir[i]][c+colDir[i]] %2 != 0)
               count += 1;
        }

        return count;
    }
}
