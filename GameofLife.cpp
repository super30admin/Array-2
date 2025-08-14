#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
We go cell by cell and count how many live neighbors it has.
We mark transitions with temporary values: 2 (alive → dead) and 3 (dead → alive).
hen, we finalize the board by converting 2 → 0 and 3 → 1
*/
class Solution{
    vector<vector<int>> dirs = {{-1,-1}, {-1,0}, {-1,1}, {0,-1}, {0,1}, {1,-1}, {1,0}, {1,1}};
    int m, n;
public:
    void gameOfLife(vector<vector<int>>& board) {
        m = board.size();
        n = board[0].size();

        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                int count = getCount(board, i, j);
                if(board[i][j] == 0 && count == 3){
                    board[i][j] = 3;
                } else if(board[i][j] == 1 && (count < 2 || count > 3)){
                    board[i][j] = 2;
                }
            }
        }

        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if(board[i][j] == 2) board[i][j] = 0;
                else if(board[i][j] == 3) board[i][j] = 1;
            }
        }
    }

private:
    int getCount(vector<vector<int>>& board, int i, int j) {
        int count = 0;
        for(auto& dir : dirs){
            int r = i + dir[0];
            int c = j + dir[1];
            if(r >= 0 && r < m && c >= 0 && c < n){
                if(board[r][c] == 1 || board[r][c] == 2) count++;
            }
        }
        return count;
    }
};
