// Time Complexity :o(m*n)
// Space Complexity :o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public int m =0;
    public int n =0;
    public void gameOfLife(int[][] board) {
        m = board.length;
        n = board[0].length;
        for(int i =0; i<m; i++)
        {
            for(int j =0; j<n; j++)
            {
                int count = getcount(board, i, j);
                if((board[i][j] == 1) && (count < 2 || count > 3))
                {
                    board[i][j] = 2;
                }
                if(board[i][j] == 0 && count == 3)
                {
                    board[i][j] = 3;
                }
            }
        }
        for(int i =0; i<m; i++)
        {
            for(int j =0; j<n; j++)
            {
                if(board[i][j] == 2)
                    board[i][j] = 0;
                else if(board[i][j] == 3)
                    board[i][j] = 1;
            }
        }
    }
    private int getcount(int[][] arr, int i, int j)
        {
            int[][] dirs = {{0,-1}, {-1,0}, {0, 1}, {1, 0}, {-1,-1}, {-1,1}, {1,1}, {1,-1} };
            int val =0;
            for(int[] dir: dirs)
            {
                int k = i + dir[0];
                int l = j + dir[1];
                if((k >=0 && k<=m-1) && (l>=0 && l<=n-1) && (arr[k][l] == 1 || arr[k][l] == 2))
                    val++;
             }
            return val;
        }
}