// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//Instead of using a auxiliary matrix again we are marking as below when they change their state
//markings: live to dead= 1 to 2
//markings: dead to live= 0 to 3
//Reason being we have to update state based on the previous state of the board

public class GameOfLife {
    public static void gameOfLife(int[][] board) {
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                int cell=board[i][j];
                int liveNeighbourCount=getLiveNeighboursCount(board,i,j);
                if(cell==1)
                {
                    if(liveNeighbourCount<2)
                    {
                        //marking live cell to dead;
                        board[i][j]=2;
                    }
                    else if(liveNeighbourCount>3)
                    {
                        //marking live to dead
                          board[i][j]=2;
                    }
                    
                }
                else{
                   if(liveNeighbourCount==3)
                   {
                       //mark dead to live
                         board[i][j]=3;
                       
                   }
                }
            }
        }
        //job of markings are done so we can make all the 3's as 1 and 2's as 0
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]==3)
                    board[i][j]=1;
                else if(board[i][j]==2)
                      board[i][j]=0;
                
            }
        } 
        
       
    }
    
    static int  getLiveNeighboursCount(int[][] board, int i, int j)
    {                  //r    //l    //u.   //d   //ld     //lu
        int[][] dirs= {{0,1},{0,-1},{1,0},{-1,0},{1,-1}, {-1,-1}, {-1,1},{1,1}};
        int count=0;
        for(int k=0;k<dirs.length;k++)
        {
            int row=i+dirs[k][0];
            int column=j+dirs[k][1];
            
            if(row>=0 && row<board.length && column>=0 && column<board[0].length)
            {
                if(board[row][column]==1 || board[row][column]==2)
                    count++;
                
            }
            
            
            
        }
        
        return count;
    }

    public static void main(String[] args)
    {
        int[][] board={{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        gameOfLife(board);

        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[i].length;j++)
            {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }   
    }
}
