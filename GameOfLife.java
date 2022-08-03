class Solution {
    int m ,n;
    int[][] dirs;
    public void gameOfLife(int[][] board) {
        m = board.length;
        n = board[0].length;
        dirs =new int[][] {{-1,0},{1,0},{0,-1},{0,1},{1,1},{1,-1},{-1,1},{-1,-1}};
        for(int r=0;r<m;r++){
            for(int c=0;c<n;c++){
                int count = getCount(board,r,c);
                if(board[r][c] == 1 && (count < 2 || count >3))
                    board[r][c] = 3;
                if(board[r][c] == 0 && count == 3)
                    board[r][c] = 2;
            }
        }
        for(int r=0;r<m;r++){
            for(int c=0;c<n;c++){
                if(board[r][c] == 2)
                    board[r][c] = 1;
                if(board[r][c] == 3)
                    board[r][c] = 0;
            }
        }
    }
    
    public int getCount(int[][] board,int r,int c){
        int count =0;
        for(int[] dir:dirs){
            int nr = r + dir[0];
            int nc = c + dir[1];
            if(nr>=0 && nr< m && nc >=0 && nc<n && (board[nr][nc]==1 || board[nr][nc]==3))
                count++;
        }
        return count;
    }
}
