//TC: O(n)
//SC: O(1)

class Solution {
public:
    void gameOfLife(vector<vector<int>>& board) {
        
        vector<vector<int>> dirs = {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};

        int m = board.size();
        int n = board[0].size();

         for(int i = 0; i<m ; i++)
        {
            for(int j = 0; j<n ; j++)
            {
                int count = 0;
                for(int dir[] : dirs)
                {
                    int r = i + dir[0];
                    int c = j + dir[1];
                }

                if(r>=0 && c>=0 && r<m &&c<n && (board[r][c] == 1 || board[r][c])) 
                count ++;

            

                if(board[i][j] == 1 && (count <2 || count > 3)
                {
                    board[i][j] = 2;
                }
                else if(board[i][j] == 0 && (count  == 1))
                {
                    board[i][j] = 3;
                }
            }
        }

         for(int i = 0; i<m ; i++)
        {
            for(int j = 0; j<n ; j++)
            {
                if(board[i][j] == 2 ) board[i][j]=0;
                else if(board[i][j] == 2 ) board[i][j]=1;
            }
            
        }
    }

// private:
//     int countAliveNeighbours(vector<vector<int>>& board, int i,int j,int m,int n)
//     {
       
//     }
};