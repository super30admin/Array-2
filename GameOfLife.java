// Time Complexity : O(8*m*n) = O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//By traversing the matrix and findinhg the number of live neighbours at each cell and also Marking live to dead by 2 and dead to live by 3. And then at the replacing all the twos with 0 and threes with 1.

class Solution {
    int n, m;
    public void gameOfLife(int[][] board) {
        if(board==null||board.length==0)
            return;
        n = board.length;
        m = board[0].length;
        for(int r =0;r<n;r++){
            for(int c =0;c<m;c++){
                int live = getCount(board,r,c);
                if(board[r][c]==1){
                    if(live<2||live>3)
                        board[r][c] = 2;
                }
                else{
                    if(live==3)
                        board[r][c] = 3;
                }
            }
        }
        for(int r =0;r<n;r++){
            for(int c =0;c<m;c++){
                if(board[r][c]==2)
                    board[r][c]=0;
                else if(board[r][c]==3)
                    board[r][c]= 1;
            }
        }
    }
    private int getCount(int[][]board, int r, int c){
        int [][] dirs = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        int count = 0;
        for(int[]dir:dirs){
            int rn = dir[0]+r;
            int cn = dir[1]+c;
            if(rn>=0&&cn>=0&&rn<n&&cn<m){
                if(board[rn][cn]==1||board[rn][cn]==2)
                    count++;
            }
        }
        return count;
    }
}