/*

Problem 3 : (https://leetcode.com/problems/game-of-life/)

Time Complexity : O(n*m)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes

*/

class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length==0){
            return;
        }

        int n = board.length;
        int m = board[0].length;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int nbr = getNeighbor(board, i, j);

                if(board[i][j] == 1){
                    if(nbr < 2 || nbr > 3){
                        board[i][j] = 2;
                    }
                }
                else{
                    if(nbr == 3){
                        board[i][j] = 3;
                    }
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] == 2){
                    board[i][j] = 0;
                }
                else if(board[i][j] == 3){
                    board[i][j] = 1;
                }

            }
        }

    }

    private int getNeighbor(int[][] board, int i, int j){
        int[][] dirs = new int[][]{{-1,-1}, {-1,0}, {-1,1}, {0,-1}, {0,1}, {1,-1}, {1,0}, {1,1}};
        int n = board.length;
        int m = board[0].length;
        int count = 0;
        for(int[] dir : dirs){
            int r = i + dir[0];
            int c = j + dir[1];
            if( r >= 0 && r < n && c >= 0 && c < m){
                if(board[r][c] == 1 || board[r][c] == 2){
                    count++;
                }
            }
        }

        return count;

    }
}