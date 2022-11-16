// Time Complexity : O(n*m)
// Space Complexity :O(1) 
class Solution {
    int n, m;
    public void gameOfLife(int[][] board) {
        if(board==null || board.length==0) return;
        //2= 1 to 0, 3= 0 to 1
       n=board.length;
        m=board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int count= countLive(board, i ,j);
                if(board[i][j]==1){
                    if(count < 2 || count > 3){
                        board[i][j] =2;
                    } 
                    
                }else{
                    if(count==3){
                        board[i][j] =3;
                    }
                }        
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==2){
                    board[i][j]=0;
                }else if(board[i][j]==3){
                    board[i][j]=1;
                }
            }
        }
        
        
    }
    
    private int countLive(int[][] board, int r, int c){
        int cnt=0;
        
        //              
        int[][] dirs={{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1}, {1,-1},{1,1}};
        for(int[] dir: dirs){
            int nr=r + dir[0];
            int nc= c + dir[1];
            if(nr>=0 && nc>=0 && nr<n && nc<m && (board[nr][nc]==1 || board[nr][nc]==2)){
                cnt++;
            }
            
        }
        return cnt; 
    }
}