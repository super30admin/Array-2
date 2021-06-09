/*
TC : O(m*n) where m*n is the size of the board
SC :O(1)
Leetcode : yes
Problems faced :no
 */

/**
 *   Here, we only flip the 1 to die and 0 to live. So if, 0 is dying or 1 is living, we dont make any changes.
 *    When we find a die somewhere, it must be a previous 1. We use this while counting the neighbours
 *    This way we can count the 1s without being affected.
 */
public class GameOfLife {

    private int die = 2;
    private int live = 3;
    public void gameOfLife(int[][] board)
    {

        int rows = board.length;
        int cols = board[0].length;
        for (int i=0;i<rows;i++)
        {
            for (int j=0;j<cols;j++)
            {
                int around = countNeighbours(i,j,board);
                //case where a dead cell comes to life
                if (board[i][j] == 0 && around == 3)
                    board[i][j] = live;


                else if (board[i][j] == 1)
                {
                    //if a live cell continues to live, we dont make any change
                    if (around == 2 || around ==3)
                        continue;

                    //case where a live cell dies in next state
                    if (around < 2 || around > 3)
                        board[i][j] = die;
                }
            }
        }

        for (int i=0;i<rows;i++)
        {
            for (int j=0;j<cols;j++)
            {
                if (board[i][j] == die)
                    board[i][j] = 0;
                if (board[i][j] == live)
                    board[i][j] = 1;
            }
        }

    }

    private int countNeighbours(int i, int j,int[][] board)
    {
        int count = 0;
        //use this matrix to get indices of all surrounding 8 neighbours
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};

        for (int[] dir:dirs)
        {
            int x = i+dir[0];
            int y = j+dir[1];

            if (x>=0 && y>=0 && x < board.length && y<board[0].length )
            {

                //if the current cell is set to die, that means it was previously alive. Hence check that condition
                if (board[x][y] == 1 || board[x][y] == die)
                    count ++;
            }
        }

        return count;

    }
}
