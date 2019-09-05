/**
 * Q. Game of life - https://leetcode.com/problems/game-of-life/
 * 
 * A. Check all the neighbours for each cell and keep the live count of them. Based of the 
 * live count of neighbour mark the cell as dead or alive. In order to get intial state of the cell
 * use different markers i.e 2 for live to dead and 1 for dead to live. Restore the values to 0 and 1
 * based on final markers
 * 
 * Time Complexity - O(nm), Each cell is visited
 * Space Complexity - O(1), In place edits 
 * Runs on leetcode - Yes
 */

class Solution {
    public void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;

        //Array to get all neighbours of a cell
        int[][] directions = { { 1, -1 }, { 1, 0 }, { 1, 1 }, { 0, -1 }, { 0, 1 }, { -1, -1 }, { -1, 0 }, { -1, 1 } };

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int liveCount = 0;
                for (int[] dir : directions) {
                    //Condition to check out of bound
                    if (i + dir[0] < 0 || i + dir[0] >= n || j + dir[1] < 0 || j + dir[1] >= m)
                        continue;
                    
                    //If neighbour is alive then increment the live count
                    if (board[i + dir[0]][j + dir[1]] == 1 || board[i + dir[0]][j + dir[1]] == 2)
                        liveCount += 1;
                }
                //Based on the live count of neigbour mark the cell as dead(2) or alive(3)
                if (board[i][j] == 1 && (liveCount < 2 || liveCount > 3))
                    board[i][j] = 2;
                else if (board[i][j] == 0 && liveCount == 3)
                    board[i][j] = 3;
            }
        }

        //Restore the markings to 1 or 0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 2)
                    board[i][j] = 0;
                if (board[i][j] == 3)
                    board[i][j] = 1;
            }
        }

    }
}