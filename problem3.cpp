/*

// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
direction conditions

// Your code here along with comments explaining your approach

Change 0->1 then change the value to 3;
Change 1->0 then change the value to 2;
they act as a flag for finding the neighbour sum
replace 2 and 3 with the actual values.

*/

#include<iostream>
#include<vector>

using namespace std;

class Solution {

    int helper(vector<vector<int>>& board, int i , int j,int m,int n,vector<vector<int>>& dirs){
        int count{};
        for (auto dir:dirs){
            int nr = i+dir.at(0);
            int nc = j+dir.at(1);
            if(nr>=0 && nr<m && nc>=0 && nc<n && 
                (board.at(nr).at(nc) == 1 || board.at(nr).at(nc) == 2)){
                    ++count;
                }
        }
        return count;
    }

public:
    void gameOfLife(vector<vector<int>>& board) {

        // 0->1 = 2
        //1->0 = 3
        
        int m{static_cast<int>(board.size())};
        int n{static_cast<int>(board.at(0).size())};

        vector<vector<int>> dirs{{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};

        for(int i{};i<m;++i){
            for(int j{};j<n;++j){
                int count = helper(board,i,j,m,n,dirs);
                // count conditions
                if (board.at(i).at(j) == 1 && (count<2 || count>3)){
                    board.at(i).at(j) = 2;
                }
                else if(board.at(i).at(j) == 0 && count == 3){
                    board.at(i).at(j) = 3;
                }
            }
        }

        for(int i{};i<m;++i){
            for(int j{};j<n;++j){
                if(board.at(i).at(j) == 2) board.at(i).at(j) = 0;
                if(board.at(i).at(j) == 3) board.at(i).at(j) = 1;
            }
        }

    }
};

/*

More optimized from leetcode

class Solution {
public:
    void gameOfLife(vector<vector<int>>& board) {
        int row = board.size(), col = board[0].size();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int cnt = 0;
                for (int m = max(i - 1, 0); m < min(i + 2, row); m++) {
                    for (int n = max(j - 1, 0); n < min(j + 2, col); n++) {
                        cnt += board[m][n] % 2;
                        // not counting the converted ones.
                        // here if 0->1 then it is 2.
                    }
                }
                
                if (cnt == 3 || cnt - board[i][j] == 3) {
                    board[i][j] |= 2;
                }
            } 
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] >>= 1;
            }
        }
    }
};

*/