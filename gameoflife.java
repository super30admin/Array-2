class Solution {
 
  //TC:O(n^2) SC:O(1)  
  
    int dir[][]={{0,1},{0,-1},{-1,0},{1,0},{1,-1},{-1,1},{1,1},{-1,-1}};
    public void gameOfLife(int[][] board) {
        int m=board.length;
        int n=board[0].length;
        int countalive=0;
        //rules: element is 1 and hasless than 2neigbors,dies - become 0()
        //if element is 1,and hasmore than 3 neighbours, dies -become 0
        //if elemet is 0 and has 3 neihgbours, becomes 1
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                countalive=countAlive(board,i,j);   
                if(board[i][j]==1&&(countalive<2||countalive>3))board[i][j]=3; //3 is deead
                if(board[i][j]==0&&(countalive==3))board[i][j]=2; //2 is alive
                
            }
        }
        for(int i=0;i<m;i++){
         for(int j=0;j<n;j++){
           if(board[i][j]==3)board[i][j]=0;
           if(board[i][j]==2)board[i][j]=1;
          }
        }
        
        
    }
     int countAlive(int board[][],int i,int j){
        
        int count=0;
        
        for(int d[]:dir){
         int nrow=i+d[0];
         int ncol=j+d[1];
         if (nrow>=0 && ncol>=0 && nrow<board.length && ncol<board[0].length){
                     if( board[nrow][ncol]==1 ||board[nrow][ncol]==3 )
                     { count+=1;}
            }}
        return count;
    }
}
