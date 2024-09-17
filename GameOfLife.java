// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
//Just optimized counting of neighboring lives using a directions array and the submission was faster that 100% compared to 5% 
class Solution {
    int[][] directions = {{0,1},{0,-1},{-1,-1},{1,1},{1,0},{-1,0},{1,-1},{-1,1}};
    public void gameOfLife(int[][] board) {
        if(board == null || board.length ==0){
            return;
        }
        int[][] result = new int [board.length][board[0].length];
        for(int i =0; i< board.length; i++){
            for(int j = 0 ; j < board[0].length; j++){
                
                int countOne = countOnes(board, i, j);
                //System.out.println(countOne);
                if(board[i][j] ==0){                  
                    if(countOne == 3){
                        result[i][j] = 1;
                    }
                }else{
                    if(countOne == 2 || countOne == 3){
                        result[i][j] = 1;
                    }
                    else if(countOne < 2){
                        result[i][j] = 0;
                    }
                    else if(countOne > 3){
                        result[i][j] = 0;
                    }
                }
            }
        }
        for(int i =0; i< board.length; i++){
            for(int j = 0 ; j < board[0].length; j++){
                board[i][j] = result [i][j];
            }
        }
        
    }
    
    public int countOnes(int[][] board, int i, int j){
        int lives = 0;
        for(int[] dir : directions){
            int x = dir[0] + i;
            int y = dir[1] + j;
            if(x< 0 || x>= board.length || y<0 || y>=board[0].length){
                continue;
            }
            if(board[x][y] == 1 || board[x][y] ==2){
                lives ++;
            }
        }
        return lives;
    }
}