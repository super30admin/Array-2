// Time Complexity :O(n*m) 
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no
class Solution {
    public int[][] dirs={{0,-1},{0,1},{-1,0},{-1,-1},{1,0},{1,1},{1,-1},{-1,1}};
    public void gameOfLife(int[][] board) {
        //0-1 2
        //1-0 3
        
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                int live=count(board,i,j);
                if((board[i][j]==0 || board[i][j]==2) && (live==3))  //dead cell with 3 live neighbours
                {
                    board[i][j]=2;
                }
                if((board[i][j]==1 || board[i][j]==3))
                {
                    if(live<2 || live>3)
                         board[i][j]=3;
                    
                }
            }
        }
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]==2)
                    board[i][j]=1;
                if(board[i][j]==3)
                    board[i][j]=0;
            }
        }
        
    }
    private int count(int[][] board,int i,int j) //here i is the location
    {
        int co=0; //count
        for(int[] dir:dirs){
            int r=dir[0]+i;
            int c=dir[1]+j;
            if(r>=0 && r<=board.length-1 && c>=0 && c<=board[0].length-1 && (board[r][c]==1 || board[r][c]==3))
            {
                co++;
            }
            
        }
        return co;
    }
}