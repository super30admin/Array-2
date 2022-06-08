// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class GameOfLife {
    public void gameOfLife(int[][] board) {
        
        int[][] directions = {{1,0},{0,1},{1,1},{-1,-1},{-1,0},{0,-1},{1,-1},{-1,1}};
        
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                int alives = 0;
                for(int[] dir : directions){
                    int row = i+dir[0];
                    int col = j+dir[1];
                    if((row>=0 && row<board.length) && (col>=0 && col<board[0].length)){
                        if(board[row][col]==1 || board[row][col]==3)
                            alives++;
                    }
                }
                                
                if(board[i][j]==1){
                    if(alives>3 || alives<2)
                        board[i][j]=3;
                }else{
                    if(alives==3)
                        board[i][j]=2;
                }
            }
        }
        
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(board[i][j]==3)
                    board[i][j] = 0;
                
                if(board[i][j]==2)
                    board[i][j] = 1;
            }
        }

    }
}
