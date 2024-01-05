
// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach


import java.util.Arrays;

public class GameOfLife {
    int [][] dirs;
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        this.dirs = new int [][]{{0,-1},{0,1},{-1,0},{1,0},{-1,-1},{-1,1},{1,1},{1,-1}};

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                int count = countAlive(board,i,j);
                if( board[i][j]==1 && (count < 2 || count >3) ) 
                {
                    board[i][j] = 2;
                }
                if(board[i][j] == 0 && count == 3)
                {
                    board[i][j] = 3;
                }

            }
        }
         for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
      
                if(board[i][j] == 2)
                {
                    board[i][j] =0;
                }
                if(board[i][j] == 3)
                {
                    board[i][j] =1;
                }

            }

        }
    }

    public int countAlive(int[][] board, int i , int j)
    {
        int result =0;
        for(int[] dir: dirs)
        {
            int nr = i+dir[0];
            int nc = j+dir[1];
            if(nr >= 0 && nc>= 0 && nr < board.length && nc < board[0].length && (board[nr][nc] == 1 || board[nr][nc] == 2 ))
            {
               result++;  
            }
        }
        return result;
    }

    public static void main(String[] args)
    {
        GameOfLife g = new GameOfLife();
        int[][] arr = { { 0,1,0}, { 0,0,1 },{1,1,1},{0,0,0} };
        int m = arr.length;
        int n = arr[0].length;
         g.gameOfLife(arr);
         for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.println(arr[i][j]);
                

            }

        }
    } 
}
