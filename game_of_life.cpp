//TC:O(N2)
//SC:O(1)
class Solution {
public:
int countAlive(int m,int n, int i, int j,vector<vector<int>> &board,int dx[],int dy[]){
        int result=0;
          for(int k=0;k<8;k++){
              int r = i+dx[k];
              int c = j+dy[k];
              if(r>=0 && c>=0 && r<m && c<n && (board[r][c]==1 || board[r][c]==2)){
                  result++;
              }
          }
        return result;
      }
    void gameOfLife(vector<vector<int>>& board) {
        int m = board.size();
        int n= board[0].size();
        //0-->1==3
        //1->0==2
     int dy[] ={1,-1,0,0,-1,1,-1,1};
     int dx[]={0,0,-1,1,1,-1,-1,1,1};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int alive = countAlive(m,n,i,j,board,dx,dy);

              if(board[i][j]==1  && (alive>3 || alive<2)){
                  board[i][j]=2;
              }
              if(board[i][j]==0 && alive==3){
                    board[i][j]=3;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==3){
                    board[i][j]=1;
                }
                if(board[i][j]==2){
                    board[i][j]=0;
                }
            }
        }

    }

};
