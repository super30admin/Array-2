//  Time complexity: O(8mn)
//  Space Complextiy: O(1)
class Solution {
    int dir[][];
    public void gameOfLife(int[][] board) {
        this.dir = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}, {-1,-1}, {-1,1}, {1,-1}, {1,1}};

        int m = board.length;
        int n = board[0].length;

        for(int i=0; i< m; i++){
            for(int j=0; j<n; j++){
                int liveNeighbors = getLiveNeighbors(board, i, j, m, n);
                if(board[i][j] == 1){
                    if(liveNeighbors < 2 || liveNeighbors > 3){
                        board[i][j] = 2;           // 2 means die
                    }
                }else{
                    if(liveNeighbors == 3){
                        board[i][j] = 3;           // 3 means live
                    }
                }
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 2) board[i][j] = 0;
                else if(board[i][j] == 3) board[i][j] = 1;
            }
        }     
    }

    private int getLiveNeighbors(int board[][], int i, int j, int m, int n){
        int count = 0;

        for(int[] d: dir){
            int r = i + d[0];
            int c = j + d[1];
            if(r >= 0 && c >= 0 && r <m && c <n && (board[r][c] == 1 || board[r][c] == 2)) count++;  
        }
        return count;
    }


}