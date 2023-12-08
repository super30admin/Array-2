//T.C - O(m*n)
//S.C - O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -

/*
Use directions matrix to check for each direction for each number
 */
public class GameOfLife_DirectionMatrix {
    int[][] dir={{1,-1},{1,0},{1,1},{0,-1},{0,1},{-1,-1},{-1,0},{-1,1}};

    public void gameOfLife(int[][] board) {
        for(int i=0;i<board.length;i++){ //O(m)
            for(int j=0;j<board[0].length;j++){//O(n)
                int live=0;
                for(int[] d:dir){ //for each direction i.e., 8 times
                    if((i+d[0])<0||(i+d[0])>=board.length||(j+d[1])<0||(j+d[1])>=board[0].length){ //checking for out of boundaries scenario
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