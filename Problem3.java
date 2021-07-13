// Time Complexity :O(M*N) where M is length of row and N is length of column
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :Yes

//TC:O(M*N) where M is length of row and N is length of column
//Sc:O(1)
class Solution {
    public void gameOfLife(int[][] board) {
        if(board==null||board.length==0||board[0].length==0) return;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                int alive=neighbours(i,j,board);
                //if its alive
                if(board[i][j]==1||board[i][j]==-2){
                    if(alive<2||alive>3) board[i][j]=-2;
                }
                //if its dead
                else{
                    if(alive==3) board[i][j]=-1;
                }

            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==-2)board[i][j]=0;
                else if(board[i][j]==-1)board[i][j]=1;
            }
        }
    }



    private int neighbours(int i,int j,int [][] board){
        int [][]dirs=new int[][]{{0,1},{1,0},{-1,0},{0,-1},{1,1},{-1,1},{1,-1},{-1,-1}};
        int count=0;
        for(int[] d:dirs){
            int r=d[0]+i;
            int c=d[1]+j;
            if(r>=0&&r<board.length&&c>=0&&c<board[0].length){
                if(board[r][c]==1||board[r][c]==-2) count++;
            }
        }
        return count;
    }
}