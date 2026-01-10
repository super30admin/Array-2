class Solution {
public:
    void gameOfLife(vector<vector<int>>& board) {
        int m = board.size();
        int n = board[0].size();

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                int count = countalive(board,i,j);

                if((board[i][j] == 1) && (count < 2 || count > 3)){
                    board[i][j] = 2;
                }
                if((board[i][j] == 0) && (count == 3)){
                    board[i][j] = 3;
                }
            }
        }

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(board[i][j] == 2){
                    board[i][j] = 0;
                }
                if(board[i][j] == 3){
                    board[i][j] = 1;
                }
            }
        }
    }

private :
    int countalive(vector<vector<int>>& board,int i,int j){
        int count = 0;

        
        vector<vector<int>> direction = {
            {0,-1},{-1,0},{1,0},
            {-1,-1},{-1,1},{1,-1},{1,1},{0,1}
        };

        for(auto &dir : direction){
            int nrow = i + dir[0];
            int ncolumn = j + dir[1];

            if(nrow >= 0 && ncolumn >= 0 &&
               nrow < board.size() && ncolumn < board[0].size() &&
               (board[nrow][ncolumn] == 1 || board[nrow][ncolumn] == 2)){
                count++;
            }
        }
        return count;
    }
};
