// Time Complexity : O(n) - For each node checking addition 8 directions(nodes); so total check N + 8N ~ 9N ~ Asym O(n)
// Space Complexity : O(1) - in-place constant space; just additional variables
// Did this code successfully run on Leetcode : Yes; (https://leetcode.com/submissions/detail/677682018/) 
// Any problem you faced while coding this : No
// My Notes : Defines states; get the count of the neighboring nodes and take the define action.
class Solution {
    // LIVE to Death
    // Case 1 : Under population 1 --> 2(Death)
    // Case 2 : Live 1 --> 1
    // Case 3 : Over population 1 --> 3 (Death)
    // Case 4 : Rebirth 0 --> -1
    // Define constant states
    public static final int IS_ALIVE = 1;
    public static final int IS_DEAD = 0;
    public static final int SET_UNDERPOP = 2;
    public static final int SET_OVERPOP = 3;
    public static final int SET_REBIRTH = -1;
    
    public void gameOfLife(int[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                int count = getNeighborCount(board, i,j);
                int cellState = board[i][j];
                if(cellState == IS_ALIVE && count<2){
                    // dies of under population
                    board[i][j] = SET_UNDERPOP;
                }else if(cellState == IS_ALIVE && (count == 2 || count == 3)){
                    //continue to live
                } else if(cellState == IS_ALIVE && count>3){
                    // dies of over population
                    board[i][j] = SET_OVERPOP;
                } else if(cellState == IS_DEAD && count == 3){
                    // rebirth
                    board[i][j] = SET_REBIRTH;
                }
                
                //System.out.println(" count i,j "+i+","+j+" - "+count);
            }
        }
        
        // change to actual 
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                int cellState = board[i][j];
                if(cellState == SET_REBIRTH){
                    // Under
                    board[i][j] = IS_ALIVE;
                } else if(cellState == SET_UNDERPOP || cellState == SET_OVERPOP ){
                    // Under
                    board[i][j] = IS_DEAD;
                }
            }
        }
    }
    
    // get count from all the directions based on the array bound conditions.
    private int getNeighborCount(int[][] board, int i, int j){
        int rowBound = board.length-2;
        int colBound = board[0].length-2;
        int count = 0;
        
        // N
        if(i!=0 && isSpecificNeighborAlive(board, i-1,j)){
            count++;
        }
        // NE
        if(i!=0 && j<=colBound && isSpecificNeighborAlive(board, i-1,j+1)){
            count++;
        }
        // E
        if(j<=colBound && isSpecificNeighborAlive(board, i,j+1)){
            count++;
        }
        // SE
        if(i<=rowBound && j<=colBound && isSpecificNeighborAlive(board, i+1,j+1)){
            count++;
        }
        // S
        if(i<=rowBound && isSpecificNeighborAlive(board, i+1,j)){
            count++;
        }
        // SW
        if(i<=rowBound && j!=0 && isSpecificNeighborAlive(board, i+1,j-1)){
            count++;
        }
        // W
        if(j!=0 && isSpecificNeighborAlive(board, i,j-1)){
            count++;
        }
        // NW
        if(i!=0 && j!=0 && isSpecificNeighborAlive(board, i-1,j-1)){
            count++;
        }
        return count;
    }
    
    // check the neighbor alive states based on the defined states
    private boolean isSpecificNeighborAlive(int[][] board, int i, int j){
        return board[i][j] == IS_ALIVE || board[i][j] == SET_UNDERPOP || board[i][j] == SET_OVERPOP;
    }
}