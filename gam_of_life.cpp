// time : o(mn)
// space: O(1)


class Solution {
public:
    vector<pair<int, int>> dir{{-1,-1}, {-1, 0}, {-1, 1}, {0,-1}, {0,1}, {1,-1}, {1,0},{1,1}};

    int countAlive(vector<vector<int>>& board, int r, int c)
    {
        int alive = 0;

        for(int i = 0 ; i < dir.size(); i++)
        {
            int row = dir[i].first;
            int col = dir[i].second;

            if(r+row < 0 || r+row >= board.size() || 
               c+col < 0 || c+col >= board[0].size())
            {
                continue;
            }
            
            if(board[r+row][c+col] == 1 || board[r+row][c+col] == 2)
            {
                alive++;
            }

            if(alive > 3)
            {
                break;
            }
        }

        return alive;
    }

    void gameOfLife(vector<vector<int>>& board) {
        
        for(int r = 0; r < board.size(); r++)
        {
            for (int c = 0; c < board[0].size(); c++)
            {
                int alive = countAlive(board, r, c);
                if(board[r][c] == 0 || board[r][c] == 2) // dead cell
                {
                    if(alive == 3)
                    {
                        board[r][c] = 3; // cell becomes alive
                    }
                    // else stays dead
                }
                else // cell is alive
                {
                    if(alive < 2 || alive > 3)
                    {
                        // cell becomes dead 
                        board[r][c] = 2;
                    }
                        // else if alive count is 2 or 3, cell stays alive

                }
            }

        }

        // iterate over matrix and put correct values for alive and dead

        for(int r = 0; r < board.size(); r++)
        {
            for (int c = 0; c < board[0].size(); c++)
            {
                if(board[r][c] == 2)
                {
                    board[r][c] = 0;
                }

                if(board[r][c] == 3)
                {
                    board[r][c] = 1;
                }
            }
        }
    }
};