// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no 
// Approach : for each cell count alive neighbors. Based on count (if <2 or >3, alive else dead), we decide whether
/// cell will be alive or dead in next timestamp, to mark them use 5 for alive and 4 for dead. Lastly iterate through the matrix
/// again and change back 5 to 1 and 4 to 0
class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int count =  countAliveNeighbors(board, i, j);
                if(board[i][j]==1 && (count<2 || count>3)){
                    board[i][j] = 5;
                }
                if(board[i][j] == 0 && count == 3){
                    board[i][j] = 4;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==4){
                    board[i][j]=1;
                }
                if(board[i][j]==5){
                    board[i][j] = 0;
                }
            }
        }
    }
    int countAliveNeighbors(int board[][], int r, int c){
        int directions[][] = new int[][]{{0,1}, {1, 0}, {0,-1}, {-1, 0}, {-1,1}, {1,1}, {1, -1}, {-1, -1}};
        int count = 0;
        for(int direction[]:directions){
            int new_r = r+direction[0];
            int new_c = c+direction[1];
            if(new_r>=0 && new_r<board.length && new_c>=0 && new_c<board[0].length && (board[new_r][new_c]==1 || board[new_r][new_c] == 5)){
                count++;
            }   
        }
        return count;
    }
}