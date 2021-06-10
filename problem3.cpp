// Time Complexity : O(m*n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// iterate throughout the 2d-array  change the state of each element based on the count of live cells in the neighbourhood we utilize a helper finction to determine the count of live cells in the neighbourhood
// use 2 and 3 to denote the state if it canges from 0 to 1 or 1 to 0 since we need to consider original state while counting live neighbours  


class Solution {
public:
    // 0 ==> 1 ==2
    // 1 ==> 0 ==3
    void gameOfLife(vector<vector<int>>& board) 
    {
        int m=board.size();
        int n=board[0].size();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                int count =findCountHelper(board,i,j,m,n);
                if(board[i][j]==1 && (count<2 || count>3))
                {
                    board[i][j]=3;
                }
                if(board[i][j]==0 && count==3)
                {
                    board[i][j]=2;
                }
            }
        }

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                 if(board[i][j]==2)
                 {
                     board[i][j]=1;
                 }
                  if(board[i][j]==3)
                 {
                     board[i][j]=0;
                 }
                 
            }
        }
        
    }

    int findCountHelper(vector<vector<int>>& board,int i,int j,int m,int n)
    {
        int count=0;
        vector<vector<int>> direction={{0,1},{0,-1},{-1,0},{1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
        for(auto it=direction.begin();it!=direction.end();it++)
        {
            int r= i+(*it)[0];
            int c= j+(*it)[1];
            
            if(r>=0 && r<m && c>=0 && c<n && ((board[r][c]==1)||(board[r][c]==3)))
            {
               count++; 
            }
        }
        return count;
    }
};
