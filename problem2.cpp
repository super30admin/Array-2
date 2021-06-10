class Solution {
public:
    void gameOfLife(vector<vector<int>>& board) {
        
        int m=board.size();
        int n=board[0].size();
        
        for(int r=0;r<m;r++)
        {
            for(int c=0;c<n;c++)
            {
                int count=countLives(board,r,c,m,n);
                if(board[r][c]==1 and (count<2 or count>3))
                {
                    board[r][c]=3;
                }
                if(board[r][c]==0 and count==3)
                {
                    board[r][c]=2;
                }
            }
        }
        
        for(int r=0;r<m;r++)
        {
            for(int c=0;c<n;c++)
            {
                if(board[r][c]==3)
                {
                    board[r][c]=0;
                }
                if(board[r][c]==2)
                {
                    board[r][c]=1;
                }
            }
        }
        
        
    }
    
    int countLives(vector<vector<int>> board, int i, int j, int m, int n)
    {
        int count=0;
        vector<vector<int>> dirs={{0,1},{0,-1},{1,0},{-1,0},{1,-1},{-1,1},{-1,-1},{1,1}};
        for(int k=0; k<dirs.size(); k++)
        {
             int r= i+ dirs[k][0];
                   int c= j+ dirs[k][1];
            if(r<m and c<n and r>=0 and c>=0 and (board[r][c]==1 || board[r][c]==3))
               {
                   count++;
                  
               }
        }
        return count;
    }
};

//Time complexity - O(mxn) ignoring constant iteration over direction matrix
//Space is indeed O(1)
