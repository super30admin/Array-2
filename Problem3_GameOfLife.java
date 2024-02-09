// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Create a directional array with 2D array and by adding we can cover all the neighbours
// To indicate the change of live to dead or dead to live
// we have used -1 and -2 respectively to indicate the previous and current states of the cell
// Once the board array is updated, finally update the array with -1 and -2 values to its actual values

public class Problem3_GameOfLife {
    int dirs[][];
    public void gameOfLife(int[][] board) {
                                //top //bottom //left //right //TL      //TR    //BL    //BR
        this.dirs = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}, {-1,-1}, {-1,1}, {1,-1}, {1,1}};
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                int count=countAlive(board, i, j);
                if(board[i][j]==1 && (count<2 || count>3)){
                    board[i][j]=-1; //1->0 == -1
                }
                if(board[i][j]==0 && count==3){
                    board[i][j]=-2; //0->1 == -2
                }
            }
        }
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j]==-1){
                    board[i][j]=0;
                }else if(board[i][j]==-2){
                    board[i][j]=1;
                }
            }
        }
    }

    private int countAlive(int[][] board, int r, int c){
        int count=0;
        for(int[] dir:dirs){
            int rcal = r+dir[0];
            int ccal = c+dir[1];
            if(rcal>=0 && rcal<board.length && ccal>=0 && ccal<board[0].length 
                && (board[rcal][ccal]==1 || board[rcal][ccal]==-1)){
                count++;
            }
        }
        return count;
    }
}
