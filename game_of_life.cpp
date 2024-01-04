// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// Idea here is we traverse through the matrix and check each element's neighbor to see if its value changes or not.
// If it changes according to the given rules we store them with intermediate values( 2 if 1->0 and 3 if 0->1) so
// that we dont miss the vlaue when comapring for other neighbors. At the end, we replace all the values intermediate 
// values (2 with 0 and 3 with 1).
#include <vector>

class Solution {
public:
    // Helper for counting nif a cell is alive
    int countAlive(std::vector<std::vector<int>> board, int i, int j)
    {
        int result = 0;
        for(auto dir : dirs)
        {
            // Get each direction and check for 1's in each of the direction to calculate count
            int nr = i + dir[0];
            int nc = j + dir[1];
            if(nr >= 0 && nc >= 0 && nr < board.size() && nc < board[0].size() && (board[nr][nc] == 1 || board[nr][nc] == 2))
            {
                result++;
            }
        }
        return result;
    }
    std::vector<std::vector<int>> dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}, {-1, 1}, {1, 1}, {1, -1}, {-1, -1}};
    void gameOfLife(std::vector<std::vector<int>>& board) {
        int m = board.size();
        int n = board[0].size();

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                // make 1 as 2 if count < 2 or > 3
                int count = countAlive(board, i, j);
                if(board[i][j] == 1 && (count < 2 || count > 3))
                {
                    board[i][j] = 2;
                }
                // make 0 as 3 if count = 3
                if(board[i][j] == 0 && count == 3)
                {
                    board[i][j] = 3;
                }
            }
        }

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                // Make 2 as 0 and 3 as 1 after everything
                if(board[i][j] == 2)
                {
                    board[i][j] = 0;
                }
                if(board[i][j] == 3)
                {
                    board[i][j] = 1;
                }
            }
        }
    }
};