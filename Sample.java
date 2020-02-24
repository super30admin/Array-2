// ========================Game of Life=======================
// Time Complexity : O(n*m)
// Space Complexity :O(1) no extra space allocated
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    int m = 0;
    int n  =0;
    public void gameOfLife(int[][] board) {
        n = board.length; 
        if(board == null || n ==0)
            return;
        
        m = board[0].length;
        
        for(int i =0; i<n; i++){
            for(int j =0; j<m;j++){
                int countLives = countLives(board, i, j);
                if(board[i][j]== 1 && (countLives <2 || countLives>3) ){
                    board[i][j] = 3;
                }
                 if(board[i][j]== 0 && (countLives == 3) ){
                    board[i][j] = 5;    
                }
            }
        }
        for(int i =0; i<n; i++){
            for(int j =0; j<m;j++){
                if(board[i][j] == 3)
                    board[i][j] =0;
                if(board[i][j] == 5)
                    board[i][j] =1;
            }
        }
    }
    
    private int countLives(int[][] board, int i, int j){
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{1,-1},{-1,-1},{1,1},{-1,1}};
        int count =0;
       for(int[] d : dirs){
           int r = i + d[0];
           int c = j + d[1];
           
           if(r >=0 && r <n && c>=0 && c<m ){
               if(board[r][c] == 1 || board[r][c] == 3 )
                   count++;
           }
       }
        return count;
    }
}
// ===============================Find All Numbers disappear in array
// Time Complexity : O(n)
// Space Complexity :O(1) no extra space allocated
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
  class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
     
        List<Integer> result = new ArrayList<Integer>();
        if(nums == null || nums.length ==0)
            return result;
        
        for(int i = 0; i< nums.length; i++){
            
            int index = Math.abs(nums[i]);
            
            if(nums[index-1] > 0){
                nums[index-1] *= -1;
            }
            
        }
        for(int i = 0; i< nums.length; i++){
            if(nums[i] > 0){
                    result.add(i+1);
            }
        }
        return result;
        }
}
