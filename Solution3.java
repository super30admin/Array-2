//Game of Life
//Ran on leetcode: Yes
//TC: O(m * n) SC: O(1)
/*
For each cell check the number of live elements around it and then apply rules:
1 -> 0 if less than two live neighbors, 1 -> 0 if more than three live neighbors, 0 -> 1 if exactly three live neighbors
1 -> 0 can be represented by 5, 0 -> 1 can be represent by 6
*/
class Solution3 {

    private static final int[][] directions = {{1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}, {0, -1}, {1, -1}};

    public void gameOfLife(int[][] board) {
        // 1 -> 0 if less than two live neighbors
        // 1 -> 0 if more than three live neighbors
        // 0 -> 1 if exactly three live neighbors
        // 1 -> 0 can be represented by 5
        // 0 -> 1 can be represent by 6

        int rowLen = board.length;
        int colLen = board[0].length;

        for(int i = 0; i < rowLen; i++){
            for(int j = 0; j < colLen; j++){
                int totalLiveNeigh = countLiveNeigh(board, i, j);
                if(totalLiveNeigh < 2 && board[i][j] == 1){ // 1 -> 0 if less than two live neighbors
                    board[i][j] = 5; // 1 -> 0 can be represented by 5
                } else if(totalLiveNeigh > 3 && board[i][j] == 1){ // 1 -> 0 if more than three live neighbors
                    board[i][j] = 5; // 1 -> 0 can be represented by 5
                } else if(totalLiveNeigh == 3 && board[i][j] == 0){ // 0 -> 1 if exactly three live neighbors
                    board[i][j] = 6; // 0 -> 1 can be represent by 6
                }
            }
        }

        for(int i = 0; i < rowLen; i++){
            for(int j = 0; j < colLen; j++){
                if(board[i][j] == 5){ // 1 -> 0 can be represented by 5
                    board[i][j] = 0;
                } else if(board[i][j] == 6){ // 0 -> 1 can be represent by 6
                    board[i][j] = 1;
                }
            }
        }

    }

    // count number of live neighbors
    private int countLiveNeigh(int[][] board, int rowIdx, int colIdx){
        int count = 0;
        // count number of live neighbors in all 8 directions
        for(int[] direction: directions){
            int cell = 0;
            if( // boundry edge case check
            (rowIdx + direction[0] >= 0 
            && rowIdx + direction[0] < board.length 
            && colIdx+direction[1] >= 0 
            && colIdx+direction[1] < board[0].length)){
                cell = board[rowIdx + direction[0]][colIdx+direction[1]];
                if(cell == 5 || cell == 1){ // 1 -> 0 can be represented by 5
                    count++;
                }
            }
        }
        return count;
    }
}