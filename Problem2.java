package Array2;
/**
 * 
 * We are mutating the input array based on the alive neighbours of a cell. But instead of changing
 * from 0 to 1 or 1 to 0 we represent this change using some other values.
 * 
 * Time Complexity :
 * O(m*n) as we traverse all elements in the arr
 * 
 * Space Complexity :
 * O(1) as we are not using any auxillary DS
 * 
 * Did this code successfully run on Leetcode : yes
 * 
 * Any problem you faced while coding this : No
 */
public class Problem2 {
    int[][] dirs={{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
    public void gameOfLife(int[][] board) {
        int rows=board.length;
        int cols=board[0].length;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                 int aliveNeighbours= getAliveNeighbours(i,j, board);
                if(board[i][j]==0 && aliveNeighbours==3){
                    //0->1 represented by 3
                    board[i][j]=3;
                }
                else if(board[i][j]==1 && (aliveNeighbours<2 || aliveNeighbours>3)){
                    //1->0 represented by 2
                    board[i][j]=2;

                }
            }
        }

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(board[i][j]==3){
                    //0->1 represented by 3
                    board[i][j]=1;
                }
                else if(board[i][j]==2){
                    //1->0 represented by 2
                    board[i][j]=0;

                }
            }
        }

    }

    private int getAliveNeighbours(int row, int col, int[][] board){
        int count=0;

        for(int i=0;i<dirs.length;i++){
            int neighbourRow=row+dirs[i][0];
            int neighbourCol=col+dirs[i][1];

            if(neighbourRow>=0 && neighbourRow<board.length && 
            neighbourCol>=0 && neighbourCol<board[0].length){
                if(board[neighbourRow][neighbourCol]==1 || 
                board[neighbourRow][neighbourCol]==2) {count++;}
            }

        }
        return count;
    }
}
