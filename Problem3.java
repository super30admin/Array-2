// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes


// Your code here along with comments explaining your approach
//calculated the number of live elements using the directions array and udpating the board matrix based on the conditions

class Solution {
    int[][] dirs;
        int m;
        int n;
    public void gameOfLife(int[][] board) {
         m = board.length;
         n = board[0].length;
        // right left up down upleft upright downleft downright
        dirs = new int[][]{{0,1}, {0,-1},{-1,0},{1,0}, {-1,1} ,{-1,-1},{1,-1},{1,1}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int count = countAlive(board,i,j);
                if((board[i][j] == 1 ||board[i][j] ==2) && (count<2 || count>3)){
                    board[i][j] = 2;
                }
                if(board[i][j] == 0 && count ==3){
                    board[i][j] = 3;
                }
            }
        }
        System.out.println(Arrays.deepToString(board));
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                 if(board[i][j] == 2){
                     board[i][j] = 0;
                 }
                if(board[i][j] == 3){
                     board[i][j] = 1;
                 }
            }
        }

    }

    private int countAlive(int[][] board, int i, int j){
        int count = 0;
        for(int[] dir:dirs){
            int r = i+dir[0];
            int c = j+dir[1];
            if((r>=0 && c>=0 && r<m && c<n) && (board[r][c] == 1 ||board[r][c] ==2)){
                count++;
            }
        }
        return count;
    }


}