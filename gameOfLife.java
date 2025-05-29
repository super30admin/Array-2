//if 0->1 put 4 if 1->0 put 5
//replace the 4s and 5s with 1s and 0s at the end
//Time complexity: O(n^2)
//Space complexity: O(1)
class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int count = countAlives(board, i, j);
                if(board[i][j]==1 && (count<2 || count>3)) {
                    board[i][j] = 5;  //1 becomes 0
                }
                if(board[i][j]==0 && count==3) {
                    board[i][j] = 4;  //0 becomes 1
                }
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j]==5) {
                    board[i][j]=0;
                }
                if(board[i][j]==4){
                    board[i][j]=1;
                }
            }
        }
    }

    private int countAlives(int[][] board, int r, int c) {
        int count=0;
        int[][] dirs={{1,-1},{1,0},{1,1},{0,-1},{0,1},{-1,-1},{-1,0},{-1,1}}; //for all directions
        for(int [] dir : dirs) {
            int newRow = r + dir[0];
            int newCol = c + dir[1];
        //check the bounds and if it is alive
            if(newRow>=0 && newRow<board.length && newCol>=0 && newCol<board[0].length && (board[newRow][newCol]==1 || board[newRow][newCol]==5 )) {
                count++;
            }
        }
        return count;
    }

}