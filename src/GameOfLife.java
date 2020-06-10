// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

/**
 * https://leetcode.com/problems/game-of-life/
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state. The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.

Example:

Input: 
[
  [0,1,0],
  [0,0,1],
  [1,1,1],
  [0,0,0]
]
Output: 
[
  [0,0,0],
  [1,0,1],
  [0,1,1],
  [0,1,0]
]
Follow up:

Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?
 
 
Strategy: if current live cell is becoming dead, instead of making it 0 which will loose the state, make it say 2, this way if cell is 2 we can 
say it was alive and use it for live neighbor calculation, same way for 3. once we complete calculation, change 2 by 0 and 3 by 1
 */
class GameOfLife {
    public void gameOfLife(int[][] board) {
       if(board == null || board.length == 0) return;
       int m = board.length, n = board[0].length; 
       
       // 1 -- 0 = 2 -- if cell becomes dead from live change to 2 so we know it was live
       // 0 -- 1 = 3 -- similar to above
       for(int i = 0; i < m; i++){
           for(int j = 0; j < n; j++) {
               int liveNeighboar = countLives(board, i, j);
               if(board[i][j] == 1){ //live
                    if(liveNeighboar < 2 || liveNeighboar > 3){
                       board[i][j] = 2; //rule1 and rule 3
                    }
               }else { //dead
                     if(liveNeighboar == 3){
                          board[i][j] = 3;
                     }
               }
            }     
       }
        //change 2 to 0 and 3 to 1
        for(int i = 0; i < m; i++){
           for(int j = 0; j < n; j++) {
               if(board[i][j] == 2){
                   board[i][j] = 0;
               }else if(board[i][j] == 3){
                   board[i][j] = 1;
               }
           }
        }
    }
    
    //get count of live neighbors of i,j
    private int countLives(int[][] board, int i, int j){
        int m = board.length, n = board[0].length;
       
        //offsets for all possible 8 neighbors -- dir array concept for cleaner code
        int[][] dir = {{0,-1},{0,+1},{-1,-1},{-1,0},{-1,1},{+1,-1},{+1,0},{+1,+1}};
        int cnt = 0;
        for(int p=0; p <dir.length;p++){
            int r = i + dir[p][0];
            int c = j + dir[p][1];
            
            //bounds check
            if(r >= 0 && r < m && c >= 0 && c < n ){
               // 1- currently alive, 2 -- it was alive before
               if(board[r][c] == 1 || board[r][c] == 2){
                   cnt++;
               } 
            }
        }
        
        return cnt;
    }
}