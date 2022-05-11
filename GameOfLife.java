// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] intermediate = new int[m][n];
        int[][] directions = new int[][]{//initialise the 8 directions
            {-1,0},{-1,1},{0,1},
            {1,1},{1,0},{1,-1},
            {0,-1},{-1,-1},
        };
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int live = 0;
                for(int[] d:directions){
                    int x = d[0]+i;
                    int y = d[1]+j;
                    if(x>=0 && x<m && y>=0 && y<n && board[x][y]==1){//this calculates the live values
                        live++;
                    }
                }
            
                if(board[i][j]==0 && live==3){
                    intermediate[i][j]=1;
                }else if(board[i][j]==1){
                    if(live==2 || live==3){
                        intermediate[i][j]=1;
                    }
                }
            }
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                board[i][j]=intermediate[i][j];
            }
        }
    }
}