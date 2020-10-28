// Time complexity is O(rows*columns) - rows = size of board, columns - size of board[0]
// Space complexity is O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach:
/*
 // 1 --> 0 - 2
 // 0 --> 1 - 3
 // During calculation of the live neigbors of each cell,
    the value '2' is considered as an alive neighbor.
 // In the next generation, the cells with value '2' are changed
    to value '0' indicating that it is dead in the next generation.
 
 // During calculation of the live neigbors of each cell,
    the value '3' is considered as a dead neighbor.
 // In the next generation, the cells with value '3' are changed
    to value '1' indicating that it is alive in the next generation.
*/

class Solution {
public:
    
    int nLiveNeighbors(vector<vector<int>> board, int i, int j) {
        /*
            Flexibity of using directions 2-D vector: Initally, we considered 8 directions(horizontal, vertical, and diagonal).
            If we have to reduce the number of directions or neighbors to be considered, we can just remove the corresponding
            pair from the directions vector.
         */
        vector<vector<int>> directions {{-1,0}, {1,0}, {0,1}, {0,-1}, {-1,1}, {1,-1}, {1,1}, {-1,-1}};
        int nLives = 0;
        
        for(vector<int> dir: directions) {
            int nbRowIdx = i + dir[0]; // neighbor row index
            int nbColIdx = j + dir[1]; // neighbor column index
            
            // checking boundary conditions of nbRowIdx and nbColIdx
            // Also checking if the neighbor cell state is 1 or 2
            if(nbRowIdx >= 0 && nbRowIdx < board.size() &&
               nbColIdx >= 0 && nbColIdx < board[0].size() &&
               (board[nbRowIdx][nbColIdx] == 1 || board[nbRowIdx][nbColIdx] == 2))
            {
                nLives++;
            }
        }
        return nLives;
    }
    
    void gameOfLife(vector<vector<int>>& board) {
        // 1 --> 0 - 2
        // 0 --> 1 - 3
        // During calculation of the live neigbors of each cell, the value '2' is considered as an alive neighbor.
        // In the next generation, the cells with value '2' are changed to value '0' indicating that it is dead in the next generation.
        
        // During calculation of the live neigbors of each cell, the value '3' is considered as a dead neighbor.
        // In the next generation, the cells with value '3' are changed to value '1' indicating that it is alive in the next generation.
        int rows = board.size();
        int columns = board[0].size();
        if(!board.size()) return ;
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                int nLives = nLiveNeighbors(board, i, j);
                //rule 1 and rule 3
                //when rule 1 and 3 are true, we change the cell state from
                // 1 to 2(2 being the intermediate state).
                // In the next nested for loops, we update cell state from 2 to 0.
                if(board[i][j] == 1 && (nLives < 2 || nLives > 3))
                    board[i][j] = 2;
                //when rule 4 is true, we change the cell state from
                // 0 to 3(3 being the intermediate state).
                // In the next nested for loops, we update cell state from 3 to 1.
                else if(board[i][j] == 0 && nLives == 3)
                    board[i][j] = 3;
            }
        }
        // Updating cell state to next generation values
        // Updating cell state from 2 to 0 and
        // Updating cell state from 3 to 1
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                if(board[i][j] == 2)
                    board[i][j] = 0;
                else if(board[i][j] == 3)
                    board[i][j] = 1;
            }
        }
    }
};
