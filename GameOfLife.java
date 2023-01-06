public class GameOfLife {
    //https://leetcode.com/problems/game-of-life/
//TC -O(n*m)
    //SC O(1)
    public static void main(String[] args) {
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        gameOfLife(board);
    }
    static int m,n;
    public static void gameOfLife(int[][] board) {
        if(board==null|| board.length == 0) return;
        m = board.length;
        n = board[0].length;
        for(int i =0;i<m;i++){
            for(int j = 0; j<n;j++){
                int count= counterMethod(board,i,j);
                if(board[i][j]==1){
                    if(count<2||count>3) board[i][j]=2;
                }
                else{
                    if(count==3) board[i][j]=3;
                }

            }
        }

        for(int i = 0 ;i<m;i++){
            for(int j =0; j<n;j++){
                if(board[i][j]==2) board[i][j]=0;
                else if(board[i][j]==3) board[i][j]=1;
            }
        }

    }
    private static int counterMethod(int[][] board,int i,int j){
        int count = 0;
        int[][] dirs ={{0,1},{1,0},{0,-1},{-1,0},{1,1},{-1,-1},{1,-1},{-1,1}};
        for(int[] dir: dirs){
            int row = i + dir[0];
            int col = j + dir[1];
            if(row>=0 && col>=0 && row<m && col<n &&(board[row][col]==1 || board[row][col]==2)) count++;
        }
        return count;
    }
    }


