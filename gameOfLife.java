// Time Complexity : O(m * n) where m -> col and n -> rows
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
rules
    1. live has < 2 live ==> dead
    2. live has > 3 live ==> dead
    3. dead has 3 live ==> live

    Let's parse through matrix and check for the above rule.
    If rule satisfied for every change in the matrix follow the below pattern.
    0 -> 1 ==> 2
    1 -> 0 ==> 3

    Parse the matrix again and change the 2 with alive i.e 1 and 3 with dead i.e 0.
*/

class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length==0)return;

        for(int row = 0; row < board.length;row++){
            for(int col = 0; col < board[0].length;col++){
                int live = cal_live(board, row, col);

                if(board[row][col] == 1){
                    if(live < 2 || live > 3){
                        board[row][col] = 3;
                    }
                }else{
                    if(live == 3){
                        board[row][col] = 2;
                    }
                }
            }
        }

         for(int row = 0; row < board.length;row++){
            for(int col = 0; col < board[0].length;col++){
               if(board[row][col] == 2){
                   board[row][col] = 1;
               }else if(board[row][col] == 3){
                   board[row][col] = 0;
               }
            }
        }


    }

    private int cal_live(int[][] board, int row, int col){
        int[][] positions = {{-1,0}, {1, 0}, {0, -1}, {0, 1} , {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

        int ans = 0;

        for(int[] cur : positions){
            int new_row = row +  cur[0];
            int new_col = col + cur[1];

            if(new_row < 0 || new_row >= board.length || new_col < 0 || new_col >= board[0].length)continue;
            else{
                if(board[new_row][new_col] == 1 || board[new_row][new_col] == 3)ans++;
            }
        }

        return ans;
    }
} 