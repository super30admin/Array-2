// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int findLiveNeighbors(vector<vector<int>>& board, int i, int j, int m, int n) {
        vector<vector<int>> dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}, {-1,-1}, {1,1}, {-1,1}, {1,-1}};
        int count = 0;
        for (int k=0; k<dirs.size(); k++){
            int nr = i + dirs[k][0];
            int nc = j + dirs[k][1];

            if (nr<m && nr >=0 && nc >=0 && nc < n && (board[nr][nc] == 1 || board[nr][nc] == -1)) count++;
        }
        return count;
    }
    void gameOfLife(vector<vector<int>>& board) {
        // 0 to 1 == 2 
        // 1 to 0 == -1
        int m = board.size();
        int n = board[0].size();
        for (int i=0; i<m; i++) {
            for (int j = 0; j<n;j++) {
                int live = findLiveNeighbors(board, i, j, m,n);
                if (board[i][j] == 1 && (live <2 || live >3)){
                    board[i][j] = -1;
                }
                if (board[i][j] == 0 && live == 3) board[i][j] = 2;
            }
        }

        for (int i=0; i<m; i++) {
            for (int j = 0; j<n; j++) {
                if (board[i][j] == -1) board[i][j] = 0;
                if (board[i][j] == 2) board[i][j] = 1;
            }
        }
    }
};