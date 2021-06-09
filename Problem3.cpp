// Time Complexity : O(n^2) or O(r^c)
// Space Complexity : O(n) extra space used in board array, can be avoided if we mark alive with 3 and dead with 2 in the same matrix O(1) in that case
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Game of Life

#include<iostream>
#include<vector>

using namespace std;



class Solution {
public:
    void gameOfLife(vector<vector<int>>& board) {
        int r = board.size();
        int c = board[0].size();
        
        vector<vector<int>> temp(r, vector<int>(c,0));
        
        int x_cord[8] = {-1,-1,0,1,1,1,0,-1};
        int y_cord[8] = {0,1,1,1,0,-1,-1,-1};
        
        for(int i = 0; i < r; i++){
            for( int j = 0; j < c; j++){
                int LiveCount =  0;
                for(int k = 0; k < 8; k++){
                    int x = x_cord[k] + i;
                    int y = y_cord[k] + j;
                    
                    if(x >= 0 && x < r && y>= 0 && y < c && board[x][y] == 1){
                        LiveCount++;
                    }
                }
                
                if(LiveCount == 3 && board[i][j] == 0){
                    temp[i][j] = 1;
                }
                
               else if(board[i][j] == 1){
                   if(LiveCount < 2)
                       temp[i][j] = 0;
                   else
                    if(LiveCount == 3 || LiveCount == 2)
                        temp[i][j] = 1;
                   else
                       if(LiveCount > 3)
                           temp[i][j] = 0;
                }
            }
        }
    board = temp;
    }
};