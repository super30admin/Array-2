// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// To check the adjacent elements use a directions array and have bound check to count alive cells . Convert the new cell into any new number apart from 0 and 1 to differentiate old values. Mutate it back to 0 & 1

class Solution {
    public void gameOfLife(int[][] board) {
        // 0->1 = 3
        // 1->0 = 2

        int m = board.length;
        int n = board[0].length;

        for(int i=0;i<m;i++)
            for (int j=0;j<n;j++){
                int count = countAlive(board, i, j);
                if(board[i][j]==1){
                    if(count<2 || count>3)
                        board[i][j] = 2;
                } else{
                    if(count == 3)
                        board[i][j] = 3;
                }
        }

        for(int i=0;i<m;i++)
            for (int j=0;j<n;j++){
                if (board[i][j] == 3) 
                    board[i][j] = 1;
                else if(board[i][j] == 2)
                    board[i][j] = 0;
            }
        
    }

    public int countAlive(int[][] board, int i, int j){
        int[][] dirs = new int[][] {{0,1},{0,-1},{1,0},{-1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
        int count =0;
        int m = board.length;
        int n = board[0].length;

        for(int[] dir:dirs){
            int I = i+ dir[0];
            int J = j+dir[1];

            if(I >=0 && I<m && J>=0 && J<n)
                //need to consider old alive cells
                if(board[I][J] == 1 || board[I][J] == 2 ) count++; 
        }

        return count;
    }
}