// Time Complexity : O(MN)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
public:
    void gameOfLife(vector<vector<int>>& board) {
        if(board.empty() || board.size() == 0){
            return;
        }
        int m = board.size();
        int n = board[0].size();
        //1-0 =2
        //0-1 =3
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int count = countLives(board, i, j, m, n);
                //rule 1 and 3
                if(board[i][j] == 1 && (count < 2 || count > 3)){
                    board[i][j] = 2;
                }
                if(board[i][j] == 0 && count == 3){
                    board[i][j] = 3;
                }
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 2)
                    board[i][j] = 0;
                if(board[i][j] == 3)
                    board[i][j] = 1;
            }
        }
    }
    int countLives(vector<vector<int>> board, int i, int j, int m, int n){
        int res = 0;
        vector<vector<int>> dirs = {{0,1}, {0,-1}, {-1,0}, {1,0}, {1,1}, {1,-1}, {-1,1}, {-1,-1}};
        for(vector<int> dir : dirs){
            int r = i + dir[0];
            int c = j + dir[1];
            if(r >= 0 && r < m && c >= 0 && c < n && (board[r][c] == 1 || board[r][c] == 2))
                res++;
        }
        return res;
    }
};
