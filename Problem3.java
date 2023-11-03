// Time Complexity : O(mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  No

// Prev : 1,  Transition : -1,  Modified : 0
// Prev : 0,  Transition : -2,  Modified : 1

class Solution {

    private int[][] directions= new int[][]{
        {-1,-1},//north west
        {-1,0},//north
        {-1,1},//north east
        {0,1},//east
        {1,1},//south east
        {1,0},//south
        {1,-1},//south west
        {0,-1} //west
    };

    int findNeighbours(int[][] board, int i, int j){
        
        int m= board.length;
        int n= board[0].length;
        int count=0;

        for(int[] direction : directions){ // here we r creating a 1D array direction which will change in every iteration according to the row of 2D directions array
            
            int x= i+ direction[0]; // getting the row index of neighbouring element
            int y= j+ direction[1]; // getting the column index of neighbouring element
            
            if(x>=0 && x<m && y>=0 && y<n){ // checking if the element is out of bounds
                // Retrieving the prev values if -1
                // 1 is as usual original
                if(board[x][y]==-1 || board[x][y]==1){ 
                count++;
                }
            }
        }
        
        
        return count;
    }


    public void gameOfLife(int[][] board) {
        int m= board.length;
        int n= board[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int prev= board[i][j];
                int neighbours= findNeighbours(board,i,j);
                // Manipulating the values from prev to transition
                if(prev==1){
                    if(neighbours<2 || neighbours>3){
                        board[i][j]=-1;
                    }
                }
                else{
                    if(neighbours==3){
                        board[i][j]=-2;
                    }
                }
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int transitionValue= board[i][j];
                // Restoring the values from transition to modified
                if(transitionValue==-1){
                    board[i][j]=0;
                }
                if(transitionValue==-2){
                    board[i][j]=1;
                }
            }
        }
    }
}