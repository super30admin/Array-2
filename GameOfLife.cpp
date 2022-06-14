// Time Complexity - O(8*m*n), since we make 8 comparisions for each element and there are a total of m*n elements in the matrix.
// Space Complexity - O(1) - This solution is in-place and we do not require any extra space.
// Problems Faced - No!
// It runs on leetcode.

class Solution {
    // int m;
    // int n;
    // vector<vector<int>> dirs;
public:
    void gameOfLife(vector<vector<int>>& board) {
        int m = board.size();
        int n = board[0].size();
       // dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int countAlive = cAlive(board, i, j);
                if((board[i][j] == 1) && (countAlive < 2 || countAlive > 3))
                    board[i][j] = -1;
                if(board[i][j] == 0 && countAlive == 3)
                    board[i][j] = 2;
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 2)
                    board[i][j] = 1;
                else if (board[i][j] == -1)
                    board[i][j] = 0;
            }
        }
    }
    
    private:
    int cAlive(vector<vector<int>>& arr, int i, int j){
        int m = arr.size();
        int n = arr[0].size();
        vector<vector<int>> dirs{{0, 1}, {0, -1}, {-1, 0}, {1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

        int count = 0;
        for(vector<int> dir : dirs){
            int nRow = dir[0] + i;
            int nCol = dir[1] + j;
            if(nRow >= 0 && nCol >= 0 && nRow < m && nCol < n && (arr[nRow][nCol] == 1 || arr[nRow][nCol] == -1))
                count++;
        }
        return count;
    }
};