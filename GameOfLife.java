// Time Complexity : O(M*N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope


// Your code here along with comments explaining your approach
// Using the given rules, we change a cell from dead to alive or vice versa
// However to keep the track of the original state we use a different interger to indicate that the cell was alive or dead
class Solution {
    public void gameOfLife(int[][] board) {
        
        int m = board.length;
        int n = board[0].length;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                int count = checkNeighbours(board, i, j, m, n);
                if (board[i][j] == 1 && (count < 2 || count > 3)) {  
                    board[i][j] = 2; // alive -> dead
                }
                if (board[i][j] == 0 && count == 3) {
                    board[i][j] = 3;  // dead -> alive
                }
            }
        }
        
        for(int i=0; i< m; i++) {
            for(int j=0; j<n; j++) { 
                if(board[i][j] == 2) {
                    board[i][j] = 0;
                }
                if(board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }
    
    private int checkNeighbours(int[][] board, int i, int j, int m, int n) {
        int result = 0;
        int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,-1},{1,-1},{-1,1}};
        
        for(int[] d: dir) {
            int r = d[0] + i;
            int c = d[1] + j;
            if(r>=0 && r<m && c>=0 && c<n && (board[r][c] == 1 || board[r][c] == 2))
                result += 1;
        }
        
        return result;
    }
}