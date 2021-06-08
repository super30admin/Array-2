//dfs? is it?
//O(n^2) is TC
//O(1) is SC
class Solution {

private:

    int countLivingRelatives(int row, int col, vector<vector<int>>& board) {
        int count = 0;
        int width = board[0].size() - 1;
        int height = board.size() - 1;

        // left/right
        if (col > 0 && board[row][col - 1] > 0) count++;
        if (col < width && board[row][col + 1] > 0) count++;
        
        // top
        if (row > 0) {
            if (board[row - 1][col] > 0) count++;
            if (col > 0 && board[row - 1][col - 1] > 0) count++;
            if (col < width && board[row - 1][col + 1] > 0) count++;
        }

        // bottom
        if (row < height) {
            if (board[row + 1][col] > 0) count++;
            if (col > 0 && board[row + 1][col - 1] > 0) count++;
            if (col < width && board[row + 1][col + 1] > 0) count++;
        }

        return count;
    }
public:
    void gameOfLife(vector<vector<int>>& board) {
        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board[0].size(); j++) {
                auto count = countLivingRelatives(i, j, board);

                if (board[i][j] == 1) {
                    if (count < 2 || count > 3) board[i][j] = 2; // will be killed
                } else {
                    if (count == 3) board[i][j] = -1; // will come to life
                }
            }
        }

        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board[0].size(); j++) {
                if (board[i][j] == 2) board[i][j] = 0;
                if (board[i][j] == -1) board[i][j] = 1;
            }
        }
    }
};