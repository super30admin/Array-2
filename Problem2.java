// Time Complexity : O(M * N) M => no of rows in board, N => no of cols in board 
// Space Complexity : O(M * N) (same)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// Calculating live neighbours for each cell
// calculating whether the cell will live or die in the next generation
// copying values in the board from the created nextGenBoard 

class Solution {
    public void gameOfLife(int[][] board) {
        int ROWS = board.length;
        int COLS = board[0].length;
        int[][] nextGenBoard = new int[ROWS][COLS];

        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {
                int liveNeighborCount = getLiveNeighborsCount(board, r, c);
                boolean aliveInCurrGen = board[r][c] == 1;
                boolean aliveInNextGen = isAliveInNextGen(liveNeighborCount, aliveInCurrGen);
                nextGenBoard[r][c] = aliveInNextGen ? 1 : 0;
            }
        }
        
        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {
                board[r][c] = nextGenBoard[r][c];
            }
        }
    }
    
    private boolean isAliveInNextGen(int liveNeighborCount, boolean aliveInCurrGen) {
        if(liveNeighborCount < 2 || liveNeighborCount > 3) 
            return false;
        // 2 dead => dead
        // 3 dead => alive
        if(!aliveInCurrGen)
            return liveNeighborCount == 3;
        // 3 alive => alive
        // 2 alive =>  alive
        return true;
    }
    
    private int getLiveNeighborsCount(int[][] board, int r, int c) {
        int ROWS = board.length;
        int COLS = board[0].length;
        int liveNeighborCounter = 0;   
        
        // top left = r-1, c-1
        if(r-1 >= 0 && c-1 >= 0 && board[r-1][c-1] == 1) liveNeighborCounter++;
        // top = r-1, c
        if(r-1 >= 0 && board[r-1][c] == 1) liveNeighborCounter++;
        // top right = r-1, c+1
        if(r-1 >= 0 && c+1 < COLS && board[r-1][c+1] == 1) liveNeighborCounter++;        
        // right = r, c+1
        if(c+1 < COLS && board[r][c+1] == 1) liveNeighborCounter++;
        // bottom right = r+1, c+1
        if(r+1 < ROWS && c+1 < COLS && board[r+1][c+1] == 1) liveNeighborCounter++;
        // bottom = r+1, c
        if(r+1 < ROWS && board[r+1][c] == 1) liveNeighborCounter++;
        // bottom left = r+1, c-1
        if(r+1 < ROWS && c-1 >= 0 && board[r+1][c-1] == 1) liveNeighborCounter++;
        // left = r, c-1
        if(c-1 >= 0 && board[r][c-1] == 1) liveNeighborCounter++;

        return liveNeighborCounter;
    }
}