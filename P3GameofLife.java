// Before class 
// Time Complexity : O(n^2)
// Space Complexity : O(mxn)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// looping over the board with 2 for loops with some if and else cases for the edges as the comparison cases changes for every edges
// added an extra check if length of m or n becomes 1 since the traversing the array is quite different in that case

class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        if(m==1 && n==1) {
            board[0][0] = 0;
            return;
        }
        if(m==1) {
            int[] arr = new int[n];
            for(int i=1;i<n;i++){
                if(i<n-1 && board[0][i] == 1 && board[0][i-1] == 1 && board[0][i+1] == 1){
                    arr[i] = 1;
                }
            }
            for(int i=0;i<n;i++){
                board[0][i] = arr[i];
            }
            return;
        }
        if(n==1){
            int[][] res = new int[m][n];
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(i==0){
                        res[i][j] = 0;
                    }else if(i==m-1){
                        res[i][j] = 0;
                    }else if(board[i][j] == 1){
                        if(board[i-1][j] == 1 && board[i+1][j] == 1){
                            res[i][j] = 1;
                        }
                    }
                }
            }
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    board[i][j] = res[i][j];
                }
            }
            return;
        }
        int[][] result = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int neighbors = 0;
                if(j==0){
                    if(i==0){
                        neighbors = board[i][j+1] + board[i+1][j+1] + board[i+1][j];
                    }else if(i==m-1){
                        neighbors = board[i-1][j] + board[i-1][j+1] + board[i][j+1];
                    }else{
                        neighbors = board[i-1][j] + board[i-1][j+1] + board[i][j+1] + board[i+1][j+1] + board[i+1][j];
                    }
                }else if(i==0){
                    if(j==n-1){
                        neighbors = board[i+1][j] + board[i+1][j-1] + board[i][j-1]; 
                    }else{
                        neighbors = board[i][j+1] + board[i+1][j+1] + board[i+1][j] + board[i+1][j-1] + board[i][j-1];
                    }
                }else if(j==n-1){
                    if(i==m-1){
                        neighbors = board[i][j-1] + board[i-1][j-1] + board[i-1][j];
                    }else{
                        neighbors = board[i+1][j] + board[i+1][j-1] + board[i][j-1] + board[i-1][j-1] +board[i-1][j];
                    }
                }else if(i==m-1){
                    neighbors = board[i][j-1] + board[i-1][j-1] + board[i-1][j] + board[i-1][j+1] + board[i][j+1];
                }else{
                    neighbors = board[i-1][j] + board[i-1][j+1] + board[i][j+1] + board[i+1][j+1] +board[i+1][j] +board[i+1][j-1]+board[i][j-1]+board[i-1][j-1];
                }

                if(board[i][j] == 0 && neighbors == 3){
                    result[i][j] = 1;
                }else if(board[i][j] == 1){
                    if(2<=neighbors && neighbors <=3){
                        result[i][j] = 1;
                    }
                }
            }
        }
        for(int i =0;i<m;i++){
            for (int j=0;j<n;j++){
                board[i][j] = result[i][j];
            }
        }
        
    }
}