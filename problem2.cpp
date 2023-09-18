//Time complexity: O(m*n)
//Space complexity: O(1)
//Approach: 
//1. Go over each cell of the matrix 
//2. have the count of live cell around it ready
//  a. get the current cell coords
//  b. iterate over dirs and create new coords
//  c. check if these new coords are valid
//  d. increment the count if valid and return in the end
//3. then check who am i, am I 1 or0?
//  a. if I am 1 and if live cells around me are less than 2 and more than 3 ->I die
//  b. if I am 0 and live cells around me is exactly 3 I live 
//4. re-ierate over this baord again to update 2 and 3 to 0 and 1 respectively
//5. Done.
class Solution {
public:
vector<vector<int>> dirs{{0,-1},{-1,0},{0,1},{1,0},{-1,-1},{1,1},{-1,1},{1,-1}};

    void gameOfLife(vector<vector<int>>& board) {
        int m=board.size();
        int n=board[0].size();
//idea: 
//1->0 =>2
//0->1 =>3

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                int countOfLiveCells=countFunc(board, i, j);
                if(board[i][j]==1)
                {
                    if(countOfLiveCells<2 || countOfLiveCells>3)
                        board[i][j]=2;
                }
                else if(board[i][j]==0)
                {
                    if(countOfLiveCells==3)
                        board[i][j]=3;
                }
            }
        }

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]==2)
                    board[i][j]=0;
                else if(board[i][j]==3)
                    board[i][j]=1;
            }
        }
    }
    int countFunc(vector<vector<int>>& board, int r, int c)
    {
        int count=0;
        for(auto dir:dirs)
        {
            int newR=r+dir[0];
            int newC=c+dir[1];
            if(valid(board, newR,newC))
                count++;
        }
        return count;
    }
    bool valid(vector<vector<int>>& board, int r, int c)
    {
        return r>=0 and r<board.size() and c>=0 and c<board[0].size() and (board[r][c]==1 || board[r][c]==2);
    }
};

