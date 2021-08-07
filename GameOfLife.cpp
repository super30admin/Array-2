// Time Complexity : O(M*N) where M is the number of rows and N is the number of columns in the matrix
// Space Complexity : O(1) as I am not using any extra space and just modifying the given matrix as asked
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope
// Problem Link: https://leetcode.com/problems/game-of-life/
// Submission Link: https://leetcode.com/submissions/detail/533999160/

class Solution {
public:
    void gameOfLife(vector<vector<int>>& board) {
        
        vector<int> x_pos = {0, -1, -1, -1, 0, 1, 1, 1};
        vector<int> y_pos = {-1, -1, 0, 1, 1, 1, 0, -1};
        
        int m = board.size();
        int n = board[0].size();
        
        int live;
        
        for(int i = 0; i < board.size(); i++){
            for(int j = 0; j < board[i].size(); j++){
                live = 0;
                for(int k = 0; k < 8; k++){
                    if(i + x_pos[k] >= 0 && i + x_pos[k] < m &&
                       j + y_pos[k] >= 0 && j + y_pos[k] < n &&
                       (board[i + x_pos[k]][j + y_pos[k]] == 1 || 
                       board[i + x_pos[k]][j + y_pos[k]] == -1)){
                        live++;
                    }   
                }
                
                if(board[i][j] == 1){
                    if(live < 2 || live > 3)
                        board[i][j] = -1;
                }
                else{
                    if(live == 3)
                        board[i][j] = 2;
                }
            }
        }
        
        for(int i = 0; i < board.size(); i++){
            for(int j = 0; j < board[i].size(); j++){
                if(board[i][j] == -1)
                    board[i][j] = 0;
                if(board[i][j] == 2)
                    board[i][j] = 1;
            }
        }
    }
};