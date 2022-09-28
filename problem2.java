public class problem2 {

// Time Complexity : O(m*n) where m and n are number of elements in rows and coloumns.
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

    int m = 0;
    int n = 0;
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0) return;       
        
        m = board.length;
        n = board[0].length;
        //1 === 0 ===> 2
        //0 === 1 ===> 3
        
        for(int i=0; i<m ;i++){
            for(int j=0; j<n ; j++){
                int liveneighbors = countliveneighbors(board,i,j);
                if(board[i][j] == 0){//dead cell
                    if(liveneighbors == 3){
                        board[i][j] = 3;
                    }
                }else{//live cell
                    if(liveneighbors <2 || liveneighbors>3){
                        board[i][j] = 2;
                        }
                    }
                }
            }
        
        for(int i=0; i<m ;i++){
            for(int j=0; j<n ; j++){
                if(board[i][j] == 2){
                    board[i][j] = 0;
                }else if(board[i][j] == 3){
                    board[i][j] = 1;
                }
            }
        }       
    }
    public int countliveneighbors(int[][] board, int i, int j){
        int count=0; // count of live neighbors
        int[][] dirs = {{0,1},{0,-1},{-1,0},{1,0},{-1,-1},{1,1},{-1,1},{1,-1}};
        for(int[] dir: dirs){
            int nr = i + dir[0];
            int nc = j + dir[1];
            if(nr >= 0 && nc >= 0 && nr < m && nc < n && (board[nr][nc] == 1 || board[nr][nc] == 2)){
                count++;
            }
        }
        return count;
    }
}
