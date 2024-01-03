/*
 * Time Complexity : O(n x m)
 * Space Complexity : O(1)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
*/

#include <vector>

class Solution {
    int countAlive(std::vector<std::vector<int>>& board, int i, int j) {
        const int dirs[8][2] = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}, {-1, -1}, {-1, 1}, {1, 1}, {1, -1}};
        int count = 0;
        for (const auto &dir : dirs) {
            int nr = i + dir[0];
            int nc = j + dir[1];

            if (nr >= 0 && nc >= 0 && nr < board.size() && nc < board[0].size()
                && (board[nr][nc] == 1 || board[nr][nc] == 2)) {
                    count++;
            }
        }

        return count;
    }
public:
    void gameOfLife(std::vector<std::vector<int>>& board) {
        const int will_die = 2, will_live = 3;
        int n = board.size(), m = board[0].size();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int alive_neighbors = countAlive(board, i, j);

                if (board[i][j] == 1 && (alive_neighbors < will_die || alive_neighbors > will_live)) {
                    // Mark the cell as dead
                    board[i][j] = will_die;
                } else if (board[i][j] == 0 && alive_neighbors == will_live) {
                    // Mark the cell as alive
                    board[i][j] = will_live;
                }
            }
        }

        // Update the board to the next state
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                } else if (board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }
};