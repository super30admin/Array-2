// Time Complexity : O(m*n) m and n are dimensions of input matrix
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
    rules are:
        1 -> 1 : alive neighbors = 2 or 3
        1 -> 0 : alive neighbors < 2 or > 3
        0 -> 1 : alive neighbors = 3

        we use temp state changes because we need to make changes in place which results in
        losing original value of node which would be required by another node to calculate
        alive neighbors

        temp state changes: when 1 -> 0 use 2, when 0 -> 1 use 3
*/

class Solution {

    int m,n;
    //matrix used for moving around a node in the matrix
    int[][] directions;

   public void gameOfLife(int[][] board) {

       if(board==null)
           return ;

        m = board.length;
        n = board[0].length;

        directions = new int[][] {
            {0,1},{0,-1},{-1,0},{1,0},{-1,-1},{-1,1},{1,-1},{1,1}
         };

       //traverse the matrix and make state changes according to rules
       for(int i=0; i<m; i++)
       {
           for(int j=0; j<n; j++)
           {
               int count = aliveNeighbors(board, i, j);

               //if node is alive and rule 2 happens - kill it
               if( board[i][j]==1 && (count<2 || count>3) )
                   board[i][j] = 2;

               //if node is dead and rule 4 happens - make it alive
               if(board[i][j]==0 && count==3)
                    board[i][j] = 3;
           }
       }

       //traverse again and reverse the temp changes
       for(int i=0; i<m; i++)
       {
           for(int j=0; j<n; j++)
           {
               //if node is 2, original value was 1 and it had to become 0
               if(board[i][j]==2)
                   board[i][j] = 0;

               //if node is 3, original value was 0 and it had to become 1
               if(board[i][j]==3)
                    board[i][j] = 1;
           }
       }

    }

    private int aliveNeighbors(int[][] board, int i, int j)
    {
        int count=0;

        //traverse through all directions of given node(i,j)
        for(int[] dir : directions)
        {
            //calculate the eight neighbors one by one
            int row = i + dir[0];
            int col = j + dir[1];

            //bound check
            if(row<m && row>=0 && col<n && col>=0)
            {
                //check if neighbor is alive or was originally alive and was killed
                if(board[row][col]==1 || board[row][col]==2)
                    count++;
            }
        }

        return count;
    }
}
