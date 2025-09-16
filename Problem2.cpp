// Problem - Game of life
//  Time Complexity : O(m*n)
//  Space Complexity : O(1)
//  Did this code successfully run on Leetcode : Yes
//  Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1. By navigating the matrix and then if the current element is 1 and
// aliveCount < 2 or aliveCount > 3,
// we mark the element as 2 (alive to dead state)
// 2. Similarly we mark element as 3 if current element is going from dead to
// alive
// 3. Then in the end, we reverse 2 to 3, to their new states 2 -> 0 and 3 -> 1

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  int countAlive(vector<vector<int>> &board, int row, int col) {
    int m = (int)board.size();
    int n = (int)board[0].size();
    int count = 0;
    vector<pair<int, int>> dirs = {{0, 1},  {0, -1},  {1, 0}, {-1, 0},
                                   {-1, 1}, {-1, -1}, {1, 1}, {1, -1}};
    for (auto dir : dirs) {
      int nr = row + dir.first;
      int nc = col + dir.second;
      if (nr >= 0 && nr < m && nc >= 0 && nc < n &&
          (board[nr][nc] == 1 || board[nr][nc] == 2)) {
        count++;
      }
    }

    return count;
  }

  void gameOfLife(vector<vector<int>> &board) {
    int m = (int)board.size();
    int n = (int)board[0].size();

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        int alives = countAlive(board, i, j);
        if (board[i][j] == 1 && (alives < 2 || alives > 3)) {
          // 1 becomes 0
          board[i][j] = 2;
        }
        if (board[i][j] == 0 && alives == 3) {
          // 0 becomes 1
          board[i][j] = 3;
        }
      }
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == 2) {
          board[i][j] = 0;
        }

        if (board[i][j] == 3) {
          board[i][j] = 1;
        }
      }
    }
  }
};
