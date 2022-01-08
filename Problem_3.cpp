/*Time complexity:
 O(mn)
*/
/*Space Complexity:
 O(1) as we are not creating any extra space
 */

/*
Approach:
We are traversing through the entire matrix and if there is a change in the 
value of the matrix we change it with numbers other than 0 and 1 e.g. -1 and 2. Then if
we have to check the changed value again for some other element we are
going to put the original value that is mapped to to -1 or 2. 
*/

class Solution {
public:
    int rSize = board.size();
    int cSize = board[0].size()
    bool check(int x, int y, vector<vector<int>>& board) {
        return (x >= 0 && x < rSize && y >= 0 && y < cSize);
    }
    
    void gameOfLife(vector<vector<int>>& board) {
        vector<int> dir_x = {0, 0, 1, 1, 1, -1, -1, -1};
        vector<int> dir_y = {1, -1, 1, -1, 0, 0, 1, -1};
        
        for (int r = 0; r < rSize; r++) {
            for (int c = 0; c < cSize; c++) {
                
                int count = 0;
                int directionCount = 8;
               
                for (int i = 0; i < directionCount; i++) {
                    int curr_x = r+ dir_x[i], curr_y = c + dir_y[i];
                    if (check(curr_x, curr_y, board) && abs(board[curr_x][curr_y]) == 1)
                        count++;
                }
                
    
                if (board[r][c] == 1 && (count < 2 || count > 3))
                    board[r][c] = -1;
                
     
                if (board[r][c] == 0 && count == 3)
                    board[r][c] = 2;
            }
        }
        
        // Get the final board
        for (int r = 0; r < rSize; r++) {
            for (int c = 0; c < cSize; c++) {
                if (board[r][c] >= 1)
                    board[r][c] = 1;
                else
                    board[r][c] = 0;
            }
        }
    }
};