//approach-In my approach to solving the problem, I start by defining a direction array that captures all eight possible neighbor positions for each cell. As I traverse the grid, I check each cell’s neighbors and count the number of live cells (1s) surrounding it. Based on the rules of the problem, if a live cell has fewer than two or more than three live neighbors, it dies. However, instead of immediately setting it to 0 (dead), I temporarily mark it as 3. This is done to preserve its previous state during the current iteration, since it may still be considered a live neighbor for other surrounding cells being processed. Similarly, when a dead cell (0) has exactly three live neighbors, it becomes alive, and I mark it as 2 for the same reason—preserving its prior state for subsequent neighbor checks. After processing the entire matrix, I perform another pass through the grid to finalize the state changes: converting all 3s to 0s and all 2s to 1s.
//time complexity-O(2(m x n)=O(m x n)since we are traversing the matrix twice and in the first tranversal we are iterating through a constant amount of directions

//space complexity-O(1)since we only have variables and directions array doesnt exceed 8 in length which is again a  constant
class Solution {
    public void gameOfLife(int[][] board) {
        int m=board.length;
        int n=board[0].length;
        //all the 8 directions
        int[][] dir={{-1,-1},{-1,0},{-1,1},{0,-1},
                    {0,1},{1,-1},{1,0},{1,1}};
        
       for(int row=0;row<m;row++){
        for(int col=0;col<n;col++){
            int countOne=0;
            //having a count of 0's and 1's for each element
            for(int i=0;i<dir.length;i++){
                int r=row+dir[i][0];
                int c=col+dir[i][1];
                //checking if each of the neighbour is inbound
                if(r<0||r>=m) continue;
                if(c<0||c>=n) continue;
                
                if(board[r][c]==1||board[r][c]==2)countOne++;
            }
            //if there are 3 1's implies 0->1 and i am marking it as 3
            if(board[row][col]==0){
                if(countOne==3)board[row][col]=3;
            }
            else if(board[row][col]==1){
                //if there are less than 2 or greather than 3  1's implies 1->0 and i am marking it as 2
                if(!(countOne>=2 && countOne<=3))board[row][col]=2;
            }
        }
       }
        //traversing the matrix to make 2->0 and 3->1
       for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(board[i][j]==2)board[i][j]=0;
            if(board[i][j]==3)board[i][j]=1;
        }
       }
    }
}
