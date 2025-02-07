// Overall Time Complexity : O(m*n) . The m*n  is the time taken iterate over each cell in the matrix.
// Overall Space Complexity : O(1) . The space complexity is O(1) since there is no auxillary space.
// Any problem you faced while coding this : No issues faced during implementation
// Did this code successfully run on Leetcode :Yes


//Traverse the board; for each cell, count its live neighbors(in 8 directions). If a live cell has fewer than two or more than three live neighbors, mark it for death (set to 2). If a dead cell has exactly three live neighbors, mark it for birth (set to 3).
//Apply Changes: Traverse the board again; convert cells marked for death (2) to dead (0) and cells marked for birth (3) to alive (1).

class GameLife {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        if((board == null ) || (board.length==0) || (board[0].length==0)){
            return ;
        }

        for(int i =0;i <m; i++){
            for(int j=0; j<n; j++){
                int countAlives = countAlive(board,i,j,m,n);
                if(board[i][j] == 1 && (countAlives < 2 || countAlives > 3)){
                    //alive condition
                    board[i][j] = 2;

                }
                if(board[i][j] == 0 && (countAlives == 3)){
                    board[i][j] = 3;
                }
        }
        }

        
        for(int i =0;i <m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 2){
                    board[i][j] = 0;
                }
                if(board[i][j] == 3){
                    board[i][j] = 1;
                }
            }
            
        }
        
    }

    private int countAlive(int[][]board,int i,int j,int m, int n){

        int count = 0;
        int [][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{-1,-1},{-1,1},{1,-1},{1,1}};

        for(int [] dir:dirs){
            int nr = i + dir[0];
            int nc = j+ dir[1]; 

            if(nr>=0 && nr<m && nc>=0 && nc<n && (board[nr][nc]==1 || board[nr][nc]==2)){
                count++;
            } 
        }
        return count;

    }
}