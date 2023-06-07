// Time Complexity : O(m*n)[since we do not get all 8 neighbours for each value we can ignore 8]
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    //logic to traverse the neighbours
    int[][] dirs ;
public void gameOfLife(int[][] board) {
              /*{0,1} -> right
    {1,0}-> bottom
    {-1,0}-> top
    {0,-1}-> left
    {1,1}-> lower right
    {-1,-1}-> upper left
    {-1,1}-> upper right
    {1,-1}-> upper left
    */
    dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1},{1,1},{-1,-1},{-1,1},{1,-1}};
    //base case
    if(board.length == 0 || board == null) return;
    int m = board.length, n = board[0].length;
    for(int i =0;i<m;i++){
        for(int j=0;j<n;j++){
            int countLiveNeighbors = countLives(board, i,j,m,n);
            //if the cell is dead 
            if(board[i][j] == 0){
                //if you have exactly 3 live neighbors
                if(countLiveNeighbors == 3){
                       //if 0->1(0 changes to 1) denote by 2
                    board[i][j] = 2;
                }

            }
            //if the cell is alive
            else {
                //fewer than 2 live neighbors or gretaer than 3 live neighbors
                if(countLiveNeighbors < 2 || countLiveNeighbors > 3){
                           //if 1-> 0(1 changes to 0) denote by 3
                    board[i][j] = 3;
                }
            }
        }
    }


//convert back the changed value to 0 & 1
             for(int i =0;i<m;i++){
        for(int j=0;j<n;j++){
            if(board[i][j]==2){
                board[i][j] =1;
            }
            else if(board[i][j]==3){
                 board[i][j] =0;
            }
        }
    }
        }
    
//logic to get the count of live neighbors
private int countLives(int[][] board, int r,int c,int m,int n){
    int count = 0;

    for(int[] dir : dirs){
        int newRow =  r + dir[0]; 
        int newColumn= c + dir[1] ;
        //check the boundary of the row and column as the board[0][0] will not have left top and bottom left neighbours
        if(newRow>=0 && newRow < m && newColumn >=0 && newColumn < n && (board[newRow][newColumn]==1 ||board[newRow][newColumn]==3 )){
            count++;
        }

    }
    return count;
}
}