/**
 * Idea: Brute force - follow conditions as mentioned in problem
 * Time Complexity : O(n)
 * Space Complexity : O(n) - buffer matrix
 * Leetcode : Yes 
 */

class GameOfLife {
    public int getNumberOfLiveNeighbors(int[][] board, int i, int j){
        int count = 0;
        int m = board.length-1;
        int n = board[0].length-1;
        
        if(j > 0 && board[i][j-1] == 1) count++;
        if(j < n && board[i][j+1] == 1) count++;
        if(i < m && board[i+1][j] == 1) count++;
        if(i > 0 && board[i-1][j] == 1) count++;
        if(i < m && j < n && board[i+1][j+1] == 1) count++;
        if(i < m && j > 0 && board[i+1][j-1] == 1) count++;
        if(i > 0 && j < n && board[i-1][j+1] == 1) count++;
        if(i > 0 && j > 0 && board[i-1][j-1] == 1) count++;

        return count;
    }
    public void gameOfLife(int[][] board) {
        int[][] resultBoard = new int[board.length][board[0].length];

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){                
                // condition 4
                if(board[i][j] == 0){
                    int numberOfNeighbours = getNumberOfLiveNeighbors(board, i, j);
                    if(numberOfNeighbours == 3){
                        resultBoard[i][j] = 1;
                    }
                }
                else{
                    int numberOfNeighbours = getNumberOfLiveNeighbors(board, i, j);
                    if(numberOfNeighbours < 2 || numberOfNeighbours > 3){
                        resultBoard[i][j] = 0;
                    }
                    else{
                        resultBoard[i][j] = 1;
                    }
                }

                
            }           
        }

        for(int i=0;i<resultBoard.length;i++){
            for(int j=0;j<resultBoard[0].length;j++){
                board[i][j] = resultBoard[i][j];
            }            
        }
    }
    public static void main(String[] args){
        System.out.println("Game Of Life");
        int[][] board = {
            {0,1,0},
            {0,0,1},
            {1,1,1},
            {0,0,0}
        };

        GameOfLife obj = new GameOfLife();
        obj.gameOfLife(board);
    }
}