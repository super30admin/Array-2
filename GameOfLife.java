// Time Complexity : O(m*n) where  m*n is size of the array
// Space Complexity : O(1) not extra auxiliary space used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*Approach
 * Problem can be solved pretty easily using extra matrix. Approach over here is to solve the problem without using
 * extra space. We will be updating the existing array to hold the temporary state in a way which will help us to
 * compute the next state. So for 1 --> 0 change we use 3 AND  for 0 --> 1 change we use 2
 * */

public class GameOfLife {

    int m,n;

    public void gameOfLife(int[][] board) {

        if(board == null || board.length==0) return;
        m = board.length;
        n = board[0].length;

        //for 1 --> 0 we use 3
        //for 0 --> 1 we use 2

        for(int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                // the the count of the live neighbours
                int liveCount = getLiveCount(board, i, j);
                //if the position is live and satisfy rule 1 Or rule 3
                // set the value to 3
                if(board[i][j]==1 && (liveCount<2 || liveCount>3)){
                    board[i][j] = 3;
                }
                //if the position is dead and satisfy rule 4 then
                // set the value to 2
                if(board[i][j]==0 && liveCount==3){
                    board[i][j] = 2;
                }
            }
        }
        //replace the value 3 to 0 and value 2 to 1
        for(int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if(board[i][j] == 2) board[i][j] = 1;
                if(board[i][j] == 3) board[i][j] = 0;
            }
        }
    }

    private int getLiveCount(int[][] board, int i, int j) {

        ////helpful in manipulating and getting neighbours
        int dirs[][] = {{-1,0}, {0,1}, {1,0}, {0,-1}, {-1,-1}, {1,-1}, {-1,1}, {1,1}};
        int count = 0;
        for(int dir[] : dirs){
            int nr = i+dir[0];
            int nc = j+dir[1];
            if(nr>=0 && nr<m && nc>=0 && nc<n && (board[nr][nc]==1 || board[nr][nc]==3)){
                count++;
            }
        }
        return count;
    }
}
