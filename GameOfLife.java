// Time Complexity: O(mn)
// Space Complexity:O(1)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this:  


// Your code here along with comments explaining your approach


class Solution {
    
    int m;
    int n;
    int [][] dirs;
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0) return;
        m = board.length;
        n = board[0].length;
        
        //1 ==> 0 ==> 2
        //0 ==> 1 ==> 3
        
        //                   top  bottom    left    right   topLeft   topRight  bottomLeft  bottomRight
        dirs = new int[][]{{-1,0}, {1,0},  {0,-1},  {0,1},  {-1,-1},   {-1,1},    {1,-1},      {1,1} };
        
        for(int i=0; i<m; i++){ //no of rows
            for(int j=0; j<n; j++){ // no of cols
                
                int countlives = countAlive(board, i, j); // get count of live cells from 8 all directions arround that particular cell

                //2nd Rule, No need implement
                //1th and 3rd Rule
                if(board[i][j] == 1 && (countlives < 2 ||  countlives > 3)){
                    //Changing the state of cell temporarily
                    board[i][j] = 2;
                }
                
                //4th Rule
                if(board[i][j] == 0 && countlives == 3){
                    //Changing the state of cell temporarily
                    board[i][j] = 3;
                }
            }
        }
        
        //Changing the state of cells temporarily to atcual changed values
        for(int i=0; i<m; i++){ 
            for(int j=0; j<n; j++){
                if(board[i][j] == 2) board[i][j] = 0;
                if(board[i][j] == 3) board[i][j] = 1;
            }
        }
    }
    
    private int countAlive(int [][] board, int r, int c){
        int count = 0;
        //Get all directions and iterate over them
        for(int []dir : dirs){
            //Adding current row and direction row
            int nr = r + dir[0];  //{-1,0} ==> -1
             //Adding current col and direction col
            int nc = c + dir[1];  //{-1,0} ==>  0
            
            //borders of columns and rows. condition without crossing
            // nr ==> 0 to m   and  cr ==> 0 to n
            
            if(nr >= 0 && nr < m && nc >= 0 && nc < n
              && (board[nr][nc]==1 || board[nr][nc] == 2)){
                count ++;
            }
        }
        
        return count;
    }
}