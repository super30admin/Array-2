//Accepted on LT
// Have A directions array
//Check for all cases on each i,j and if index goes out of bound dont consider that
//Time should be 0(mn) and space is constant

class Solution {
    public void gameOfLife(int[][] board) {

        int[][] directions = {
            {-1, 0},
            {-1, -1},
            {0, -1},
            {1, -1},
            {1, 0},
            {1, 1},
            {0, 1},
            {-1, 1}
        };
        int m = board.length;
        int n = board[0].length;
        //1->0 = 2
        //0->1 = 3
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int counter = 0;
                for (int[] direction : directions) {
                    int newRow = i + direction[0];
                    int newCol = j + direction[1];
                    if(newRow>=0 && newCol>=0 && newRow<m && newCol <n){
                        if(board[newRow][newCol]==1 || board[newRow][newCol]==2){
                            counter++;
                        }
                    }

                
                
                }
                System.out.println(counter);

                if(counter<2 && board[i][j]==1){

                    board[i][j] = 2;
                }
                else if(counter==3 && board[i][j]==0){

                    board[i][j] = 3;
                }
                if(counter>3 && board[i][j]==1){
                    board[i][j] = 2;
                }
                
   
            }
           
        }
        

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

                if(board[i][j]==2){
                    board[i][j]=0;
                }
                else if(board[i][j]==3){
                    board[i][j]=1;
                }
               
            }
            
        }

        
    }
}