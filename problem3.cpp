// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// We modify the matrix in place to make sure we dont use auxilliary space, and we check how many neighbors are live cells for each element
// Live cells which die are denoted with 2 and dead cells which are alive are denoted by 3 (temporary state change)
// Once we finish the simulation, we flip the 2s to 0s and the 3s to 1s

class Solution {
private:
    vector<vector<int>> dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}, {-1, 1}, {1,1}, {-1,-1}, {1, -1}}; // right, left, up, down, top right, bottom right, top left, bottom left
    int countAlives(vector<vector<int>>& board, int r, int c) {
        int m = board.size();
        int n = board[0].size();
        int count = 0;
        for(auto& dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if(nr >=0 && nr < m && nc >= 0 && nc < n && (board[nr][nc] == 1 || board[nr][nc] == 2)) { // bounds check + consider alive cells which are now dead (2's)
                count++;
            }
        }
        return count;
    }
public:
    void gameOfLife(vector<vector<int>>& board) {
        int m = board.size(); int n = board[0].size();
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                int aliveCount = countAlives(board, i, j);
                if(board[i][j] == 0 && aliveCount == 3) { // dead to alive
                    board[i][j] = 3;
                }
                if(board[i][j] == 1 && (aliveCount > 3 || aliveCount < 2)) {  // alive to dead
                    board[i][j] = 2;
                }
            }
        }
        // 3 = originally dead, now alive
        // 2 = originally alive, now dead
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == 2) { // alive cells which are now dead
                    board[i][j] = 0;
                }
                if(board[i][j] == 3) { // dead cells which are now alive
                    board[i][j] = 1;
                }
            }
        }
    }
};