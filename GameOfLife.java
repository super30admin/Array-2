//TC: O(m*n), m and are the dimenstions of the board
//SC: O(1)
//Approach:
//1. Followed the simple rules to iterate as per the question.
//2. Just to make sure that we don't loose the initial state of the input while processing the board cells, we take new constants indicating
// value transitions. When 0 -> 1, we put it as 2 and 1->0 is put as 3. This way, we make sure that from 2, we imput 0 for the current state and 1 for next state,
// which is going to be out output.

class Solution {
    public void gameOfLife(int[][] board) {
        int[][] dir = {{1,-1},{1,0},{1,1},{0,-1},{0,1},{-1,-1},{-1,0},{-1,1}};
        int m = board.length;
        int n = board[0].length;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int live = 0;
                for(int[] d : dir){
                    if(i+d[0] < 0 || i+d[0]>m-1 || j+d[1]<0 || j+d[1]>n-1){
                        continue;
                    }
                    if(board[i+d[0]][j+d[1]] == 1 || board[i+d[0]][j+d[1]] == 3){
                        live++;
                    }
                }
                
                if(board[i][j] == 1 && (live < 2 || live > 3)){
                    board[i][j] = 3;
                }
                else if(board[i][j]==0 && live == 3){
                    board[i][j] = 2;
                }
            }
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 2){
                    board[i][j] = 1;
                }
                else if(board[i][j] == 3){
                    board[i][j] = 0;
                }
            }
        }
    }
}
