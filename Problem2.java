//Game of Life
//spacecomplexity :o(1)
//timecomplexity : o(mn)
public class Problem2 {
    int m=0;
    int n=0;
    public void gameOfLife(int[][] board) {
        if(board==null || board.length==0){
            return;
        }
        //2= dead
        //3=live
        m= board.length;
        n=board[0].length;
        
        for(int i=0; i<m;i++){
            for(int j=0; j<n;j++){
                    int liveCells = getLiveCells(board,i,j);
                if(board[i][j]==1){
                    if(liveCells<2 || liveCells>3){
                        board[i][j]=2;
                    }
                }else{
                      if(liveCells==3){
                         board[i][j]=3;
                      }
                }
            }
        }
        
           for(int i=0; i<m;i++){
            for(int j=0; j<n;j++){
                if(board[i][j]==2){
                    board[i][j]=0;
                }else if(board[i][j]==3){
                    board[i][j]=1;
                }
            }
           }
        
        
    }
    
    
    public int getLiveCells(int[][]board,int i,int j){
        int[][] dir={{1,-1},{1,0},{1,1},{0,-1},{0,1},{-1,-1},{-1,0},{-1,1}};
        int count=0;
        for(int[] d : dir){
            int nr=i+d[0];
            int nc=j+d[1]; 
            if(nr>=0 && nc>=0 && nr<m && nc<n && (board[nr][nc]==1 || board[nr][nc]==2)){
                count++;
            }
    
}
    return count;
    }
}
