/*
# T.C => O(m * n)
# S.C => O(1)  Since we did in place changes
#approach => In this approach we are traversing throug all the neighbouring elements of an element.
 if the neighbouring elements have value(1) which are less than 2 and greater then 3 we can replace the current value with 2, and if neighbouring elements count upto 3 we change current value to 3.
  Then in the next pass we change the value of 2 to 0 and the 3 to 1.
 To compute the neighbouring elements 1 add upto 3 or less than 2 or greater then 3 we made a countLives function. Where there is dir 2 array which goes through all the neighbouring elements.

*/


class Solution {
    int m;
    int n;
    public void gameOfLife(int[][] board) {
    if(board == null || board.length == 0){
        return;
    }
     m = board.length;
     n = board[0].length;
    for(int i =0 ; i<m ;i++){
        for(int j =0 ;j<n ;j++){
            int relatLives = relatives(board,i,j);
            if(board[i][j] == 1){
                if(relatLives >3 || relatLives < 2){
                    board[i][j] = 2;
                }
            }else{
                if(relatLives == 3){
                    board[i][j] = 3;
                }
            }
        }     
    }
    for(int k =0 ; k< m; k++){
        for(int l =0 ; l<n ; l++){
           if(board[k][l] == 2){
               board[k][l] =0;
           }else if(board[k][l] == 3){
                board[k][l] =1;
           }
        }
    }
    }
    
    int relatives(int[][] board, int row, int column){
        int dirs[][]= {{-1, 0},{1,0},{
            0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}} ;       
            int count = 0;
        for(int[] dir : dirs){
            int nr = row+dir[0];
            int nc = column+dir[1];
        if(nr >= 0 && nr < m && nc >=0 && nc < n && (board[nr][nc] == 1 || board[nr][nc] == 2  )){
            count++;
        }
        }
        return count;
    }
       
}
