// Time Complexity :O(m*n) where m and n are number of rows and coloums of matrix
// Space Complexity : O(1)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    void gameOfLife(vector<vector<int>>& board) {
        int r = 0;
        int c = 0;
        int m = board.size();
        int n = board[0].size();
        int alive;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                alive = findAlives(board,i,j,m,n);
                if(board[i][j] == 1 && (alive < 2 || alive > 3))
                    board[i][j] = 3;
                else if(alive == 3 && board[i][j] == 0)
                   board[i][j] =2;// 1->3 for alive to dead;0->2 for dead to alive 
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == 3) board[i][j] = 0;
                else if(board[i][j] == 2) board[i][j] = 1;
            }
        }
    }
    int findAlives(vector<vector<int>> board,int i,int j,int m,int n){
        vector<vector<int>> myNeighbours= {{-1,0},{0,1},{1,0},{0,-1},{1,1},{-1,1},{1,-1},{-1,-1}};
        int r=0,c=0,alive=0;
        for(auto neighbour: myNeighbours){
            r = i + neighbour[0];
            c = j + neighbour[1];
            if(r<m && c<n && r>=0 && c>=0 && (board[r][c] == 1 || board[r][c] == 3))
                alive++;
        }
        return alive;
    }
};