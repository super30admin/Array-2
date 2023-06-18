// Time Complexity: O(m*n)
// Space Complexity: O(1)

class Solution {
public:
    void gameOfLife(vector<vector<int>>& board) {
        // 0 -> 1 : 2
        // 1 -> 0 : 3

        for(int i = 0; i < board.size(); i++) {
            for(int j = 0; j < board[0].size(); j++) {
                int live_neighbors = liveNeighbors(board, i, j);
                
                if(live_neighbors < 2 && board[i][j] == 1) {
                    board[i][j] = 3;  
                }

                if((live_neighbors == 2 || live_neighbors == 3) && board[i][j] == 1) {
                    board[i][j] = 1;  
                }

                if(live_neighbors > 3 && board[i][j] == 1) {
                    board[i][j] = 3;
                }

                if(live_neighbors == 3 && board[i][j] == 0) {
                    board[i][j] = 2; 
                }
            }
        }


        for(int i = 0; i < board.size(); i++) {
            for(int j = 0; j < board[0].size(); j++) {
                if(board[i][j] == 2) board[i][j] = 1; 
                else if(board[i][j] == 3) board[i][j] = 0; 
            }
        }
               
    }

    int liveNeighbors(vector<vector<int>>& board, int row, int col) {
        
        int dir[8][2] = {{0,1}, {0,-1}, {1,0}, {-1,0}, {1,1}, {1,-1}, {-1,1}, {-1,-1}};
        int live_neighbors = 0; 

        for(int i = 0; i < 8; i++) {
            int new_row = dir[i][0] + row; 
            int new_col = dir[i][1] + col; 

            if(new_row >= 0 && new_row < board.size() && new_col >= 0 && new_col < board[0].size()) {
                if(board[new_row][new_col] == 1 || board[new_row][new_col] == 3) live_neighbors++; 
            } 
        }

        return live_neighbors; 
        
        // Fewer than two live neighbors dies

        // Two or Three live neighbors lives

        // More than three live neighbors dies 

        // A dead cell with exactly three neighbors becomes a live cell     
    } 
};