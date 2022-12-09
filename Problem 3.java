// Time Complexity : O (r *c)
// Space Complexity : O(rc)
// Did this code successfully run on Leetcode :yes 
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

/*
We will pick each cell, go through the 8 neighbours and then update the new state of that cell in a new array

we then copy the values from that new array to the input array
*/
class Solution {

    
    public void gameOfLife(int[][] board) {

        // the return type of the function is void
        // this means that we have to mutate the input array to store the answer

        int rows = board.length;
        int col = board[0].length;
        // if we keep mutating the input, our results can get messed up , so creating a new result array
        int[][] result = new int[rows][col];

        for(int r = 0;r<rows;r++){
            for(int c=0;c<col;c++){

                int liveNeighbors = nextState(board,r,c);
                // go through the rules
                if(liveNeighbors <2 && board[r][c] == 1){ //Any live cell with fewer than two live neighbors dies as if caused by under-population.
                    result[r][c] =0;
                }else if(liveNeighbors>=2 && liveNeighbors<=3 && board[r][c] == 1){ // Any live cell with two or three live neighbors lives on to the next generation.
                        result[r][c] = 1;
                    }
                    else if(liveNeighbors>3 && board[r][c] == 1){ // Any live cell with more than three live neighbors dies, as if by over-population.
                         result[r][c] =0;
                    }
                    else if(liveNeighbors==3 && board[r][c] ==0){ // Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
                            result[r][c] = 1;
                }
                
            }
        }

        // now we will change input

        for(int r =0 ; r<rows;r++){
            for(int c=0;c<col;c++){
                board[r][c] =  result[r][c];
            }

        }

        // At this point the input should contain the next state
        
    }

    private int nextState(int[][] board, int row,int col){
        
        // we need to go
        // left, right, up, down, upright, upleft, downright, downleft

        // we will create a dirs array, which will have the next coordinates , when added with the current ones
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};

        int count =0;
        for(int[] pair : dir){ // O(8) ==> O(1)

            int r = pair[0]+row;
            int c = pair[1]+col;

            // check for bounds

            if(r>=0 && r<board.length && c>=0 && c<board[0].length){
                count+=board[r][c];

            }

        }

        return count;

    }
}