//Time Complexity:O(m*n)
//Space Complexity: O(1)
class Solution {
    int[][] dirs;
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        this.dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};

        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                int isAlive = board[i][j];
                int count = countAliveNeighbors(board,i,j,m,n);
                if(isAlive == 1 && (count<2 || count>3 ))
                    board[i][j] = 2; // Alive -> dead
                else if(isAlive == 0 && count == 3)
                    board[i][j] = 3;//Dead -> ALive
            }
        }
         for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                if(board[i][j]==2)
                    board[i][j] = 0;
                else if(board[i][j]==3)
                    board[i][j] = 1;
            }
         }

    }
    private int countAliveNeighbors(int[][] board,int i,int j, int m , int n){
        int count = 0;
        for(int[] dir:dirs){
            int r = i + dir[0];
            int c = j + dir[1];
            if(r>=0 && c>=0 &&r<m &&c <n){
                if(board[r][c]==1 || board[r][c]==2)
                    count++;
            }
        }
        return count;
    }
}