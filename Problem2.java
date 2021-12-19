//time o(mn)
//space o(1)

class Solution {
    public void gameOfLife(int[][] board) {
        
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                int sum = neighborSum(board,i,j);
                if(board[i][j] == 0) {
                    if(sum == 3)
                        board[i][j] = 3;
                } else {
                    if(sum < 2 || sum > 3)
                        board[i][j] = 4;
                }
            }
        }
        
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j] == 4)
                    board[i][j] = 0;
                else if(board[i][j] == 3)
                    board[i][j] = 1;
            }
        }
    }
    
    private int neighborSum(int[][] board, int row, int col) {
        int[][] vals = {{-1,-1},{-1,0},{-1,1},{1,-1},{1,0},{1,1},{0,-1},{0,1}};
        int sum = 0;
        for(int i=0; i<vals.length; i++) {
            int rowTemp = row + vals[i][0];
            int colTemp = col + vals[i][1];
            if((rowTemp >= 0 && rowTemp <=board.length-1) && (colTemp >= 0 && colTemp <= board[0].length-1)) {
                int val = board[rowTemp][colTemp];
                if(val == 3)
                    val = 0;
                else if(val == 4)
                    val = 1;
                sum = sum + val;
            }
        }
        return sum;
    }
}
