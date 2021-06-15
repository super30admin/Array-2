// Time Complexity : O(m * n)
// Space Complexity : O(1)

class Solution {
    public void gameOfLife(int[][] board) {
        for(int i = 0; i < board.length;i++)
            for(int j = 0;j < board[0].length;j++){
                int count = neighbourCount(board,i,j);
                // 1 to 0 -> 2
                if(board[i][j] == 1 && (count < 2 || count > 3))
                    //under-population or over-population
                    board[i][j] = 2;
                //0 to 1 -> 3
                if(board[i][j] == 0 && count == 3)
                    // dead cell with 3 live neighbours becomes live
                    board[i][j] = 3;
            }
        //change 2 to 0 and 3 to 1
        for(int i = 0; i < board.length;i++)
            for(int j = 0;j < board[0].length;j++){
                if(board[i][j] == 2)
                     board[i][j] = 0;
                 if(board[i][j] == 3)
                     board[i][j] = 1;
            }
    }
    
    public int neighbourCount(int[][] board,int i, int j){
        int[][] neighbours = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        int count = 0;
        for(int[] arr:neighbours){
            int m = i + arr[0];
            int n = j + arr[1];
            //check for both 1 and 2, as 1 to 0 -> 2
            if(m >= 0 && m < board.length && n >= 0 && n < board[0].length && (board[m][n] == 1 || board[m][n] == 2))
                count++;
        }
        return count;
    }
}