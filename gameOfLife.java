// TC : O(m*n)
// SC : O(1)

class Solution {
    public void gameOfLife(int[][] board) {
        int[][] dir={{1,-1},{1,0},{1,1},{0,-1},{0,1},{-1,-1},{-1,0},{-1,1}}; // All directions around a cell

        for(int i=0;i<board.length;i++){
            
            for(int j=0;j<board[0].length;j++){
                
                int live=0;
                
                for(int[] d:dir){

                    if((i+d[0])<0||(i+d[0])>=board.length||(j+d[1])<0||(j+d[1])>=board[0].length){
                        continue;
                    }

                    if(board[i+d[0]][j+d[1]]==1||board[i+d[0]][j+d[1]]==2){
                        live++;
                    }
                }

                if(board[i][j]==1&&(live<2||live>3)){

                    board[i][j]=2;

                }
                if(board[i][j]==0&&live==3){
                    board[i][j]=3;                

                }
            }
        }

        for(int i=0;i<board.length;i++){
            
            for(int j=0;j<board[0].length;j++){
                
                if(board[i][j] == 2){
                    
                    board[i][j] = 0;
                }
                else if(board[i][j] == 3)
                {
                    board[i][j] = 1;
                }
            }

        }
        
    }
}
