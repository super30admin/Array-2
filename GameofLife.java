/* Time complexity: O(m*n)
Space complexity: O(1)

1. According to the given rules, the game can be played within the given array without using a new matrix created.
2. Updating 1 t0 2 if it dies(becomes zero) and updating 0 to 3 if it becomes one. So for each element, check if its neighbouring
elements are 0 or 3 to be counted as dead neighbours and 1 0r 2 to be counted as neighbours who are alive.
3. An element dies if it has less than 2 alive neighbours, remain to live if it has 2 to 3 alive neighbors and comes to life if it has more than three alive neighbours.
Continue in the same fashion till you iterate through all the elements.

*/

class Solution{
    int[][] dir = {{1,-1}, {1,0}, {1,1}, {0,-1}, {-1,-1}, {-1,0}, {-1,1}, {0,1}};
    public void GameofLife(int[][] board){
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                int live = 0;
                for(int[] d:dir){
                    if((i+d[0])<0 || (i+d[0])>=board.length || (j+d[1])<0 || (j+d[1]>=board[0].length)){
                        Continue;
                    }

                    if(board[i+d[0]][j+d[1]] == 1 || board[i+d[0]][j+d[1]] == 3){
                        live++;
                    }
                }

                if(board[i][j] == 1 && (live < 2 || live > 3)){
                    board[i][j] = 3;
                }

                if(board[i][j] == 0 && live == 3){
                    board[i][j] = 2;
                }
            }
        }
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == 3){
                    board[i][j] = 0;
                }

                if(board[i][j] == 2){
                    board[i][j] = 1;
                }
            }
        }
    }
}