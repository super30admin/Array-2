//TC : O(n*m)
//SC: O(1)

class Solution {

    private int [][] directions = new int[][]
            {
                    {-1,-1},//left up
                    {-1,0},//up,
                    {-1,1},//Right up
                    {0,1},//Right
                    {1,1}, //Right Down
                    {1,0}, //down
                    {1,-1}, //left down
                    {0,-1} //left

            };

    private int getLiveNeighborcount(int[][] board , int i , int j)
    {
        int m =board.length;
        int n  = board[0].length;
        int liveNeighCount=0;
        for(int [] direction : directions)
        {
            int x = i+ direction[0];
            int y = j+ direction[1];

            if(x>=0 && x<m && y>=0 && y<n)
            {
                if((board[x][y] == -2) || (board[x][y] ==1))
                {
                    ++liveNeighCount;
                }
            }

        }
        return liveNeighCount;
    }


    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        //0to1 => -1
        //1 to 0 => -2
        for(int i=0; i<m ; ++i){
            for(int j =0 ; j<n ; ++j)
            {
                int liveNeighCount = getLiveNeighborcount(board, i, j);
                if(board[i][j] == 1) //live
                {
                    // <2 => dead
                    // ==2 || ==3 -> alive
                    //>3 => dead
                    if(liveNeighCount <2 || liveNeighCount >3)
                    {
                        board[i][j] =-2;
                    }
                }
                else{
                    //dead

                    if(liveNeighCount ==3)
                    {
                        board[i][j] =-1;
                    }
                }
            }
        }




        for(int i=0;i<m ;++i)
        {
            for(int j=0; j<n; ++j)
            {
                if(board[i][j]==-1)
                {
                    board[i][j] =1;
                }
                else if(board[i][j] ==-2)
                {
                    board[i][j] =0;
                }
            }
        }

    }
}