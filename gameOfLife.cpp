// Time Complexity : O(mn)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes


class Solution {
private:
    int getLiveCount(vector<vector<int>>& board, int row, int column){
        //traverses through all the 8 directions and counts the live cells
        //initialise an array to define the 8 directions 

        int count = 0;
        // U D L R UL UR DL DR
        vector<vector<int>> dirs ({{-1,0}, {1,0}, {0,-1}, {0,1}, {-1, -1}, {-1,1}, {1,-1}, {1,1}});

        for(vector<int>each_dir : dirs){
            //get the new block on the grid
            int new_row = row + each_dir[0];
            int new_col = column + each_dir[1];

            //check boundary condition
            //check if its 1 or if it was previously 1 i.e., if it was 3 
            if(new_row >= 0 && new_col >= 0 && new_row < board.size() && new_col < board[0].size() && (board[new_row][new_col] == 1 || board[new_row][new_col] == 3))
            count++;
        }

        return count;
    }
public:
    void gameOfLife(vector<vector<int>>& board) {
        if(board.size() == 0)
            return;
        for(int i=0; i<board.size(); i++){
            for(int j=0; j<board[0].size(); j++){
                int count = getLiveCount(board, i, j);
                //we have 2 cases: the current block is either 0 or 1
                // 0 => 1 we will mark it as 2
                // 1 => 0 we will mark it as 3
                if(board[i][j] == 1){
                    if (count < 2 || count > 3)
                        board[i][j] = 3;
                }
                else {
                    if(count == 3)
                        board[i][j] = 2;
                }
            }
        }

        //now switch back all 2s and 3s to 1s and 0s
        for(int i=0; i<board.size(); i++)
            for(int j=0; j<board[0].size(); j++){
                if(board[i][j] == 2)
                    board[i][j] = 1;
                else if(board[i][j] == 3)
                    board[i][j] = 0;
            }
    }
};