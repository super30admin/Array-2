/*
 * Time Complexity : O(m*n)
 * Space Complexity :  O(1)
 * Did this code successfully run on Leetcode : yes
 * Any problem you faced while coding this : No
 * 
 * Approach - We construct a directions array to traverse all the 8 neighbors of an element and count the number of live neighbours. 
 * We traverse through each element of the matrix and count the live neighbors. We use the conditions provided and change the state of the element 
 * to either dead or live. To differentiate between the new alive & dead state, we change the element to 3 if the element was dead and is now alive and 
 * change it to 2 if the element was previously alive and is now dead.
 */

//https://leetcode.com/problems/container-with-most-water/description/
class GameOfLife {
    int m,n;
    int[][] directions=new int[][]{{-1,0},{0,1},{1,0},{0,-1},{-1,-1},{-1,1},
    {1,1},{1,-1}};
    public void gameOfLife(int[][] board) {
        int count=0;
        m=board.length;
        n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                count = getAliveCount(i,j,board);
                //case aliveNeighbours <2 or aliveNeighbours>3
                if(board[i][j]==1 && (count>3 || count<2)) 
                    board[i][j]=2;
                else if(board[i][j]==0 && count==3 )
                    board[i][j]=3;
                else if(board[i][j]==1 && (count==3 || count==2))
                    board[i][j]=1;
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==3)
                    board[i][j]=1;
                else if(board[i][j]==2)
                    board[i][j]=0;
            }
        }
    }

    private int getAliveCount(int i,int j, int[][]board){
        int count=0;
        int nr,nc; 
        for(int k=0;k<directions.length;k++){
            nr = i+directions[k][0];
            nc= j+ directions[k][1];
            if(nr<m && nr>=0 && nc<n && nc>=0){
                if(board[nr][nc] == 2 || board[nr][nc]==1){
                    count++;
                }
            } 
        }
        return count;
    }
}