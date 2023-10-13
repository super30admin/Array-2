//Time Complexity: O(mxn)
//Space Complexity: O(1)

// we first convert all the dead and alive cells to 3 and 2 respectively 
// because any that changed from  1-> 0 = 2 and 0->1 = 3
// we run another iteration to change number to 0 and 1 depending on the 2 or 3 numbers 
// thus using constant space 

public class GameOfLife {

    public static void main(String[] args)
    {
        int[][] nums = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        gameOfLife(nums);

        System.out.println("New State of Matrix is");

        for (int i = 0; i < nums.length; i++)
        {
            System.out.println();
            for (int j = 0; j < nums[0].length; j++)
            {
                System.out.print(" " + nums[i][j]);
            }
        }
    }

    public static void gameOfLife(int[][] board) {
          int m = board.length;
          int n = board[0].length;
          int count = 0;

          for(int i = 0; i<m ; i++)
          {
              for(int j=0; j< n; j++)
               {
                 count = countAlive(board, i, j,m,n);
               
                    if(board[i][j] == 1 && (count<2 || count>3))
                    {
                        board[i][j] = 2;
                    }
                    else if(board[i][j] == 0 && count == 3)
                    {
                        board[i][j] = 3;
                    }
                }    
          }    

          for(int i = 0; i<m ; i++)
          {
              for(int j=0; j< n; j++)
              {
                  if(board[i][j] == 2)
                  {
                      board[i][j] = 0;
                  }
                  else if(board[i][j] == 3)
                  {
                      board[i][j] = 1;
                  }
              }
          }    
    }

    private static int countAlive(int[][] board, int i, int j, int m, int n)
    {
        int result = 0;
        int[][] dirs = new int[][]{{0,-1},{0,1},{-1,0},{1,0},{-1,-1},{-1,1},{1,1},{1,-1}};

        for(int[] dir: dirs)
        {
            int nr = i + dir[0];
            int nc = j + dir[1];

            //bound check 
            if(nr >= 0 && nr< m && nc>= 0 && nc < n && 
                (board[nr][nc] == 1 || board[nr][nc] == 2))
            {
                result++;
            }
        }
        return result;
    
    }
}
