// Time Complexity :o(m*n)
// Space Complexity :o(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
// maintaing the change in each state ,later decide to use 1->0==>2; 0->1==>3


// Your code here along with comments explaining your approach


class Solution {
public:
    void gameOfLife(vector<vector<int>>& board) {


       int m=board.size();
       int n=board[0].size();

       for(int i=0;i<m;i++)
       {
           for(int j=0;j<n;j++)
           {
               int count_of_live=countof(board,i,j);
               if(board[i][j]==1)
               {
                   if(count_of_live<2 || count_of_live>3)
                   board[i][j]=2;
               }
               else
               {
                  if(count_of_live==3)
                  board[i][j]=3;
               }
           }
       }
// 1->0==>2
// 0->1==>3
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

       return;
        
    }
// function to check surroundings of each element
    int countof(vector<vector<int>>&board,int row,int col)
    {
        vector<vector<int>> matrix_neighbour_search{{-1,0}, {1,0}, {0,-1}, {0,1}, {-1,1}, {1,-1}, {-1,-1}, {1,1}};

        int count=0;

        for(int i=0;i<matrix_neighbour_search.size();i++)
        {
              int n_row=row+matrix_neighbour_search[i][0];
              int n_col=col+matrix_neighbour_search[i][1];

              if(n_row<=board.size()-1 && n_row>=0 && n_col<=board[0].size()-1 && n_col>=0 && (board[n_row][n_col]==2 || board[n_row][n_col]==1  ))
              count++;
        }

        return count;
    

    }
};