//TC = O(MN)
//SC = O(1)

class Solution {
public:
     vector<vector<int>> dirs = {
            {0,1},{0,-1},{1,0},{-1,0},
            {-1,-1},{-1,1},{1,1},{1,-1}};
    
    void gameOfLife(vector<vector<int>>& board) {
        int m = board.size();
        int n = board[0].size();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int count = countAlive(board,i,j,m,n);
                if(board[i][j]==0 && count ==3){
                    board[i][j] = 2;
                }else if(board[i][j]==1 && count<2){
                    board[i][j] = 3;
                }else if(board[i][j]==1 && count>3){
                    board[i][j] = 3;
                }
            }
        }
         for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
            if(board[i][j]==2) board[i][j]=1;
            if(board[i][j]==3) board[i][j]=0;    
        }
    }
}
    
    int countAlive(vector<vector<int>>& board, int i,int j,int m,int n){
        int result = 0;
        for(auto v: dirs){
            int row = i + v[0];
            int col = j + v[1];
            if(row>=0 && row<m && col>=0 && col<n &&
              (board[row][col]==1 || board[row][col]==3)){
                result++;
            }
        }
        return result;
    }
};
