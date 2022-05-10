// Time Complexity : O(m*n)
// Space Complexity : O(1)

// Three line explanation of solution in plain english
/* New values are introduced to preserve the original state of array.
 * Use new value - 2 to represent when value 1 is changed to 0 and use value 3 to represent value change from 0 to 1. 
 * Use the rules given in problem to update the i/p array with above new values. In the second pass update the value 2 to 0 and 3 to 1;
 */

class Solution {
public:
    int m, n;
    
    void gameOfLife(vector<vector<int>>& board) {
        
        if (board.size() == 0)
        {
            return;
        }
        
        m = board.size();
        n = board[0].size();
        
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                int liveCells = countLiveCells(board, i, j);
                
                // 1 -> 0 ==> 2
                // 0 -> 1 ==> 3
                if (board[i][j] == 1)
                {
                    if (liveCells < 2 || liveCells > 3)
                    {
                        board[i][j] = 2;
                    }
                }
                else
                {
                    if (liveCells == 3)
                    {
                        board[i][j] = 3;
                    }
                }
            }
        }
        
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (board[i][j] == 2)
                {
                    board[i][j] = 0;
                }
                else if (board[i][j] == 3)
                {
                    board[i][j] = 1;
                }
            }
        }
    }
    
    int countLiveCells(vector<vector<int>>& board, int r, int c)
    {
        vector<vector<int>> dirs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        int count = 0;
        for (vector<int> dir : dirs)
        {
            int new_r = r + dir[0];
            int new_c = c + dir[1];
            
            if (new_r >= 0 && new_r < m && new_c >= 0 && new_c < n && (board[new_r][new_c] == 1 || board[new_r][new_c] == 2))
            {
                count++;
            }
        }
        
        return count;
    }
};