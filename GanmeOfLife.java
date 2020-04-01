// Time Complexity :O(mn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Follow the given rules
class Solution {
    public void gameOfLife(int[][] board) {
        //edge case
        if(board==null || board.length==0) return;
     int [][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1},{-1,-1},{1,1},{-1,1},{1,-1}};
     
        for(int i = 0 ; i <board.length;i++)
        {
            for(int j = 0 ; j <board[0].length;j++)
            {
                int live = neighbour(board,i,j,dirs);
                //live cell
                if(board[i][j]==1)
                {
                    //condition 1
                    if(live<2 || live >3)
                        board[i][j] =5; //DEAD
                }
                else //dead cell
                {
                    if(live==3)
                       board[i][j] =3; //Live
                }
            }
        }
        for(int i = 0 ; i <board.length;i++)
        {
            for(int j = 0 ; j <board[0].length;j++)
            {
                if(board[i][j] == 5)
                    board[i][j] =0;
                if(board[i][j]==3)
                    board[i][j]=1;
            }
        }
    
    }
    private int neighbour(int[][] board,int i , int j,int[][] dirs)
    {
        int count=0;
        
        for(int[] d:dirs)
        {
            int r = i+ d[0];
            int c = j+d[1];
            if(r >=0 && r <board.length && c>=0 && c <board[0].length)
            {
                if(board[r][c]==5 || board[r][c]==1)
                    count+=1;
            }
            
        }
        return count;
    }

}