//Time complexity = O(m*n)
//Space complexity = O(1)
//Interview=Microsoft
//Consider 8 directions are constant in this approach so space complexity is constant.Based on all directions comparing the the current index value based on live and dead.live =dead-> greater than 3 or <2
//Dead= live->if it equal to 3 live neighbors.Iterate over the array and subsitute with the current value.
class Solution {
    int m,n;
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0) return;
        
        m = board.length;//Row or height
        n= board[0].length;//Column or width

        //0->1 ===2
        //1->0 ===3
         for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int countLiveNeighbors = countLives(board,i,j);
                //if the cell was dead
                if(board[i][j] == 0){
                    //when I have exactly 3 live neighbors
                    if(countLiveNeighbors == 3){
                        board[i][j] = 2;
                    }
                }
                
           //if the cell was live
            else{
                //fewer than 2 live neighbors
                if(countLiveNeighbors<2){
                    board[i][j] = 3;   
                } //more than 3 live neighbors
                if(countLiveNeighbors>3){
                    board[i][j] = 3;
                }
            }
            }
                
        }
    
    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(board[i][j] == 2){
                board[i][j] = 1;
            } else if(board[i][j] == 3){
                board[i][j] = 0;
                }
            }
        }
    
    }
    private int countLives(int[][] board, int r , int c){
        int count=0;
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}, {-1,-1}, {1,1}, {-1,1}, {1,-1}};
    
            for(int[] dir:dirs){
            int nr = r+dir[0];
            int nc = c+dir[1];
            
            if(nr >= 0 && nr < m && nc >= 0 && nc < n && (board[nr][nc] == 1 || board[nr][nc] == 3)){
            count++;
            }
        }
        return count;
    }
}