//Time complexity : O (m * n)
//Space complexity : O(1)
//Leetcode : Yes

//Approach :
            //Just follow the rules to calculate live cells and act accordingly

class Solution {
public:
    //If a live cell dies we denote it by 2 i.e. 1->0 = 2
    //If a dead cell comes alive , 0->1 = 3
    int m;
    int n;
    void gameOfLife(vector<vector<int>>& board) {
        if(board.size() == 0 || board[0].size() == 0)
            return;
        
        m = board.size();
        n = board[0].size();
        
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                //Get live cells around current cells
                int liveCells = countLives(board, i , j);
                if(board[i][j] == 1)
                {
                    if(liveCells < 2 || liveCells > 3)
                    {
                        board[i][j] = 2;
                    }
                }
                else
                    {
                        if(liveCells == 3)
                        {
                            board[i][j] = 3;
                        }
                    }
            }
        }
        
        for(int i = 0 ; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
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
    
    int countLives(vector<vector<int>>& board, int row , int col)
    {
        vector<vector<int>> dirs = {{0,1}, {0, -1}, {1 ,0}, {-1, 0}, {1 , 1}, {1 , -1}, {-1 , 1}, {-1 , -1}};
        int count = 0;
        
        for(auto dir : dirs)
        {
            int r = row + dir[0];
            int c = col + dir[1];
            
            if(r >= 0 && c >= 0 && r <= m - 1 && c <= n - 1 && (board[r][c] == 1 || board[r][c] == 2))
            {
                count++;
            }
        }
        return count;
    }
};