
//Time Complexity = O(M*N)
//Space Complexity = O(M*N).         Since we are not mutating the given matrix.
//Where M is the number of rows and N is the number of coloumns in matrix board.

class Solution {
public:
    int countinglife(vector<vector<int>>& board, int i,int j)
    {
        int count=0,r,c;
        vector<vector<int>> dir{
            {0,1},
            {1,0},
            {0,-1},
            {-1,-1},
            {-1,1},
            {-1,0},
            {1,1},
            {1,-1}
        };
        
        for(int k=0;k<dir.size();k++)
        {
            r=i+dir[k][0];
            c=j+dir[k][1];
            if(r>=0 && r<board.size() && c>=0 && c<board[0].size() && board[r][c]==1)
                count++;
        }
        return count;
    }
    void gameOfLife(vector<vector<int>>& board) {
        int r=board.size(), c=board[0].size(),i,j,count;
        int ans[r][c];
        //0->1 = 2
        //1->0 = 3
        for(i=0;i<r;i++)
            for(j=0;j<c;j++)
            {
                count = countinglife(board,i,j);
                if(board[i][j]==1)
                {
                    if(count<2 || count>3)
                        ans[i][j]=0;
                    else
                        ans[i][j]=board[i][j]; 
                }
                else
                {
                    if(count==3)
                        ans[i][j]=1;
                    else
                        ans[i][j]=board[i][j]; 
                } 
            }
        for(i=0;i<r;i++)
            for(j=0;j<c;j++)
                board[i][j]=ans[i][j];
    }
};


//Time Complexity = O(M*N)
//Space Complexity = O(1).         Since we are mutating the given matrix.
//Where M is the number of rows and N is the number of coloumns in matrix board.

class Solution {
public:
    int countinglife(vector<vector<int>>& board, int i,int j)
    {
        int count=0,r,c;
        vector<vector<int>> dir{
            {0,1},
            {1,0},
            {0,-1},
            {-1,-1},
            {-1,1},
            {-1,0},
            {1,1},
            {1,-1}
        };
        
        for(int k=0;k<dir.size();k++)
        {
            r=i+dir[k][0];
            c=j+dir[k][1];
            if(r>=0 && r<board.size() && c>=0 && c<board[0].size() && (board[r][c]==1 || board[r][c]==3))
                count++;
        }
        return count;
    }
    void gameOfLife(vector<vector<int>>& board) {
        int r=board.size(), c=board[0].size(),i,j,count;
        //0->1 = 2
        //1->0 = 3
        for(i=0;i<r;i++)
            for(j=0;j<c;j++)
            {
                count = countinglife(board,i,j);
                if(board[i][j]==1)
                {
                    if(count<2 || count>3)
                        board[i][j]=3;
                }
                else
                {
                    if(count==3)
                        board[i][j]=2;
                }
            }
        for(i=0;i<r;i++)
            for(j=0;j<c;j++)
            {
                if(board[i][j]==2)
                    board[i][j]=1;
                if(board[i][j]==3)
                    board[i][j]=0;
            }
    }
};
