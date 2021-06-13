// Time Complexity: O(mn)
//Space Complexity: O(1)
class Solution {
    public void gameOfLife(int[][] board) {
        int m=board.length, n=board[0].length, count=0;
        //0 - 1 => 2
        // 1- 0 => -2
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                count=countLiveNeighbours(board,i, j);
                
                if(board[i][j]==1)
                {
                     // 0 or -2 dead cell
                    if(count<2 || count>3)
                    {
                        board[i][j]=-2;
                    }
                    
                }
                else
                {
                    // 1 or 2 live cell
                    if(count==3)
                    {
                        board[i][j]=2;
                    }
                }
               // System.out.print(count+" ");
               
            }
           // System.out.println();
        }
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]<0)
                    board[i][j]=0;
                else if(board[i][j]>1)
                    board[i][j]=1;
                else
                    continue;
            }
        }
        
    }
    
    public int countLiveNeighbours(int[][] board, int i, int j)
    {                            // lt   rt    down   up     up-lt down-rt up-rt  down-lt
        int[][] dirs=new int[][] {{0,-1},{0,1},{1,0},{-1,0},{-1,-1},{1,1},{-1,1},{1,-1}}; 
        int x=0, y=0, m=board.length,n=board[0].length, count=0;
        for(int[] dir: dirs)
        {
            x= i+dir[0];
            y=j+dir[1];
        
            if(x >=0 && x< m && y>=0 && y<n && (board[x][y]==1 || board[x][y]==-2))
            {
                count++;
            }
            
        }
        
        return count;
    }
}