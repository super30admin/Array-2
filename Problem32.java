// Time Complexity - O(M*N) where M*N is the matrix size
// Space Complexity - O(1)

// Approach:
//     Make a direction array containg all the directions i.e. 8 dircetions (Diagonals included)
//     Loop through the board and see if i or j goes out of bound for any addition of direction coordinate to given i & j.
//     This way checks for the neigbours values and do computation as per the problem statement.

class Solution {
    public void gameOfLife(int[][] board) {
        int[][] directions = {{1,0}, {1,1}, {0,1}, {-1,0}, {-1,1}, {-1,-1}, {0,-1},{1,-1}};
        
        for(int i = 0; i<board.length; i++){
            for(int j =0; j<board[0].length; j++){
                int live = 0;
                for(int[] dir : directions){
                    if(i+dir[0]<0 || i+dir[0]>=board.length || j+dir[1]<0 || j+dir[1]>=board[0].length){
                    continue;    
                    } 
                    else if(board[i+dir[0]][j+dir[1]] == 1 || board[i+dir[0]][j+dir[1]] == 3){
                        live++;
                    }
                }
                //New value - Not Alive
                if(board[i][j] == 1 && (live<2 || live>3)) board[i][j] = 3;
                //New Value - Make Alive
                else if(board[i][j] == 0 && live==3) board[i][j] = 2;
            }
        }
        
        //Looping through the board to update the board
        for(int i = 0; i<board.length; i++){
            for(int j =0; j<board[0].length; j++){
                if(board[i][j] == 3) board[i][j] = 0;
                else if(board[i][j] ==2 ) board[i][j] = 1;
            }
        }
    }
}