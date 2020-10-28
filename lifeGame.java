//Time Complexity: O(m*n) 
//Space Complexity: O(1)
//Program ran successfully
/*
    Algorithm: 1. The problem is solved by linearly scanning all 8 neighbours of each element
               2. The tricky part was to solve it in-place. 
               3. The cells that change their states are assigned some values 
               4. In the end, those states are retrieved. 
*/
class lifeGame {
    public void gameOfLife(int[][] board) {
        //edge cases
        //1 --> 0 3
        //0 --> 1 2
        if(board.length == 0 || board == null) return;
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int live = findLive(board, i, j);
                if((board[i][j] == 1) && (live < 2 || live > 3)){
                    board[i][j] = 3;
                }
                else if((board[i][j] == 0) && live == 3){
                    board[i][j] = 2;
                }  
            }
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 2) {
                    board[i][j] = 1;   
                }
                if(board[i][j] == 3) {
                    board[i][j] = 0;   
                }
            }
        }
    }
    private int findLive(int[][] board, int i , int j){
        int count = 0;
        int[][] dirs = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
        for(int[] dir: dirs){
            int row = i + dir[0];
            int col = j + dir[1];
            if(row >= 0 && row < board.length && col >= 0 && col < board[0].length && (board[row][col] == 1 || board[row][col] == 3)){
                count++;
            }
        }
        return count;
    }
}
