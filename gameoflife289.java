// Time Complexity : O(M*N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    /*
    1
     less than 2 "1s" -> 0
     is still 1 2 | 3 "1s"  > 1
     more than 3 "1s" > 0

     0
     3 "1s" > 1

     Direction vectors
    -1 -1  -10 -11
      0-1  00  01
      1,-1  10  11
    */
    int[] dx = new int[]{-1,-1,-1,0,1,1,1,0};
    int[] dy = new int[]{-1,0,1,1,1,0,-1,-1};
    public void gameOfLife(int[][] board) {
        if(board == null || board.length==0) return;
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                int count = getZeroOneNeighbourCount(i,j, board);
                if(board[i][j] == 1){
                    if(count < 2 || count > 3){
                        board[i][j] = -1;
                    }
                }
                else{
                    if(count == 3){
                        board[i][j] = 2;
                    }
                }
            }
        }
        for(int i =0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if(board[i][j] == -1){
                    board[i][j] = 0;
                }
                else if(board[i][j] == 2){
                    board[i][j] = 1;
                }
            }
        }
    }
    public int getZeroOneNeighbourCount(int x, int y, int[][]board){
        int count = 0;
        for(int k = 0;k<dx.length;k++){
            int i = dx[k]+x;
            int j = dy[k]+y;
            if(isValid(i,j, board)){
                if(board[i][j] == 1 || board[i][j] == -1){
                    count++;
                }
            }

        }
        return count;
    }
    public boolean isValid(int i, int j, int[][] board){
        return i>=0 && i<board.length && j>=0 && j<board[0].length;
    }



}
