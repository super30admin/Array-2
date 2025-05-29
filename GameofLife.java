//Problem 289 - Game of Life
//Solved on leetcode and faced no issues
//Time complexity : O(mn) + O(mn) = O(2mn) ~= O(mn) , Space complexity : O(1)
//Approach is included in comments below




class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length; //number of rows
        int n = board[0].length; //number of columns
        int[][] directions = { {0, 1},   // right neighbour
        {0, -1},  // left neighbour
        {-1, 0},  // up neighbour
        {1, 0},   // down neighbour
        {1, 1},   // bottom-right neighbour
        {1, -1},  // bottom-left neighbour
        {-1, 1},  // top-right neighbour
        {-1, -1}  // top-left neighbour 
        };
        //first pass : for converting 0's and 1's to 5 and 4
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                int liveneighbours = neighbour(board,i,j);
                if(board[i][j] == 1) { //if a cell is live 
                    if(liveneighbours < 2 || liveneighbours > 3){  //rule 1 or 3 ->cell dies
                        board[i][j] = 5; //cell from live to dead transition is marked as 5 (it can be any number other than 0 & 1)
                    }
                    else if(liveneighbours == 2 || liveneighbours == 3){ //rule 2
                        board[i][j] = 1;
                    }

                }
                else if(board[i][j] == 0){ // if a cell is dead
                    if(liveneighbours == 3){ //rule 4 -> cell becomes live
                        board[i][j] =4; //cell from dead to live transition is marked as 4 (it can be any number other than 0 & 1)
                    }
                }

            }
        }
        
        //second pass for converting back 5 & 4 to 0,s and 1's.
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(board[i][j] == 5) {board[i][j] = 0;}
                if(board[i][j] == 4) {board[i][j] = 1;}
            }
        }


        
    }
    private int neighbour(int[][] board , int i , int j){
        int[][] directions = { {0, 1},   // right neighbour
        {0, -1},  // left neighbour
        {-1, 0},  // up neighbour
        {1, 0},   // down neighbour
        {1, 1},   // bottom-right neighbour
        {1, -1},  // bottom-left neighbour
        {-1, 1},  // top-right neighbour
        {-1, -1}  // top-left neighbour 
        };
        int count = 0; //initially count of liveneighbour is 0
        for(int[] dir : directions){
            int neighbourrow = i + dir[0]; //row index of neighbour
            int neighbourcolumn = j + dir[1]; //column index of neighbour
            if(neighbourrow>=0 && neighbourrow < board.length && neighbourcolumn >=0 && neighbourcolumn< board[0].length && (board[neighbourrow][neighbourcolumn] == 1 || board[neighbourrow][neighbourcolumn] == 5)){
                count++;
            }

        }
        return count;

    }


        
}
