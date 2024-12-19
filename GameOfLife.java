/*
    Leetcode problem 289: Game of Life
    T.C: O(m * n) :: S.C: O(1) - Updating the gird in place

    Solved using linear traversal  of the given matrix, there are four conditions to be
    taken care of when traversing. If a live cell has < 2 or > 3 live neighbors then the
    cell dies we can mark this as 2 as we need to consider this cell for the surrounding
    neighbors in the same iteration. 
    
    Next if a dead cell has exactly 3 live neighbors it becomes alive we can mark it with 3 
    as it's not alive yet, for live cells with 2 or 3 live neighbors we leave them as it is. 
    
    In the end mark all 2's as 0 and 3's as 1.
    
    Note: DFS or BFS solution can also be used as the matrix has connected components.
*/

class Solution {
    int m, n;
    int[][] dirs = { {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1} };

    public void gameOfLife(int[][] board) {

        if (board == null || board.length == 0) return;

        m = board.length;
        n = board[0].length;        

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //check the live neighbors for current cell
                int liveCells = countLiveCells(board, i, j);

                System.out.println(liveCells);

                if (board[i][j] == 1) { //Cell is alive
                    if (liveCells < 2 || liveCells > 3) { //Case 1 & 3
                        board[i][j] = 2;
                    } else { //Case 2
                        //Do Nothing
                    }
                } else { //Cell is dead
                    if (liveCells == 3) { //Case 4
                        board[i][j] = 3;
                    }
                }                 
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) { //Cell becomes dead
                    board[i][j] = 0;
                } else if (board[i][j] == 3) { //Cell becomes live
                    board[i][j] = 1;
                } else {
                    //Do Nothing
                }
            }
        }

    }

    private int countLiveCells(int[][] board, int i, int j) {
        int count = 0; //Count of live neighbors for the current cell

        for (int[] dir: dirs) {
            int r = i + dir[0];
            int c = j + dir[1];

            if (r >= 0 && c >= 0 && r < m && c < n) {
                if (board[r][c] == 1 || board[r][c] == 2) {
                    count++;
                }
            }
        }

        return count;
    }
}