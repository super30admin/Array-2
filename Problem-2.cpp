// https://leetcode.com/problems/game-of-life/
// Time Complexity : O(n*m) where n is the number of rows in the array and m is the number of columns
// Space Complexity : O(n*m) where n is the number of rows in the array and m is the number of columns
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// check for all the condition at each index, if alive and satisfies the condition to die then convert it to 2.
// Do the same for dead and convert it to 3.
// Finally change it back to 0,1 respectively. 

class Solution {
public:
    int countAlive(vector<vector<int>>& board, int i, int j, int n, int m){
        vector<pair<int,int>> dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}, {-1,-1}, {-1,1}, {1,1}, {1,-1}};
        int count=0;
        for(auto dir: dirs){
            int nr = i + dir.first;
            int nc = j + dir.second;

            if(nr>=0 && nr<n && nc>=0 && nc<m && (board[nr][nc] == 1 || board[nr][nc] == 2)){
                count++;
            }
        }
        return count;
    }
    void gameOfLife(vector<vector<int>>& board) {
        int n = board.size();
        int m = board[0].size();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int count = countAlive(board, i, j, n, m);
                //alive
                if(board[i][j] == 1 && (count < 2 || count > 3)){
                    board[i][j] = 2;
                }
                else if(board[i][j] == 0 && count == 3){
                    board[i][j] = 3;
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] == 2){
                    board[i][j] = 0;
                }
                if(board[i][j] == 3){
                    board[i][j] = 1;
                }
            }
        }
    }
};