// Time Complexity :O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Syntaxes error


// Your code here along with comments explaining your approach

class Solution {
    int m,n;
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0) return;
        
         m = board.length; // rows
         n = board[0].length; // columns
        
        //representing 0 to 1 transformation as 2
        //representing 1 to 0 transformation as 3
        
        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                int count = countNeighbors(board,row,col); // calculating the total number of neighbours around that index
                if(board[row][col]==1){ // if the value is = 1
                    if(count <2){ //matching all the conditions
                        board[row][col]=3;
                    }else if(count > 3){
                        board[row][col]=3;
                    }else{ // when count ==2 or 3
                        continue;
                    }
                }else{ // when equal to 0
                    if(count ==3){
                        board[row][col]=2;
                    }
                }
            }
        }
        
        for(int row=0;row<m;row++){ // for changing back the 2s and 3s to 1 and 0
            for(int col=0;col<n;col++){
                if(board[row][col] == 2){
                    board[row][col]=1;
                }else if(board[row][col] == 3){
                    board[row][col]=0;
                }
            }
        }
    }
        private int countNeighbors(int[][] board, int row,int col){ // for caluclating the neighbors, the trickiest and important part in this code
            int count=0;
            int[][] dirs = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}}; // use a 2d array to navigate the neighbors
            
            for(int[] dir:dirs){
                int nr = row + dir[0]; // these will give index of nneighbour rows and columns
                int nc = col + dir[1];
                if(nr >=0 && nr < m && nc >=0 && nc < n && (board[nr][nc] == 1 || board[nr][nc] == 3)){
                    count++; // if they are equal to 1 or 3, then increase the count
                } 
            }
            return count;
        }    
}