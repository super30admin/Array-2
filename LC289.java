// Time Complexity : O(N*M)
// Space Complexity : O(N*M)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public void gameOfLife(int[][] board) {
        
        //if board is empty, return
        if(board.length == 0 || board == null || board[0].length == 0){
            return;
        }
        
        //find the length and width of board
        int n = board.length;
        int m = board[0].length;
        
        //start traversing over every element on the board
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                //find out the number of alive neighbor cells using a function
                int alive = countAlive(board, i, j, n, m);
                
                //if the cell is alive and it has less than 2 or more than 3 alive neighbor cells,
                //change the element to 
                //2 -> previous state -> Alive
                //current state -> Dead
                if(board[i][j] == 1 && (alive < 2 || alive > 3)){
                    board[i][j] = 2;
                }
                //if the cell is dead and it has exactly 3 alive neighbor cells, 
                //we change it to 4
                //4 -> previous state -> Dead
                //current state -> Alive
                else if(board[i][j] == 0 && alive == 3){
                    board[i][j] = 4;
                }
            }
        }
        
        //Traverse over the board second time to change 2 -> 0(making it dead cell)
        //and 4 -> 1(making it alive cell)
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 2){
                    board[i][j] = 0;
                }
                else if(board[i][j] == 4){
                    board[i][j] = 1;
                }
            }
        }
    }
    
    //custom function to calculate the number of alive neighbor cells in all eight directions
    private int countAlive(int[][] board, int i, int j, int n, int m){
        int count = 0;
        
        //all the directions
        int[][] dirs = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
        
        //checking all the directions from the every single element 
        for(int[] dir : dirs){
            int r = i + dir[0];
            int c = j + dir[1];
            
            //if the condition satisfies, increase the count
            if(r >= 0 && c >= 0 && r < n && c < m && (board[r][c] == 1 || board[r][c] == 2)){
                count += 1;
            }
        }
        return count;
    }
}