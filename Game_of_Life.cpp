/*
Time Complexity: O(m*n)
Space Complexity: O(1)
Did this code successfully run on Leetcode :yes
Any problem you faced while coding this : no
*/

class Solution {
public:
    int L = 1, D = 0, L_D = 2, D_L = 3; 
    
    vector<vector<int>> dir={{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{1,1},{-1,1},{1,-1}};
    
    void gameOfLife(vector<vector<int>>& board) {
        int m = board.size(), n = board[0].size();
        
        for(int i = 0; i< m; i++){
            for(int j = 0; j < n; j++){
                int lv = liveN(board,i,j);
                if(board[i][j]==L){
                    if(lv<2 || lv>3){
                        board[i][j]=L_D;
                    } 
                }else {
                    if(lv==3){
                        board[i][j]=D_L;
                    }
                }
            }
        }
        for(int i = 0; i<m;i++){
            for(int j=0; j<n; j++){
                if(board[i][j]==D_L){
                    board[i][j]=L;
                } else if(board[i][j]==L_D){
                    board[i][j]=D;
                }
            }
        }
    }
    int liveN(vector<vector<int>>& board, int i, int j){
        int m = board.size(), n = board[0].size();
        int c = 0;
        for(vector<int> d: dir){
            int ni = d[0]+i;
            int nj = d[1]+j;
                if(ni>=0 && ni<m && nj>=0 && nj<n){
                    if(board[ni][nj]==L || board[ni][nj]==L_D){
                        c++;
                    }
                }
        }
        return c;
    }
    
};
