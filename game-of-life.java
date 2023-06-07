// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class Solution {
    private int[][] direction;
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        //creating 8 directions of the instance of matrix
        direction = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{-1,-1},{1,1},{-1,1},{1,-1}};

        for(int i = 0 ; i <m ; i++){
            for(int j = 0 ; j<n; j++){
                int countAlive = countAlive(board, i , j,m,n);
                //setting the value to 2 if the cell is alive and has less than 2 or more than 3 alive neighbours
                if(board[i][j] == 1){
                    if(countAlive < 2 || countAlive > 3){
                        board[i][j] = 2;
                    }
                    //setting the value to 3 if the cell is dead and has 3 alive neighbours
                }else{
                    if(countAlive == 3){
                        board[i][j] = 3;
                    }
                }
            }
        }
        //setting the value to 0 if the value is 2 and 1 if the value is 3
        for(int i = 0 ; i <m ; i++){
            for(int j = 0 ; j<n; j++){
                if(board[i][j] == 2){
                    board[i][j] = 0;
                }else if(board[i][j] == 3){
                    board[i][j] = 1;
                    }
            }}

    }
    //function to count the number of alive cells
    private int countAlive(int[][] board, int i, int j, int m, int n){
        int count = 0; 
        for(int[] dir: direction){
            int r = i + dir[0];
            int c = j+ dir[1];
            if(r >= 0 && c >= 0 && r < m && c < n && (board[r][c] == 1 || board[r][c] == 2)){
                count++;
            }
        }
        return count;
    }
}