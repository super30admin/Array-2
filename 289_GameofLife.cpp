// Time Complexity: O(m * n)
// Space Complexity: O(1)

// Approach in 3 sentences:
// For each cell, count the alive neighbors considering transitional states to decide its next state.
// Mark cells that change state with temporary values to avoid affecting neighbor counts during iteration.
// After processing all cells, convert the temporary marks to their final alive or dead states.

class Solution {
public:
    // if 1 -> 0 = 5
    // if 0 -> 1 = 4
    int countAlives(vector<vector<int>>& board , int i, int j){
        int count=0;
        int directions[8][2] = {
            {-1, 0},  // up
            {1, 0},   // down
            {0, -1},  // left
            {0, 1},   // right
            {-1, -1}, // up-left
            {-1, 1},  // up-right
            {1, -1},  // down-left
            {1, 1}    // down-right
        };

        for(auto dir : directions ){
            int r = i + dir[0];
            int c = j + dir[1];
            if(r >=0 && c >=0 && r < board.size() 
                && c < board[0].size() && (board[r][c] == 1 || board[r][c] == 5))
                count++;
        }
        return count;
    }
    void gameOfLife(vector<vector<int>>& board) {
        
        for(int i=0;i<board.size();i++){
            for(int j=0;j<board[0].size();++j){
                int count = countAlives(board,i,j);
                // 1's < 2 --> 0
                if(board[i][j] == 1 && count < 2)
                    board[i][j] = 5;
                // 1's > 3 --> 0
                else if(board[i][j] == 1 && count > 3)
                    board[i][j] = 5;
                // 10, 1 == 3 --> 1
                else if(board[i][j] == 0 && count == 3)
                    board[i][j] = 4;
            }
        }
        for(int i=0;i<board.size();i++){
            for(int j=0;j<board[0].size();++j){
                if(board[i][j] == 4)
                    board[i][j] = 1;
                if(board[i][j] == 5)
                    board[i][j] = 0;
            }
        }

    }
};
