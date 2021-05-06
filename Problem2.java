// Time Complexity : O(m*n) m*n is the length of the board
// Space Complexity : O(1)  
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no  

// get the count of neighbors for each cell in the board and updating according to the given conditions. 
// If alive is dead, its changed to a negative value
// If dead is alive, its value is changed to 2.
//After the calculation, the new dead and alives are changed to 0s and 1s respectively.




class Solution {
    public void gameOfLife(int[][] board) {
         // null check
        if(board.length==0 || board[0].length==0)
            return;
        int lives =0;
        int m = board.length;
        int n = board[0].length;
        // Applying the rules
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                //board[i][j]
                // 1 to 0 -> -1
                // 0 to 1 -> 2
                lives = calcLives(board, i,j, m, n);
                System.out.println(lives);
                if(board[i][j] == 1 && lives<2){
                    board[i][j]*=-1;//rule
                }
                if(board[i][j] == 1  && lives>3){
                    board[i][j]*=-1;//rule
                }
                if(board[i][j] == 0 && lives == 3){
                    board[i][j]=2;//rule
                }
            }
        }
        
        //Changing the state for output
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]<0)
                    board[i][j]=0;
                if(board[i][j]==2)
                    board[i][j]=1;
            }
        }
                   
        
    }
    public int calcLives(int[][] board,int i, int j, int m, int n){
        int result=0;
        int directions[][] = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};//calculating 8 neighbors
        for(int[] dir : directions){
            int neighbor_row = i+dir[0];
            int neighbor_col = j+dir[1];
            if(neighbor_row>=0 && neighbor_col>=0 && neighbor_row<m && neighbor_col<n && Math.abs(board[neighbor_row][neighbor_col])==1 ){
                result++;
            }
                
        }
        return result;
    }
}