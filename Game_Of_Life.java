//TimeComplexity O(m*n)
//SpaceComplexity O(1)
class Solution {
    int m;
    int n;
    int[][] dirs;
    public void gameOfLife(int[][] board) {        
        m = board.length;
        n = board[0].length;
        dirs = new int[][] {{0,1},{0,-1}, {1,0}, {-1,0},{-1,-1},{-1,1}, {1,-1},{1,1}};
        for(int i = 0 ; i < m;i++){
            for(int j = 0; j < n ; j ++){
                int countAlive = countAlive(board,i,j);
                //count < 2 or > 3 1 -> 0, count == 3 0 -> 1
                //orginal value 0 -> 3 , 1 ->  2
                if((countAlive > 3 || countAlive < 2) && (board[i][j] == 1)){
                    board[i][j] = 2;
                }else if(board[i][j] == 0 && countAlive == 3){
                    board[i][j] = 3;
                }else{
                    continue;
                }                
            }
        } 
           for(int i = 0 ; i < m;i++){
            for(int j = 0; j < n ; j ++){
                if(board[i][j] == 3) board[i][j] = 1;                   
                if(board[i][j] == 2) board[i][j] = 0;
            }
        } 
    }
    
    private int countAlive(int[][] board, int i, int j){
        int result = 0;
        for(int[] dir : dirs){
            int nr = i + dir[0];
            int nc = j + dir[1];
            if(nr >= 0 && nc >= 0 && nr < m && nc < n && (board[nr][nc] == 1 || board[nr][nc] == 2)){
                result++;                
            }
            
        }
        return result;        
    }
}
