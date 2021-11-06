class Solution {
    public void gameOfLife(int[][] board) {
        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[0].length;j++)
                board[i][j]=board[i][j]==0?2:board[i][j];

        int neighbours;
        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[0].length;j++){
                neighbours=countNeighbours(board,i,j);
                if(board[i][j]==2){
                    if(neighbours==3)
                        board[i][j]=2; //alive
                    else
                        board[i][j]=-2; //dead
                }
                else{
                    if(neighbours<2)
                        board[i][j]=-1;
                    else if(neighbours<=3)
                        board[i][j]=1;
                    else
                        board[i][j]=-1;
                }

            }


        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++)
                board[i][j]=board[i][j]>0?1:0;
        }
    }
    public static int countNeighbours(int[][] board, int i, int j){
        int count=0;
        count+=alive(board,i-1,j-1)?1:0;
        count+=alive(board,i-1,j)?1:0;
        count+=alive(board,i-1,j+1)?1:0;
        count+=alive(board,i,j-1)?1:0;
        count+=alive(board,i,j+1)?1:0;
        count+=alive(board,i+1,j-1)?1:0;
        count+=alive(board,i+1,j)?1:0;
        count+=alive(board,i+1,j+1)?1:0;
        return count;
    }

    public static boolean alive(int[][] board, int i, int j){
        if(i>=0 && i<board.length)
            if(j>=0 && j<board[0].length)
                if(board[i][j]==1||board[i][j]==-1)
                    return true;
        return false;
    }
}