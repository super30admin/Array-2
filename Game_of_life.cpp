// Apporach 1 
// Time Complexity : O(2*n*m) == O(n * m)  ... n = number of rows and m = number of columns          
// Space Complexity : O(1)   ..... hasmap is used to store data 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/*
Leetcode : https://leetcode.com/problems/game-of-life/
*/


/*
'dir' vector is used to get index of neighbour in all eight directions.
*/

class Solution {
                         // up    //dn   //left   //right  
    vector<vector<int>>dir{{-1,0}, {1,0}, {0, -1}, {0,1}, {-1,-1}, {-1,1}, {1,-1}, {1,1}};

public:
    void gameOfLife(vector<vector<int>>& board) {

        for(int i =0; i<board.size(); i++){
            for(int j=0; j<board[0].size(); j++){
                int count = liveCount(board, i, j);

                if(board[i][j] == 1 && count < 2) board[i][j] = 2;
                //if(board[i][j] == 1 && (count == 2 || count == 3)) ;//no change here, so not required
                if(board[i][j] == 1 && count > 3) board[i][j] = 2;
                if(board[i][j] == 0 && count == 3) board[i][j] = -1;
            }
        }

        for(int i =0; i<board.size(); i++){
            for(int j=0; j<board[0].size(); j++){
                if(board[i][j] == 2) board[i][j] = 0;
                else if(board[i][j] == -1) board[i][j] = 1;
            }
        }
        return;
    }

    int liveCount(vector<vector<int>>& board, int i, int j){
        int count = 0;
        for(auto pair : dir){
            int newI = i + pair[0];
            int newJ = j + pair[1];

            if(newI >= 0 && newJ >= 0 && newI < board.size() && newJ < board[0].size()){
                if(board[newI][newJ] > 0){
                        count++;
                }
            }
        }
        return count;
    }
};