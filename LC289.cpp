// Time complexity O(m*n)
// Space complexity O(1)

class Solution {
    int forward(vector<vector<int>>& board, int i, int j, int m, int n) {
        const vector<int> rows = {-1, -1, -1, 0, 1, 1, 1, 0};
        const vector<int> cols = {-1, 0, 1, 1, 1, 0, -1, -1};
        int count = 0;
        
        for (int k = 0; k < 8; ++k) {
          int ni = i + rows[k];
          int nj = j + cols[k];
          if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
            if (board[ni][nj] % 2 == 1) {
              count++;
            }
          }
        }

        // dead to alive = 2
        // alive to dead = 3
        if (board[i][j] % 2 == 1) {
          if (count < 2 || count > 3) {
            return 3;
          } else  {
            return 1;
          }                       
        } else {
          if (count == 3) {
            return 2;
          } else {
            return 0;
          }
        }
    }

    int backward(int val) {
        if (val == 1 || val == 2) {
          return 1;
        }
        else {
          return 0;
        }
    }

public:
    void gameOfLife(vector<vector<int>>& board) {
        int m = board.size();
        int n = board[0].size();

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                board[i][j] = forward(board, i, j, m, n);
            }
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                board[i][j] = backward(board[i][j]);
            }
        }
    }
};
