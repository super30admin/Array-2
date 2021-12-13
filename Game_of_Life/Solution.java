// Time Complexity : O(n * m) where n -> rows and m -> columns
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * For each cell, we apply given rules to check if its status changes (i.e. dead -> alive or alive -> dead)
 * Now whenever a cell changes from dead -> alive, we mark it as 2.
 * Whenever a cell changes from alive -> dead, we mart it as 3.
 * This way we can calculate no of live cells around the current cell without using extra space. (value = 1 && value = 3)
 * As a final step, we replace 2 with a(alive) and 3 with 0(dead) by going over matrix once again making it a 2 pass solution
*/





class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length==0)return;
        //rules
        // 1. live has < 2 live ==> dead
        // 2. live has > 3 live ==> dead
        // 3. dead has 3 live ==> live
        
        // 0 -> 1 ==> 2
        // 1 -> 0 ==> 3
        
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