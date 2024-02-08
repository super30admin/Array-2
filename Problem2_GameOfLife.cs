// Time Complexity : O(m * n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 

public class Solution {
    //Index directions to find neighbours
    List<int[]> dirs = new List<int[]>{
        new int[]{0,1} //right,
        new int[]{0,-1}//left, 
        new int[]{-1,0},//top, 
        new int[]{1,0},//bottom 
        new int[]{-1,1},//top right
        new int[]{-1,-1},//top left 
        new int[]{1,1},//bottom right 
        new int[]{1,-1}//bottom left
    };
    public void GameOfLife(int[][] board) {
        int m = board.Length - 1;
        int n = board[0].Length - 1;
        for(int i = 0; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
                //Get count of live neighbours for current element
                int count = GetLiveNeighboursCount(board, i, j);
                //Change live(1) to dead(0) using temporary state "-1"
                if(board[i][j] == 1 &&(count < 2 || count > 3)) {
                    board[i][j] = -1;
                }
                else {
                    //Change dead(0) to live(1) using temporary state "-2"
                    if(board[i][j] == 0 && count == 3) {
                        board[i][j] = -2;
                    }
                }
            }
        }
        for(int i = 0; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
                //Update temporary states --> -1 to 0 and -2 to 1
                board[i][j] = board[i][j] == -1 ? 0 : (board[i][j] == -2 ? 1 : board[i][j]);
            }
        }
    }

    //Function to get the count of live neighbours around the element at [row][col]
    private int GetLiveNeighboursCount(int[][] board, int row, int col) {
        int count = 0;
        foreach(var dir in dirs) {
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];
            if(nextRow >= 0 && nextRow < board.Length && nextCol >= 0 && nextCol < board[0].Length) {
                if(board[nextRow][nextCol] == -1 || board[nextRow][nextCol] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}
