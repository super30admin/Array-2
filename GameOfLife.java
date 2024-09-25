// Time Complexity :O(m*n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
//

class Solution {
    int m;
    int n;
    public void gameOfLife(int[][] board) {
        if(board==null || board.length == 0)return;
        m=board.length;
        n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int lives = cLives(board,i,j);
                if(board[i][j]==1){
                    if(lives<2 || lives>3){
                        board[i][j] = 5;
                    }
                                        
                }
                else{
                    if(lives == 3){
                        board[i][j] = 3;
                    }
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==3){
                    board[i][j]=1;
                }
                if(board[i][j]==5){
                    board[i][j]=0;
                }
            }
        }
    }
    
    private int cLives(int[][] board, int i,int j){
        int [][] dir ={{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,-1},{-1,1},{1,-1}};
        int count  = 0;
       for(int[] dirs:dir) {
           int r = i + dirs[0];
           int c = j + dirs[1];
            if(r >=0 && c>=0 && r < m && c < n && (board[r][c]==1 || board[r][c]==5)){
                count++;
            }               
       }return count;
    }
}