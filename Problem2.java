//289. Game of Life
/**
 * 3 Pointer Approach:
 * Brute force => Create another matrix of same soze and use actual matrix to update that and return.
 * 
 * Implemented approach:
 * 1. Traverse all nodes and check in all 8 possible directions for elements.
 * 2. compute current node new value as per given rules of game.
 * 3. The challange is to read previous values which may get modify, to counter this created following rules
 *    if state change 0 => 1 : 10
 *    if state change 1 => 0 : -10
 * 4. while reading nodes take care of above rules, i.e if a node is 10 consider it as 0.
 * 5, After all computations iterate over matrix and update with proper values for -10 and 10.
 * 
 */
//
// time Complexity :
// O(M*N)

// Space Complexity :
// O(1)

// Did this code successfully run on Leetcode : YES.
// Any problem you faced while coding this : NO.

class Solution {
    public void gameOfLife(int[][] board) {

        // Rules
        // 1. <2 dies
        // 2. ==2 ==3 survives
        // 3. >3 dies
        // 4. dead -> life ==3

        // eight directions;

        int[][] dir = { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 }, { 1, 1 }, { -1, 1 }, { -1, -1 }, { 1, -1 } };

        // int[][] dir = new int{[0,-1]};
        // int[][] a = {{1,1}};

        // state change 0 => 1 : 10
        // state change 1 => 0 : -10

        int rlen = board.length, clen = board[0].length;

        for (int row = 0; row < rlen; row++) {

            for (int col = 0; col < clen; col++) {

                int cnt = 0;

                for (int[] d : dir) {

                    int r = row + d[0];
                    int c = col + d[1];

                    if (r >= 0 && r < rlen && c >= 0 && c < clen) {

                        if (board[r][c] == 1 || board[r][c] == -10) {
                            cnt++;
                        }
                    }

                }

                if (cnt < 2 && board[row][col] == 1)
                    board[row][col] = -10;
                else if (cnt > 3 && board[row][col] == 1)
                    board[row][col] = -10;
                else if (cnt == 3 && board[row][col] == 0)
                    board[row][col] = 10;

            }
        }

        for (int row = 0; row < rlen; row++) {

            for (int col = 0; col < clen; col++) {

                if (board[row][col] == -10)
                    board[row][col] = 0;
                else if (board[row][col] == 10)
                    board[row][col] = 1;
            }
        }
    }

}