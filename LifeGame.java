// Time Complexity: O(mn)
// Space complexity: O(1)

// Approach: 
// We define a dirs matrix which will have x,y coordinates i.e. neighbors for a particular elements. Since we can have max
// 8 neighboars we define 8 coordinates.
// We iterate through the matrix once to check for each elements the number of alive/dead neighbors. If the element is to be set as 
// alive-> dead i.e. from 1 -> 0, then we make the element 2.
// For dead - > alive or 0 -> 1, we make the element 3.
// We iterate over the matrix one more time to make the 2's as 0 and 3's as 1 since matrix can only have 1's and 0's.
// For the first for loop, we call a function which gives us the number of alive neighbors, this function uses the 8 coordinates from the
// dirs matrix. With every coordinate, we get the status of each neigbor if it is dead or alive and increment the count if alive.

class Solution {
    private int[][] dirs; //dirs matrix global variable
    public void gameOfLife(int[][] board) {
        int m=board.length;
        int n=board[0].length;
        
        // dirs matrix, x y coordinates of the element's neighbors, like a graph
        dirs = new int[][]{{0,1},{1,0},{1,1},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1}};
        
        //iterate through matrix to get the state of the neighbors and then set the state of the element itself
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int countAlive=countAlive(board,i,j,m,n);
                if(board[i][j]==1 & (countAlive < 2 || countAlive > 3)){
                    board[i][j]=2; // set 2 for dead
                } 
                // no need to check the below condition since the live cell will not die
                // else if(board[i][j]==1 & (countAlive==2 || countAlive==3)){
                //     board[i][j]=1;
                // }
                if(board[i][j]==0 & countAlive==3){
                    board[i][j]=3; //set 3 for alive
                }
            }
        }
        
        //iterate through the array again and reset values 2 to 0 (dead) and 0 to 3 (alive)
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==2){
                    board[i][j]=0;
                }
                if(board[i][j]==3){
                    board[i][j]=1;
                }
            }
        }
    }
        
        //count the alive neighbors
        private int countAlive(int[][] board, int i, int j, int m, int n){
            int count=0;
            for(int[] dir:dirs){
                //current direction {0,1} since we are starting from there in the dirs matrix defined at the top
                
                //get row index of neighbor
                int r=i+dir[0]; //index of curr element + direction in which we are moving
                
                //col index of neigbor
                int c=j+dir[1];
                if(r>=0 && c>=0 && r<m && c<n && (board[r][c]==1 || board[r][c]==2)){
                    count++;
                }
            }
            return count;
        }
        
    
}