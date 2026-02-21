// Time Complexity : O(m * n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
We create a function to basically check all neighbours at 8 directions(if applicable) and apply the given
problem's rules of live and dead cell count for each entry in the board.To make sure we are not counting
recently alive or ignoring recently dead cells, we mark them with 2 and 3 and later revert them in-place
to their actual states in the board.
 */
class Solution {
    private int[][] dirs = new int[][]{{0, 1} , {1, 0} , {0, -1} , {-1, 0}, {-1, -1}, {-1, 1}, {1, 1}, {1, -1}};

    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                checkIfAlive(board, m , n, i , j);
            }
        }
        // 1 -> 2 (previous alive, now dead)
        // 0 -> 3 (previous dead, now alive)
        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(board[i][j] == 2)
                    board[i][j] = 0;
                else if(board[i][j] == 3)
                    board[i][j] = 1;
            }
        }
    }

    private void checkIfAlive(int[][] board, int m, int n, int i , int j) {
        int countLiveCell = 0;
        for(int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if(x < 0 || y < 0 || x > m - 1 || y > n - 1)
                continue;
            if(board[x][y] == 1 || board[x][y] == 2)
                countLiveCell++;
        }
        if(board[i][j] == 0 && countLiveCell == 3)
            board[i][j] = 3;
        else if(board[i][j] == 1 && (countLiveCell < 2 || countLiveCell > 3)) {
            board[i][j] = 2;
        }
    }

}