


class Solution {
    //Directions representing the eight neighbours around a cell
    //(row offset, column offset)

    int[][] dirs;
    int m,n; //Number of rows and columns in the board

    /*Approach 
    For each cell in board, count thenumber of live neighbours.
    Use temporary markerrs to represent cells that will change state:
     2: alive-> dead
     3: dead_> alive
     -This way, we can update the board in-place without affecting neighbour counts.
     -After marking all cells, do a second pass to finalize the states by replacing 2 with 0 and 3 with 1.

    */
    public void gameOfLife(int[][] board) {
        //Initialize directions for all 8 neighbours
        this.dirs = new int[][] {
            {-1,-1},{-1,0},{-1,1},
            {0,-1},     {0,1},
            {1,-1},{1,0},{1,1}      
        };

        //Store board dimensiond for easy access
        this.m =board.length;
        this.n =board[0].length;

        //First Pass: iterate over every cell to decise its next state
        for(int i=0; i<m;i++){
            for(int j = 0; j<n; j++){
                //Count how many neighbours are alive
                int count =getCount(board, i, j);
            //Apply Game of life rules using temporary markers:

            //Rule: A dead cell with exactly 3 live neighbours becomes alive
            if (board[i][j] == 0 && count == 3){
                board[i][j] = 3; //Mark as dead -> alive transition
            }

            //Rule: A live cell with fewer than 2 or more than 3 live neighbours dies
            else if (board[i][j] == 1 && (count<2 || count>3)){
                board[i][j] = 2;  //Mark as alive-dead transition
            }
            //Otherwise, cell remains unchanges(no marker needed)
            }
        }
        //Second pass: finalize the state changes by replacing temporary markers
        for(int i = 0; i<m; i++){
            for(int j=0; j<n;j++){
                if(board[i][j] == 2){
                    board[i][j] = 0; //alive -> dead transition finalized
                } else if(board[i][j] == 3){
                    board[i][j] = 1; //dead -> alive transition finalized
                }
            }
        }
    }
    /*
    Helper method to count how many neighbours around (i,j) are alive.
    Neighbours with value 1 are currently alive.
    Neighbours with value 2 are alive but marked to die, so count as alive here.
    */
    private int getCount(int[][] board, int i, int j){
        int count = 0;

        //Iterate through all 8 neighbours
        for (int[] dir : dirs) { 
            int r = i+dir[0];//row of neighbor
            int c=j+dir[1];//column of neighbor

            //Check if neighbour is inside board boundaries
            if(r>=0 && c>=0 && r<m && c<n){
                //Count as alive if neighbour is currently alive (1)
                //or alive but marked to die (2)
                if (board[r][c] == 1 || board[r][c] == 2){
                    count++;
                }
            }
        }
        return count; //Return total live neighbours count    
    }
}

/*
Time Complexity:
Each cell is visited twice (two passes)
Counting neighbours takes O(1) time per cell since there are 8 fixed neighbours.
Overall : O(m*n), where m and n are the dimensions of the board.

Space Complexity:
No extra board or arrays proportional to input size to input size are used.
Only a fixed-size directions array and counters.
-Overall : O(1) additional space.

*/