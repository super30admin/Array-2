// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

class Solution {
    int row;
    int col;

    //1--> 0 ---> 3 ; 3 represents it was alive earlier but will become dead again
//0--> 1 ---> 2 ; 2 represents it was dead earlier but will become live again
    public void gameOfLife(int[][] board) {

        if(board == null || board.length ==0)
            return;
        row = board.length;
        col = board[0].length;
        for(int i =0; i<row;i++){
            for(int j =0; j<col; j++){
                int liveCellNeigbour = countLives(board,i, j);
                if(board[i][j]==1){
                    //Rule : 1 & 3
                    if(liveCellNeigbour>3 || liveCellNeigbour<2)
                        board[i][j] = 3 ;
                        //Rule : 2
                    else if(liveCellNeigbour==2 || liveCellNeigbour == 3)
                        board[i][j] = 1;
                }else{
                    //Rule :  4
                    if(liveCellNeigbour==3 && board[i][j]==0)
                        board[i][j] = 2;
                }
            }
        }

        //Making the 3 as dead and 2 as lives
        for(int i =0; i<row;i++){
            for(int j =0; j<col; j++){
                if(board[i][j] == 3){
                    board[i][j] = 0;
                }else if(board[i][j] ==2)
                    board[i][j] = 1;
            }
        }
    }

    public int countLives(int[][] board , int i, int j){
        //For traversing in 8 directions
        //+- values for moving right,left,top,bottom, leftTop Dia, rightTop dia, leftDown Dia, rightDown dia
        int[][] directions = {{0,1},{0,-1},{-1,0},{1,0},{-1,-1},{-1,1},{1,-1},{1,1}};

        int countLiveOnes = 0;
        for(int dir[] : directions){
            int r = i + dir[0];
            int c = j + dir[1];
            if(r<row && c<col && r>=0 && c>=0 && (board[r][c]==1 || board[r][c]==3)){
                countLiveOnes++;
            }
        }
        return countLiveOnes;
    }
}