// Time Complexity : O(M*N)

// Space Complexity : O(1)

// Did this code successfully run on Leetcode : YES

// Appoarch: Creating a directions array, using it to find how many alive are there
// around each cell and keeping track of the count. Transforming the array to a diff
// state to keep track of prev state.

#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    vector<vector<int>> dir = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}, {-1, -1}, {-1, 1}, {1, 1}, {1, -1}};

    int countAlive(vector<vector<int>> &board, int row, int col)
    {
        int newRow, newCol;
        int countLive = 0;
        int m = board.size(), n = board[0].size();
        for (auto d : dir)
        {
            newRow = row + d[0];
            newCol = col + d[1];
            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n)
            {
                if (board[newRow][newCol] == 1 || board[newRow][newCol] == 2)
                {
                    countLive++;
                }
            }
        }
        return countLive;
    }
    void gameOfLife(vector<vector<int>> &board)
    {
        int m = board.size();
        int n = board[0].size();
        //    initial State    new state   codevalue
        //     1                 0          2
        //     0                 1          3
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                int count = countAlive(board, i, j);
                if (board[i][j] == 1 && (count < 2 || count > 3))
                {
                    board[i][j] = 2;
                }
                if (board[i][j] == 0 && count == 3)
                {
                    board[i][j] = 3;
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
                if (board[i][j] == 3)
                {
                    board[i][j] = 1;
                }
            }
        }
    }
};