//Time Complexity: O(m*n), size of the board. two passes are done which given O(2m*2n), so amortized O(n)
//Space complexity: O(1), no auxillary data structure used
//running on leetcode: yes
class Solution {
    public void gameOfLife(int[][] board) {
        if (board==null || board.length==0)
        {
            return;
        }
        //rows of board
        int m = board.length;
        //columns of board
        int n = board[0].length;
        //1-->0 make it 2
        //0-->1 make it 3
        for (int i=0; i<m; i++)
        {
            for (int j=0; j<n; j++)
            {
                //i and j give the current location to the count lives function
                int count = countlives(board, i, j, m, n);
                //rule 1 and rule 3
                if (board[i][j]==1 && (count<2 || count>3))
                {
                    board[i][j]=2;
                }
                //rule 4 for dead cell
                if (board[i][j]==0 && (count==3))
                {
                    board[i][j]=3;
                }
            }
        }
        //another pass to revert the board back to 0 and 1 from 2 and 3
        for (int i=0; i<m; i++)
        {
              for (int j=0; j<n; j++)
              {
                  if(board[i][j]==2)
                  {
                      board[i][j]=0;
                  }
                  if (board[i][j]==3)
                  {
                      board[i][j]=1;
                  }
              }
        }
    }
        //function to count live neighbors of a given element
        private int countlives(int[][] board, int i, int j, int m, int n)
        {
            int result=0;
            //array to hold the positions of all the 8 neighbours of any element
            int[][] dirs = {{0,1},{-1,0},{1,0},{0,-1}, {1,1}, {-1,-1}, {-1,1}, {1,-1}};
            //go thru the dirs array and get pisitions of neighbours for the current i and j
            for(int[] dir : dirs)
            {
                int r = i+dir[0];
                int c = j+dir[1];
                if (r>=0 && r<m && c>=0 && c<n && (board[r][c]==1 || board[r][c]==2))
                {
                    result++;
                }
            }
            return result;
        }
}
