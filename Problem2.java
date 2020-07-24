// Time Complexity : O(mn) m=row, n=col
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : none


// Your code here along with comments explaining your approach

class Solution {
    int[][] grid;
    int[][] directions;
    
    public void gameOfLife(int[][] grid) {
        directions = new int[][]{{0,-1}, {-1,-1}, {-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}, {1,-1}};
        
        this.grid = grid;
        //0->1 == 2
        //1->0 == 3
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                int liveNeighbor = count(i, j);
                if(grid[i][j] == 1){
                    if(liveNeighbor<2 || liveNeighbor>3)
                        grid[i][j] = 3;
                }
                else{
                    if(liveNeighbor == 3)
                        grid[i][j] = 2;
                }
            }
        }
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j]==2)
                    grid[i][j] = 1;
                else if(grid[i][j]==3)
                    grid[i][j] = 0;
            }
        }
        
    }
    
    private int count(int i, int j){
        int count = 0;
        
        for(int[] dir: directions){
            int i_new = i + dir[0];
            int j_new = j + dir[1];
            
            if(isValid(i_new, j_new)){
                count++;
            }
        }
        return count;
    }
    
    private boolean isValid(int i, int j){
        return (i>=0 && j>=0 && i<grid.length  && j<grid[i].length && (grid[i][j] == 1 || grid[i][j] == 3));
    }
}