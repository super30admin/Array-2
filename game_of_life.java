// Time Complexity : O(n*m) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public void gameOfLife(int[][] board) {
         if(board==null || board.length==0) return ;
        
        //State changes 
        //1 --> 0 // 3
        //0 --> 1 //2
        
        int m = board.length;
        int n = board[0].length;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                //we will count lives first for each cell
                int countLives = countLives(board,i,j,m,n);
                //1-> 0 state change, if count>3 or count<2 then we represent this as 3 for future cells count
                if(board[i][j]==1 &&(countLives>3 || countLives<2)){
                    board[i][j]=3;
                }
                 //0 -> 1 state change, if count==3 then we represent this as 2 for  future cells count
                else if(board[i][j]==0 && countLives==3){
                    board[i][j]=2;
                }
            }
        }
        //changing states appropriately
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==3) board[i][j]=0;
                else if(board[i][j]==2) board[i][j]=1;
            }
        }
    }
    
    private static int countLives(int[][] board,int i,int j,int m,int n){
        int result =0;
        //Let's takes list of all possible pairs of directions - 8 overall
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,-1},{1,-1},{-1,1}};
        //we have element corresponding row, column value as i,j and m,n as matrix size which we can use for checking outerbounds
        for(int[] dir: dirs){//for all possible neighbourhoods
            int r=i+dir[0];
            int c=j+dir[1];
            if(r>=0 && r<m && c>=0 && c<n &&(board[r][c]==1 || board[r][c]==3)){
                result++;
            }
        }
        return result;
    }
}
