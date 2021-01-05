// Time Complexity : The time complexity is O(m*n) where n is the number of rows and n is the number of columns.
// Space Complexity : The space complexity is O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public void gameOfLife(int[][] board) {

        int rows = board.length;
        int columns = board[0].length;

        for(int i=0;i<rows;i++){

            for(int j=0;j<columns;j++){

                int count_1 = 0;

                // Go to all the 8 neighbours
                for(int k=i-1;k<=i+1;k++){

                    for(int l=j-1;l<=j+1;l++){

                        if(k>=0 && k<rows && l>=0 && l<columns){
                            // count the number of alive states
                            if(board[k][l] == 1 || board[k][l] == 3){
                                count_1++;
                            }
                        }

                    }
                }

                if(board[i][j] == 1 || board[i][j] == 3) {count_1--;}

                // Update the current state based on the number of alive states around
                if(board[i][j] == 1 || board[i][j] == 3){
                    if(count_1<2 || count_1>3){
                        board[i][j] = 3;
                    }
                }
                else{
                    if(count_1 == 3){
                        board[i][j] = 2;
                    }
                }
            }
        }

        // Next state
        for(int i=0;i<rows;i++){

            for(int j=0;j<columns;j++){

                if(board[i][j] == 2){
                    board[i][j] = 1;
                }
                else if(board[i][j] == 3){
                    board[i][j] = 0;
                }
            }
        }

    }
}