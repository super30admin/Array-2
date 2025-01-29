// Game of Life
// Time Complexity : O(mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Approach
// We have to record the state if we consider the same matrix. for 0->1 state we'll mark as 2 and 1->0 state we'll mark as 3.
// We shouldn't change directly 0 & 1 as we need all neighbours for later calculations.
// Then will follow 4 rules mentioned in the ques & to count live neighbours will create a static array & helper function to check these directions.

class Solution {
private:
    // TC = O(m * n)
    // SC = O(1)
    int m, n;
    vector<vector<int>> dirs{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1,1}};
    //                           R        L       B       T       TL          TR      BL      BR
    int countAlive(vector<vector<int>>& board, int i, int j) {
        int result = 0;
        for(auto dir: dirs) {
            int nr = i + dir[0]; // neighboring row
            int nc = j + dir[1]; // neighboring col
            if(nr >= 0 && nc >= 0 && nr < m && nc < n && (board[nr][nc] == 1 || board[nr][nc] == 3))
                result++;
        }
        return result;
    }
public:
    void gameOfLife(vector<vector<int>>& board) {
        m = board.size();
        n = board[0].size();
        //null
        if(m == 0 || n == 0) return;
        // 0 -> 1 = 2   
        // 1 -> 0 = 3
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int alive = countAlive(board, i, j);
                // cell death condition
                if(board[i][j] == 1 && (alive < 2 || alive > 3))
                    board[i][j] = 3;
                // cell alive condition
                if(board[i][j] == 0 && alive == 3)
                    board[i][j] = 2;
            }
        }
        // replacing 2 & 3 with 0 & 1
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 3) board[i][j] = 0;
                if(board[i][j] == 2) board[i][j] = 1;
            }
        }
    }
};