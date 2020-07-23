// Time Complexity :O(n) n = total number of elements
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes


// Your code here along with comments explaining your approach
  //make changes in place ,
  //all conversion from 1 -> 0  are replaced by -1.
  //all conversion from 0->1 are replaced by 2(any number other than 1, -1 & 0)
  // on second run all -1's are converted to 0.
  //and all 2's are converted to 1.
class Solution {
    public void gameOfLife(int[][] board) {
        for(int i = 0 ; i < board.length; i++){
            for(int j = 0 ; j < board[i].length; j++){
                int cnt = 0;
                if(i-1 >= 0 && j-1 >=0 &&
                   i-1 < board.length && j-1 < board[i].length
                   && Math.abs(board[i-1][j-1]) == 1)
                    cnt++;
                if(i-1 >= 0 && j >=0 &&
                   i-1 < board.length && j < board[i].length
                   && Math.abs(board[i-1][j]) == 1)
                    cnt++;
                if(i-1 >= 0 && j+1 >=0 &&
                   i-1 < board.length && j+1 < board[i].length
                   && Math.abs(board[i-1][j+1]) == 1)
                    cnt++;
                if(i >= 0 && j-1 >=0 &&
                   i < board.length && j-1 < board[i].length
                   && Math.abs(board[i][j-1]) == 1)
                    cnt++;
                if(i >= 0 && j+1 >=0 &&
                   i < board.length && j+1 < board[i].length
                   && Math.abs(board[i][j+1]) == 1)
                    cnt++;
                if(i+1 >= 0 && j-1 >=0 &&
                   i+1 < board.length && j-1 < board[i].length
                   && Math.abs(board[i+1][j-1]) == 1)
                    cnt++;
                if(i+1 >= 0 && j >=0 &&
                   i+1 < board.length && j < board[i].length
                   && Math.abs(board[i+1][j]) == 1)
                    cnt++;
                if(i+1 >= 0 && j+1 >=0 &&
                   i+1 < board.length && j+1 < board[i].length
                   && Math.abs(board[i+1][j+1]) == 1)
                    cnt++;

                if(cnt < 2 && board[i][j] == 1){
                    board[i][j] = -1;
                }
                else if(cnt > 3 && board[i][j] == 1){
                    board[i][j] = -1;
                }
                else if(cnt == 3 && board[i][j] == 0){
                    board[i][j] = 2;
                }
            }
        }

        for(int i = 0 ; i < board.length; i++){
            for(int j = 0 ; j < board[i].length; j++){
                if(board[i][j] > 0)
                    board[i][j] = 1;
                else
                    board[i][j] = 0;
            }
        }
    }
}
