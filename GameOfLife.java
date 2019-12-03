// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
//brute force solution

class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length ==0){
            return;
        }
        int[][] result = new int [board.length][board[0].length];
        for(int i =0; i< board.length; i++){
            for(int j = 0 ; j < board[0].length; j++){
                
                int countOne = countOnes(board, i, j);
                System.out.println(countOne);
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
        int count = 0;
        if(i + 1 < board.length){
            if(board[i+1][j] == 1){
                    count += 1;
                }
            if(j+1 < board[0].length){
                if(board[i+1][j+1] == 1){
                    count += 1;
                }
                if(board[i][j+1] == 1){
                    count += 1;
                }
            
            }
            if(j -1 >= 0){
                if(board[i+1][j-1] == 1){
                    count += 1;
                }
                if(board[i][j-1] == 1){
                    count += 1;
                }
            }
        }
        if(i -1 >= 0){
            if(board[i-1][j] == 1){
                    count += 1;
                }
            if(j+1 < board[0].length){
                if(board[i-1][j+1] == 1){
                    count += 1;
                }
                if(board[i][j+1] == 1 && i+1 >= board.length){
                    count += 1;
                }
            
            }
            if(j -1 >= 0){
                if(board[i-1][j-1] == 1){
                    count += 1;
                }
                if(board[i][j-1] == 1 && i+1 >= board.length){
                    count += 1;
                }
            }
        }
        return count;
    }
}