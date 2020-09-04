// Time Complexity : o(n*m) n is the number of rows and m is the number of columns
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

//To maintain same space, consider state 1->0 as 4 and 0->1 as 2

class GameOfLife {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0){
            return;
        }
        
        int n =board.length, m= board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                //get the count of the neighbors that are alive
                int neiAlive = getAliveNeighbors(board, n, m, i, j);
                //once we get the count, apply the conditions as per the question
                //if alive and has less than 2 or greater than 3 alive neighbors , then state changes to dead( code 4: 1->0) 
                if(board[i][j] == 1 && (neiAlive<2 || neiAlive >3)){ 
                    board[i][j] = 4;
                    //if dead and has exactly 3 alive neighbors , then state changes to alive( code 2: 0->1) 
                }else if(board[i][j] == 0 && neiAlive==3){
                    board[i][j] = 2;
                }
            }
        }
        
        //Replace the code back to the changed states
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == 2){
                    board[i][j] = 1;
                }else if(board[i][j] == 4){
                    board[i][j] = 0;
                }
            }
        }
        
    }
    
    private int getAliveNeighbors(int[][] board, int n , int m, int i, int j){
        //these are the directions to travel with row and columns indices to get to all the neighbors
        int[][] dirs = {{-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}, {1,-1}, {0,-1}, {-1,-1}};
        int count =0;
        //for each direction, get the row and column of the neighbor, check if the neighbor is alive and update the count if alive
        for(int[] dir : dirs){
            int r = i+dir[0];
            int c = j+dir[1];
            //To check if the neighbor is alive, we need to check if the neighbor has value 1 or coded value 4.
            //coded value 4 also means that the neighbors initial state is 1
            if(r>=0 && r<n && c>=0 && c<m &&(board[r][c]==1 || board[r][c]==4)){ 
                count++;
            }
        }
        return count;
    }
}