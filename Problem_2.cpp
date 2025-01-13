// Author: Subhed Chavan
// Batch: December 24
// Problem Statement: 289: Game of Life
// Approach: Array and Index (Dir Array)
// Time Complexity: O(m x n)
// Space Complexity: O(1)

class Solution
{
public:
    void gameOfLife(vector<vector<int>> &board)
    {
        // Base Case
        if (board.empty())
        {
            return;
        }

        // Store the size of board
        int m = board.size();
        int n = board[0].size();

        // Iterate over the board and pass the index to get it's 8 neighbors
        // Set 2 -> It was alive and then set to dead
        // Set 3 -> It was dead and then got alive
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                int countLiveNeighbor = countLiveNeighbors(board, i, j, m, n);

                // If Alive, the check if it needs to be dead or alive based on
                // the condition
                if (board[i][j] == 1)
                {
                    if (countLiveNeighbor < 2 || countLiveNeighbor > 3)
                    {
                        board[i][j] = 2;
                    }
                    // If Dead, the check if it needs to be alive or dead based
                    // on the condition
                }
                else if (board[i][j] == 0)
                {
                    if (countLiveNeighbor == 3)
                    {
                        board[i][j] = 3;
                    }
                }
            }
        }

        // Iterate over the newly updated values and set the values for 2 and 3
        // to be dead and alive respectively
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

    // Function to get the count of alive neighbor
    // We look in all 8 directions by using the dirs array and get the count to return
    int countLiveNeighbors(vector<vector<int>> &board, int i, int j, int m,
                           int n)
    {
        int count = 0;

        // Directions array {i, j} to be updated to reach the neighbors
        vector<vector<int>> dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

        for (const auto &dir : dirs)
        {

            int nr = i + dir[0];
            int nc = j + dir[1];

            if (nr >= 0 && nr < m && nc >= 0 && nc < n &&
                (board[nr][nc] == 1 || board[nr][nc] == 2))
            {

                count++;
            }
        }
        return count;
    }
};
