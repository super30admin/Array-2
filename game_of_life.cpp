//Time Complexity - O(mn)
//Space COmplexity - O(1)
//Ran successfully on leetcode

class Solution {
    int m,n;
public:
    void gameOfLife(vector<vector<int>>& board) {
        if(board.empty())
            return;
        m=board.size();
        n=board[0].size();
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
            {
                int living_count=countlives(board,i,j,m,n);
                if(board[i][j]==1)
                {
                    if(living_count<2 || living_count>3)
                        board[i][j]=3; //1->0=3
                }
                else
                {
                    if(living_count==3)
                        board[i][j]=5; ////0->1=5
                }
            }
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
            {
                if(board[i][j]==5)
                    board[i][j]=1;
                if(board[i][j]==3)
                    board[i][j]=0;
            }
    }
    int countlives(vector<vector<int>>& board,int r, int c,int m,int n)
    {
        int count=0;
        int dirs[8][2]={{0,-1},{0,1},{1,0},{-1,0},{1,-1},{-1,1},{-1,-1},{1,1}};
        for(int i=0;i<8;i++)
        {
            int x=r+dirs[i][0];
            int y=c+dirs[i][1];
            if(x>=0 && x<m && y>=0 && y<n && (board[x][y]==1 || board[x][y]==3))
                count++;
        }
        return count;
    }
};