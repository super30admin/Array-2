// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

class GameOfLife {
    public void gameOfLife(int[][] board) {
        int[][] dirs = new int[][] {{0,1}, {1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1}};
        int r = board.length;
        int c = board[0].length;
        for(int i=0;i<r;i++){
            for(int j=0; j<c;j++){
                int live = findLive(r, c,i,j,dirs, board);
                if( board[i][j]==1){
                    if(live<2){
                    board[i][j]=4;
                    } else if(live>3){
                    board[i][j]=4;
                    }
                } else if(board[i][j]==0 && live==3){
                    board[i][j]=3;
                }
            }
        }
        for(int i=0;i<r;i++){
            for(int j=0; j<c;j++){
                if(board[i][j]==4){
                    board[i][j]=0;
                } else if(board[i][j]==3){
                    board[i][j]=1;
                } 
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }

    }

    public int findLive(int r, int c, int row, int col, int[][] dirs, int[][] board){
        int live = 0;
        int nr, nc;
        for(int[] dir: dirs){
            nr = row+dir[0];
            nc = col+dir[1];
            if(nr>=0 && nr<r && nc>=0 && nc<c && (board[nr][nc]==1 || board[nr][nc]==4)) 
            live++ ;
        }
        return live;

    }

    public static void main(String[] args) {
        GameOfLife obj = new GameOfLife();
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        obj.gameOfLife(board);
    }
}