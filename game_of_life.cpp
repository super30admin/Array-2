// Time complexity: O(m*n)
// Space complexity: O(1)
// Did this code successfully run on Leetcode : Yes

//Approach:
//1. We iterate through the board and for each element, we find the number of live neighbours.
//2. If the element is 0 and has 3 live neighbours, we mark it as 3.
//3. If the element is 1 and has more than 3 or less than 2 live neighbours, we mark it as 2.
//4. In the second pass, we iterate
//5. If the element is 3, we mark it as 1.
//6. If the element is 2, we mark it as 0.

class Solution {
private: 
    int neighbour(int i, int j, vector<vector<int>>& board){
        vector<vector<int>> directions = {{1,0},{0,1}, {-1,0}, {0,-1}, {1,1},{1,-1}, {-1,1}, {-1, -1}};
        int count = 0; 
        for(auto& it : directions){
            int nr = i + it[0];
            int nc = j + it[1];
            if(nr >= 0 && nr < board.size() && nc >= 0 && nc < board[0].size() &&
            (board[nr][nc] == 1 || board[nr][nc] == 2)){
                count++;
            }
        }
        return count;
    }
public:
    void gameOfLife(vector<vector<int>>& board) {
        int m = board.size(); 
        int n = board[0].size();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int count = neighbour(i, j, board); 
                if(board[i][j] == 0 && count == 3){
                    board[i][j] = 3;
                }
                if(board[i][j] == 1){
                    if(count > 3 || count < 2){
                        board[i][j] = 2; 
                    }
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 3){board[i][j] = 1;}
                if(board[i][j] == 2){board[i][j] = 0;}
            }
        }
    }
};