//Game of Life using bit manipulation

class Solution {
public:
    void gameOfLife(vector<vector<int>>& board) {
        int m = board.size();      //rows
        int n = board[0].size();   //colums

        //iterate through the board; mxn
        for(int i = 0; i < m; i++ ){
            for(int j = 0; j < n; j++){

                int count = 0;    // keeps a count of the live neighbors for each cell

                for(int I = max(i-1, 0); I < min(i+2, m) ; I++){
                    for(int J = max(j-1, 0); J < min(j+2, n); J++){
                        count += board[I][J] & 1;    //update count
                    }
                   }
                count -= board[i][j];  //because the current cell was already included in the count

                if((count == 3) || (board[i][j] == 1 && count == 2)) //live conditions
                    board[i][j]  |= 2;    //bitwise or for live conditions
            }
        }

        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                board[i][j] >>= 1;   //shifting a bit to the right to update from old values to new values
    }
};

//Time Complexity: O(m x n) m = rows, n = columns 
//Space Complexity: O(1), since we are manipulating the same result array
