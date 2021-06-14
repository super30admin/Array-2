//time conplexity = o(m*n)
//space complexity =o(1)
package leetcode;

class Faang33 {
    public void gameOfLife(int[][] board) {
        if(board==null ||  board.length==0 ||board[0].length==0 ) return;
        int m=board.length; int n=board[0].length;
        for(int  i =0;i<board.length;i++) {
            for (int j = 0; j < board[0].length; j++) {
                int count = countAlive(board,i,j,m,n);
                if(board[i][j]==1 && (count<2||count>3)){
                    board[i][j]=3;
                }
                if(board[i][j]==0 && count==3){
                    board[i][j]=2;
                }
            }
        }
        for(int  i =0;i<board.length;i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j]==2){
                    board[i][j]=1;
                }
                if(board[i][j]==3){
                    board[i][j]=0;
                }

            }
        }
    }
    public int countAlive(int[][] board,int i, int j , int m, int n) {
        int count = 0;
        int[][] dirs = {{-1, 1}, {0, 1}, {1, 0}, {1, 1}, {-1, 0}, {0, -1},{1,-1},{-1,-1}};
        for (int[] dir : dirs) {
            int r = i + dir[0];
            int c = j + dir[1];
            if(r>=0 && r<m && c>=0 && c<n &&(board[r][c] == 1 || board[r][c] == 3)){
                count++;
            }

        }
        return count;
    }
}
