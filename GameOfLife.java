// Time Complexity : O(m * n) m = number of rows, n = number of columns
// Space Complexity : O(1) , we manipulate the input array
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public void gameOfLife(int[][] board) {

        // 1 = neighbors < 2 live cells = dies i.e. 1 -> 0
        // 1 = neighbors == 2 or 3 live cells = lives i.e 1 -> 1
        // 1 = neighbors > 3 live cells = dies i.e. 1 -> 0
        // 0 = neighbors == 3 live cells = lives i.e. 0 -> 1

        //If a live cell dies mark as 2
        //If a live cell dies mark as 3

        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < m; i++) {

            for(int j = 0; j < n; j++) {

                int countNumAlives = countAlive(i, j, board, m, n);
            
                //live cell:- under population
                if(board[i][j] == 1 && countNumAlives < 2) {
                    board[i][j] = 2;
                }

                 //live cell:- over population
                if(board[i][j] == 1 && countNumAlives > 3) {
                    board[i][j] = 2;
                }

                //dead cell:- neighbor has 3 live cells
                if(board[i][j] == 0 && countNumAlives == 3) {
                    board[i][j] = 3;
                }
        }
    }

        //Turn 2 to 1, Turn 3 to 1
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                if(board[i][j] == 2)
                    board[i][j] = 0;
                
                if(board[i][j] == 3)
                    board[i][j] = 1;
            }
        }


}

    public int countAlive(int row, int col, int[][] board, int m, int n) {

        int[][] dirs = new int[][]{{-1,0},{0,1},{1,0},{0,-1},{-1,-1},{-1,1},{1,1},{1,-1}};

        //check all the eight neighbors and count number of live cells
        int count = 0;
        for(int[] dir: dirs) {

            int nr = row + dir[0];
            int nc = col + dir[1];

            if(nr >= 0 && nr < m && nc >= 0 && nc < n && (board[nr][nc] == 1 || board[nr][nc] == 2)) {
                count++;
            }
        }
        
        return count;
    }
}
