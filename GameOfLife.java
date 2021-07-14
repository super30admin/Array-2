//Time Complexity : O(m*n)
//Space Complexity : O(1) as the operation is in-place

// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach
class Solution {
    int row ,col;
    //helper function to count number of live cells
    public int countLives(int[][] board,int rows, int cols){
        //using direction array. In the worst case, a cell will have 8 neighobours
        //{0,1} indicates same row, next column
        int[][] dir = {{0,1},{0,-1},{-1,0},{1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
        int count=0;
        //for each neighoubor check the live cell and count
        for(int[] dirs : dir){
            //determine the row and col of the neighbour using dirs array
            int r = rows + dirs[0];
            int c = cols + dirs[1];
            if(r>=0 && c>=0 && r<row && c<col && (board[r][c] == 1 || board[r][c]==2)){
                count++;
            }
        }
        return count;
    }
    public void gameOfLife(int[][] board) {
        if(board==null||board.length==0){
            return;
        }
        row = board.length;
        col = board[0].length;
        int countlive = 0;//count of number of live neighbours
        //1-->0 denoted as 3
        //0-->1 denoted as 2
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                countlive = countLives(board, i, j);//helper function to get the count of live cells
                //if the value is 1 check if it has live neighbours less than 2 or greater than 3
                if(board[i][j]==1 && (countlive < 2 || countlive > 3)){
                    //if so convert it to 0 by changing the state to 2
                    board[i][j] = 2;
                }
                //if the value is 0 check if it has live neighbours exactly equal to 3
                if(board[i][j]==0 && (countlive ==3)){
                    //  //if so convert it to 1 by changing the state to 3
                    board[i][j] = 3;
                }
            }
        }
        //revert back the 2's and 3's back to their original state
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]==2){
                    board[i][j] = 0;
                }
                if(board[i][j]==3){
                    board[i][j] = 1;
                }
            }
        }
    }
}