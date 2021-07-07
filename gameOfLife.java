// Time Complexity : O(m*n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : partial, worked for the given matrix.
// Any problem you faced while coding this : No

class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0){		// Base Case
            return;
        }
        
        if(board.length == 1){			// edge case
            board[0][0] = 0;
            return;
        }
        
        int temp = 0;
        int m = board.length;		// get the length of the row and column
        int n = board[0].length;
        int[][] out = new int[m][n];	// temporary array is created to store the next state value before updating
        int i = 0;
        
        for(int j = 0; j < m; j++){		// traversing through every element in the matrix
            for(int k = 0; k < n; k++){
                if(j == 0){
                    if(k == 0){		// left corner case
                        temp = board[j+1][k] + board[j][k+1] + board[j+1][k+1];
                        out = output(board, out, j, k, temp);
                    }
                    else if(k == n - 1){	// right corner case
                        temp = board[j+1][k] + board[j][k-1] + board[j+1][k-1];
                        out = output(board, out, j, k, temp);
                    }else{				// middle columns
                        temp = board[j][k-1] + board[j][k+1] + board[j+1][k] + board[j+1][k+1]                                + board[j+1][k-1];
                        out = output(board, out, j, k, temp);
                    }
                }
                else if(j == m - 1){
                    if(k == 0){			// left corner case
                        temp = board[j][k+1] + board[j-1][k+1] + board[j-1][k];
                        out = output(board, out, j, k, temp);
                    }
                    else if(k == n - 1){		// right corner case
                        temp = board[j][k-1] + board[j-1][k-1] + board[j-1][k];
                        out = output(board, out, j, k, temp);
                    }
                    else{		// middle columns
                        temp = board[j][k-1] + board[j][k+1] + board[j-1][k] + board[j-1][k+1]                                + board[j-1][k-1];
                        out = output(board, out, j, k, temp);
                    }
                }
                else{
                    if(k == 0){		// left corner case
                        temp = board[j-1][k] + board[j-1][k+1] + board[j][k] + board[j+1][k+1]                                + board[j+1][k];
                        out = output(board, out, j, k, temp);
                    }else if( k == n - 1){	// right corner case
                        temp = board[j-1][k] + board[j-1][k-1] + board[j][k-1] + board[j+1][k-                               1]+ board[j+1][k];
                        out = output(board, out, j, k, temp);
                    }else{		// middle rows
                    temp = board[j][k-1] + board[j][k+1] + board[j-1][k] + board[j-1][k+1]                                + board[j-1][k-1] + board[j+1][k] + board[j+1][k+1] + board[j+1][k-                             1];
                    out = output(board, out, j, k, temp);
                    }
                }
            }
        }
        for(int j = 0; j < m; j++){		// update all the values to the next state
            for(int k = 0; k < n; k++){
                board[j][k] = out[j][k];
                //System.out.print(out[j][k]);
            }
            //System.out.println();
        }
    }
    
    
    private int[][] output(int[][] board, int[][]out, int j, int k, int temp){		// helper function to decide the condition of the next state
        if(board[j][k] == 1 && temp < 2){
            out[j][k] = 0;
        }else if(board[j][k] == 1 && (temp == 2 || temp == 3)){
            out[j][k] = 1;
        }else if(temp > 3){
            out[j][k] = 0;
        }else if(board[j][k] == 0 && temp == 3){
            out[j][k] = 1;
        }
        return out;
    }
}