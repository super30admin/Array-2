// Time Complexity : O(n*m), size of the input array
// Space Complexity :O(1), we are manipulating the same input array
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : please correct me on the time complexity


// Your code here along with comments explaining your approach

class Solution {
    public void gameOfLife(int[][] board) {
        //return if board is null or board is empty
        if(board == null || board.length == 0) return;
        
        //0 --> 1 = 2
        //1 --> 0 = 3   
        //Iterate over the entire board to check the rules
        for(int i =0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                //count the live neighbours of the current cell
                int lives = countLives(board, i, j);
                
                //rule 4
                if(board[i][j] == 0 && lives == 3){
                    board[i][j] = 2; //becomes alive
                }
                //rule 1 and 3
                if(board[i][j] == 1 && (lives < 2 || lives > 3 )){
                    board[i][j] = 3;
                }
            }
        }
        
        //replace 2 and 3 with 1 and 0 respectively
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == 2){
                    board[i][j] = 1;
                }
                if(board[i][j] == 3){
                    board[i][j] = 0;
                }
            }
        }
    }
    
    //Function to count the live neighbours of the current cell
     private int countLives(int[][] board, int i, int j){   
            int count =0;
            
            //2-d array that gives position of all 8 neighbours
            int [][]dirs = {{-1,0}, {1,0}, {0, -1}, {0,1}, {-1, 1}, {1,1}, {1,-1}, {-1,-1}};
            
            
            for(int[] dir: dirs){
                int row = i + dir[0];
                int col = j + dir[1];
                //check if the neighbour is live
                if( row >= 0 && row < board.length && col >= 0 && col < board[0].length 
                   && (board[row][col] == 1 || board[row][col] == 3)){
                    count++;
                }
            }
            
         //return the count of live neighbours for that cell
            return count;
        }
}