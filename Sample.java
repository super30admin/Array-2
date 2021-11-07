// find all disappeared numbers in an array
// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        
        ArrayList<Integer> disappearedList = new ArrayList<>();
        
        for(int i = 0; i<nums.length;i++){
            
            int index = nums[i];
            
            if(nums[Math.abs(index)-1]>0)            
               nums[Math.abs(index)-1] = nums[Math.abs(index)-1]  * -1;
            
        }
        
        for(int i = 0; i<nums.length;i++){
            
            if(nums[i]>0)
                disappearedList.add(i+1);
            
        }
        
        return disappearedList;
        
    }
}

// game of life
// Time Complexity :O(n*m)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :

class Solution {
    public void gameOfLife(int[][] board) {
        
        //0->1 3
        //1->0 7
        
        for(int row = 0; row<board.length; row++){
            
            for(int column = 0; column<board[0].length; column++){
                
                int livingCells = count(board, row, column);
                
                //living cell
                if(board[row][column]==1){
                    
                    if(livingCells>3 || livingCells<2){
                        board[row][column]=7;
                    }
                    
                }
                else{
                    if(livingCells==3){
                        board[row][column]=3;
                    }
                }
                
                
            }
            
        }
        
        for(int i = 0; i<board.length;i++){
            for(int j = 0; j<board[0].length;j++){
                
                if(board[i][j]==3){
                    board[i][j]=1;
                }
                if(board[i][j]==7){
                    board[i][j]=0;
                }
                
            }
        }
        
        
    }
    
    private int count(int[][] board, int row, int column){
        
        int rows = board.length;
        int columns = board[0].length;
        
        int[][] neigh = {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};
        
        int living = 0;
        
        for(int i = 0; i<neigh.length;i++){
            
            int nrow = row+neigh[i][0];
            int ncol = column+neigh[i][1];
            
            if((nrow>=0 && nrow<rows)&&(ncol>=0 && ncol<columns)){
                
                if(board[nrow][ncol]==1 || board[nrow][ncol]==7){
                    living++;
                }
                
            }
            
        }
        return living;
        
    }
    
    
}
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
