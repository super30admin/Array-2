## Problem1 (https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)

// Time Complexity : 0(n) because the solution performs two passes over the array, each of which takes linear time.
// Space Complexity : 0(1) because the solution uses only a constant amount of extra space regardless of the size of the input array.

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null || nums.length ==0) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = nums[index] * -1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
            else {
                nums[i] = nums[i] * -1;
            }
        }
        return result;
    }
}


## Problem - (https://leetcode.com/problems/sort-colors/)

// Time Complexity : because the solution uses a single pass over the input array, and each element is processed exactly once.
// Space Complexity : because the solution only uses a constant amount of extra space regardless of the size of the input array.

class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;

        while (mid <= high) {
            if (nums[mid] == 2) {
                swap(nums, mid, high);
                high--;
            }
            else if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            }
            else {
                mid++;
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

## Problem3 (https://leetcode.com/problems/game-of-life/)

// Time Complexity - 0(m * n) because the method iterates through all the cells in the board twice, 
//                   once for updating the state of each cell and once for converting the temporary values back to the original values.
// Space Complexity - 0(1) because the method only uses a constant amount of extra space to store the count_live.

class Solution {
    int m, n;
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        m = board.length;
        n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count_live = countlive(board, i, j);
                if (board[i][j] == 1) {                           // if its a live cell
                    if (count_live < 2 || count_live > 3) {
                        board[i][j] = 2;                          // live becaome dead change it to 2
                    }
                }                 
                else if (board[i][j] == 0) {                      // if its a dead cell
                    if (count_live == 3) {
                        board[i][j] = 3;
                    }            
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                }
                else if (board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }
    private int countlive (int board[][], int row, int col) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        int count = 0;
        
        for (int i = 0; i < 8; i++) {
            int nr = row + dirs[i][0];
            int nc = col + dirs[i][1];
            if (nr >= 0 && nr < m && nc >= 0 && nc < n && (board[nr][nc] == 1 || board[nr][nc] == 2)) {
                count++;
            }
        }
        return count;
    }
}