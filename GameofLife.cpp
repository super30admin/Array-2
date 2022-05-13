// Time Complexity : log(board width x board height)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


class Solution {
public:
    void gameOfLife(vector<vector<int>>& board) {
        //for changing 1 to zero indicated by 8
        //for changing 0 to one indicated by 9
        vector<vector<int>> dir = {{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
        for(int i=0;i<board.size();i++) {
            for(int j=0;j<board[0].size();j++) {
                int counter = 0;
                for(auto &d : dir) {
                    int row = i + d[0];
                    int col = j + d[1];
                    if(row >= 0 && col >= 0 && row < board.size() && col < board[0].size() && (board[row][col] == 1 || board[row][col] == 8)) {
                        counter++;
                    }
                }
                if(counter < 2 && board[i][j] == 1) {
                    board[i][j] = 8;
                } else if(counter > 3 && board[i][j] == 1) {
                    board[i][j] = 8;
                } else if(counter == 3 && board[i][j] == 0) {
                    board[i][j] = 9;
                }
            }
        }
        
        for(int i=0;i<board.size();i++) {
            for(int j=0;j<board[0].size();j++) {
                if(board[i][j] == 8) {
                    board[i][j] = 0;
                } else if(board[i][j] == 9) {
                    board[i][j] = 1;
                }
            }
        }
        
    }
};