// Time Complexity : O(m*n+m*n)=O(m*n) m, n is rows and cols of the 2d matrix, first m*n is to do the mutation and second is to
//                   change back 2,3's to 0 and 1 respectively. 2 representing Live to dead and 3 representing dead to live
// Space Complexity : O(1) as no new space is used and only existing matrix is modified
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
public:
    int getLiveNeighbors(int row, int col, vector<vector<int>>& board)
    {
        int count_one = 0;
        int tot_rows = board.size();
        int tot_cols = board[0].size();
        // top row
        if(row-1 >= 0 && (board[row-1][col] == 1 || board[row-1][col] == 2))
        {
            count_one++;
        }
        
        
        // bottom row
        if(row+1 <= tot_rows-1 && (board[row+1][col] == 1 || board[row+1][col] == 2))
        {
            count_one++;
        }
            
        // left col
        if(col-1 >= 0 && (board[row][col-1] == 1 || board[row][col-1] == 2))
        {
            count_one++;
        }
            
        // right col
        if(col+1 <= tot_cols-1 && (board[row][col+1] == 1 || board[row][col+1] == 2))
        {
            count_one++;
        }
            
        if(row-1>=0 && col-1>=0 && (board[row-1][col-1] == 1 || board[row-1][col-1] == 2))
        {
            count_one++;
        }
            

        if(row-1>=0 && col+1<=tot_cols-1 && (board[row-1][col+1] == 1 || board[row-1][col+1] == 2))
        {
            count_one++;
        }
            

        if(row+1<=tot_rows-1 && col-1>=0 && (board[row+1][col-1] == 1 || board[row+1][col-1] == 2))
        {
            count_one++;
        }
            

        if(row+1<=tot_rows-1 && col+1<=tot_cols-1 && (board[row+1][col+1] == 1 || board[row+1][col+1] == 2))
        {
            count_one++;
        }
            

    return count_one;


    }
    void gameOfLife(vector<vector<int>>& board) {
        int rows = board.size();
        int cols = board[0].size();
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                int one_cnt = getLiveNeighbors(i, j, board);
                if(board[i][j])
                {
                    // Live to dead
                    if(one_cnt < 2 || one_cnt > 3 )
                        board[i][j] = 2;
                }
                else
                {
                    // Dead to live
                    if(one_cnt == 3)
                        board[i][j] = 3;
                }
            }
        }
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(board[i][j]==2)
                    board[i][j] = 0;
                else if(board[i][j] == 3)
                    board[i][j] = 1;
            }
        }
    }
};