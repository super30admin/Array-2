/*
Algorithm:
    1. Traverse through the matrix, if the case 1 or case 3 is satisfied change the cell value to 2.
    2. If the case 3 is satisfied, change the cell value to 3.
    3. Traverse through the matrix change the value of each cell to element value%2.
    
    Time Complexity: O(n^2)
    Space Complexity: O(1)
    
    Did the code run on leet code? Yes

*/

class Solution {
    
    private int dirs[][] = {{0,1}, {0,-1}, {1,0}, {-1,0}, {-1,-1}, {-1,1}, {1,-1}, {1,1}}; 
    public void gameOfLife(int[][] board) {
    //Base case
    if(board.length==0)
        return;
    int m = board.length;
    int n = board[0].length;
    /*Value Setting
        1->0 => 2
        0-> 1=> 3 */
            
            
    for(int i=0; i<m ;i++){
        for(int j=0; j<n; j++){
            int lives = getLiveNeighbours(i,j,board);
            
            if(lives==3 && (board[i][j]==0 || board[i][j]==3)){
                board[i][j]=3;
            }
               
             else if((lives>3 || lives<2) && board[i][j]==1){
                 board[i][j]=2;
             }
            
        }
    }
        
    for(int i=0; i<m; i++){
        for(int j=0; j<n;j++){
            board[i][j]=board[i][j]%2;
}
    }
        
    }
               
               
private int getLiveNeighbours(int i, int j, int[][] board){
        int count=0;
        for(int[] dir: dirs){
            int x = dir[0]+i;
            int y = dir[1]+j;
            //Edge Case
            if(x<0 || x>=board.length || y<0 || y>=board[0].length){
                continue;
            }
            
            if(board[x][y]==1 || board[x][y]==2){
                count++;
            }
            
        }
        
        return count;
    }        
               
}