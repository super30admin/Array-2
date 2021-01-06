class Solution {
public:
    
    //alive->dead = -1
    //dead->alive= 2
   
    vector<vector<int>> neighbour={{1,0},{-1,0},{0,-1},{0,1},{-1,1},{1,1},{-1,-1},{1,-1}};
  
    void gameOfLife(vector<vector<int>>& board) 
    {
          int rows=board.size();
         int col=board[0].size();
        int live=0;
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(board[i][j]==0)
                {
                    live=count(board,i,j);
                    if(live==3)
                    {
                        board[i][j]=2;
                    }
                }
               if(board[i][j]==1)
                {
                    live=count(board,i,j);                  
                    if(live<2 || live>3)
                    {
                        board[i][j]=-1 ;
                    }
                }
            }
            cout<<endl;
        }
      update(board); 
    }
    
    int count(vector<vector<int>>& board,int i,int j)
    {
        int rows=board.size();
         int col=board[0].size();
        int res=0;
        for(int k=0;k<neighbour.size();k++)
        {
            int ii=i+neighbour[k][0];
            int jj=j+neighbour[k][1];
            if(ii>=0 && ii<rows && jj>=0 && jj<col && (board[ii][jj]==1 || board[ii][jj]==-1) )
            {
             res++;
            }
        }
        return res;
    }
    
    void update(vector<vector<int>>& board)
    {
         int rows=board.size();
         int col=board[0].size();
        
       for(int i=0;i<rows;i++)
       {
        for(int j=0;j<col;j++)
        {
            if(board[i][j]==-1)
            {
            board[i][j]=0;   
            }
            if(board[i][j]==2)
            {
            board[i][j]=1;
            }          
        }
       }
    }
    
};