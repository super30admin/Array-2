// Time Complexity : O(m * n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// logic: Iterate through each cell on the board and count its live neighbors. Use temporary states to mark cells that will die (from live to dead as 2) or become alive (from dead to live as 3) without affecting the original state of other cells during the iteration.
// After determining the changes, iterate through the board again and convert all marked temporary states to their final states: change 2 to 0 (dead) and 3 to 1 (live).
// Count Live Neighbors: A helper function counts the number of live neighbors around a given cell, considering boundaries and ignoring temporary states to avoid interference with ongoing state changes.

class Solution {

    int  m , n;
    public void gameOfLife(int[][] board) {

        if(board == null || board.length ==0){
            return ;
        }

        m = board.length;
        n = board[0].length;

        // 1 changes to 2 if live cell changes to Dead cell
        // 0 changes to 3 i Dead cell changes to Live cell

        for(int i =0 ; i<m;i++){
            for(int j =0; j<n;j++){
                int count = countLiveNeighbours(board, i, j);
                if(board[i][j] == 1){
                    if(count < 2 ||count > 3){
                        board[i][j] = 2;
                    }
                }
                else{
                    if(count == 3){
                        board[i][j] =3;
                    }
                }
            }
        }

        for(int i =0; i< m; i++){
            for(int j =0; j< n;j++){
                if(board[i][j] == 2){
                    board[i][j] = 0;
                }
                else if(board[i][j] == 3){
                    board[i][j] = 1;
                }

            }
        }
    }

    private int countLiveNeighbours(int[][] board, int row, int col){
        int count = 0;
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};
        for(int []dir : dirs){
            int newrow = row + dir[0];
            int newcol = col + dir[1];

            if(newrow >= 0 && newrow < m && newcol >= 0 && newcol < n && (board[newrow][newcol]==1 || board[newrow][newcol]==2) ){
                count++;
            }
        }

        return count;
    }
}