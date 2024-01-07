//289. Game of Life


/*
The conditions boils down to only two:
1 changes to 0 when under/over populated
0 changes to 1 when alive neigbours are 3

So, for 1 change to 0, put as 2 when alive neigbours count is greater 3 or less than 2
for 0 change to 1, put as 3 when alive neigbours are 3 exact

Then loop through matrix, change 2 to 0 and 3 to 1, to get output matrix.


Time complexity: O(m*n)
Space complexity: O(1)
*/


class Solution {
public:
    int countAlive(vector<vector<int>>& board, int i, int j) {
        vector<vector<int>> dir = {{0, -1},  {0, 1},  {-1, 0}, {1, 0},
                                   {-1, -1}, {-1, 1}, {1, 1},  {1, -1}};
        int ret = 0;
        for (auto d : dir) {
            int nr = i + d[0];
            int nc = j + d[1];

            // check boundaries and alive neighbors
            if (nr >= 0 && nc >= 0 && nr < board.size() &&
                nc < board[0].size() &&
                (board[nr][nc] == 1 || board[nr][nc] == 2)) {
                ret++;
            }
        }

        return ret;
    }
    
    void gameOfLife(vector<vector<int>>& board) {

        int m = board.size();
        int n = board[0].size();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int count = countAlive(board, i, j);
                // 1->0 ==> 2
                if (board[i][j] == 1 && (count < 2 || count > 3))
                    board[i][j] = 2;
                // 0->1 ==> 3
                if (board[i][j] == 0 && count == 3)
                    board[i][j] = 3;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2)
                    board[i][j] = 0;
                if (board[i][j] == 3)
                    board[i][j] = 1;
            }
        }
    }
};