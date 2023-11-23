// Time Complexity : O(N^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Go throught each element in the 2d array count the number of ones and apply the
//rules to update the value. If the value changes from 0 to 1 update it as 2 , if it
//changes from 1 to 0 update it as 3. Using two different values help us to
//keep track of the past state and update accordingly
class Problem3 {
    public void gameOfLife(int[][] board) {

        int m = board.length;
        int n = board[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int num = countNoOfLiveNigh(board,i,j,m,n);
                if(board[i][j] == 1  && (num>3 || num<2)){
                    board[i][j] = 2;
                } else if(board[i][j] == 0 && num == 3){
                    board[i][j] = 3;
                } else {
                    board[i][j] = board[i][j];
                }
            }
        }

        for(int i=0; i<m ;i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 2)
                    board[i][j] = 0;
                else if(board[i][j] == 3)
                    board[i][j] = 1;
            }
        }
    }

    private int countNoOfLiveNigh(int[][]board,int i,int j, int m, int n){
        int[][] dirArr = {{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
        int counter = 0;
        for(int[]dir : dirArr){
            int row = i + dir[0];
            int col = j + dir[1];
            if(row>=0 && col>=0 && row<m && col<n && (board[row][col] == 1 ||board[row][col] == 2))
                counter++;
        }
        return counter;
    }
}