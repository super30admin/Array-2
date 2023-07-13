// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach: to find the count of immediate neighbors of each cell we will be using a countAlive function. In this function we will use the directions array to iterate over the directions using the for loop.
//This function will return us the count of alive cell around each cell in the board. If the number is not equal to 2 or 3, it means it is dead. Since we cannot return any value through the given fuction, we need to make the changes in the already given board matrix. In this matrix whenever a 1 gets 0 we update its value to 2 and whenever a 0 gets 1, we update it to 3. This is known as temporary state change. We do this, so that the mutation doesn't affect our final answer. 
//Eventually we change these 2s and 3s once we have iterated through all the cells.

class Solution {
    int [][] dir;
    public void gameOfLife(int[][] board) {

int m=board.length, n=board[0].length;
            //right //left //up //down  //upleft //upright //downleft //downright
dir=new int[][]{{0,1},{0,-1},{-1,0},{1,0},{-1,-1},{-1,1},{1,-1},{1,1}};

//instead of using 8 operations to go through the directions to count the live cell, we would use for loops on the direcion array


for(int i=0;i<m;i++)
{
    for(int j=0;j<n;j++)
    {
        //Count function to count the number of live cells
        int cnt=CountAlive(board,i,j,m,n);
        //we check if the current cell is 1 and there is underpopulation or over population
        if(board[i][j]==1 && (cnt<2 || cnt>3))
        {
            //We do temporary state change and make the cell to 2
            //this also means originally the cell was alive and now it is dead
            board[i][j]=2;
        }
        if(board[i][j]==0 && cnt==3)
        {
            //We do temporary state change and make the cell to 3
            //this also means originally the cell was dead and now it is alive
            board[i][j]=3;
        }

    }
}

//replacing 2 and 3 with their respective mutated values
for(int i=0;i<m;i++)
{
    for(int j=0;j<n;j++)
    {
        if(board[i][j]==2)
        {
            //Originally 1, but now 0
            board[i][j]=0;
        }
        if(board[i][j]==3)
        {
            //Originally 0, but now 1
            board[i][j]=1;
        }
    }
}
        
    }


    private int CountAlive(int[][] board,int i,int j, int m, int n)
    {
        int count=0;
        for(int[] dirs:dir)
        {
            int r=i+dirs[0];
            int c=j+dirs[1];

            //this is to check the boundary of the row and column. They need to be greater than 0 and less than m and n. Also the current cell needs to be either 1 or should have been originally 1.
            if(r>=0 && c>=0 && r<m && c<n && (board[r][c]==1 || board[r][c]==2))
            {
               count++;
            }
        }   


        return count;
    }
}