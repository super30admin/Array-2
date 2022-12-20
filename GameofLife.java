//Tc : o(mn)
//sc : o(1)
//https://leetcode.com/problems/game-of-life/
class Solution {
    int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0},{-1,1},{1,1},{1,-1},{-1,-1}};
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int live = getLive(board,i,j);
                if(board[i][j] == 0 && live == 3 ){
                    board[i][j] = 2;
                }
                if(board[i][j] == 1 && (live < 2 || live >3)){
                    board[i][j] = 3;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == 2)
                    board[i][j] = 1;
                else if(board[i][j] == 3)
                    board[i][j] = 0;
            }
        }
    }
    private int getLive(int[][] board, int i, int j){
        int count = 0;
        int m = board.length;
        int n = board[0].length;
        for(int[] dir : dirs){
            int r = i + dir[0];
            int c = j + dir[1];
            if(r >= 0 && c >= 0 && r < m && c < n && (board[r][c] ==1 || board[r][c] ==3)){
                count++;
            }
        }
        return count;
    }
}
