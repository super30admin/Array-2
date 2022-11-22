// Time complexity O(mxn)
// Space complexity O(1)

class Solution
{
public:
    int rows, columns;
    void gameOfLife(vector<vector<int>> &board)
    {
        // We need to make changes within the same matrix to not onsume extra space

        // First we need to iterate through the matrix and check the count of live cells
        rows = board.size();
        columns = board[0].size();

        // live to dead (1 -> 0) = 3
        // dead to live (0 -> 1) = 2

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                // check count of live cells around the particular element in the matrix
                int count = countlive(board, i, j);
                if (board[i][j] == 1)
                {
                    if (count < 2 || count > 3)
                    {
                        board[i][j] = 3;
                    }
                }
                // conditions for cell to die

                else
                {
                    if (count == 3)
                    {
                        board[i][j] = 2;
                    }
                }
            }
        }

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {

                if (board[i][j] == 3)
                {
                    board[i][j] = 0;
                }

                else if (board[i][j] == 2)
                {
                    board[i][j] = 1;
                }
            }
        }
    }

    int countlive(vector<vector<int>> &board, int rows, int columns)
    {
        int count = 0;

        vector<vector<int>> dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}}; // Up,down,left,right,Up left , Up right, down left , down right

        for (vector<int> x : dirs)
        {
            int nrow = rows + x[0];
            int ncolumn = columns + x[1];

            if (nrow >= 0 && ncolumn >= 0 && nrow < rows && ncolumn < columns && board[nrow][ncolumn] == 1 || board[nrow][ncolumn] == 2)
            {

                count++;
            }
        }
        return count;
    }
};
