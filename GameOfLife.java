//Time Complexity: O(m*n)
//Space Complexity: O(m*n)

class Solution {
    
    //creating these varaibles and matrix  globally as we'll be using them in multiple functions
    int m;
    int n;
    int [][] dirs;
    
    public void gameOfLife(int[][] board) {
    
        //row and column length
        m = board.length;
        n = board[0].length;
        
        //these represent the coordinates for each of the right directions
        dirs = new int [][] 
        {
            {1, 0}, {-1, 0}, {0,1}, {0, -1}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}
            //top, bottom, right, left, topRight, bottomRight, topLeft, bottomLeft
        };
        
        //null
        if(board == null || m == 0) return;
        
        //For our login, we will replace changing values to 6 and 9 
        //This is so that we can revert back to the matrix's og state
        //0 --> 1: 6
        //1 --> 0: 9
        
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                //alling the function to count how many alive(1) values in the all potential 8 directions
                int countAlive = countAlive(board, i, j);
                if(board[i][j] == 1 && (countAlive < 2 || countAlive > 3)) //Rule 1 & 3
                {
                    board[i][j] = 9;
                }
                if(board[i][j] == 0 && countAlive == 3) //Rule 4
                {
                    board[i][j] = 6;
                }
            }
        }
        
        //looping through the matrix one more time to set the values to 0's and 1's
        
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if(board[i][j] == 9) board[i][j] = 0;
                if(board[i][j] == 6) board[i][j] = 1;
            }
        }
        
    }
    
    
    public int countAlive (int[][] board, int i, int j) {
        int result = 0;
        
        //iterating through each direction mentioned in the dirs array
        for (int [] dir: dirs)
        {
            //hitting all 8 rows and columns of the 8 directions listed in dirs
            int nr = i + dir[0];
            int nc = j + dir[1];
            
            //first making sure our nr and nc only represent the rows and columns inside the matrix
            //second making sure the element we are checking is 1 or it used to be 1(now changed to 9)
            if(nr >= 0 && nc >= 0 && nr < m && nc < n &&
              (board[nr][nc] == 1 || board[nr][nc] == 9))
            {
                //incrementing the number of 1's(alive cells) and returning them below
                result++;
            }
        }
        return result;
    }
}