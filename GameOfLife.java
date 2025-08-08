// This traverses the whole matrix. At each element we check number of 1's and apply given rules. Only catch is that we have to keep the state of the previous element at the same time update it. To keep this case, we convert 0 to 2 and 1 to 3 to make sure we know the previous case. At end, we conver 2 to 1 and 3 to 2 to get the states
class Solution {
    int[][] rows = new int[][]{{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
    public void gameOfLife(int[][] board) {
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                update(board, i, j);
            }
        }
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(board[i][j]==2) {
                    board[i][j]=1;
                }
                if(board[i][j]==3) {
                    board[i][j]=0;
                }
            }
        }
    }

    private void update(int[][] board, int i, int j) {
        int oneCount = 0;
        for(int a=0;a<8;a++) {
            int[] row = rows[a];
            int b = i+row[0];
            int c = j+row[1];
            if(b<0 || c<0 || b>board.length-1 || c>board[0].length-1) {
                continue;
            }
            if(board[b][c]==1 || board[b][c]==3) oneCount++;
        }
        if(board[i][j]==0 && oneCount==3) {
            board[i][j] = 2;
        } else if(board[i][j]==1 && (oneCount<2 || oneCount>3)) {
            board[i][j] = 3;
        } 
    }
}

// 1 - <2 - 0
// 1 - >=2 and <=3 - 1
// 1 - >3 - 0
// 0 - =3 - 1
