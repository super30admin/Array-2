// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

#include <iostream>
#include <vector>

using namespace std;

// iterate through matrix and acc to condition and change the value as 2 or 3 and while re traversing replace 2 by 0 and 3 by 1
using namespace std;

class Solution {
    vector<vector<int>> dir = {{1, -1}, {1, 0}, {1, 1}, {0, -1}, {0, 1}, {-1, -1}, {-1, 0}, {-1, 1}};

public:
    void gameOfLife(vector<vector<int>>& board) {
        int rows = board.size();
        int cols = board[0].size();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int live = 0;

                for (auto d : dir) {
                    int ni = i + d[0];
                    int nj = j + d[1];

                    if (ni < 0 || ni >= rows || nj < 0 || nj >= cols) {
                        continue;
                    }

                    if (board[ni][nj] == 1 || board[ni][nj] == 2) {
                        live++;
                    }
                }

                if (board[i][j] == 1 && (live < 2 || live > 3)) {
                    board[i][j] = 2;
                } else if (board[i][j] == 0 && live == 3) {
                    board[i][j] = 3;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] %= 2;
            }
        }
    }
};