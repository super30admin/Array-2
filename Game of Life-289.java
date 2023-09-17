class Solution {
    // Time Complexity: O(m*n) where m is number of rows and n is number of columns
    // Space Complexity: O(1) constant
    // Global variable where m indicates number of rows in the board 
    //and n indicates number of cols in the board.
    //Global varibale used so that we can use directly in private variable as well.
    int m=0, n=0;
    public void gameOfLife(int[][] board) {

// If board is empty or null then return
        if(board.length==0 || board==null)
        {
            return;
        }
        
        // 1 -> 0 means live to dead update 2.
        // 0 -> 1 means dead to live update 3.

         m = board.length;// number of rows
         n = board[0].length; // number of columns
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                // count of live neighbours
                int countLive = countLiveNeighbours(board, i, j);
                // If current element is live
                if(board[i][j]==1) // if current element is live
                {
                  if(countLive<2 || countLive>3)  // Consition 1 and 3
                  {
                      // If the element is supposed to die then we update it by 2. So while calculating live neighbours we'll consider 2 as live but in final output it will be considered as dead.
                      board[i][j]=2;
                  }
                }
                // If current element is not live
                else { // if current element is dead
                    if(countLive==3)  // Condition 4
                    {
                        // If the current element was dead and now it becomes live then we update 3 in current board. While calculating we will condier this dead, however while updating the final matrix this would be considered live.
                        board[i][j]=3; 
                    }

                }
            }
        }

// Updating 2 or 3 with live or dead to complete the final matrix/board properly.

        for(int i=0;i<m;i++)
        {
            for (int j=0;j<n;j++)
            {
                // element 2 means its changes from live to dead
                if(board[i][j]==2)
                {
                    board[i][j]=0;
                }
                // element 3 means its changes from dead to live
                else if(board[i][j]==3)
                {
                    board[i][j]=1; 
                }
            }
        }
        
    }
    // To get the count of live neighbours for specific cell
    private int countLiveNeighbours(int[][] board, int i, int j)
    {
        // dirs array which helps us in traversing the matrix to get the neighbours.
        int[][] dirs = {{-1,0},{1,0}, {0,-1}, {0,+1}, {-1,-1}, {-1,1}, {1,-1}, {1, 1}};
        int count=0; // count of live neighbours
        for(int[] dir : dirs)
        {
           int row = dir[0]+i; 
           int col = dir[1]+j;
           // count the live cells for all permissible neighbours
           if(row>=0 && row<m && col>=0 && col<n && (board[row][col]==1||board[row][col]==2))
           {
              count++;
           }     
        }
        return count; // return count
    }
}
