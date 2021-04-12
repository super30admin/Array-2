// Time Complexity : O(n) We might access each element upto 8 times, which is still a constant so the time complexity can be still O(n)  
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class GameOfLife {
    public void gameOfLife(int[][] grid) {
        if(grid == null || grid.length == 0) return;
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                int cnt = getCount(grid,i,j);
                if(grid[i][j] == 1){
                    if(cnt < 2 || cnt > 3) grid[i][j] = 3;
                }else{
                    if(cnt == 3) grid[i][j] = 2;
                }
            }
        }
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                //System.out.print(grid[i][j]);
                if(grid[i][j] == 3){
                    grid[i][j] = 0;
                }else if(grid[i][j] == 2){
                    grid[i][j] = 1;
                }
            }
            //System.out.println();
        }
        
    }
    
    private int getCount(int[][] grid, int i, int  j){
        int cnt = 0;
        int left = j -1 < 0 ? 0 : j-1, right = j+1 > grid[0].length -1 ?  grid[0].length -1 : j+1;
        int top = i-1 < 0 ? 0 : i-1 , bottom = i+1 > grid.length-1 ? grid.length-1 : i+1;
        
        for(int p = top; p <= bottom ; p++){
            for(int q=left; q<=right; q++){
                if(grid[p][q] == 1 || grid[p][q] == 3) cnt++;
            }
        }
        
        if(grid[i][j] == 1) cnt--;
        
        //System.out.println(left + "," + right + "," + top + "," + bottom + "  " + cnt);
        
        return cnt;
    }
}