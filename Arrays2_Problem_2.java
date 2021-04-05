// Time Complexity : O(m*n) n is the length of the array  
// Space Complexity : O(1)  
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no  

// get the count of neighbours for each value in the board and updating according to the given conditions, 
class Solution {
    public void gameOfLife(int[][] board) {
        
      
        int m=board.length;
        int n=board[0].length;
        // 0->1 ===> 3
        // 1->0 ===> 2
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int count= countNeighbours(board, i, j);
                System.out.print(count);
                if(board[i][j]==1 && (count<2 || count>3)) board[i][j]=2;
                else if(board[i][j]==0 && count==3) board[i][j]=3;
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==2) board[i][j]=0;
                else if(board[i][j]==3) board[i][j]=1;
            }
        }
    }
    private int countNeighbours(int[][] board, int i, int j){
        int[][] dirs= {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        int count=0;
        for(int k=0;k<dirs.length;k++){
            int row= i+dirs[k][0];
            int col =j+ dirs[k][1];
            if(row>=0 && col>=0 && row<board.length && col<board[0].length && (board[row][col]==1 || board[row][col]==2)) count++;
        }return count;
    }
}