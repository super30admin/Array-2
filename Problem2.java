// Time Complexity :O(mn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :NO
public class Problem2 {
    //approach is to user one dir [][] which contains where to look for neighbour for current element means 8 directions
    //and to not use extra space we're gonna modified the original array in such a way that
    // if alive element becomes dead -> make it 2
    //if dead become alive -> make it 3
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0){
            return;
        }
        int m = board.length;
        int n = board[0].length;
        for(int i = 0;i<m;i++){
            for(int j =0 ;j<n;j++){
                int alive = findNoOfAliveNeighbours(board,i,j,m,n);
                System.out.println(alive);
                if((alive < 2 || alive > 3) && board[i][j]==1){
                    board[i][j] = 2;
                }else if(alive == 3 && board[i][j]==0){
                    board[i][j] = 3;
                }
            }
        }

        for(int i = 0;i<m;i++){
            for(int j =0 ;j<n;j++){
                if( board[i][j]==3){
                    board[i][j] = 1;
                }else if(board[i][j]==2){
                    board[i][j] = 0;
                }
            }
        }
    }

    private int findNoOfAliveNeighbours(int[][] board,int row, int col,int rowSize, int colSize){
        int[][] dirs = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        int count = 0;
        for(int[] dir : dirs){
            int i = row + dir[0];
            int j = col + dir[1];
            //i and j should be in range >=0 and < size
            if(i>=0 && i<rowSize && j>=0 && j<colSize && (board[i][j] == 1 || board[i][j] == 2)){
                count++;
            }
        }
        return count;
    }
}
