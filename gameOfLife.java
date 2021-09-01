// Time Complexity: We are traversing the whole matrix and 8 neighbours each time so it will be O(m*n*8) and then traversing again to correct the values O(m*n) ==> O(m*n)
// Space Complexity: Only a fixed size array is used which can be considered constant O(1)
// Did you complete it on leetcode: Yes
// Any problems faced: Understood in class

//Write your approach here:
// Idea here is to assign board with safe values which we can check that they were previously 1s or 0s, by assigning them as 3 and 2.
// by looping through the directions array we are traversing all neighbours of every element
// and counting total number of alive neighbours
// we are assigning 2/3 according to conditions given in problem if a dead cell becomes alive
// or an alive cell becomes dead. rest will continue to exist as they were earlier.
// once completed we can traverse matrix again to assign 0 to now dead cell(3) and 1 to now alive cells(2).
class Solution {
    public void gameOfLife(int[][] board) {
        if(board==null||board.length==0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        for(int i=0; i< m; i++) {
            for(int j=0; j<n; j++) {
                int liveNeighbour = livingCount(board,i,j);
                if(board[i][j]==1 && (liveNeighbour<2 || liveNeighbour>3)) {
                    board[i][j]=3;
                } else if(board[i][j]==0 && liveNeighbour==3) {
                    board[i][j]=2;
                }
            }
        }
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j]==3) board[i][j]=0;
                if(board[i][j]==2) board[i][j]=1;
            }
        }
    }
    
    public int livingCount(int[][] board, int i, int j) {
        int result = 0;
        int m = board.length;
        int n = board[0].length;
        int[][] dirs = {{-1,-1}, {-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}, {1,-1}, {0,-1}};
        for(int[] dir: dirs) {
            int nr = i+dir[0];
            int nc = j+dir[1];
            if(nr>=0 && nr<m && nc>=0 && nc<n && (board[nr][nc]==1 || board[nr][nc]==3)) {
                result++;
            }
        }
        return result;
    }
}