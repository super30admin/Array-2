#time complexity = O(m*n)
#space complexity = O(1)

class Solution {
    public void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] dir = {{-1,-1},{-1,0},{1,-1},{0,-1},{0,1},{-1,1},{1,1},{1,0}};
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                // 0--1 ->2
                // 1--0 ->3
                int count = getCount(board,dir,m,n,i,j);
                if(board[i][j] == 1 && (count < 2 || count > 3)){
                    board[i][j] = 3;
                }
                if(board[i][j] == 0 && count == 3){
                    board[i][j] = 2;
                }
            }
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 3){
                    board[i][j] = 0;
                }
                 if(board[i][j] == 2){
                    board[i][j] = 1;
                }
            }
        }
    }
    
    private int getCount(int[][] board, int[][] dir,int m,int n,int i,int j){
        int count=0;
        for(int[] d: dir){
            int o = i + d[0];
            int p = j + d[1];
            if(o>=0 && o<n && p>=0 && p<m && (board[o][p] == 1 || board[o][p] == 3)){
                count++;
            }   
        }
        return count;
    }
}
