//Time Complexity : O(M*N)
//Space Complexity: O(1)
class Solution {
    public void gameOfLife(int[][] board) {
         //Live to dead
         //1 => 2
         //Dead to live
         //0 -> 3
         int[][] dirs={{0,1},{0,-1},{1,0},{-1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
         //              R      L      D     T      DTL    DTR   DDL    DDR
         int m=board.length;
         int n=board[0].length;
         
         for(int i=0;i<m;i++){
             for(int j=0;j<n;j++){
                 int countOnes=0;
                 for(int[] dir:dirs){
                     int xCord=i+dir[0];
                     int yCord=j+dir[1];
                     if((xCord<m && xCord>=0) && (yCord>=0 && yCord<n)){
                         if(board[xCord][yCord]==1 || board[xCord][yCord]==2)
                             countOnes++;
                     }
                 }
                 //condition 4
                 if(countOnes==3 && board[i][j]==0)
                    board[i][j]=3;
                 //Condition 3
                 //Condition 2
                 if((countOnes<2|| countOnes>3) && board[i][j]==1)
                     board[i][j]=2;
             }
         }
         for(int i=0;i<m;i++){
                 for(int j=0;j<n;j++){
                     if(board[i][j]==2)
                         board[i][j]=0;
                     if(board[i][j]==3)
                         board[i][j]=1;
                 }
             }
     }
 }