public class GameOfLife {

    class Solution {

        //  0  1  0  1   00  01  02  03   (m-1)(n-1)  (m-1)n    (m-1)(n+1)
        //  0  0  1  1   10  11  12  13    m(n-1)       mn      m(n+1)
        //  1  1  1  0   20  21  22  23   (m+1)(n-1)  (m+1)n    (m+1)(n+1)

        //cell==1    neighbors < 2  live cells  becoms 2- for indicating dead
        //cell=1     neighbors == 2 or 3  no change it lives
        //cell=1     neighbors > 3   dies becomes 2 indicating dead
        //cell=0     neighbours == 3  become live value -3 indication

        int[][] dir={{1,-1},{1,0},{1,1},{0,-1},{0,1},{-1,-1},{-1,0},{-1,1}};
        public void gameOfLife(int[][] board) {
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[0].length;j++){
                    int live=0;
                    for(int[] d:dir){
                        if((i+d[0])<0||(i+d[0])>=board.length||(j+d[1])<0||(j+d[1])>=board[0].length){
                            continue;
                        }
                        if(board[i+d[0]][j+d[1]]==1||board[i+d[0]][j+d[1]]==2){
                            live++;
                        }
                    }
                    if(board[i][j]==1&&(live<2||live>3)){
                        board[i][j]=2;
                    }
                    if(board[i][j]==0&&live==3){
                        board[i][j]=3;
                    }
                }
            }
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[0].length;j++){
                    board[i][j]=board[i][j]%2;
                }
            }
        }
    }
}
