// Time Complexity :O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList<Integer>();
        }
        List<Integer> result = new ArrayList<>();
        for(int i = 0 ;i< nums.length; i++){
            //index of value
            int index = Math.abs(nums[i])-1;
        
        //negating the value present at that particular index
        if(nums[index] > 0)
            nums[index]= nums[index]*-1;
        }
        for(int i = 0 ; i < nums.length; i++){
            //if the value is found > 0 then we will add i+1 value to array
            if(nums[i] > 0){
                result.add(i+1);                
            }
            else{
                //again negating the values to make positive numbers
                nums[i]= nums[i]*-1;
            }
        }
        return result;
        
    }
}

// Time Complexity :O(MN)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0)
            return;
        int m = board.length, n = board[0].length;
 //Live < 2 or > 3 -> dead(1,3), dead == 3 -> live(4), live == 2 or 3 -> live(2)
        // 1 -> 0 = 3, 0 -> 1 = 2
        for(int i = 0 ; i< m ; i++){
            for(int j = 0; j< n; j++){
                int count = countLiveNeighbors(board,m,n,i,j);
                if(board[i][j] == 1 && (count < 2 || count > 3) )
                    board[i][j] = 3;
                else if(board[i][j] == 0 && count == 3)
                    board[i][j] = 2;
            }
            
        }
        for(int i = 0 ; i< m ; i++){
            for(int j = 0; j< n; j++){
                if(board[i][j] == 3)
                    board[i][j] = 0;
                else if(board[i][j] == 2)
                    board[i][j] = 1;
            }
        }
        
    }
    private int countLiveNeighbors(int[][]board, int m , int n, int i , int j){
        int result = 0;
        int [][] dirs = new int[][]{{-1,-1},{-1,1},{1,-1},{1,1},{0,1},{0,-1},{-1,0},{1,0}};
        for(int[]dir: dirs){
            int r = i+dir[0];
            int c = j+dir[1];
            if(r >= 0 && r < m && c >= 0 && c < n){
                if(board[r][c] == 1 || board[r][c] == 3)
                    result++;
                }
            }
        return result;
            
        }
        
    }
