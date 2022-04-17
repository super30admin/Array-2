// Time Complexity : O(M*N) where M is no of rows and N is the number of cols
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// when 0 converts to 1 mark it as 3, when 1 converts to zero mark it as 2.
// Count num of 1s and previously ones (2s) and follow conditions in question. Rewrite 2,3 to 0,1
public class GameOfLife {
    public void gameOfLife(int[][] board) {
        if(board==null || board.length==0) return;

        for(int i=0;i<board.length;i++){
            for(int j=0;j< board[0].length;j++){
                int count= getCount(board,i,j);
                if(board[i][j]==0){
                    if(count==3) board[i][j]=3;
                }else{
                    if(count>3 || count<2) board[i][j]=2;
                }
            }
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j< board[0].length;j++){

                if(board[i][j]==2){
                    board[i][j]=0;
                }else if(board[i][j]==3){
                    board[i][j]=1;
                }
            }
        }
    }

    private int getCount(int[][] board,int i,int j){
        int[][] dirs=new int[][]{{1,0},{0,1},{0,-1},{-1,0},
                {1,1},{-1,1},{1,-1},{-1,-1}};
        int count=0;
        for(int[] dir:dirs){
            int x=i+dir[0];
            int y=j+dir[1];

            if(x<0 || y<0 || x>board.length-1 || y>board[0].length-1) continue;
            if(board[x][y]==1 || board[x][y]==2) count++;
        }
        return count;
    }
}
