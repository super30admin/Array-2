// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
//approach: we iterate through the matrix, find the count of neighbouring elements with the help of dirs array and count function.
//if the count==3 we make it 3 to mark its change from dead to alive, if not we make it 2 to mark it alive to dead.In the next
//iteration, if an element is 2 we make it 0 as its dead, if its 3, we make it 1 as its alive.


// Your code here along with comments explaining your approach

public class gameoflife {
    class Solution {
        public void gameOfLife(int[][] board) {
            int m=board.length;
            int n=board[0].length;
            int[][] dirs=new int[][]{{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};
            for(int i=0;i<m;i++)
            {   for(int j=0;j<n;j++)
                {
                    int count=getCount(dirs,board,i,j,m,n);
                    if(board[i][j]==0)
                    {
                        if(count==3)
                        {
                            board[i][j]=3;//dead->alive
                        }
                    }
                    else 
                    {
                        if(count<2||count>3)
                        {
                            board[i][j]=2;//alive->dead
                        }
                    }
                    System.out.println(count);
                }
            }
            for(int i=0;i<m;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(board[i][j]==2)
                        board[i][j]=0;
                    else if(board[i][j]==3)
                        board[i][j]=1;
                }
            }
        }
        public int getCount(int[][] dirs,int[][] board,int i,int j,int m,int n)
        {
            int count=0;
            for(int[] dir:dirs)
            {
                int nr=dir[0]+i;
                int nc=dir[1]+j;
                if((nr>=0) && (nr<m) && (nc>=0) && (nc<n))
                {
                    if(board[nr][nc]==1||board[nr][nc]==2)
                        count++;
                }
            }
            return count;
        }
    }
}
