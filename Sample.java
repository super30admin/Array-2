          // Game of Life
// Time Complexity : O(m * n)   .. m, n = dimensions of 2D array
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 

class Solution {

    private boolean isValid(int x, int y, int m, int n){
        if(x >= 0 && x < m && y >= 0 && y < n)
            return true;
        return false;
    }

    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};

        // 2 = 0 (previously), afterwards change to 1
        // 3 = 1 (previously), afterwards change to 0

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int live = 0;
                for(int[] dir : directions){
                    int x = i + dir[0], y = j + dir[1];
                    if(isValid(x, y, m, n) && (board[x][y] == 3 || board[x][y] == 1))
                        live++;
                }

                if(board[i][j] == 0 && live == 3)
                    board[i][j] = 2;
                if(board[i][j] == 1 && (live < 2 || live > 3))
                    board[i][j] = 3;
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == 2)
                    board[i][j] = 1;
                else if(board[i][j] == 3)
                    board[i][j] = 0;
            }
        }
        
    }
}


          // Find All Numbers Disappeared in an Array
// Time Complexity : O(n)   .. n = dimensions of 2D array
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList();
        for(int i=0;i<nums.length;i++){
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0)
                nums[index] = nums[index] * -1;
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i] >= 0)
                list.add(i + 1);
        }

        return list;
    }
}
