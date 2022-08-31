// Time Complexity :O(m*n) where m is the number of rows and n is the number of columns 
// Space Complexity :O(1) using no extra space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class GameOfLife {

    int m;
    int n;
    int dirs[][];

    public void gameOfLife(int[][] board) {
        m = board.length;
        n = board[0].length;

        //null check
        if(board ==  null || board.length == 0)
            return;

        //direction array of arrays
        dirs = new int [][]{{0,1},{0,-1},{-1,0},{1,0},{1,1},{-1,-1},{-1,1},{1,-1}};

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){

                int countAlive = countAlive(board,i,j);

                if(board[i][j] == 0 && countAlive == 3){
                    board[i][j] = 2;
                }

                if(board[i][j] == 1 && (countAlive < 2 || countAlive >3)){
                    board[i][j] = 3;
                }
            }
        }

        for(int i = 0 ; i < m ; i++){
            for(int j = 0; j < n ; j++){

                //it was initially alive, now became dead --> we marked with 3 --> now change to result value as 0
                if(board[i][j] == 3)
                    board[i][j] = 0;

                //it was initially dead, now became alive --> we marked with 2 --> now change to result value as 1
                if(board[i][j] == 2)
                    board[i][j] = 1;
            }
        }
    }

    private int countAlive(int[][] board, int i, int j){
        int result = 0;

        for(int[] dir : dirs){
            int new_row = i + dir[0];
            int new_col = j + dir[1];

            if(new_row >= 0 && new_col >= 0 && new_row < m && new_col <n && (board[new_row][new_col] == 1 || board[new_row][new_col] == 3))
                result++;
        }
        return result;
    }
}

