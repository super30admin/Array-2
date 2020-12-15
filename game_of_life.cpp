// Time Complexity : O(M*N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes

class Solution {
    int m,n;
public:
    void gameOfLife(vector<vector<int>>& board) {
        if(board.empty()){
            return;
        }
        m = board.size();
        n = board[0].size();
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int liveCells = countlives(board,i,j);
                if(board[i][j]==1 && (liveCells<2||liveCells>3)){
                    board[i][j]=3;
                }
                else if(board[i][j]==0 && liveCells == 3){
                    board[i][j]=2;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==2){
                    board[i][j]=1;
                }
                else if(board[i][j]==3){
                    board[i][j]=0;
                }
            }
        }
    }
    int countlives(vector<vector<int>>& board, int i, int j){
        int count = 0;
        vector<vector<int>>dirs = {{0,-1},{-1,0},{1,1},{-1,-1},{1,0},{0,1},{-1,1},{1,-1}};
        for(vector<int>dir:dirs){
            int r = i+dir[0];
            int c = j+dir[1];
            if(r>=0&&r<m && c>=0&&c<n && (board[r][c]==1 || board[r][c]==3)){
                count++;
            }
        }
        return count;
    }
};
