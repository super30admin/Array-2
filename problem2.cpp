//time complexity : o(m*n)  where m is row and n is colown.
//space complexity : o(1)

    class Solution {
    public:
        
 int countOne(vector<vector<int>>& board,int r,int c)   {
    vector<vector<int>> dirs = {{0,1},{-1,0},{1,0},{0,-1},{-1,-1},{-1,1},{1,1},{1,-1}};
           
        int n = board.size();
        int m = board[0].size();
        int total = 0;
       for(auto dir : dirs) {
            int nr = r + dir[0];
            int nc  = c + dir[1];
           
           if(nr >= 0 && nr < n && nc >=0 && nc < m && (board[nr][nc] == 1 || board[nr][nc] == 2))             {
               total++;
          }
        }                  
        return total;                             
    }
        
        void gameOfLife(vector<vector<int>>& board) {

            int n = board.size();
            int m = board[0].size();

            for(int i=0;i<n;i++) {
                for(int j =0;j<m;j++) {

                    int oneCount = countOne(board,i,j);
                    if(board[i][j] == 1) {
                        if(oneCount <2 || oneCount > 3) {
                             board[i][j] = 2;
                        }

                    } else {
                        if(oneCount == 3) {
                             board[i][j] = 3;
                        }
                     }
                }
            }
                           
            for(int i=0;i<n;i++) {
                for(int j =0;j<m;j++) {
                   if(board[i][j] == 2) {
                       board[i][j] = 0;
                   } else if(board[i][j] == 3) {
                       board[i][j] = 1;
                   }
                }
             }
        }

                           
      

    };