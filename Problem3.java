// Time Complexity : O(n*m)
//      n: number of row
//      m: number of cols
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class Problem3 {
    
    // neighbor matrix
    int[][] neighbors = {{-1, -1}, {-1, 0}, {-1, 1},
                        {0, -1}, {0,1},
                        {1, -1}, {1, 0}, {1,1}};
    // row max
    int n;
    // col max
    int m;
    

    public void gameOfLife(int[][] board) {
        //initialize
        n = board.length;
        m = board[0].length;

        //Mapping: O -> 1 : 2 (dead -> alive)
        //Mapping: 1 -> 0 : 3 (alive -> dead)

        // iterate
        for(int i=0; i<n;i++){
            
            for(int j=0; j<m; j++){
                
                //count live neighbor
                int live =  findLiveNeighbor(i,j, board);
                // current cell is dead and 3 Neighbors are alive
                if((board[i][j]==0) && (live==3)) // reproduction
                    board[i][j] = 2;
                // current cell is alive and less than 2 neighbor are alive
                else if((board[i][j]==1) && (live<2)) // under population
                    board[i][j] = 3;
                // current cell is alive and greater than 4 neighbor are alive
                else if((board[i][j]==1) && (live>3)) // over population
                    board[i][j] = 3;
            
            }
        }
        
        // reverse mapping
        for(int i=0; i<n; i++){
            for(int j=0;j<m;j++){
                
                if(board[i][j]==3)
                    board[i][j] = 0;
                else if(board[i][j]==2)
                    board[i][j] = 1;
            }
        }
        
    }
    
    private int findLiveNeighbor(int row, int col, int [][] board){
        //Mapping: O -> 1 : 2 (dead -> alive)
        //Mapping: 1 -> 0 : 3 (alive -> dead)
        int result = 0;
        // find neighbors
        for(int[] neighbor: neighbors){
            int curRow = neighbor[0] + row;
            int curCol = neighbor[1] + col;
            // in range
            if((0<= curRow) && ( curRow <n) && (0<= curCol) && (curCol< m)){
                if(board[curRow][curCol] == 1 || board[curRow][curCol] == 3)
                    result++;
            }
        }
        
        return result;
    }
}