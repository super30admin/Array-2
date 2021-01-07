// Time Complexity : 0(m*n)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : Yes

class GameOfLife {
    public void gameOfLife(int[][] board) {

        if(board == null || board.length == 0)
            return;
        if(board[0].length == 0)
            return;

        //1 --> 2
        //0 --> 3
        int m = board.length, n = board[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int count = countNeighbours(board, m, n, i, j);
                //rule 1, 3
                if(board[i][j] == 1 && (count < 2 || count > 3))
                    board[i][j] = 2;

                    //rule 4
                else if(board[i][j] == 0 && count == 3)
                    board[i][j] = 3;
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == 3)
                    board[i][j] = 1;
                if(board[i][j] == 2)
                    board[i][j] = 0;
            }
        }
    }

    public int countNeighbours(int[][] board, int m, int n, int i, int j){
        int count = 0;
        int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}, {1,1}, {-1,-1}, {1,-1}, {-1,1}};

        for(int[] dir : dirs){
            int r = i + dir[0];
            int c = j + dir[1];
            if(r>=0 && c>=0 && r<m && c<n && (board[r][c] == 1 || board[r][c] == 2)){
                count++;
            }
        }

        return count;
    }
}