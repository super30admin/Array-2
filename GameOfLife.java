// Time Complexity : O(n * m) n,m are dimensions of board
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Find the count of live for each neighbour.
//We can use delta array to reduce code size
// So as to save space we will update the current board matrix itself
//If transition is from 0-1 we mark it as 2 and consider it as 0 for rest element in neibhour calculations.
//If transition is from 1-0 we will mark it as -1 and consider it as 1 for rest element in neibhour calculations.
//We will finally change the board members with 2 and -1 to 1 and 0.
class Solution {
    int delta[][] = {
        {-1,-1},
        {-1,0},
        {-1,1},
        {0,-1},
        {0,1},
        {1,-1},
        {1,0},
        {1,1}
        
    };
    public int findcountLive(int[][]board, int i, int j){
        int count = 0;
        int n = board.length;
        int m = board[0].length;
        for(int k = 0; k < delta.length; k++){
            int x =i+delta[k][0];
            int y =j+delta[k][1];
            if(x>=0 && x<n && y>=0 && y<m){
                if(board[x][y] == 1 || board[x][y] == -1)
                    count++;
            }
        }
        return count;
    }
    public void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                count = findcountLive(board, i, j);
                if(board[i][j] == 1 || board[i][j] == -1){
                     if(count < 2 || count > 3)
                         board[i][j] = -1; 
                    }
                else{
                    if(count == 3)
                        board[i][j] = 2;
            }
            }
        }  
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == -1)
                    board[i][j] = 0;
                if(board[i][j] == 2)
                    board[i][j] = 1;
            }
        }
    }
}
    