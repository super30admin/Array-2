/*
* Approach:
*  1. Mark the modified states in the same input array as below:
       prev  new  coded
       0     1    2
       1     0    3
* 
*  2. Check the directions using directions array and 
        check & update the states based on the given rules.
*   
        While checking for live count, 
            consider 1s and 3s as well.

*  3. Finally, convert coded states into new states.
* 
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(m*n)
        m -> rows, n-> cols
* 
* Space Complexity: O(1)
* 
*/

public class GameofLife {
    int[][] directions = new int[][] {
            { 0, 1 },
            { 0, -1 },
            { 1, 0 },
            { -1, 0 },
            { 1, 1 },
            { 1, -1 },
            { -1, 1 },
            { -1, -1 }
    };

    private int getLiveCount(int[][] board, int row, int col) {
        int m = board.length;
        int n = board[0].length;

        int count = 0;

        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if (newRow >= 0 && newRow < m
                    && newCol >= 0 && newCol < n
                    && (board[newRow][newCol] == 1
                            || board[newRow][newCol] == 3)) {
                count++;
            }
        }

        return count;
    }

    public void gameOfLife(int[][] board) {

        int m = board.length, n = board[0].length;

        // Prev New Coded
        // 0 1 2
        // 1 0 3

        for (int indexI = 0; indexI < m; indexI++) {
            for (int indexJ = 0; indexJ < n; indexJ++) {
                int liveCount = getLiveCount(board, indexI, indexJ);

                if (board[indexI][indexJ] == 1 &&
                        (liveCount < 2 || liveCount > 3)) {
                    board[indexI][indexJ] = 3;
                }

                if (board[indexI][indexJ] == 0
                        && liveCount == 3) {
                    board[indexI][indexJ] = 2;
                }
            }
        }

        for (int indexI = 0; indexI < m; indexI++) {
            for (int indexJ = 0; indexJ < n; indexJ++) {
                if (board[indexI][indexJ] == 2)
                    board[indexI][indexJ] = 1;

                if (board[indexI][indexJ] == 3)
                    board[indexI][indexJ] = 0;
            }
        }
    }
}
