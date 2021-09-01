// Time Complexity : O(m*n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Indexing issues, can be very annoying and time consuming


// Your code here along with comments explaining your approach

#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int m, n;
    void gameOfLife(vector<vector<int>>& board) {
        if(board.size() == 0) return;
        m = board.size();
        n = board[0].size();
        for(int i = 0; i<m; i++)
        {
            for(int j = 0; j<n; j++){
            
                int count = countLive(board, i, j);  // will get the number of live neighbours
                if(board[i][j] == 1 && (count < 2 || count> 3))  // if the live cell neighbour count is less than 2 or >3 than it will be dead.
                {
                    board[i][j] = 3;
                   
                }
                if(board[i][j] == 0 && count == 3)  // if dead cell n count is 3 then it will turn live; numbers taken as 2 & 3 so as to not create confusion in neighbour counting
                {
                    board[i][j] = 2;
                }
            }
        }
        for(int i =0 ; i<m; i++){
            for(int j= 0; j<n; j++){
                if(board[i][j] == 2) board[i][j] = 1;  // set the 2's prev dead into lives
                if(board[i][j] == 3) board[i][j] = 0; // set the live ones to dead
            }
        }
    }
                   
    int countLive(vector<vector<int>>& board, int i, int j)
    {
        
        vector<vector<int>> dir = {{0, 1}, {0, -1}, {1, 0}, {-1,0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};   // directions array of all 8 directions
        int result = 0;
        for(vector<int> dirs: dir){
            int nr = i + dirs[0];  // get the resultant row
            int nc = j + dirs[1]; // get the column
            if(nr>=0 && nr<m && nc>=0 && nc<n && (board[nr][nc] == 1 || board[nr][nc] == 3)){ // if the cell is 1 and index is within bounds
                result++; // increase count
            }
        }
        return result; // return count
    }
};


// int main(){
    
//     return 0;
// }