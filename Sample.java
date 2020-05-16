// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

//Game Of Life - (Inplace)
//TC  O(mn)
//SC - O(1)

class Solution {public void gameOfLife(int[][] board) {
    if (board == null || board.length == 0) {
        return;
    }
    int m = board.length;
    int n = board[0].length;

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            int count = getNeighbors(board, i, j, m , n);
            if (count == 3 || board[i][j] + count == 3) {
                board[i][j] ^= 2;
            }
        }
    }
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            board[i][j] = board[i][j] >> 1;
        }
    }
}

private int getNeighbors(int[][] board, int i, int j, int m, int n) {
    int result = 0;
    for (int x = Math.max(i-1, 0); x < Math.min(i+2, m); x++) {
        for (int y = Math.max(j-1, 0); y < Math.min(j+2, n); y++) {
            result += (board[x][y] & 1);
        }
    }
    return result - (board[i][j] & 1);
}
}
    

//Find all numbers in disappeared array
/*
TC - O(n)
SC : O(N)

*/


class Solution {
  public List<Integer> findDisappearedNumbers(int[] nums) {
      
      List<Integer> lis = new ArrayList<Integer>();
      
      if(nums == null || nums.length ==0)
          return lis;
      
      int[]temp = new int[nums.length+1];
      
      for(int i=0 ; i<nums.length; i++)
          temp[nums[i]] = nums[i];
      
      for(int i=1; i<temp.length; i++){
          if(temp[i] == 0)
              lis.add(i);
      }
      return lis;
      
  }
}
    