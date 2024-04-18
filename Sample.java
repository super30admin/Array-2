// Problem 1: (https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach : I have used the concept of marking the elements in the array as negative to keep track of the elements that are present in the array.
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            int index = num - 1;
            if (nums[index] > 0) {
                nums[index] *= -1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            } else {
                nums[i] *= -1;
            }
        }
        return result;
    }
}
// Problem 2 : Given an array of numbers of length N, find both the minimum and
// maximum. Follow up : Can you do it using less than 2 * (N - 2) comparison
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : NA
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach :
// I have used the concept of comparing the elements in pairs and then comparing
// the min and max of the pairs to get the final min and max.
class Solution {
    public int[] findMinMax(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int i = 0;
        if (n % 2 == 0) {
            if (nums[0] > nums[1]) {
                max = nums[0];
                min = nums[1];
            } else {
                max = nums[1];
                min = nums[0];
            }
            i = 2;
        } else {
            max = nums[0];
            min = nums[0];
            i = 1;
        }
        while (i < n - 1) {
            if (nums[i] > nums[i + 1]) {
                max = Math.max(max, nums[i]);
                min = Math.min(min, nums[i + 1]);
            } else {
                max = Math.max(max, nums[i + 1]);
                min = Math.min(min, nums[i]);
            }
            i += 2;
        }
        return new int[] { min, max };
    }
}

// Problem 3: (https://leetcode.com/problems/game-of-life/)
// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach: I have used the
// concept of marking the elements in the array as 2 and 3 to keep track of the
// elements that are dead and alive respectively. I have used the dirs array to
// keep track of the 8 directions in which the elements can be present. I have
// counted the number of alive elements in the 8 directions and based on the
// count I have marked the elements as 2 or 3. Finally, I have updated the
// elements in the array based on the values of 2 and 3.

class Solution {
    int[][] dirs;
    int m, n;

    public void gameOfLife(int[][] board) {
        this.dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { 1, 1 }, { 1, -1 }, { -1, 1 },
                { -1, -1 } };
        this.m = board.length;
        this.n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = countAlive(board, i, j);
                if (board[i][j] == 1 && (count < 2 || count > 3)) {
                    board[i][j] = 3;
                }
                if (board[i][j] == 0 && count == 3) {
                    board[i][j] = 2;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                }
                if (board[i][j] == 3) {
                    board[i][j] = 0;
                }
            }
        }
    }

    private int countAlive(int[][] board, int i, int j) {
        int count = 0;
        for (int[] dir : dirs) {
            int r = i + dir[0];
            int c = j + dir[1];
            if (r >= 0 && r < m && c >= 0 && c < n && (board[r][c] == 1 || board[r][c] == 3)) {
                count++;
            }
        }
        return count;

    }
}
