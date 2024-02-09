class Solution {
public:
    int cnt_neighbors(int r, int c, vector<vector<int>>& b){
      int rows = b.size(), cols = b[0].size();
      int cnt = 0;
      if(r>0)  cnt += b[r-1][c];
      if(c>0)  cnt += b[r][c-1];
      if(r>0 && c>0)  cnt += b[r-1][c-1];

      if(r<rows-1)  cnt += b[r+1][c];  
      if(c<cols-1)  cnt += b[r][c+1];
      if(r<rows-1 && c<cols-1)  cnt += b[r+1][c+1];

      if(r>0 && c<cols-1)  cnt += b[r-1][c+1];
      if(r<rows-1 && c>0)  cnt += b[r+1][c-1];  

      return cnt;
    }

    void gameOfLife(vector<vector<int>>& board) {
      int r = board.size(), c = board[0].size();
      vector<vector<int>> tmp = vector(r,vector(c,-1));
      
      for(int i=0;i<r;i++){
        for(int j=0;j<c;j++)
        {
            int prev = board[i][j];
            int now = prev;
            int adj = cnt_neighbors(i,j,board);
            
            //cout<<i<<j<<": "<<adj<<endl;

            if(prev==0 && adj==3)  now = 1;
            if(adj<2 || adj>3)  now = 0;
            if(prev==1 && (adj==2 || adj==3))  now = 1;

            tmp[i][j] = now;
        }
      }
      

      board = tmp;
    }

};
