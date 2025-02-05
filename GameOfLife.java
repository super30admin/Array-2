//Time Complexity : O(m*n)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/*
 We calculate the number of alives for each element. If element is dead and alives are 3 then we make that element as 3. If alives are not 2,3 and element is alive then
 we make that element 2. Now, wherever 3 is present we make that 1 and 2 as 0.
 */
class GameOfLife {
    public void gameOfLife(int[][] board) {
        if(board==null){
            return;
        }
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int countAlives = countAlive(board,i,j,m,n);
                if(board[i][j]==1 && (countAlives<2 || countAlives>3)){
                    board[i][j]=2;
                }else if(board[i][j]==0 && countAlives==3){
                    board[i][j]=3;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==2){
                    board[i][j]=0;
                }else if(board[i][j]==3){
                    board[i][j]=1;
                }
            }
        }
        
    }

    private int countAlive(int[][] board,int i, int j, int m, int n){
        int count=0;
        int[][] dirs=new int[][]{{0,1},{0,-1},{-1,0},{1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
        for(int[] dir:dirs){
            int row = i+dir[0];
            int col = j+dir[1];
            //bounds check
            if(row>=0 && row<m && col>=0 && col<n && (board[row][col]==1 || board[row][col]==2)){
                count++;
            }
        }
        return count;
    }
}