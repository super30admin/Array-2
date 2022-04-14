// Time Complexity                              :  O(N*M), N is the number of rows and M is the number of columns in the board matrix.
// Space Complexity                             :  O(1)
// Did this code successfully run on Leetcode   :  Yes
// Any problem you faced while coding this      :  No

#include <bits/stdc++.h> 
using namespace std;  



class Solution {
private: 
    int n,m;
    vector<vector<int>> dirs{{-1,0},{1,0},{0,1},{0,-1},{-1,-1},{-1,1},{1,-1},{1,1}};
    // the method below calculates the live cells adjacent to the cell in ith row and jth column
    int liveNeighbours(vector<vector<int>>& board, int i,int j) {
        int live = 0;
        for(auto dir : dirs) {
            int r = dir[0] + i, c = dir[1] + j;
            if(r < 0 || r >= n || c < 0 || c >= m) continue;
            if(board[r][c] == 1 || board[r][c] == 2) live++;
        }
        return live;
    }
public:
    void gameOfLife(vector<vector<int>>& board) {
        n = board.size();
        m = board[0].size();
        if(n == 0 || m == 0) return;
        
        // mutate the board array inplace
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++) {
                int ln = liveNeighbours(board,i,j);
                
                if(board[i][j] == 1) {
                    if((ln < 2 || ln > 3))
                        board[i][j] = 2; // board[i][j] goes from alive to dead so replace board[i][j] = 1 to board[i][j] = 2
                } else {
                    if(ln == 3)
                        board[i][j] = 3; // board[i][j] goes from dead to alive, then replace board[i][j] = 0 to board[i][j] = 3
                }
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++) {
                if(board[i][j] == 2)
                    board[i][j] = 0; 
                else if(board[i][j] == 3)
                    board[i][j] = 1;
            }
        }
        
    }
};