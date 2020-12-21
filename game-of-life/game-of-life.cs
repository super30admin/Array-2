public class Solution {
    public void GameOfLife(int[][] board) {
        
        int[] neighbours = {0,1,-1};
        
        int rows = board.Length;
        int cols = board[0].Length;

        for(int i =0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                int count =0;
                Console.WriteLine(board[i][j]);

                
                for(int x =0;x<3;x++)
                {
                    for(int y=0;y<3;y++)
                    {
                        if(!(neighbours[x]==0 && neighbours[y]==0))
                        {
                            int a = (i+neighbours[x]);
                            int b = (j+neighbours[y]);
                            if((a<rows && a>=0) && (b<cols && b>=0) && 
                               (Math.Abs(board[a][b])==1))
                            {
                                count+=1;
                            }
                        }
                    }
                }
                
                if((board[i][j]==1) && (count <2 || count >3))
                {
                    board[i][j] =-1;
                }
                if(board[i][j]==0 && count==3)
                {
                    board[i][j]=2;
                }
            }
        }
        for(int row=0;row<rows;row++)
        {
            for(int col=0;col<cols;col++)
            {
                if(board[row][col]>0)
                {
                    board[row][col]=1;
                }
                else
                {
                    board[row][col]=0;
                                    }
            }
        }
        
    }
}
