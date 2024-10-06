// Time Complexity : O(mxn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no



public class Solution {
    int m,n;
    public void GameOfLife(int[][] board) {
        this.m = board.Length;
        this.n = board[0].Length;

        int[][] dirs = new int[][]{
        new int[]{0, -1},  // Left
        new int[]{0, 1},   // Right
        new int[]{-1, 0},  // Up
        new int[]{1, 0},   // Down
        new int[]{-1, -1}, // Up-Left
        new int[]{-1, 1},  // Up-Right
        new int[]{1, -1},  // Down-Left
        new int[]{1, 1}    // Down-Right
    };

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int count = countAlive(dirs,board,i,j);
                if(board[i][j] ==1){
                    if(count<2 || count>3){
                        board[i][j] =2; // alive -> dead
                    }
                }else if(board[i][j] ==0){
                    if(count == 3){
                        board[i][j]=3; //dead -> alive
                    }
                }
            }
        }

         for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] ==2){
                    board[i][j] =0;
                }else if(board[i][j] ==3){
                    board[i][j]=1;
                }
            }
         }
    }

    private int countAlive(int[][] dirs, int[][] board, int i, int j){
        
        int count = 0;
        foreach(int[] dir in dirs ){ //i,j -> 0,0 -> 0,-1
            int r = dir[0] +i;
            int c = dir[1] +j;
            if(r>=0 && r<m && c>=0 && c<n){
                if(board[r][c] ==1 || board[r][c]==2){
                    count++;
                }
            }
        }
        return count;
    }
}