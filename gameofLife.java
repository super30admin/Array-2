/**Time Complexity: O(m*n)
 * Space Complexity: O(1)
 * Did this code successfully run on leetcode: Yes
 * Any problems faced while coding this: No
 */


/**
 * The direction array and the lengths are declared as global variables as they need to be accessed in both methods.
 * For every element we check all 8 neighbors using the direction array.
 * We use temporary numbers like 2 and 3 instead of 0 and 1 to keep track of values before change since,  when we move to next values we must consider the prior values to determine the number of live neighbors.
 * Also while checking the neighbors we add additional check to avoid accessing invalid indexes
 */

class gameOfLife {
    int[][] dirs={{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
    int m;
    int n;
    public void gameOfLife(int[][] board) {
        m=board.length;
        n=board[0].length;
        for (int i=0;i<=m-1;i++)
        {
            for(int j=0;j<=n-1;j++)
            {
                int livecount=getcount(board,i,j);
                if(board[i][j]==0 && livecount==3)
                {
                    board[i][j]=2; //dead-->alive
                }
                else if(board[i][j]==1 && (livecount>3 || livecount<2))
                {
                    board[i][j]=3; //alive-->dead
                }
            }
        }
        
        for (int i=0;i<=m-1;i++)
        {
            for(int j=0;j<=n-1;j++)
            {
                if(board[i][j]==2)
                    board[i][j]=1;
                else if(board[i][j]==3)
                    board[i][j]=0;
            }
        }
        return;

    }
    public int getcount(int[][] board,int i,int j)
    {
        int count=0;

        for(int[] dir:dirs)
        {
            int r=i+dir[0];
            int c=j+dir[1];

            if(r>=0 && r<=m-1 &&c>=0 &&c<=n-1)
            {
                if(board[r][c]==1||board[r][c]==3)
                {
                    count=count+1;
                }
            }

        }
      
        return count;
    }
}