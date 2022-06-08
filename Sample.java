// Time Complexity : o(n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

class Solution {
    // -4 -3 -2 -7 8 2 -3 -1
    //  0  1  2  3 4 5  6  7
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(null == nums || nums.length == 0) return new ArrayList<Integer>();
        //optimal
        List<Integer> result = new ArrayList<Integer>();
        //make the corresponding number at the index as negative
        for(int i=0; i<nums.length; i++){
            int idx = Math.abs(nums[i]);
            if(nums[idx-1] > 0){
                nums[idx-1] = nums[idx-1] * -1;
            }
        }
        
        for(int i=0; i<nums.length; i++){
            if(nums[i] > 0){
                result.add(i+1);
            }
        }
        return result;
    }
}

// Time Complexity : o(m*n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// https://leetcode.com/problems/game-of-life/submissions/

class Solution {
    int m;
    int n;
    int[][] dirs;
    public void gameOfLife(int[][] board) {
       
        if(board == null || board.length == 0) return;
        m = board.length;
        n = board[0].length;
        // 1 -> 0 -- 3
        // 0 -> 1 -- 2
        dirs = new int [][]{
            {0,1}, {0,-1}, {-1,0}, {1,0},
            {-1,-1}, {-1,1}, {1,-1}, {1,1}
        };
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int countOfLive = helper(board, i, j);
                if(board[i][j] == 1 && (countOfLive < 2 || countOfLive > 3)){
                    board[i][j] = 3;
                } 
                if(board[i][j] == 0 && countOfLive == 3){
                    board[i][j] = 2;
                }
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 3){
                    board[i][j] = 0;
                } 
                if(board[i][j] == 2){
                    board[i][j] = 1;
                }
            }
        }
    }
    
    private int helper(int[][] board, int i, int j){
        int count = 0;
        for(int[] dir: dirs){
            int nr = i + dir[0];
            int nc = j + dir[1];
            if(nr>=0 && nc>=0 && nr<m && nc<n && (board[nr][nc] == 1 || board[nr][nc] == 3)){
                count++;
            }
        }
        return count;
    }
}
