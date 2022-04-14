class GameOfLife {

    // Time Complexity : 0(m*n) where m is the elements in the row and n is elements in column
// Space Complexity :0(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


    // Your code here along with comments explaining your approach:1st I am checking the adjacent neighbors around the given
    //index to count the no. of alive cells. If the alive cells are less than 2 and greater than 3, then if the present cell
    //is alive it will die. Else if the present cell is dead and the alive adjacent cells is equal to 3 then the state is
   //changed to alive. Also I am using numbers 2 and 3 if state changes from alive to dead or dead to alive. In this way
   //I don't have to use any extra space and later after the computation is done, I can simply change 2 & 3 back to it's
   //respective values.

    int rowlength;
    int columnlength;
    public void gameOfLife(int[][] board) {
        rowlength = board.length;
        columnlength = board[0].length;
        //1->0 === 2;   0->1 ===3
        for(int i = 0; i < rowlength; i++){
            for(int j =0; j < columnlength; j++){
                int Alive = livecell(board, i, j);
                if(board[i][j] == 1 ){
                    if(Alive < 2 || Alive > 3 ){
                        board[i][j] = 2;
                    }
                }
                else{
                    if(Alive == 3){
                        board[i][j] = 3;
                    }
                }
            }
        }
        for(int i = 0; i < rowlength; i++){
            for(int j = 0; j < columnlength; j++){
                if(board[i][j] == 2){
                    board[i][j] = 0;
                }
                else if(board[i][j] == 3){
                    board[i][j] = 1;
                }
            }
        }
    }
    public int livecell(int [][] board, int i, int j){
        int[][] direction = new int[][] {{1,1},{1,-1},{-1,1},{-1,-1}, {0,1},{1,0},{-1,0},{0,-1}};
        int total = 0;
        for(int [] dir: direction){
            int newrow = i + dir[0];
            int newcolumn = j + dir[1];
            if(newrow >=0 && newrow < rowlength && newcolumn >= 0 && newcolumn < columnlength && (board[newrow][newcolumn] == 1 || board[newrow][newcolumn] == 2)){
                total++;
            }
        }
        return total;
    }
}