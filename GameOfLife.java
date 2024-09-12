/**
 * Time Complexity : O(m*n) where m = number of rows , n = number of columns of board
 * Space Complexity: O(1)
 */
public class GameOfLife {
    int m,n;
    public void gameOfLife(int[][] board) {
        // 0 --> 1 = 2
        // 1 --> 0 = -1
        
        if(board == null || board.length==0) return;
        m = board.length;
        n = board[0].length;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int lives = countLives(board,i,j);
                if(board[i][j]==1){ //alive
                    if(lives<2 || lives >3){ //rule 1 & 3
                        board[i][j] = -1;
                    }
                }
                    else{//dead
                        if(lives==3){
                            board[i][j] = 2;
                        }
                    }
                }
            }
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(board[i][j] == 2 ) board[i][j] = 1;
                    if(board[i][j] == -1) board[i][j] = 0;
                }
            }
            
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    System.out.print(board[i][j]+",");
                }
            }
        }
    
        
        private int countLives(int[][] board,int i,int j){
            int[][] dirs = {{0,1},{0,-1},{-1,0},{1,0},{-1,1},{1,1},{-1,-1},{1,-1}};
            int count = 0;
            for(int[] dir:dirs){
                int r = i+dir[0];
                int c = j+dir[1];
                if(r>=0 && c>=0 && r<m && c<n && (board[r][c] == 1 || board[r][c] == -1)){
                    count++;
                }
            }
            return count;
        } 

        public static void main(String[] args){
            GameOfLife obj = new GameOfLife();
            int[][] myArr = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
            obj.gameOfLife(myArr);
        }
}