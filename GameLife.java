//Time Complexity: O(m*n*8) 
//Space complexity : O(1) Used only constant spaces
//Executed on leet code.

class Solution { 
    public void gameOfLife(int[][] board) { // 0 --> 1 5  Instead of changing 0(died) to live(1) using 5 represent 0 and indicates value should be changed to 1.
        for(int i=0;i<board.length;i++)     // 1 --> 0 4 Instead of changing live(1) to  0(died) using 4 represent 1 and indicates value should be changed to 0.
        {
            for(int j=0;j<board[0].length;j++)
            {
                int [][]directions = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
                int count=0;
                for(int k=0;k<directions.length;k++)
                {
                    int x = i+directions[k][0];                                 //Used directions array to check neighbour values.
                    int y = j+directions[k][1];
                    if(x>=0 && x<board.length && y>=0 && y<board[0].length && (board[x][y]==1 || board[x][y]==4))
                    {
                        count++;
                    }
                }
                    
                    if(board[i][j]==1 && (count<2 || count>3))      //based on the given four conditions changing the values.
                        board[i][j] = 4;
                    else if(board[i][j]==0 && count==3)
                        board[i][j] = 5;
                
            }
        }
        
        for(int i=0;i<board.length;i++)     // 1 --> 0 4
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j] == 5)
                    board[i][j] = 1;
                if(board[i][j] == 4)
                    board[i][j] = 0;
            }
        }
    }
}