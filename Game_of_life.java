//time complexity: o(mn)
//space complexity: o(mn)

class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0) return;
        int m = board.length;
        int n = board[0].length;

        // 1-->0 = 3
        //0---1 = 2
        for(int i = 0; i< m; i++){
            for(int j = 0; j<n; j++){
                int countlive = countlives(board, i, j);
                if(board[i][j] == 0){
                    if (countlive == 3){
                        board[i][j] = 2;
                    }
                }
                else{
                    if(countlive < 2){
                        board[i][j] = 3;
                    }
                    if(countlive > 3){
                        board[i][j] = 3;
                    }
                }
            }
        }

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(board[i][j] == 2){
                    board[i][j] = 1;
                }
                else if(board[i][j] == 3){
                    board[i][j] = 0;
                }
            }
        }




        for(int i = 0; i < m; i++){
            for(int j = 0; j<n; j++){
                if(board[i][j] == 2){
                    board[i][j] = 1;
                }
                if(board[i][j] == 3){
                    board[i][j] = 0;
                }
            }
        }
    }

    private int countlives(int [][] board, int r, int c){
        int count = 0;
        int[][] directions =  {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1} };

        for(int[] dir: directions){
            int nr= r + dir[0];
            int nc = c + dir[1];

            if(nr >= 0 && nr < m && nc >= 0 && nc < n && (board[nr][nc] == 1 || board[nr][nc] == 3))
            {
                count++;
            }
        }

        return count;
    }

}