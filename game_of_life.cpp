// Time Complexity : O(m*n)
// Space Complexity :  O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this - Couldn't find in-place manipulation solution

class Solution {
public:
    void gameOfLife(vector<vector<int>>& board) {
        
        int m = board.size();
        int n = board[0].size();
        int i = 0; int j = 0;
        int count;
        
        vector<vector<int>> ret_board(m, vector<int> (n, 0));

        // Iterate for each element        
        for(i = 0; i < m; i++)
        {
            for(j = 0; j < n; j++)
            {
                count = 0;

                // Find the number of adjacent ones
                // Boundary checks included

                if((i-1 >= 0) && (j-1 >= 0) && board[i-1][j-1])
                    count++;
                
                if((i-1 >= 0) && board[i-1][j])
                    count++;
                
                if((i-1 >= 0) && (j+1 < n) && board[i-1][j+1])
                    count++;
                
                if((j-1 >= 0) && board[i][j-1])
                    count++;
                
                if((j+1 < n) && board[i][j+1])
                    count++;
                
                if((i+1 < m) && (j-1 >= 0) && board[i+1][j-1])
                    count++;
                
                if((i+1 < m) && board[i+1][j])
                    count++;
                
                if((i+1 < m) && (j+1 < n) && board[i+1][j+1])
                    count++;

                // 0 value Case                
                if(board[i][j] == 0)
                {
                    if(count == 3)
                        ret_board[i][j] = 1;
                }
                // 1 value Case
                else
                {
                    if(count == 2 || count == 3)
                        ret_board[i][j] = 1;
                }
            }
        }

        // Copy the new matrix to original
        for(i = 0; i < m; i++)
            for(j = 0; j < n; j++)
                board[i][j] = ret_board[i][j];
    }
};