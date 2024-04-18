// Time Complexity :O(m*n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


public class GameofLife289 {
   

    // Step1: find 8 directions array
    // Step2:check for the 4 conditions given:0= dead, 1= live
    // 1: 1 live cell with <2 live neighbors -->dies
    // 2: 1 live cell with = 2 or 3 live neighbors -->lives
    // 3: 1 live cell >3 live neighbors -->dies
    // 4: 0 dead cell = 3 live neighbors -->lives
    // no change in all other cases
    // change the state of cells temporarily:
    // -1 if previoulsy alive and now dead
    // 2 if previously dead and now alive
    
    int[][] directions = new int[][] { { -1, 0 }, { -1, -1 }, { 0, -1 }, { 1, -1 }, { 1, 0 }, { 1, 1 }, { 0, 1 },
            { -1, 1 } };// 8 directions array [i][j]

    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int columns = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int neighCnt = findstatusofCell(board, i, j);
                System.out.println("neighCnt: " + neighCnt + " i: (" + i + "," + j + ") ");
                if (board[i][j] == 0) {// only one condition to check for 0. condition 4:
                    if (neighCnt == 3) {// exactly = 3 live neighbors -->lives
                        board[i][j] = 2;// 2=>previously dead and now alive
                    }
                } else {
                    if (neighCnt < 2 || neighCnt > 3) {
                        board[i][j] = -1;//-1 if previoulsy alive and now dead
                    }
                }
               
            }
        }

       // System.out.println(Arrays.deepToString(board));

        // now convert -1 and 2 to 0 and 1 respectively. output is same array with modified 0's and 1's
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 1;

                } else if (board[i][j] == -1) {
                    board[i][j] = 0;

                }

            }
        }
       // System.out.println(Arrays.deepToString(board));

    }

    private int findstatusofCell(int[][] board, int i, int j) {

        int cnt = 0;
        for (int[] dir : directions) {
            int row = i + dir[0];
            int col = j + dir[1];
            // boundary conditions
            // 1: Generated neighbor row and col should be >=0
            // and they shouldnot exeed board row and col length.
            if (row >= 0 && col >= 0 && row < board.length && col < board[0].length) {
                //increase count only if board[row][col] =1 and board[row][col] =-1 (-1 because previosuly it was 1. to track actual data we are considering -1 also.)
                if (board[row][col] == 1 || board[row][col] == -1) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}

// https://youtu.be/uJZ-h9qFXvw