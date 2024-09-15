// Time Complexity : 2*O(MXN) = O(MXN) where M is number of rows and N is number of columns
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    int m, n;
    public void gameOfLife(int[][] board) {
        //edge cases
        if(board==null || board.length ==0){
            return;
        }
        //Dimensions of the array
        m = board.length;
        n = board[0].length;
        
        
        //Main logic count() is the method to find how many neighbours alive
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int count = count(board, i, j);
                System.out.println(count);
                if(board[i][j]==1 && (count<2 || count>3)){ //case 1 & 3
                    board[i][j]=-99; //Sentinent value for initially alive to now dead
                }
                 else if(board[i][j]==0 && count==3){ //case 1 & 2
                    board[i][j]=99; //Sentinent value for initially dead to now alive
                }
            }
        }
            
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]==-99){ //now dead
                    board[i][j]=0;
                }
                else if(board[i][j]==99){ //now alive
                    board[i][j]=1;
                }
            }
        }
    }
                   
    private int count(int[][] board, int i, int j){
        int result = 0;
        int[][] dirs={{-1,-1}, {-1,0}, {-1,1}, {0, -1}, {0,1}, {1,-1}, {1,0}, {1,1}};
        for(int[] dir: dirs){
            int r=i+dir[0];
            int c=j+dir[1];
            if(r>=0 && c>=0 && r<m && c<n && (board[r][c]==1 || board[r][c]==-99)){ result++; }
        }
        
     return result;

    }               
}
                   
