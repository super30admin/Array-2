// Problem1
// Time Complexity : O(n) where n = length of array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Algorithm
// 1 - iterate through array
// 2 - get index using absolute
// 3 - negate respective index element
// 4 - get positive index + 1
class Solution {
  public List<Integer> findDisappearedNumbers(int[] nums) {
    if (nums == null || nums.length == 0) {
      return new ArrayList<>();
    }

    // 1
    for (int num : nums) {
      // 2
      int index = Math.abs(num) - 1;
      // 3
      if (nums[index] > 0) {
        nums[index] *= -1;
      }
    }

    List<Integer> result = new ArrayList<>();
    for (int i=0; i<nums.length; i++) {
      if (nums[i] > 0) {
        result.add(i + 1);
      }
    }

    return result;
  }
}

// Problem2
// Time Complexity : O(n x m) where n = length of array, m = elements in a row
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Algorithm
// 1 - iterate through board
// 2 - get active cell count
// 3 - conditions
// 4 - convert current live to dead using 5 and dead to live using 10
class Solution {
    public void gameOfLife(int[][] board) {
      if (board == null || board.length == 0 || board[0].length == 0) {
        return;
      }
        
      // 1
      for (int i=0; i<board.length; i++) {
        for (int j=0; j<board[0].length; j++) {
          // 2
          int active = getActiveCount(board, i, j);
          // 3
          if (active < 2 && board[i][j] == 1) {
            board[i][j] = 5;
          } else if (active > 3 && board[i][j] == 1) {
            board[i][j] = 5;
          } else if (active == 3 && board[i][j] == 0){
            board[i][j] = 10;
          }
        }
      }
        
      for (int i=0; i<board.length; i++) {
        for (int j=0; j<board[0].length; j++) {
          if (board[i][j] == 5) {
            board[i][j] = 0;
          } else if (board[i][j] == 10) {
              board[i][j] = 1;
          }
        }
      }
    }
    
    private int getActiveCount(int[][] board, int i, int j) {
      int count = 0;
      int[][] neighbors = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
      for (int[] n : neighbors) {
        int x = i + n[0];
        int y = j + n[1];
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
          continue;
        } else if (board[x][y] == 1 || board[x][y] == 5) {
          count += 1;
        }
      }
      
      return count;        
    }
}
