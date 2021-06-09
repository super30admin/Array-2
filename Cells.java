//time complexity: O(n^2)
//space complexity: O(1)
class Solution {
    public void gameOfLife(int[][] board) {
        if(board==null||board.length==0||board[0].length==0)
        {
            return;
        }
        int m=board.length;int n=board[0].length;
        
        
        for(int i=0;i<m;i++)
        {
            for( int j=0;j<n;j++)
            {
                int count = neighbours(board, i,j,m,n);//count stores the 
                //number of neighbours satisfying the given conditions of 
                // the live cell dying.
                if(board[i][j]==1 && (count <2 || count>3))
                {
                    board[i][j]=3;//replace the live cell by another no.
                    //say 3 as it is going to die
                }
                if(board[i][j]==0 && count==3)
                {
                    board[i][j]=2;//replace the dead cell by any other no.
                    //say 2 as it is going to live
                }
                
            }
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]==3)
                {
                    board[i][j]=0;//replacing the correct values 
                }
                if(board[i][j]==2)
                {
                    board[i][j]=1;//replacing the correct values 
                }
            }
        }
    }
    private int neighbours(int[][] board, int i,int j, int m,int n)
    {
        int result =0;
        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
        for(int[] dir:dirs)
        {
            int r=i+dir[0];//here we check for the neighbours of a each of the cells
            //if they are one or three then increment the result.
            int c=j+dir[1];
            if(r>=0 && r<m && c>=0 && c<n && (board[r][c]==1||board[r][c]==3))
            {
                result++;
            }
            
        }
        return result;
    }
}
