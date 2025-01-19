// TC : O(m*n)
// SC : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class Solution
{
public:
    void gameOfLife(vector<vector<int>> &board)
    {
        if (board.size() < 0 || board.empty())
        {
            return;
        }

        for (int i = 0; i < board.size(); i++)
        {
            for (int j = 0; j < board[i].size(); j++)
            {
                int liveCount = cellCountUpdate(board, i, j);
                if (board[i][j] == 0)
                {
                    if (liveCount == 3)
                    {
                        board[i][j] = 3;
                    }
                }
                else
                {
                    if (liveCount < 2 || liveCount > 3)
                    {
                        board[i][j] = 2;
                    }
                }
            }
        }

        // reverse the values of 2 and 3 in place
        // in the expected result format
        for (int i = 0; i < board.size(); i++)
        {
            for (int j = 0; j < board[i].size(); j++)
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

    // 1 changed to 0->2 | 0 changed to 1->3
    int cellCountUpdate(vector<vector<int>> &board, int i, int j)
    {
        int count = 0;
        vector<vector<int>> dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

        for (int k = 0; k < dirs.size(); k++)
        {
            int nr = i + dirs[k][0];
            int nc = j + dirs[k][1];

            if (nr >= 0 && nr < board.size() && nc >= 0 && nc < board[0].size() && (board[nr][nc] == 1 || board[nr][nc] == 2))
            {
                count++;
            }
        }

        return count;
    }
};