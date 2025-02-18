// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public void gameOfLife(int[][] board) {
        int[] neighbours={0,1,-1};

        int n=board.length;
        int m=board[0].length;
        for(int row=0;row<n;row++){
            for(int col=0;col<m;col++){

                int count=0;
                for(int i=0;i<3;i++){
                    for(int j=0;j<3;j++){
                        if(!(neighbours[i]==0 && neighbours[j]==0)){
                            int r=row+neighbours[i];
                            int c=col+neighbours[j];
                            if((r>=0 && r<n) && (c>=0 && c<m) && Math.abs(board[r][c])==1){
                                count++;
                            }
                        }
                    }
                }

                if(board[row][col]==1 && (count<2 || count>3)){
                    board[row][col]=-1;
                }
                if(board[row][col]==0 && count==3){
                    board[row][col]=2;
                }
            }
        }

        for(int row=0;row<n;row++){
            for(int col=0;col<m;col++){
                if(board[row][col]>0){
                    board[row][col]=1;
                }
                else {
                    board[row][col]=0;
                }
            }
        }
    }
} 
