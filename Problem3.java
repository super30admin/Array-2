Time Complexity: O(mn)
Space Complexity: Constant
Ran successfully on leetcode?: yes

class Solution {
    private int m,n;
    public void gameOfLife(int[][] board) {
        
        m = board.length;
        n = board[0].length;
        
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                int liveNeighbors = calculateLiveNeighbors(board, i,j);
                if(liveNeighbors < 2 && board[i][j] == 1){
                    board[i][j] = 2;
                } else if((liveNeighbors == 2 || liveNeighbors == 3) && board[i][j] == 1){
                    board[i][j] = 1;
                } else if(liveNeighbors > 3 && board[i][j] == 1){
                    board[i][j] = 2;
                } else if(liveNeighbors == 3 && board[i][j] == 0){
                    board[i][j] = 3;
                }
            }
        }
        
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if(board[i][j] == 2)
                    board[i][j] = 0;
                else if(board[i][j] == 3)
                    board[i][j] = 1;
            }
        }
    }
    
    private int calculateLiveNeighbors(int[][] board, int a, int b){
        int[][] directions = {{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
        int countNeighbors = 0;
        
        for(int i = 0; i < directions.length; ++i){
            int x = a + directions[i][0];
            int y = b + directions[i][1];
            if( x >= 0 && x < m && y >= 0 && y < n){
                if(board[x][y] == 1 || board[x][y] == 2){
                    countNeighbors++;
                }
            }
        }
        return countNeighbors;
    }
}
